package com.celnet.dc.service;

import java.util.List;

import com.celnet.dc.domain.AccountSource;

public interface InterfaceService {

	List<AccountSource> getAccount(String sfid);
	
}
