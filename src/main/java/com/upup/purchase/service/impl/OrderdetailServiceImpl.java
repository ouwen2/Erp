package com.upup.purchase.service.impl;

import com.upup.base.util.JsonResponseBody;
import com.upup.purchase.mapper.OrderdetailMapper;
import com.upup.purchase.model.Orderdetail;
import com.upup.purchase.service.IOrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderdetailServiceImpl implements IOrderdetailService {

    @Autowired
    private OrderdetailMapper orderdetailMapper;

    @Override
    public int deleteByPrimaryKey(Integer uuid) {
        return 0;
    }

    @Override
    public int insert(Orderdetail record) {
        return 0;
    }

    @Override
    public int insertSelective(Orderdetail record) {
        return 0;
    }

    @Override
    public Orderdetail selectByPrimaryKey(Integer uuid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Orderdetail record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Orderdetail record) {
        return 0;
    }

    @Override
    public JsonResponseBody<List<Orderdetail>> queryByuuidAll(Integer ordersuuid) {
        List<Orderdetail> orderdetails = orderdetailMapper.queryByuuidAll(ordersuuid);
        return new  JsonResponseBody<>(orderdetails);
    }

    @Override
    public JsonResponseBody<?> queryByuuidwfh(Integer ordersuuid) {
        List<Orderdetail> orderdetails = orderdetailMapper.queryByuuidwfh(ordersuuid);
        return new  JsonResponseBody<>(orderdetails);
    }
}
