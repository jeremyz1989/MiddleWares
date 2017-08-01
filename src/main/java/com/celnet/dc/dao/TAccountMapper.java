package com.celnet.dc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.celnet.dc.domain.AccountSource;
import com.celnet.dc.domain.TAccount;
import com.celnet.dc.domain.TAccountSourceTest1;

public interface TAccountMapper {
	
	List<TAccount> getAccount();
	
	//通过证件号查询主档客户
	List<TAccount> getAccountByCardId(String cardId);
	//通过手机号查询主档客户
	List<TAccount> getAccountByPhone(String phone);
	
	int callAddData(@Param("guid")String guid,@Param("main_guid")String main_guid);
	
	int callSplitData(@Param("t_guid")String t_guid,@Param("m_guid")String m_guid);
}
