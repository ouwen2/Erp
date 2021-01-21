package com.upup.purchase.service.impl;

import com.upup.purchase.controller.OrdersController;
import com.upup.purchase.mapper.OrderdetailMapper;
import com.upup.purchase.model.Orderdetail;
import com.upup.purchase.model.Orders;
import com.upup.purchase.service.IOrderdetailService;
import com.upup.purchase.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class OrderdetailServiceImpl implements IOrderdetailService {

    @Autowired
    private OrderdetailMapper orderdetailMapper;

    @Autowired
    private IOrdersService ordersService;


    @Override
    public List<Orderdetail> selectByoid(int orderuuid) {
        return orderdetailMapper.selectByoid(orderuuid);
    }


    @Override
    public int updateOrderdetail(Orderdetail orderdetail) {
        int i=orderdetailMapper.updateOrderdetail(orderdetail);
        if(i>0){
            List<Orderdetail> orderdetails = ordersService.selectQue(orderdetail.getOrdersuuid());
            if(orderdetails.size()==0) {
                Orders orders = new Orders();
                orders.setUuid(orderdetail.getOrdersuuid());
                orders.setState("3");
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String s = simpleDateFormat.format(date);
                orders.setEndtime(s);
                ordersService.updateOrderStateR(orders);
            }
        }
        return i;
    }

    @Override
    public int updateTuiD(Orderdetail orderdetail) {
        int i=orderdetailMapper.updateTuiD(orderdetail);
        if(i>0){
            List<Orderdetail> list = ordersService.selectRu(orderdetail.getOrdersuuid());
            if(list.size()==0){
                Orders orders=new Orders();
                orders.setType("2");
                orders.setState("0");
                orders.setUuid(orderdetail.getOrdersuuid());
                Date date=new Date();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String s =simpleDateFormat.format(date);
                orders.setCreatetime(s);
                orders.setChecktime("");
                orders.setStarttime("");
                orders.setEndtime("");
                ordersService.updateTuiD(orders);
            }
        }
        return i;
    }

    @Override
    public int updateTuiS(Orderdetail orderdetail) {
        int i = orderdetailMapper.updateTuiS(orderdetail);
        if(i>0){
            List<Orderdetail> list = ordersService.selectDen(orderdetail.getOrdersuuid());
            if(list.size()==0){
                Orders orders=new Orders();
                orders.setState("1");
                orders.setUuid(orderdetail.getOrdersuuid());
                Date date=new Date();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String s =simpleDateFormat.format(date);
                orders.setChecktime(s);
                ordersService.updateTuiS(orders);
            }
        }
        return i;
    }

    @Override
    public int updateTuiC(Orderdetail orderdetail) {
        int i=orderdetailMapper.updateTuiC(orderdetail);
        if(i>0){
            List<Orderdetail> list = ordersService.selectShen(orderdetail.getOrdersuuid());
            if(list.size()==0){
                Orders orders=new Orders();
                orders.setState("2");
                orders.setUuid(orderdetail.getOrdersuuid());
                Date date=new Date();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String s =simpleDateFormat.format(date);
                orders.setEndtime(s);
                ordersService.updateTuiC(orders);
            }
        }
        return i;
    }


}
