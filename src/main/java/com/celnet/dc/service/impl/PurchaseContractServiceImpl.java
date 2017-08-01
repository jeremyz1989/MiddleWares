package com.celnet.dc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.celnet.dc.dao.PurchaseContractMapper;
import com.celnet.dc.domain.PurchaseContract;
import com.celnet.dc.service.PurchaseContractService;

/**
 * 系统参数业务实现层
 *
 * Created by ensure 2017-06-17.
 */
@Service
public class PurchaseContractServiceImpl implements PurchaseContractService {

    @Autowired
    private PurchaseContractMapper purchaseContractMapper;

    
    @Override
    public PurchaseContract selectByGUID(String guid) {
    	PurchaseContract PurchaseContract = purchaseContractMapper.selectByGUID(guid);

        return PurchaseContract;
    }
    
    
    @Override
    public int insert(PurchaseContract PurchaseContract) {
    	int cntInt = purchaseContractMapper.insert(PurchaseContract);
         return cntInt;
    }
 
    @Override
    public int updateByGUID(PurchaseContract PurchaseContract) {
    	int cntInt = purchaseContractMapper.updateByGUID(PurchaseContract);
         return cntInt;
    }

  
    @Override
    public int deleteByGUID(String guid) {
    	int cntInt = purchaseContractMapper.deleteByGUID(guid);
         return cntInt;
    }


	@Override
	public String getHouseSfid(String sfid) {
		return purchaseContractMapper.getHouseSfid(sfid);
	}

}