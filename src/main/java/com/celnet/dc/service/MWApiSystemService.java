package com.celnet.dc.service;

import java.util.List;

import com.celnet.dc.domain.MWApiSystem;

/**
 * api接口业务接口
 *
 * Created by ensure 2017-06-17.
 */
public interface MWApiSystemService {
	
	MWApiSystem selectByGUID(String guid);
	
	MWApiSystem selectByAppKey(String apiname);
	
	List<MWApiSystem>  selectAll();

    int insert(MWApiSystem record);

    int updateByGUID(MWApiSystem record);
	
    int deleteByGUID(String guid);

}