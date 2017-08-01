package com.celnet.dc.dao;

import com.celnet.dc.domain.Unit;

public interface UnitMapper {
    int deleteByGUID(String guid);

    int insert(Unit record);

    Unit selectByGUID(String guid);

    int updateByGUID(Unit record);
}