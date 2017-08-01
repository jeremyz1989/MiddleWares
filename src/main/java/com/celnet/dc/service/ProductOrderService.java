package com.celnet.dc.service;

import com.celnet.dc.domain.ProductOrder;

/**
 * 产品订单-业务接口
 *
 * Created by ensure 2017-06-17.
 */
public interface ProductOrderService {
	
	ProductOrder selectByGUID(String guid);

    int insert(ProductOrder record);

    int updateByGUID(ProductOrder record);
	
    int deleteByGUID(String guid);

}