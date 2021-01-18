package com.upup.sale.controller;

import com.upup.base.util.JsonResponseBody;
import com.upup.sale.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/GoodsController")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;


    @RequestMapping("GoodNameAll")
    @ResponseBody
    public JsonResponseBody GoodNameAll() {
        return goodsService.queryNameAll();
    }

    @RequestMapping("GoodGetByName")
    @ResponseBody
    public JsonResponseBody GoodGetByName(Integer uuidd) {
        return goodsService.selectByPrimaryKey(uuidd);
    }

    @RequestMapping("StoreQueryByNameAll")
    @ResponseBody
    public JsonResponseBody StoreQueryByNameAll(String name) {
        return goodsService.queryBynameAll(name);
    }

}
