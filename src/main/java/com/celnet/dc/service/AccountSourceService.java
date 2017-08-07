package com.celnet.dc.service;

import java.util.List;
import com.celnet.dc.domain.AccountSource;

public interface AccountSourceService {

	List<AccountSource> getAccount();

	boolean getAccountByParam(String param);

	List<AccountSource> queryAccountByUserName(String username);
	
}
