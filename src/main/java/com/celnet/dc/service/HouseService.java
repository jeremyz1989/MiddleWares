package com.celnet.dc.service;

import com.celnet.dc.domain.House;

/**
 * 房源业务接口
 *
 * Created by ensure 2017-06-17.
 */
public interface HouseService {
	
	House selectByGUID(String guid);

    int insert(House record);

    int updateByGUID(House record);
	
    int deleteByGUID(String guid);

}