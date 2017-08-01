package com.celnet.dc.dao;

import com.celnet.dc.domain.PurchaseContract;

/**
 * 合同：数据接口
 *
 * Created by ensure 2017-06-17.
 */
public interface PurchaseContractMapper {
    
    int deleteByGUID(String guid);

    int insert(PurchaseContract record);

    PurchaseContract selectByGUID(String guid);

    int updateByGUID(PurchaseContract record);
    //根据投诉建议表sfid查询房源主数据sfid
    String getHouseSfid(String sfid);
}