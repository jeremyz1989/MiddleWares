package com.celnet.dc.dao;

import java.util.List;

import com.celnet.dc.domain.MWApiSystem;

public interface MWApiSystemMapper {
    int deleteByGUID(String guid);

    int insert(MWApiSystem record);

    MWApiSystem selectByGUID(String guid);

    int updateByGUID(MWApiSystem record);
    
    MWApiSystem selectByAppKey(String apiname);

	List<MWApiSystem> selectAll();
}