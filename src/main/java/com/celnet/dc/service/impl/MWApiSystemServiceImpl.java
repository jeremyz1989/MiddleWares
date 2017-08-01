package com.celnet.dc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.celnet.dc.dao.MWApiSystemMapper;
import com.celnet.dc.domain.MWApiSystem;

import java.util.List;
import com.celnet.dc.service.MWApiSystemService;

/**
 * 接口外部系统-业务实现层
 *
 * Created by ensure 2017-06-17.
 */
@Service
public class MWApiSystemServiceImpl implements MWApiSystemService {

    @Autowired
    private MWApiSystemMapper mwApiSystemMapper;

    //根据参数名称查询参数信息
    @Override
    public MWApiSystem selectByAppKey(String appKey) {
    	MWApiSystem MWApiSystem = mwApiSystemMapper.selectByAppKey(appKey);

        return MWApiSystem;
    }
    
    
    @Override
    public MWApiSystem selectByGUID(String guid) {
    	MWApiSystem MWApiSystem = mwApiSystemMapper.selectByGUID(guid);

        return MWApiSystem;
    }
    
    @Override
    public List<MWApiSystem> selectAll() {
         List<MWApiSystem> list = mwApiSystemMapper.selectAll();
         return list;
    }
    
    @Override
    public int insert(MWApiSystem MWApiSystem) {
    	int cntInt = mwApiSystemMapper.insert(MWApiSystem);
         return cntInt;
    }
 
    @Override
    public int updateByGUID(MWApiSystem MWApiSystem) {
    	int cntInt = mwApiSystemMapper.updateByGUID(MWApiSystem);
         return cntInt;
    }

  
    @Override
    public int deleteByGUID(String guid) {
    	int cntInt = mwApiSystemMapper.deleteByGUID(guid);
         return cntInt;
    }

}