package com.celnet.dc.service;

import java.util.List;

import com.celnet.dc.domain.TAccount;
import com.celnet.dc.domain.TAccountSourceTest1;

public interface TAccountService {

	List<TAccount> getAccount();
	
	//通过证件号查询主档客户
	List<TAccount> getAccountByCardId(String cardId);
	//通过手机号查询主档客户
	List<TAccount> getAccountByPhone(String phone);
	
	int callAddData(String guid,String main_guid);
	
	int callSplitData(String t_guid,String m_guid);
}
