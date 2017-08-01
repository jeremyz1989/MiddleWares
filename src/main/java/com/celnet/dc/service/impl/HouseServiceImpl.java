package com.celnet.dc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.celnet.dc.dao.HouseMapper;
import com.celnet.dc.domain.House;
import com.celnet.dc.service.HouseService;

/**
 * 房源业务实现层
 *
 * Created by ensure 2017-06-17.
 */
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;
   
    
    @Override
    public House selectByGUID(String id) {
    	House House = houseMapper.selectByGUID(id);

        return House;
    }
    
    @Override
    public int insert(House House) {
    	int cntInt = houseMapper.insert(House);
         return cntInt;
    }
 
    @Override
    public int updateByGUID(House House) {
    	int cntInt = houseMapper.updateByGUID(House);
         return cntInt;
    }

  
    @Override
    public int deleteByGUID(String guid) {
    	int cntInt = houseMapper.deleteByGUID(guid);
         return cntInt;
    }

}