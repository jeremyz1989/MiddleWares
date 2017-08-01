package com.celnet.dc.dao;

import java.util.List;

import com.celnet.dc.domain.SystemParamter;

public interface SystemParamterMapper {
    int deleteByGUID(Integer id);

    int insert(SystemParamter record);

    SystemParamter selectByGUID(Integer id);
    
    SystemParamter selectByName(String name);
    
    List<SystemParamter> selectAll();

    int updateByGUID(SystemParamter record);
}