package com.celnet.dc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celnet.dc.dao.TAccountSourceTest1Mapper;
import com.celnet.dc.domain.TAccountSourceTest1;
import com.celnet.dc.service.TAccountSourceService;

@Service
public class TAccountSourceImpl implements TAccountSourceService {
	
	@Autowired
	private TAccountSourceTest1Mapper tAccountSourceMapper;

	@Override
	public List<TAccountSourceTest1> getAccountList() {
		return tAccountSourceMapper.getAccountList();
	}

	@Override
	public List<TAccountSourceTest1> getCombineAccountList() {
		return tAccountSourceMapper.getCombineAccountList();
	}

	@Override
	public List<TAccountSourceTest1> getAccountListSelectByCardId(String cardId) {
		return tAccountSourceMapper.SelectByCardId(cardId);
	}

	@Override
	public List<TAccountSourceTest1> getAccountListSelectByPhone(String phone) {
		return tAccountSourceMapper.SelectByPhone(phone);
	}

	@Override
	public List<TAccountSourceTest1> getCombineAccountListByCardId(String cardId) {
		return tAccountSourceMapper.getCombineAccountSelectByCardId(cardId);
	}

	@Override
	public List<TAccountSourceTest1> getCombineAccountListByPhone(String phone) {
		return tAccountSourceMapper.getCombineAccountSelectByPhone(phone);
	}

	@Override
	public String getMainGuid(String guid) {
		return tAccountSourceMapper.getMainGuid(guid);
	}

	@Override
	public int getCount(String m_guid) {
		return tAccountSourceMapper.getCount(m_guid);
	}

}
