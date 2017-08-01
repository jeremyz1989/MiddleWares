package com.celnet.dc.dao;

import com.celnet.dc.domain.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(String sfid);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(String sfid);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    
    String getAccountName(String sfid);
}