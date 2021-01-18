package com.upup.purchase.service;

import com.upup.base.util.JsonResponseBody;
import com.upup.purchase.model.Orders;

import java.util.List;
import java.util.Map;

public interface IOrdersService {

    JsonResponseBody<?> insertSelective(Orders orders);

    JsonResponseBody<?> queryall();
}