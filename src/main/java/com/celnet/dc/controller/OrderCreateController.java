package com.celnet.dc.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.celnet.dc.common.util.HttpClientUtil;
import com.celnet.dc.common.util.StringUtil;
import com.celnet.dc.domain.ComplaintsAdviceC;
import com.celnet.dc.domain.api.response.OrderResponseJson;
import com.celnet.dc.service.AccountService;
import com.celnet.dc.service.PurchaseContractService;

import io.swagger.annotations.Api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;



@RestController
@RequestMapping(value = "order")
@Api("工单融合-相关api") 
public class OrderCreateController {

	@Autowired
	private PurchaseContractService purchaseContractService;
	
	@Autowired
	private AccountService accountService;
	
	public void createOrderList(List<ComplaintsAdviceC> list){
		Set<String> set = new HashSet<String>();
		for(ComplaintsAdviceC complain : list){
			set.add(complain.getCreatedbyid());
		}
		for(String id : set){
			List<ComplaintsAdviceC> orderList = new ArrayList<ComplaintsAdviceC>();
			for(ComplaintsAdviceC complain : list){
				if(complain.getCreatedbyid().equals(id)){
					orderList.add(complain);
				}
			}
			try{
				createOrder(orderList);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void createOrder(List<ComplaintsAdviceC> list) throws NoSuchAlgorithmException, IOException{
		List<Map<String,String>> orderList = new ArrayList<Map<String,String>>();
		String createUser = "";
		for(ComplaintsAdviceC complain : list){
			createUser = complain.getCreatedbyid();
			Map<String,String> map = new HashMap<String,String>();
			map.put("workOrderSFID", complain.getSfid());
			map.put("processId", "2");
			map.put("woTypeCode", "1");
			map.put("woSourceCode", "4");
			map.put("departmentCode", "1");
			map.put("complainType", "1");
			//根据工单的id，查询房源id
			String houseSfid = purchaseContractService.getHouseSfid(complain.getSfid());
			map.put("roomId", houseSfid);
			map.put("problemTheme", complain.getEventpropertiesC());
			map.put("problemDesc", complain.getEventpropertiesC());
			//根据请求人sfid查询客户姓名
			if(StringUtil.isNotEmpty(accountService.getAccountName(complain.getCustomernameC()))){
				map.put("requestName", accountService.getAccountName(complain.getCustomernameC()));
			}else{
				map.put("requestName", "");
			}
			map.put("requestPhone", complain.getCalleridC());
			map.put("ownerId", complain.getCustomernameC());
			//紧急程度
			map.put("woLevelCode", "1");
			//报修类别bxTypeCode
			map.put("bxTypeCode", "1");
			map.put("checkListSource", "4");
			orderList.add(map);
		}
//		Map<String,List<Map<String,String>>> orderMap = new HashMap<String,List<Map<String,String>>>();
//		orderMap.put("workOrderList", orderList);
		JSONArray obj=(JSONArray)JSON.toJSON(orderList);
		String strObj=obj.toString();
		System.out.println(strObj);
		
//		Header[] header = new Header[5];
//		header[0] = new BasicHeader("method", "sf_create_order");
//		header[1] = new BasicHeader("app", "salesforce");
//		header[2] = new BasicHeader("v","1.0");
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//		header[3] = new BasicHeader("timestamp",df.format(new Date()));
//		String secret = "01b03b5011b14bd9bc3b4736b1674edb";
//		String signStr = secret + "app" + "saleforce" + "method" + "sf_create_order" + "sfid" + createUser + "timestamp" + df.format(new Date()) + "v" + "1.0" + secret ;
//		byte[] byteMD5 = encryptMD5(signStr.getBytes());
//		String myMdKey = byte2hex(byteMD5);
//		header[4] = new BasicHeader("sign",myMdKey);
		
		
	        Map<String, String> signMap = new HashMap<String, String>();
	        String secret = "01b03b5011b14bd9bc3b4736b1674edb";
	        signMap.put("v", "1.0");
	        signMap.put("method", "sf_create_order");
	        signMap.put("app", "saleforce");
	        signMap.put("timestamp", df.format(new Date()));
	        signMap.put("sfId",createUser);
	        signMap.put("content",strObj);
	        //检查参数是否已经排序
	        String[] keys1 = signMap.keySet().toArray(new String[0]);
	        Arrays.sort(keys1);
	        // 把所有参数名和参数值串在一起
	        StringBuilder query1 = new StringBuilder();
	        query1.append(secret);
	        for (String key : keys1) {
	            String value = signMap.get(key);
	            if (key != null && key.length() != 0) {
	                query1.append(key).append(value);
	            }
	        }
	     // 使用MD5/HMAC加密
	        query1.append(secret);
	        byte[] bytes1 = encryptMD5(query1.toString().replaceAll("\\s+", "+").getBytes());
	        String myMdKey = byte2hex(bytes1);
		
		
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("method", "sf_create_order"));
		params.add(new BasicNameValuePair("app", "saleforce"));
		params.add(new BasicNameValuePair("v","1.0"));
		params.add(new BasicNameValuePair("timestamp",df.format(new Date())));
		params.add(new BasicNameValuePair("sign",myMdKey));
		params.add(new BasicNameValuePair("sfId",createUser));
		System.out.println(createUser);
		params.add(new BasicNameValuePair("content", strObj));
		System.out.println(df.format(new Date()));
		System.out.println(myMdKey);
		String url = "https://shimaowymanagetest.herokuapp.com/router/api";
		String resp = HttpClientUtil.doPostJson(url, params,null);
		System.out.println("请求结束：。。。。。。。。。。");
		System.out.println(resp);
		try{
		JSONObject jsonObj = JSONObject.parseObject(resp);	
		Object result = jsonObj.get("result");
		List<OrderResponseJson> resList = (List<OrderResponseJson>)JSON.parseArray(result.toString(), OrderResponseJson.class);
		for(OrderResponseJson order : resList){
			//将工单id更新到本地投诉建议表
			ComplaintsAdviceC complaint = new ComplaintsAdviceC();
			complaint.setPropertyidC(order.getWoId());
			System.out.println("工单id" + order.getWoId());
		}
		}catch (JSONException e){
			System.out.println("出错");
			e.printStackTrace();
		}
		
	}
	
	public static byte[] encryptMD5(byte[] data) throws IOException {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            bytes = md.digest(data);
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.toString());
        }
        return bytes;
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
}
