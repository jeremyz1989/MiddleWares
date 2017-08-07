package com.celnet.dc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.celnet.dc.domain.AccountSource;

public interface AccountSourceMapper {

	List<AccountSource> getAccount(@Param("id") String id);
	
	List<AccountSource> getAccountNew();

	List<AccountSource> getAccountByParam(String param);

}
