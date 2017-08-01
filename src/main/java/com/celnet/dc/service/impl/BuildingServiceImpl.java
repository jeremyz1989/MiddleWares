package com.celnet.dc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.celnet.dc.dao.BuildingMapper;
import com.celnet.dc.domain.Building;
import com.celnet.dc.service.BuildingService;

/**
 * 系统参数业务实现层
 *
 * Created by ensure 2017-06-17.
 */
@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;
   
    @Override
    public Building selectByGUID(String guid) {
    	Building Building = buildingMapper.selectByGUID(guid);

        return Building;
    }
    
    @Override
    public int insert(Building building) {
    	int cntInt = buildingMapper.insert(building);
         return cntInt;
    }
 
    @Override
    public int updateByGUID(Building building) {
    	int cntInt = buildingMapper.updateByGUID(building);
         return cntInt;
    }

  
    @Override
    public int deleteByGUID( String guid) {
    	int cntInt = buildingMapper.deleteByGUID( guid);
         return cntInt;
    }

}