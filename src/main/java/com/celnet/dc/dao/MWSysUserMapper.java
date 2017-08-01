package com.celnet.dc.dao;

import java.util.List;

import com.celnet.dc.domain.MWSysUser;

public interface MWSysUserMapper {
	int insert(MWSysUser record);

	int updateByGUID(MWSysUser record);

	MWSysUser selectByGUID(String guid);

	MWSysUser selectByName(String username);

	List<MWSysUser> selectAll();

	int deleteByGUID(String guid);
}