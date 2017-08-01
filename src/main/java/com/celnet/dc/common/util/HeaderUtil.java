package com.celnet.dc.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import com.celnet.dc.common.exception.ErrorMessage;
import com.celnet.dc.controller.ApiLogController;
import com.celnet.dc.domain.InterfaceHandler;
import com.celnet.dc.domain.MWApiList;
import com.celnet.dc.domain.MWApiLog;
import com.celnet.dc.domain.api.response.ResponseJson;

import net.sf.json.JSONObject;

/**
 * 接口加密处理
 * Created by jerry 2017-06-17.
 */
public class HeaderUtil {
private ErrorMessage error;
	
	public ResponseJson doPost(HttpServletRequest request){
		
		ApiLogController apiLog = new ApiLogController();
		
		try{
			InputStream reqIS = request.getInputStream();
	        BufferedReader reqBR = new BufferedReader(new InputStreamReader(reqIS));
	        String line = reqBR.readLine();
	        StringBuilder body = new StringBuilder();
	        //String body = "";
	        while (line != null) {
	            body.append(line);
	            line = reqBR.readLine();
	        }
	        String method = request.getParameter("method");
	        String apiVersion = request.getParameter("apiVersion");
	        String authorizedApp = request.getParameter("authorizedApp");
	        ResponseJson responseJson = new ResponseJson();
	        
	        int len = request.getContentLength();
	        ServletInputStream iii = request.getInputStream();
	        byte[] buffer = new byte[len];
	        iii.read(buffer, 0, len);
	
	        //从数据库mw_api_list表根据method，apiVersion获取记录
	        List<MWApiList> list = new ArrayList<MWApiList>();
	        
	        List<MWApiList> handlerNames = new ArrayList<MWApiList>();
	        Set<String> authorAppSet;
	        Integer index = 0;
	        Boolean hasActive = false;
	        MWApiLog log = null;
	        
	        for(MWApiList api : list){
	        	if(api.getStatus().equals("1")){
	                authorAppSet = new HashSet<String>();
	                authorAppSet.addAll(Arrays.asList(api.getAuthoritedAppKey().split(";")));
	                if(authorAppSet.contains(authorizedApp)){
	                    handlerNames.add(api);
	                }
	                hasActive = true;
	            }else if(index == 0){
	                return error.errorHandle(FinalUtil.API_ERROR_CODE_1020,null);//接口未启用
	            }
	            index++;
	        }
	        
	      //1.list中存在，但没有权限调用
	        //2.list中没有此配置
	        if(handlerNames.size()==0){
	            if(hasActive){
	                return error.errorHandle(FinalUtil.API_ERROR_CODE_1010,null);
	            }
	            return error.errorHandle(FinalUtil.API_ERROR_CODE_1012,null);
	        }
	        if(handlerNames.size() >1){
	        	return error.errorHandle(FinalUtil.API_ERROR_CODE_1013,null);
	        }
	        
	       InterfaceHandler handler;
	       try {
	           handler = (InterfaceHandler)Class.forName("").newInstance();//
	       }
	       catch(Exception err) {
	           return error.errorHandle(FinalUtil.API_ERROR_CODE_1015,null);//初始化接口处理器错误
	       }
	       try{
	           if(handler == null){
	               //LogHelper.updateLog(log,1021);
	               return error.errorHandle(FinalUtil.API_ERROR_CODE_1021,null);//未找到接口处理器
	           }
	    	   //成功请求接口时，记录日志
	          // log = apiLog.InsertLog(handlerNames.get(0),body.toString());
	           responseJson = handler.setLog(log).dohandle("");
	           //接口正常返回时，记录日志
	          // apiLog.UpdateLog(log,JSONObject.fromObject(responseJson).toString(),"成功");
	       }
	       catch(Exception err){
	    	   //接口非正常返回时，记录日志
	           apiLog.UpdateLog(log,JSONObject.fromObject(responseJson).toString(),"错误");
	           return error.errorHandle(FinalUtil.API_ERROR_CODE_1005,null);
	       }
	       return responseJson;
   }
   catch(Exception err){
       return error.errorHandle(FinalUtil.API_ERROR_CODE__1,null);//  -1
   }
	}
}
