package com.upup.basics.controller;

import com.upup.base.util.PageBean;
import com.upup.basics.model.GoodsType;
import com.upup.basics.service.IGoodsTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("GoodsType")
public class GoodsTypeController  {

    @Autowired
    public IGoodsTypeService goodsTypeService;

    //查询所有
    @RequestMapping("/cxsy")
    @ResponseBody
    public Map<String,Object> cxsy(){
        System.out.println("lailessss");
        List<GoodsType> cxsp = goodsTypeService.cxsp();
        cxsp.forEach(System.out::println);
        return toJson("ok",true,cxsp);
    }


    //查询
    @RequiresPermissions(value ="GoodsType/queryAllGoodsType")
    @RequestMapping("/queryAllGoodsType")
    @ResponseBody
    public Map<String,Object> queryAllGoodsType(GoodsType goodsType){
        List<GoodsType> goodsTypes = goodsTypeService.queryAllGoodsType(goodsType);

        return toJson("ok",true,goodsTypes);
    }

    //添加
    @RequiresPermissions(value ="GoodsType/addGoodsType")
    @RequestMapping("/addGoodsType")
    @ResponseBody
    public Map<String,Object> addGoodType(GoodsType goodsType){
        goodsTypeService.insert(goodsType);


        return toJson("添加类型成功",true,null);
    }

    //删除
    @RequiresPermissions(value ="GoodsType/delGoodsType")
    @RequestMapping("/delGoodsType")
    @ResponseBody
    public Map<String,Object> delGoodType(GoodsType goodsType){
        goodsTypeService.deleteByPrimaryKey(goodsType.getUuid());
        return toJson("删除类型成功",true,null);
    }


    //分页查询
    @RequiresPermissions(value ="GoodsType/querPageGoodsType")
    @RequestMapping("/querPageGoodsType")
    @ResponseBody
    public Map<String,Object> querPager(HttpServletRequest request, GoodsType goodstype,PageBean pageBean){
        Map<String,Object> map=new HashMap<>();
       // PageBean pageBean=new PageBean();
        //pageBean.setRequest(request);
        List<GoodsType> goods = goodsTypeService.queryGoodsTypePage(goodstype,pageBean);
        System.out.println("getTotal:"+pageBean.getTotal());
        System.out.println(goods);
        map.put("success",true);
        map.put("data",goods);
        map.put("total",pageBean.getTotal());
        return  map;
    }

    //修改
    @RequiresPermissions(value ="GoodsType/updGoodsType")
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
