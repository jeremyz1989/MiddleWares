package com.celnet.dc.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.celnet.dc.common.util.HttpClientUtil;
import com.celnet.dc.domain.AccountSource;
import com.celnet.dc.domain.api.request.HouseOwnerChangeRequestJson;
import com.celnet.dc.domain.api.request.UnitsInfoInterfaceClass;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PushHouseBindingController {

	public void pushAccount(List<AccountSource> list) throws NoSuchAlgorithmException{
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		
		 String timestamp2 =  df.format(new Date());
		 String bussinessId = "SFDC";
		  String app_secret = "cn@shimaoHeroku";
		  String businessIdStr = app_secret + "SFDC" + timestamp2  + "http://sm.kwinsmarthome.com:10010/Notify/Salesforce/usermodify" + app_secret;
		  //String businessIdStr = 'SFDC'  + SystemConfig.qyUrl;
		  System.out.println("businessIdStr:" + businessIdStr);
		  MessageDigest mdt = MessageDigest.getInstance("MD5");
	      mdt.update(businessIdStr.getBytes());
	      String myMdKey = byte2hex(mdt.digest());
	      System.out.println("签名：" + myMdKey);
		  List<HouseOwnerChangeRequestJson> accList = new ArrayList<HouseOwnerChangeRequestJson>();
		  /*newHouseOCR.acceptName    =  accidMap.get(obj.Customer__c).Name                    ;
    newHouseOCR.acceptphone   =  accidMap.get(obj.Customer__c).ClubRegisteredPhone__c  ;
    newHouseOCR.acceptCardId  =  accidMap.get(obj.Customer__c).Bahns__c */
		  for(AccountSource acc : list){
			  HouseOwnerChangeRequestJson house = new HouseOwnerChangeRequestJson();
			  house.setAcceptName(acc.getName());
			  house.setAcceptphone(acc.getClubregisteredphoneC());
			  house.setAcceptCardId(acc.getBahnsC());
			 accList.add(house);
		  }
		  
		 
		//1、使用JSONObject
		 // JSONObject json = JSONObject.fromObject(accList);
		//2、使用JSONArray
		JSONArray array=JSONArray.fromObject(accList);
		//String strJson=json.toString();
		String strArray=array.toString();
		System.out.println("strJson:"+strArray);
		//System.out.println("strArray:"+strArray);
		  
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("timestamp", timestamp2));
		params.add(new BasicNameValuePair("token", myMdKey));
		params.add(new BasicNameValuePair("acceptList", strArray));
		String url = "http://sm.kwinsmarthome.com:10010/Notify/Salesforce/usermodify";
		String resp = HttpClientUtil.doPostJson(url, params,null);
		System.out.println("请求过去++++++++++++++++++++++++++++++++++++");
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
