package com.celnet.dc.service;

import com.celnet.dc.domain.Unit;

/**
 * 单元业务接口
 *
 * Created by ensure 2017-06-17.
 */
public interface UnitService {
	
	Unit selectByGUID(String guid);

    int insert(Unit record);

    int updateByGUID(Unit record);
	
    int deleteByGUID(String guid);

}