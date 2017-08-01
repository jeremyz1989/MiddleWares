package com.celnet.dc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.celnet.dc.dao.SystemParamterMapper;
import com.celnet.dc.domain.SystemParamter;

import java.util.List;
import com.celnet.dc.service.SystemParamterService;

/**
 * 系统参数业务实现层
 *
 * Created by ensure 2017-06-17.
 */
@Service
public class SystemParamterServiceImpl implements SystemParamterService {

    @Autowired
    private SystemParamterMapper systemParamterMapper;

    //根据参数名称查询参数信息
    @Override
    public SystemParamter selectByName(String name) {
    	SystemParamter systemParamter = systemParamterMapper.selectByName(name);

        return systemParamter;
    }
    
    
    @Override
    public SystemParamter selectByGUID(Integer id) {
    	SystemParamter systemParamter = systemParamterMapper.selectByGUID(id);

        return systemParamter;
    }
    
    @Override
    public List<SystemParamter> selectAll() {
         List<SystemParamter> list = systemParamterMapper.selectAll();
         return list;
    }
    
    @Override
    public int insert(SystemParamter systemParamter) {
    	int cntInt = systemParamterMapper.insert(systemParamter);
         return cntInt;
    }
 
    @Override
    public int updateByGUID(SystemParamter systemParamter) {
    	int cntInt = systemParamterMapper.updateByGUID(systemParamter);
         return cntInt;
    }

  
    @Override
    public int deleteByGUID(Integer id) {
    	int cntInt = systemParamterMapper.deleteByGUID(id);
         return cntInt;
    }

}