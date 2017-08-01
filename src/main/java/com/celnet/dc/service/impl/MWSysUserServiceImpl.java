package com.celnet.dc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.celnet.dc.dao.MWSysUserMapper;
import com.celnet.dc.domain.MWSysUser;

import java.util.List;
import com.celnet.dc.service.MWSysUserService;

/**
 * 系统参数业务实现层
 *
 * Created by ensure 2017-06-17.
 */
@Service
public class MWSysUserServiceImpl implements MWSysUserService {

    @Autowired
    private MWSysUserMapper mwSysUserMapper;

    //@TargetDataSource(name="ds2")//指定数据源
    public MWSysUser selectByName(String username) {
    	MWSysUser AccountSource = mwSysUserMapper.selectByName(username);

        return AccountSource;
    }
    
    //@Override
    public MWSysUser selectByGUID(String guid) {
    	MWSysUser AccountSource = mwSysUserMapper.selectByGUID(guid);

        return AccountSource;
    }
    
    //@Override
    public List<MWSysUser> selectAll() {
         List<MWSysUser> list = mwSysUserMapper.selectAll();
         return list;
    }
    
    //@Override
    public int insert(MWSysUser record) {
    	int cntInt = mwSysUserMapper.insert(record);
         return cntInt;
    }


    //@Override
    public int updateByGUID(MWSysUser record) {
    	int cntInt = mwSysUserMapper.updateByGUID(record);
         return cntInt;
    }


    //@Override
    public int deleteByGUID(String guid) {
    	int cntInt = mwSysUserMapper.deleteByGUID(guid);
         return cntInt;
    }

}