package com.celnet.dc.service;

import java.util.List;

import com.celnet.dc.domain.MWSysUser;

/**
 * 用户业务接口
 *
 * Created by ensure 2017-06-17.
 */
public interface MWSysUserService {
	
    int insert(MWSysUser record);

    int updateByGUID(MWSysUser record);
    
	MWSysUser selectByGUID(String guid);
	
	MWSysUser selectByName(String username);
    
    List<MWSysUser> selectAll();
    
    int deleteByGUID(String guid);

}