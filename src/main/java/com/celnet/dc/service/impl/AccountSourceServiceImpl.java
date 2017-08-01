package com.celnet.dc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celnet.dc.dao.AccountSourceMapper;
import com.celnet.dc.domain.AccountSource;
import com.celnet.dc.service.AccountSourceService;

@Service
public class AccountSourceServiceImpl implements AccountSourceService{

	@Autowired
	private AccountSourceMapper accountSourceMapper;
	
	@Override
	public List<AccountSource> getAccount() {
		List<AccountSource> list = accountSourceMapper.getAccountNew();
		return list;
	}

	
}
