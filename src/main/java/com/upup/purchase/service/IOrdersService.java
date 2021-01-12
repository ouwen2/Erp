package com.upup.purchase.service;

import com.upup.purchase.model.Orders;

public interface IOrdersService {

    int deleteByPrimaryKey(Integer uuid);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}