package com.upup.sale.controller;

import com.upup.base.util.JsonResponseBody;
import com.upup.sale.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/good")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;


    @RequestMapping("GoodNameAll")
    @ResponseBody
    public JsonResponseBody GoodNameAll() {
        return goodsService.queryNameAll();
    }



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
