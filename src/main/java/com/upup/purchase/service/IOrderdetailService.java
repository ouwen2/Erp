package com.upup.purchase.service;

import com.upup.base.util.JsonResponseBody;
import com.upup.purchase.model.Orderdetail;

import java.util.List;

public interface IOrderdetailService {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    Orderdetail selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);

    JsonResponseBody<?> queryByuuidAll(Integer ordersuuid);

    JsonResponseBody<?> queryByuuidwfh(Integer ordersuuid);

}