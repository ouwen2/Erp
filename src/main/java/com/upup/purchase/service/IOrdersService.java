package com.upup.purchase.service;

import com.upup.base.util.JsonResponseBody;
import com.upup.purchase.model.Orders;

import java.util.List;

public interface IOrdersService {

    int deleteByPrimaryKey(Integer uuid);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    JsonResponseBody<?> queryall();
}