package com.celnet.dc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.celnet.dc.domain.MWApiList;

public interface MWApiListMapper {
    int deleteByGUID(String guid);

    int insert(MWApiList record);

    MWApiList selectByGUID(String guid);

    int updateByGUID(MWApiList record);
    
    MWApiList selectByApiName(String apiname);

	List<MWApiList> selectAll();
	
	List<MWApiList> getApiList(@Param("method")String method,@Param("apiVersion")String apiVersion);
}