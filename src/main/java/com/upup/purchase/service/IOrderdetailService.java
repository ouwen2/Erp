package com.upup.purchase.service;

import com.upup.purchase.model.Orderdetail;
import org.springframework.stereotype.Repository;

public interface IOrderdetailService {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    Orderdetail selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
}