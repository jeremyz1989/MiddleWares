package com.celnet.dc.common.util;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.celnet.dc.domain.api.response.ResponseJson;

@Aspect
@Component
public class ApiCheckAOP {

	static String secret = "cn@shimaoHeroku";
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
                    }
                }
                catch (Exception ex){
                    return new ResponseJson(FinalUtil.API_ERROR_CODE_1002,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_1002));//参数类型错误
                }
            }
        	 if(s.equalsIgnoreCase("version")){
                 if(!value.equals("1.0")){
                	 return new ResponseJson(FinalUtil.API_ERROR_CODE_1018,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_1018));//无效的version
                 }
             }
             if(s.equalsIgnoreCase("app_key")){
                 if(!Arrays.asList(appkeys).contains(value)){
                	 return new ResponseJson(FinalUtil.API_ERROR_CODE_1017,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_1017));//无效的appkey
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
        return myMdKey.equals(mdKey)? pjp.proceed():new ResponseJson(FinalUtil.API_ERROR_CODE_1009,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_1009));//签名验证错误
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
