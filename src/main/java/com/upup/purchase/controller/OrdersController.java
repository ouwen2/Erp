package com.upup.purchase.controller;

import com.upup.base.util.JsonResponseBody;
import com.upup.purchase.model.Orders;
import com.upup.purchase.service.IOrdersService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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




}
