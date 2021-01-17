package com.upup.purchase.controller;

import com.upup.base.util.JsonResponseBody;
import com.upup.purchase.model.Orderdetail;
import com.upup.purchase.model.Orders;
import com.upup.purchase.service.IOrdersService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/queryall")
    @ResponseBody
    public JsonResponseBody queryall(){
        return ordersService.queryall();
    }


    @RequestMapping("/insertSelective")
    public void insertSelective(@RequestBody Map<String,Object> map){
        try {
           List<Orderdetail>  list=(List<Orderdetail>) map.get("orderDetailList");
           int supplierId =(Integer)map.get("ordersSupplierId");
           Float totalmoney=(Float)map.get("ordersTotalmoney");

           Orders orders=new Orders();
           orders.setCreatetime(new Date());
           orders.setTotalmoney(totalmoney);
           orders.setSupplieruuid(supplierId);
           orders.setType("0");

           ordersService.insertSelective(orders);
        }catch (Exception e){
            e.printStackTrace();
        }


    }




}
