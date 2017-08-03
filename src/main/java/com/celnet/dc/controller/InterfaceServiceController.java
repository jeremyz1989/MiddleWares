package com.celnet.dc.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.HttpHeaders;
//import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Context;

import org.apache.commons.collections.CollectionUtils;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.celnet.dc.common.util.FinalUtil;
import com.celnet.dc.common.util.HttpClientUtil;
import com.celnet.dc.domain.AccountSource;
import com.celnet.dc.domain.SystemParamter;
import com.celnet.dc.domain.api.request.RequestJson;
import com.celnet.dc.domain.api.response.ResponseJson;
import com.celnet.dc.service.AccountSourceService;
import com.celnet.dc.service.InterfaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/")
@Api("系统参数-相关api") // 用在类上，说明该类的作用
public class InterfaceServiceController extends ApiServiceController{
	
	// 创建线程安全的Map
	static Map<String, SystemParamter> systemParamters = Collections.synchronizedMap(new HashMap<String, SystemParamter>());

	@Autowired
	private InterfaceService interfaceService;
	
	@Autowired
	private AccountSourceService accountSourceService;

	@ApiOperation(value = "查询世茂币", notes = "")
	@RequestMapping(value = "/get/coin", method = RequestMethod.POST)
	public ResponseJson getShiMaoCoin( @RequestBody JSONObject obj) throws Exception {
		
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();

//		InputStream reqIS = request.getInputStream();
//        BufferedReader reqBR = new BufferedReader(new InputStreamReader(reqIS));
//        String line = reqBR.readLine();
//        StringBuilder body = new StringBuilder();
//        //String body = "";
//        while (line != null) {
//            body.append(line);
//            line = reqBR.readLine();
//        }
        System.out.println("请求内容" + obj.toString());
		
		ResponseJson result = new ResponseJson();
		//签名验证
		String code = this.headerVerification(request);
		if(!FinalUtil.API_ERROR_CODE_0.equals(code)){
			result=new ResponseJson(code,FinalUtil.getErrorMsg(code));
			return result;
		}
		
		RequestJson requestJson = new RequestJson(request);
		String sfid = obj.getString("id");
		System.out.println("id=" + sfid);
		//接口，版本号校验
		code = this.doPost(requestJson);
		System.out.println(code);
		if(!FinalUtil.API_ERROR_CODE_0.equals(code)){
			result=new ResponseJson(code,FinalUtil.getErrorMsg(code));
			return result;
		}
		//String sfid = "0012800000mHh4AAAS";
		if(sfid == null || sfid.equals("") ){
			//缺少必填参数
			result=new ResponseJson(FinalUtil.API_ERROR_CODE_1001,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_1001));
			return result;
		}	
		if(sfid.length() != 15 && sfid.length() != 18){
			//参数类型错误
			result=new ResponseJson(FinalUtil.API_ERROR_CODE_1002,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_1002));
			return result;
		}
		System.out.println("===cstSFID===:"+sfid);
		
		List<AccountSource> list = interfaceService.getAccount(sfid);
		if(CollectionUtils.isEmpty(list)){
			//客户不存在
			result=new ResponseJson(FinalUtil.API_ERROR_CODE_2001,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_2001));
		}else{
			try
	        {
				List<Object> list1 = new ArrayList<Object>();
	          for(AccountSource obj1:list)
	          {
	              Map<String,String> map = new HashMap<String,String>();
	              map.put("totalSMB", String.valueOf(obj1.getTotalsmb()));
	              map.put("pendingapprovalsmb", String.valueOf(obj1.getPendingapprovalsmb()));
	              map.put("availablesmb", String.valueOf(obj1.getAvailablesmb()));
	              map.put("exchangedsmb", String.valueOf(obj1.getExchangedsmb()));
	        	  list1.add(map);
	          }
				result=new ResponseJson(FinalUtil.API_ERROR_CODE_0,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_0),list1);
				return result;
	        }
	        catch(Exception ex)
	        {
	        	//客户不存在
				result=new ResponseJson(FinalUtil.API_ERROR_CODE_2001,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_2001));

	        }
		}
		
		return result;
	}
	

	@ApiOperation(value = "查询世茂币callout接口", notes = "")
	@RequestMapping(value = "/get/coin/callout", method = RequestMethod.POST)
	public ResponseJson getShiMaoCoinCallout(@RequestBody String id) {

		List params=new ArrayList();
		
		params.add(new BasicNameValuePair("id", id));
		
		String url = "http://localhost:8888/get/coin";
		String resp = HttpClientUtil.doPostJson(url, params,null);
		return new ResponseJson(FinalUtil.API_ERROR_CODE_0,FinalUtil.getErrorMsg(FinalUtil.API_ERROR_CODE_0),resp);

	}
	
	
	@ApiOperation(value = "查询客户", notes = "")
	@RequestMapping(value = "/get/acc", method = RequestMethod.POST)
	public ResponseJson getAccount() throws Exception {
		List<AccountSource> list = accountSourceService.getAccount();
		System.out.println(list.get(0).getClubregisteredphoneC());
		System.out.println("*****************************");
		ResponseJson res = new ResponseJson("12","12");
		return res;
	}
	
}
