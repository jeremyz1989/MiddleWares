package com.celnet.dc.dao;

import com.celnet.dc.domain.Project;

/**
 * 项目数据接口
 *
 * Created by ensure 2017-06-17.
 */
public interface ProjectMapper {
    int deleteByGUID(String guid);

    int insert(Project record);

    Project selectByGUID(String guid);

    int updateByGUID(Project record);
}