package com.celnet.dc.domain;

import com.celnet.dc.domain.MWApiLog;
import com.celnet.dc.domain.api.response.ResponseJson;

public interface InterfaceHandler {

	 public ResponseJson dohandle(String entry);
     public InterfaceHandler setLog(MWApiLog log);
}
