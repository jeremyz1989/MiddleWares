package com.celnet.dc.domain.api.request;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.ApiModelProperty;

public class RequestJson {
	// 1. 将Content-Type、timestamp、version、app_key、method五个参数进行字典序排序
	// 2. 将五个参数参数名加值拼接成一个字符串并在字符串头尾加secret进行MD5加密计算
	// 3. 开发者获得加密后的字符串可与sign对比，标识该请求来源于授权App
	// 以下是接口中Http请求Header示例：
	// "timestamp": "2017-05-16 21:10:00", 时间戳 GTM+8，系统允许最大误差时间为10分钟
	// "sign": "DD2D211D376DABD505E325C0B13BB113", 签名
	// "Content-Type": "Application/json", 请求数据类型
	// "version": "1.0", API版本号
	// "app_key": "cn@qianyunApi" 授权应用Key
	// "method": "cst_status_visit_info" 请求接口名称

	@ApiModelProperty(value = "请求接口名称  ")
	private String method;

	@ApiModelProperty(value = "密钥 ")
	private String secretId;

	@ApiModelProperty(value = " 请求数据类型： Application/json")
	private String contentType = "Application/json";

	@ApiModelProperty(value = "外部系统授权应用Key ")
	private String app_key; // 外部系统编号（KEY）,授权应用Key

	@ApiModelProperty(value = "API版本号")
	private String version;

	@ApiModelProperty(value = "传入数据")
	private Object data;
	
	@ApiModelProperty(value = "请求Json")
	private String timestamp;
	
	@ApiModelProperty(value = "签名串")
	private String sign;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getSecretId() {
		return secretId;
	}

	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getApp_key() {
		return app_key;
	}

	public void setApp_key(String app_key) {
		this.app_key = app_key;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


	public RequestJson() {
		super();
	}
	
//	public RequestJson(String method, String secretId, String contentType, String app_key, String apiVersion,
//			Object data) {
//		this.method = method;
//		this.secretId = secretId;
//		this.contentType = contentType; 
//		this.app_key = app_key; 
//		this.apiVersion = apiVersion; 
//		this.data = data;
//	}
	
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public  RequestJson(HttpServletRequest request) {
		this.method = request.getHeader("method");
		this.secretId = request.getHeader("secretId");
		this.contentType = request.getHeader("Content-Type"); 
		this.app_key = request.getHeader("app_key"); 
		this.version = request.getHeader("version"); 
		this.timestamp = request.getHeader("timestamp");
		this.sign = request.getHeader("sign");
	}


	@Override
	public String toString() {
		return "RequestJson [method=" + method + ", secretId=" + secretId + ", contentType=" + contentType + ", app_key="
				+ app_key + ", apiVersion=" + version + ", data=" + data + "]";
	}

}
