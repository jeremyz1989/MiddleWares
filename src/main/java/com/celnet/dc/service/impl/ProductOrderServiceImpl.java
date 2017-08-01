package com.celnet.dc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.celnet.dc.dao.ProductOrderMapper;
import com.celnet.dc.domain.ProductOrder;
import com.celnet.dc.service.ProductOrderService;

/**
 * 产品订单-业务实现层
 *
 * Created by ensure 2017-06-17.
 */
@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    private ProductOrderMapper productOrderMapper;

    
    @Override
    public ProductOrder selectByGUID(String guid) {
    	ProductOrder ProductOrder = productOrderMapper.selectByGUID(guid);

        return ProductOrder;
    }

    
    @Override
    public int insert(ProductOrder ProductOrder) {
    	int cntInt = productOrderMapper.insert(ProductOrder);
         return cntInt;
    }
 
    @Override
    public int updateByGUID(ProductOrder ProductOrder) {
    	int cntInt = productOrderMapper.updateByGUID(ProductOrder);
         return cntInt;
    }

  
    @Override
    public int deleteByGUID(String guid) {
    	int cntInt = productOrderMapper.deleteByGUID(guid);
         return cntInt;
    }

}