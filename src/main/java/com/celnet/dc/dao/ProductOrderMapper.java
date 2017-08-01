package com.celnet.dc.dao;

import com.celnet.dc.domain.ProductOrder;

public interface ProductOrderMapper {
    int deleteByGUID(String guid);

    int insert(ProductOrder record);

    ProductOrder selectByGUID(String guid);

    int updateByGUID(ProductOrder record);
}