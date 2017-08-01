package com.celnet.dc.dao;

import com.celnet.dc.domain.Building;

public interface BuildingMapper {
    int deleteByGUID(String guid);

    int insert(Building record);

    Building selectByGUID(String guid);

    int updateByGUID(Building record);
}