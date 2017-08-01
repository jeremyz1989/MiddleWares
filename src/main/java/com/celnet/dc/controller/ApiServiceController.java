package com.celnet.dc.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.celnet.dc.common.exception.ErrorMessage;
import com.celnet.dc.common.util.FinalUtil;
import com.celnet.dc.common.util.StringUtil;
import com.celnet.dc.domain.InterfaceHandler;
import com.celnet.dc.domain.MWApiList;
import com.celnet.dc.domain.MWApiLog;
import com.celnet.dc.domain.api.request.RequestJson;
import com.celnet.dc.service.MWApiListService;

import net.sf.json.JSONObject;
/**
 * CallIn
 * api 版本化
 * @author loki
 *
 */
public class ApiServiceController {
	
	static String secret = "cn@shimaoHeroku";
	@Autowired
	private MWApiListService mwApiListService;
	
	public String headerVerification(HttpServletRequest request) throws NoSuchAlgorithmException{
		Map<String,String> headers = new HashMap<String,String>();
		String mdKey="";
        String[] ss = new String[]{"method","Content-Type","app_key","timestamp","version","sign"};
        //获取系统变量
        String appkeyConfig = System.getenv("appkey");
        appkeyConfig = "cn@qianyunApi;cn@dongruanApi";
        String[] appkeys = appkeyConfig.split(";");
        for(String s : ss){
        	if(StringUtil.isEmpty(request.getHeader(s))){
        		return FinalUtil.API_ERROR_CODE_1001;//缺少必填参数
        	}
        	String value = request.getHeader(s);
        	if(s.equalsIgnoreCase("timestamp")){
            	try {
                    if(!checkTime(value)){
                    	return FinalUtil.API_ERROR_CODE_1019;//非法请求时间戳
                    }
                }
                catch (Exception ex){
                    return FinalUtil.API_ERROR_CODE_1002;//参数类型错误
                }
            }
        	 if(s.equalsIgnoreCase("version")){
                 if(!value.equals("1.0")){
                	 return FinalUtil.API_ERROR_CODE_1018;//无效的version
                 }
             }
             if(s.equalsIgnoreCase("app_key")){
                 if(!Arrays.asList(appkeys).contains(value)){
                	 return FinalUtil.API_ERROR_CODE_1017;//无效的appkey
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
        return myMdKey.equals(mdKey)?FinalUtil.API_ERROR_CODE_0:FinalUtil.API_ERROR_CODE_1009;//签名验证错误
		
	}
	
	public String doPost(RequestJson requestJson){
		
//		try{
		
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
//   }
//   catch(Exception err){
//       return FinalUtil.API_ERROR_CODE__1;//  -1
//   }
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
