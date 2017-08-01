package com.celnet.dc.dao;

import java.util.List;

import com.celnet.dc.domain.MWApiLog;

public interface MWApiLogMapper {
    int deleteByGUID(String guid);

    int insert(MWApiLog record);

    MWApiLog selectByGUID(String guid);

    MWApiLog selectByApiName(String apiname);

	List<MWApiLog> selectAll();

    int updateByGUID(MWApiLog record);
}