package com.celnet.dc.dao;

import com.celnet.dc.domain.House;

public interface HouseMapper {
    int deleteByGUID(String guid);

    int insert(House record);

    House selectByGUID(String guid);

    int updateByGUID(House record);

}