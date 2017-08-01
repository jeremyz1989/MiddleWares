package com.celnet.dc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.celnet.dc.dao.UnitMapper;
import com.celnet.dc.domain.Unit;
import com.celnet.dc.service.UnitService;

/**
 * 单元业务实现层
 *
 * Created by ensure 2017-06-17.
 */
@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitMapper unitMapper;

   
    @Override
    public Unit selectByGUID(String guid) {
    	Unit Project = unitMapper.selectByGUID(guid);

        return Project;
    }

    @Override
    public int insert(Unit Project) {
    	int cntInt = unitMapper.insert(Project);
         return cntInt;
    }
 
    @Override
    public int updateByGUID(Unit Project) {
    	int cntInt = unitMapper.updateByGUID(Project);
         return cntInt;
    }

  
    @Override
    public int deleteByGUID(String guid) {
    	int cntInt = unitMapper.deleteByGUID(guid);
         return cntInt;
    }

}