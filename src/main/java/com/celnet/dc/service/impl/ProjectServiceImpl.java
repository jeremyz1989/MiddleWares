package com.celnet.dc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.celnet.dc.dao.ProjectMapper;
import com.celnet.dc.domain.Project;
import com.celnet.dc.service.ProjectService;

/**
 * 系统参数业务实现层
 *
 * Created by ensure 2017-06-17.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

   
    @Override
    public Project selectByGUID(String guid) {
    	Project Project = projectMapper.selectByGUID(guid);

        return Project;
    }

    @Override
    public int insert(Project Project) {
    	int cntInt = projectMapper.insert(Project);
         return cntInt;
    }
 
    @Override
    public int updateByGUID(Project Project) {
    	int cntInt = projectMapper.updateByGUID(Project);
         return cntInt;
    }

  
    @Override
    public int deleteByGUID(String guid) {
    	int cntInt = projectMapper.deleteByGUID(guid);
         return cntInt;
    }

}