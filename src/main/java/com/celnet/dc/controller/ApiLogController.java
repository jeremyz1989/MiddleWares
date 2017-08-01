package com.celnet.dc.controller;

import java.io.IOException;
import java.util.Date;

import com.celnet.dc.common.util.FinalUtil;
import com.celnet.dc.domain.MWApiList;
import com.celnet.dc.domain.MWApiLog;
import com.celnet.dc.domain.api.request.RequestJson;
import com.celnet.dc.domain.api.response.ResponseJson;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 记录日志表
 * 
 * @author loki
 *
 */
public class ApiLogController {

	ObjectMapper objectMapper = new ObjectMapper();

	// 序列化成功的请求报文，记录为集成日志 insert/update
	public MWApiLog InsertLog(MWApiList list, String body) {
		MWApiLog log = new MWApiLog();
		log.setStartTime(new Date());
		log.setEndpoint(list.getEndpoint());
		log.setRequestText(body);
		log.setCallType(list.getCallType());
		log.setCreateddate(new Date());
		log.setCreateduserguid("");
		if (log.getGuid() != null && log.getGuid() != "") {
			// 更新日志
		} else {
			// 插入日志
		}
		return log;
	}

	// 序列化失败的请求报文，记录为集成日志 insert/update
	public MWApiLog InsertErrorLog(RequestJson requestJson, String endPoint, String type, Exception ex) {
		MWApiLog log = new MWApiLog();
		log.setStartTime(new Date());
		log.setEndpoint(endPoint);
		log.setCallType(type);
		log.setCreateddate(new Date());
		log.setCreateduserguid("");
		log.setExceptionMsg(ex.getMessage());
		log.setStackTrace(String.valueOf(ex.getStackTrace().length));
		log.setEndTime(new Date());
		log.setDuration(String.valueOf(log.getEndTime().getTime() - log.getStartTime().getTime()));
		// 插入日志
		return log;
	}

	// 更新集成日志
	public void UpdateLog(MWApiLog log, String Response_Text, String Status)
			throws JsonParseException, JsonMappingException, IOException {
		ResponseJson responseBody = null;
		try {
			responseBody = (ResponseJson) objectMapper.readValue(Response_Text, ResponseJson.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		String LogStatus = (FinalUtil.getErrorMsg(responseBody.getErrCode()));// errcode:
																				// 0-成功
		log.setStatus(LogStatus);
		log.setResponseText(Response_Text);
		log.setEndTime(new Date());
		log.setDuration(String.valueOf(log.getEndTime().getTime() - log.getStartTime().getTime()));
		// 更新日志
	}

	// 更新集成日志的异常信息
	public void UpdateErrorLog(MWApiLog log, Exception ex, String Response_Text) {
		log.setStatus((ex.getMessage().contains("Read timed out") ? "超时" : "异常"));
		log.setExceptionMsg(ex.getMessage());
		log.setStackTrace(String.valueOf(ex.getStackTrace().length));
		log.setResponseText(Response_Text);
		log.setEndTime(new Date());
		log.setDuration(String.valueOf(log.getEndTime().getTime() - log.getStartTime().getTime()));
		// 更新日志update log;
	}

}
