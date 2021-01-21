package com.upup.purchase.service.impl;

import com.upup.purchase.mapper.OrderdetailMapper;
import com.upup.purchase.model.Orderdetail;
import com.upup.purchase.service.IOrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderdetailServiceImpl implements IOrderdetailService {

    @Autowired
    private OrderdetailMapper orderdetailMapper;



    @Override
    public int insert(Orderdetail record) {
        return 0;
    }

    @Override
    public int insertSelective(Orderdetail record) {
        return 0;
    }


}
