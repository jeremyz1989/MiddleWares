package com.celnet.dc.service;

import java.util.List;

import com.celnet.dc.domain.MWApiLog;

/**
 * 系统参数业务接口
 *
 * Created by ensure 2017-06-17.
 */
public interface MWApiLogService {
	
	MWApiLog selectByGUID(String guid);
	
	MWApiLog selectByApiName(String apiname);
	
	List<MWApiLog>  selectAll();

    int insert(MWApiLog record);

    int updateByGUID(MWApiLog record);
	
    int deleteByGUID(String guid);

}