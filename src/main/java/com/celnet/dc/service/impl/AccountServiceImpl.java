package com.celnet.dc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celnet.dc.dao.AccountMapper;
import com.celnet.dc.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public String getAccountName(String sfid) {
		return accountMapper.getAccountName(sfid);
	}

}
