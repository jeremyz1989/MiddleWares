package com.celnet.dc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.celnet.dc.dao.MWApiListMapper;
import com.celnet.dc.domain.MWApiList;

import java.util.List;
import com.celnet.dc.service.MWApiListService;

/**
 * 系统参数业务实现层
 *
 * Created by ensure 2017-06-17.
 */
@Service
public class MWApiListServiceImpl implements MWApiListService {

    @Autowired
    private MWApiListMapper mwApiListMapper;

    //根据接口名称查询参数信息
    @Override
    public MWApiList selectByApiName(String name) {
    	MWApiList MWApiList = mwApiListMapper.selectByApiName(name);

        return MWApiList;
    }
    
    
    @Override
    public MWApiList selectByGUID(String guid) {
    	MWApiList MWApiList = mwApiListMapper.selectByGUID(guid);

        return MWApiList;
    }
    
    @Override
    public List<MWApiList> selectAll() {
         List<MWApiList> list = mwApiListMapper.selectAll();
         return list;
    }
    
    @Override
    public int insert(MWApiList MWApiList) {
    	int cntInt = mwApiListMapper.insert(MWApiList);
         return cntInt;
    }
 
    @Override
    public int updateByGUID(MWApiList MWApiList) {
    	int cntInt = mwApiListMapper.updateByGUID(MWApiList);
         return cntInt;
    }

  
    @Override
    public int deleteByGUID(String guid) {
    	int cntInt = mwApiListMapper.deleteByGUID(guid);
         return cntInt;
    }


	@Override
	public List<MWApiList> getApiList(String method, String apiVersion) {
				return mwApiListMapper.getApiList(method,apiVersion);
	}

}