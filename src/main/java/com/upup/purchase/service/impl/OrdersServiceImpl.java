package com.upup.purchase.service.impl;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.ResponseStatus;
import com.upup.purchase.mapper.OrdersMapper;
import com.upup.purchase.model.Orders;
import com.upup.purchase.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public int deleteByPrimaryKey(Integer uuid) {
        return 0;
    }

    @Override
    public int insert(Orders record) {
        return ordersMapper.insert(record);
    }

    @Override
    public int insertSelective(Orders record) {
        return 0;
    }

    @Override
    public Orders selectByPrimaryKey(Integer uuid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Orders record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Orders record) {
        return 0;
    }

    @Override
    public JsonResponseBody<List<Orders>> queryall() {
        List<Orders> list=ordersMapper.queryall();
        if(list.size()==0)
            return new JsonResponseBody<>(ResponseStatus.STATUS_202);
        return new JsonResponseBody<>(list);
    }


}
