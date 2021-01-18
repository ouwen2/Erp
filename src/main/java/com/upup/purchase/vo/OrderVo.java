package com.upup.purchase.vo;

import com.upup.purchase.model.Orderdetail;
import com.upup.purchase.model.Orders;
import lombok.*;

import java.util.List;

public class OrderVo extends Orders {

    private List<Orderdetail> orderDetailList;

    public List<Orderdetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<Orderdetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
