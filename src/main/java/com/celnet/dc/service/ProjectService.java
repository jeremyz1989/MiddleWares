package com.celnet.dc.service;

import com.celnet.dc.domain.Project;

/**
 * 项目业务接口
 *
 * Created by ensure 2017-06-17.
 */
public interface ProjectService {
	
	Project selectByGUID(String guid);

    int insert(Project record);

    int updateByGUID(Project record);
	
    int deleteByGUID(String guid);

}