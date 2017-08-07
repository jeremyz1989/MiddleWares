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

	@Override
	public boolean getAccountByParam(String param) {

		List<AccountSource> list = accountSourceMapper.getAccountByParam(param);
		//如果数据库有匹配的账户，则返回true，否则返回false
		return list.size()>0?true:false;
	}

	@Override
	public List<AccountSource> queryAccountByUserName(String username) {
		List<AccountSource> list = accountSourceMapper.getAccountByParam(username);
		return list;
	}


}
