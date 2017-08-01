package com.celnet.dc.service;

import com.celnet.dc.domain.Building;

/**
 * 系统参数业务接口
 *
 * Created by ensure 2017-06-17.
 */
public interface BuildingService {
	
	Building selectByGUID(String guid);

    int insert(Building record);

    int updateByGUID(Building record);
	
    int deleteByGUID(String guid);

}