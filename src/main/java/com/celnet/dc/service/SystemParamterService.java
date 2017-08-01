package com.celnet.dc.service;

import java.util.List;

import com.celnet.dc.domain.SystemParamter;

/**
 * 系统参数业务接口
 *
 * Created by ensure 2017-06-17.
 */
public interface SystemParamterService {
	
	SystemParamter selectByGUID(Integer id);
	
	SystemParamter selectByName(String name);
	
	List<SystemParamter>  selectAll();

    int insert(SystemParamter record);

    int updateByGUID(SystemParamter record);
	
    int deleteByGUID(Integer id);

}