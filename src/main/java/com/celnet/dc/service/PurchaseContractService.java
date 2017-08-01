package com.celnet.dc.service;

import com.celnet.dc.domain.PurchaseContract;

/**
 * 合同：业务接口
 *
 * Created by ensure 2017-06-17.
 */
public interface PurchaseContractService {
	
	PurchaseContract selectByGUID(String guid);

	int insert(PurchaseContract record);

    int updateByGUID(PurchaseContract record);
	
    int deleteByGUID(String guid);
    //根据投诉建议表sfid查询房源主数据sfid
    String getHouseSfid(String sfid);

}