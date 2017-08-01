package com.celnet.dc.common.exception;

import com.celnet.dc.common.util.FinalUtil;
import com.celnet.dc.domain.api.response.ResponseJson;
import com.github.pagehelper.StringUtil;

public class ErrorMessage {
	public ResponseJson errorHandle(String errorCode, String parameter) {
		ResponseJson responseJson = new ResponseJson();
		responseJson.setErrCode(errorCode);
		responseJson.setErrMsg(FinalUtil.getErrorMsg(errorCode));
		if (StringUtil.isNotEmpty(parameter)) {
			responseJson.setErrMsg(String.format(responseJson.getErrMsg(), new String[] { parameter }));
		}
		return responseJson;
	}

}
