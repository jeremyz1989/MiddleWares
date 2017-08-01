package com.celnet.dc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.celnet.dc.dao.MWApiLogMapper;
import com.celnet.dc.domain.MWApiLog;

import java.util.List;
import com.celnet.dc.service.MWApiLogService;

/**
 * 接口列表业务实现层
 *
 * Created by ensure 2017-06-17.
 */
@Service
public class MWApiLogServiceImpl implements MWApiLogService {

    @Autowired
    private MWApiLogMapper mwApiLogMapper;

    //根据接口名称查询信息
    @Override
    public MWApiLog selectByApiName(String name) {
    	MWApiLog MWApiLog = mwApiLogMapper.selectByApiName(name);

        return MWApiLog;
    }
    
    
    @Override
    public MWApiLog selectByGUID(String guid) {
    	MWApiLog MWApiLog = mwApiLogMapper.selectByGUID(guid);

        return MWApiLog;
    }
    
    @Override
    public List<MWApiLog> selectAll() {
         List<MWApiLog> list = mwApiLogMapper.selectAll();
         return list;
    }
    
    @Override
    public int insert(MWApiLog MWApiLog) {
    	int cntInt = mwApiLogMapper.insert(MWApiLog);
         return cntInt;
    }
 
    @Override
    public int updateByGUID(MWApiLog MWApiLog) {
    	int cntInt = mwApiLogMapper.updateByGUID(MWApiLog);
         return cntInt;
    }

  
    @Override
    public int deleteByGUID(String guid) {
    	int cntInt = mwApiLogMapper.deleteByGUID(guid);
         return cntInt;
    }

}