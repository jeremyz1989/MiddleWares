package com.celnet.dc.service;

import java.util.List;

import com.celnet.dc.domain.TAccountSourceTest1;

public interface TAccountSourceService {

	List<TAccountSourceTest1> getAccountList();
	
	List<TAccountSourceTest1> getCombineAccountList();
	//通过证件号查询来源客户
	List<TAccountSourceTest1> getAccountListSelectByCardId(String cardId);
	//通过手机号查询来源客户
	List<TAccountSourceTest1> getAccountListSelectByPhone(String phone);
	//通过证件号查询合并客户
	List<TAccountSourceTest1> getCombineAccountListByCardId(String cardId);
	//通过手机号查询合并客户
	List<TAccountSourceTest1> getCombineAccountListByPhone(String phone);
	//通过来源客户id查询对应主档客户id
	String getMainGuid(String guid);
	//查询来源表，合并记录条数
	int getCount(String m_guid);
	
	
}
