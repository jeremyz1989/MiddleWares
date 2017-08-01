package com.celnet.dc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celnet.dc.dao.AccountSourceMapper;
import com.celnet.dc.domain.AccountSource;
import com.celnet.dc.service.InterfaceService;

@Service
public class InterfaceServiceImpl implements InterfaceService {

	@Autowired
	private AccountSourceMapper accountSourceMapper;
	
	@Override
	public List<AccountSource> getAccount(String sfid) {
		return accountSourceMapper.getAccount(sfid);
	}

}
