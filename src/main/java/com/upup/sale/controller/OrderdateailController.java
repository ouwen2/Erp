package com.upup.sale.controller;

import com.upup.base.util.JsonResponseBody;
import com.upup.purchase.service.IOrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/OrderdateailController")
public class OrderdateailController {

    @Autowired
    private IOrderdetailService iOrderdetailService;


    @RequestMapping("/queryByuuidAll")
    @ResponseBody
    public JsonResponseBody queryByuuidAll(Integer ordersuuid){
        System.out.println(ordersuuid);
        return iOrderdetailService.queryByuuidAll(ordersuuid);
    }


}
