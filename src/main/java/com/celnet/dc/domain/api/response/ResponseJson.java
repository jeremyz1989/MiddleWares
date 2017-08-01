package com.celnet.dc.domain.api.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ResponseJson {
	@ApiModelProperty(value = "状态码", example = "40001", required = true, position = -2)
	private String errCode;

	@ApiModelProperty(value = "返回消息", example = "成功！", required = true, position = -1)
	private String errMsg;

	@ApiModelProperty(value = "具体数据")
	private Object data;

	public ResponseJson(){
		
	}
	
	public ResponseJson(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	
	public ResponseJson(String errCode, String errMsg, Object data) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.data = data;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseJson [errCode=" + errCode + ", errMsg=" + errMsg + ", data=" + data ;
	}
	
	
}
