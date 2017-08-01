package com.celnet.dc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celnet.dc.dao.TAccountMapper;
import com.celnet.dc.domain.TAccount;
import com.celnet.dc.service.TAccountService;

@Service
public class TAccountServiceImpl implements TAccountService {
	
	@Autowired
	private TAccountMapper tAccountMapper;

	@Override
	public List<TAccount> getAccount() {
		return tAccountMapper.getAccount();
	}

	@Override
	public List<TAccount> getAccountByCardId(String cardId) {
		return tAccountMapper.getAccountByCardId(cardId);
	}

	@Override
	public List<TAccount> getAccountByPhone(String phone) {
		return tAccountMapper.getAccountByPhone(phone);
	}

	@Override
	public int callAddData(String guid,String main_guid) {
		return tAccountMapper.callAddData(guid,main_guid);
	}

	@Override
	public int callSplitData(String t_guid, String m_guid) {
		return tAccountMapper.callSplitData(t_guid, m_guid);
	}

}
