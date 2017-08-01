package com.celnet.dc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.celnet.dc.domain.AccountSource;
import com.celnet.dc.domain.TAccountSourceTest1;

public interface TAccountSourceTest1Mapper {

	List<AccountSource> getAccount(@Param("id") String id);
	
	List<TAccountSourceTest1> getAccountList();
	
	List<TAccountSourceTest1> getCombineAccountList();
	//通过证件号查询来源客户
	List<TAccountSourceTest1> SelectByCardId(String cardId);
	//通过手机号查询来源客户
	List<TAccountSourceTest1> SelectByPhone(String phone);
	//通过证件号查询合并客户
	List<TAccountSourceTest1> getCombineAccountSelectByCardId(String cardId);
	//通过手机号查询合并客户
	List<TAccountSourceTest1> getCombineAccountSelectByPhone(String phone);
	//通过来源客户id查询对应主档客户id
	String getMainGuid(String guid);
	//查询来源表，合并记录条数
	int getCount(String m_guid);
}
