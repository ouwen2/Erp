package com.upup.purchase.service;

import com.upup.purchase.model.Orderdetail;

public interface IOrderdetailService {


    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);



}