package com.upup.basics.controller;

import com.upup.basics.model.GoodsType;
import com.upup.basics.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goodType")
public class GoodsTypeController  {

    @Autowired
    public IGoodsTypeService goodsTypeService;

    //查询
    @RequestMapping("/queryAllGoodsType")
    @ResponseBody
    public Map<String,Object> queryAllGoodsType(GoodsType goodsType){
        List<GoodsType> goodsTypes = goodsTypeService.queryAllGoodsType(goodsType);

        return toJson("ok",true,goodsTypes);
    }

    //添加
    @RequestMapping("/addGoodsType")
    @ResponseBody
    public Map<String,Object> addGoodType(GoodsType goodsType){
        goodsTypeService.insert(goodsType);


        return toJson("添加类型成功",true,null);
    }

    //删除
    @RequestMapping("/delGoodsType")
    @ResponseBody
    public Map<String,Object> delGoodType(GoodsType goodsType){
        goodsTypeService.deleteByPrimaryKey(goodsType.getUuid());


        return toJson("删除类型成功",true,null);
    }

    //修改
    @RequestMapping("/updGoodsType")
    @ResponseBody
    public Map<String,Object> updGoodType(GoodsType goodsType){
        goodsTypeService.updateByPrimaryKey(goodsType);


        return toJson("修改类型成功",true,null);
    }




    private Map<String,Object> toJson(String msg,boolean flag,Object data){
        Map<String,Object> json=new HashMap<>();
        json.put("msg",msg);
        json.put("success",flag);
        json.put("data",data);
        return  json;
    }



}
