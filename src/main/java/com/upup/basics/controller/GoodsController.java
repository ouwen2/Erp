package com.upup.basics.controller;

import com.upup.basics.model.Goods;
import com.upup.basics.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    public IGoodsService goodsService;

    @RequestMapping("/queryGoodsAll")
    @ResponseBody
    public Map<String,Object> queryGoodsAll(Goods goods){
        List<Goods> goodss = goodsService.queryAllGoods(goods);


        return toJson("ok",true,goodss);
    }

    @RequestMapping("/addGoods")
    @ResponseBody
    public Map<String,Object> addGoods(Goods goods){
        System.out.println("goods:"+goods);
        goodsService.insert(goods);
        return toJson("新增书本成功",true,null);
    }

    @RequestMapping("/delGoodsAll")
    @ResponseBody
    public Map<String,Object> delGoodsAll(Goods goods){

        return null;
    }

//    @RequestMapping("/queryGoodsAll")
//    @ResponseBody
//    public Map<String,Object> queryGoodsAll(Goods goods){
//
//        return null;
//    }

    private Map<String,Object> toJson(String msg,boolean flag,Object data){
        Map<String,Object> json=new HashMap<>();
        json.put("msg",msg);
        json.put("success",flag);
        json.put("data",data);
        return json;
    }

}
