package com.upup.purchase.service;

import com.upup.purchase.model.Orderdetail;

import java.util.List;

public interface IOrderdetailService {


    //根据订单编号查询所对应的订单
    List<Orderdetail> selectByoid(int orderuuid);

    //入库
    int updateOrderdetail(Orderdetail orderdetail);

    //退货登记
    int updateTuiD(Orderdetail orderdetail);

    //退货审核
    int updateTuiS(Orderdetail orderdetail);

    //退货出库
    int updateTuiC(Orderdetail orderdetail);



}