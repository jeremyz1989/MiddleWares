package com.celnet.dc.common.util;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.celnet.dc.domain.MWApiList;
import com.celnet.dc.domain.api.request.RequestJson;
import com.celnet.dc.domain.api.response.ResponseJson;
import com.celnet.dc.service.MWApiListService;

@Aspect
@Component
public class ApiCheckAOP {

	static String secret = "cn@shimaoHeroku";
	@Autowired
	private MWApiListService mwApiListService;
	/**
     * 1、callin，header验证
     * 2、callout，header加密
     * 3、数据质量提升（数据补全）
     * 
     * @param joinPoint
     * @throws Throwable
     */
    @Pointcut("within(com.celnet.dc.controller.InterfaceServiceController)")
    public void apiCheck(){}
    
    @Around("apiCheck()")
     public Object doBefore(ProceedingJoinPoint pjp) throws Throwable{
    	
    	ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
    	Map<String,String> headers = new HashMap<String,String>();
    	RequestJson requestJson = new RequestJson();
		String mdKey="";
        String[] ss = new String[]{"method","Content-Type","app_key","timestamp","version","sign"};
        //获取系统变量
        String appkeyConfig = System.getenv("appkey");
        appkeyConfig = "cn@qianyunApi;cn@dongruanApi";
        String[] appkeys = appkeyConfig.split(";");
        for(String s : ss){
        	if(StringUtil.isEmpty(request.getHeader(s))){
        		return new ResponseJson(FinalUtil.API_ERROR_CODE_1001,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_1001));//缺少必填参数
        	}
        	String value = request.getHeader(s);
        	if(s.equalsIgnoreCase("timestamp")){
            	try {
                    if(!checkTime(value)){
                    	return new ResponseJson(FinalUtil.API_ERROR_CODE_1019,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_1019));//非法请求时间戳
                    }else{
                    	requestJson.setTimestamp(value);
                    }
                }
                catch (Exception ex){
                    return new ResponseJson(FinalUtil.API_ERROR_CODE_1002,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_1002));//参数类型错误
                }
            }
        	 if(s.equalsIgnoreCase("version")){
                 if(!value.equals("1.0")){
                	 return new ResponseJson(FinalUtil.API_ERROR_CODE_1018,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_1018));//无效的version
                 }else{
                	 requestJson.setVersion(value);
                 }
             }
             if(s.equalsIgnoreCase("app_key")){
                 if(!Arrays.asList(appkeys).contains(value)){
                	 return new ResponseJson(FinalUtil.API_ERROR_CODE_1017,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_1017));//无效的appkey
                 }else{
                	 requestJson.setApp_key(value);
                 }
             }
             if(s.equalsIgnoreCase("sign")){
                 mdKey = value;
             }
             else {
                 headers.put(s,value);
             }
             
        }
		
        String[] keyset = headers.keySet().toArray(new String[0]);
        Arrays.sort(keyset);
        StringBuilder query = new StringBuilder();
        query.append(secret);
        for (String key : keyset) {
            String value = headers.get(key);
            query.append(key).append(value);
        }
        query.append(secret);
        System.out.println(query);
        // 第三步：使用MD5加密
        MessageDigest mdt = MessageDigest.getInstance("MD5");
        mdt.update(query.toString().getBytes());
        String myMdKey = byte2hex(mdt.digest());
        System.out.println("签名：" + myMdKey);
        if(myMdKey.equals(mdKey)){
        	String str = doPost(requestJson);
        	if(FinalUtil.API_ERROR_CODE_0.equals(str)){
        		pjp.proceed();
        	}else{
        		return new ResponseJson(str,FinalUtil.getErrorMsg(str));
        	}
        }else{
        	return new ResponseJson(FinalUtil.API_ERROR_CODE_1009,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_1009));
        }
        return myMdKey.equals(mdKey)? doPost(requestJson):new ResponseJson(FinalUtil.API_ERROR_CODE_1009,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_1009));//签名验证错误
    }
    
	public String doPost(RequestJson requestJson){
		
		try{
		
	        //从数据库mw_api_list表根据method，apiVersion获取记录
	        List<MWApiList> list = mwApiListService.getApiList(requestJson.getMethod(), requestJson.getVersion());
	        if(CollectionUtils.isEmpty(list)){
	        	return FinalUtil.API_ERROR_CODE_1012;
	        }
	        List<MWApiList> handlerNames = new ArrayList<MWApiList>();
	        Set<String> authorAppSet;
	        Integer index = 0;
	        Boolean hasActive = false;
	        
	        for(MWApiList api : list){
	        	if(api.getStatus().equals("1")){
	                authorAppSet = new HashSet<String>();
	                authorAppSet.addAll(Arrays.asList(api.getAuthoritedAppKey().split(";")));
	                if(authorAppSet.contains(requestJson.getApp_key())){
	                    handlerNames.add(api);
	                }
	                hasActive = true;
	            }else if(index == 0){
	                return FinalUtil.API_ERROR_CODE_1020;//接口未启用
	            }
	            index++;
	        }
	        
	      //1.list中存在，但没有权限调用
	        //2.list中没有此配置
	        if(handlerNames.size()==0){
	            if(hasActive){
	                return FinalUtil.API_ERROR_CODE_1010;//没有该接口权限
	            }
	            return FinalUtil.API_ERROR_CODE_1012;//未查到该接口处理器
	        }
	        if(handlerNames.size() >1){
	        	return FinalUtil.API_ERROR_CODE_1013;//接口处理器重复
	        }
	        
	       
	       return FinalUtil.API_ERROR_CODE_0;
   }
   catch(Exception err){
       return FinalUtil.API_ERROR_CODE_1;//  -1
   }
}
	
    public static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }

	private static boolean checkTime(String timeStamp) throws Exception{
	    TimeZone cnTimezone = new SimpleTimeZone(28800000,TimeZone.getAvailableIDs(28800000)[0]);
	    DateFormat formats = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    formats.setTimeZone(cnTimezone);
	    Date requestTime = formats.parse(timeStamp);
	    Date timenow = new Date();
	    if(timenow.getTime() - requestTime.getTime() < 600000L && timenow.getTime() - requestTime.getTime() > 0L ){
	        return true;
	    }
	    return false;
	}
    
}
