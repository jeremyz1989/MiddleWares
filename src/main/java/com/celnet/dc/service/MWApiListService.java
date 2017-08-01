package com.celnet.dc.service;

import java.util.List;

import com.celnet.dc.domain.MWApiList;

/**
 * api接口业务接口
 *
 * Created by ensure 2017-06-17.
 */
public interface MWApiListService {
	
	MWApiList selectByGUID(String guid);
	
	MWApiList selectByApiName(String apiname);
	
	List<MWApiList>  selectAll();

    int insert(MWApiList record);

    int updateByGUID(MWApiList record);
	
    int deleteByGUID(String guid);
    
    List<MWApiList> getApiList(String method,String apiVersion);

}