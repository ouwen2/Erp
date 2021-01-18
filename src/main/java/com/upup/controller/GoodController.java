package com.upup.controller;


import com.upup.base.util.JsonResponseBody;
import com.upup.service.IGoodsService;
import com.upup.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/querygoodall")
    @ResponseBody
    public JsonResponseBody querygoodall(){
        return goodsService.querygoodall();
    }


    @RequestMapping("/selectSinglegood")
    @ResponseBody
    public JsonResponseBody selectSinglegood(String goodname){
        System.out.println(goodname);
        return goodsService.selectSinglegood(goodname);
    }


}
