package com.upup.sale.controller;

import com.upup.base.util.JsonResponseBody;
import com.upup.purchase.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/OrdersSales")
public class OrdersSalesController {

    @Autowired
    private IOrdersService ordersService;


//    @RequestMapping("/queryall")
//    @ResponseBody
//    public JsonResponseBody queryall(){
//        System.out.println("来了");
//
//        return ordersService.queryall();
//    }


}
