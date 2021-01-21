package com.upup.basics.controller;

import com.upup.base.util.PageBean;
import com.upup.basics.model.Goods;
import com.upup.basics.service.IGoodsService;
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
@RequestMapping("Goods")
public class GoodsController {

    @Autowired
    public IGoodsService goodsService;


    //查询
    @RequiresPermissions(value ="Goods/queryGoodsAll")
    @RequestMapping("/queryGoodsAll")
    @ResponseBody
    public Map<String,Object> queryGoodsAll(Goods goods){
       List<Map<String,Object>> goodss = goodsService.queryAllGoods(goods);

        return toJson("ok",true,goodss);
    }

    //添加
    @RequiresPermissions(value ="Goods/addGoods")
    @RequestMapping("/addGoods")
    @ResponseBody
    public int addGoods(Goods goods){
        System.out.println("goods:"+goods);
        goodsService.insert(goods);
        return 1;
    }

    //删除
    @RequiresPermissions(value ="Goods/delGoods")
    @RequestMapping("/delGoods")
    @ResponseBody
    public Map<String,Object> delGoods(Goods goods){
        goodsService.deleteByPrimaryKey(goods.getUuid());
        return toJson("删除成功",true,null);
    }

    //修改
    @RequiresPermissions(value ="Goods/updGoods")
    @RequestMapping("/updGoods")
    @ResponseBody
    public int updGoods(Goods goods){
        goodsService.updateByPrimaryKeySelective(goods);
        System.out.println("goods:"+goods);
        return 1;
    }



    //分页查询
    @RequiresPermissions(value ="Goods/querPageGoods")
    @RequestMapping("/querPageGoods")
    @ResponseBody
    public Map<String,Object> querPageGoods(HttpServletRequest request, Goods goods, PageBean pageBean){
        Map<String,Object> map=new HashMap<>();
        // PageBean pageBean=new PageBean();
        //pageBean.setRequest(request);
        List<Map<String,Object>> goodss = goodsService.queryGoodsPage(goods, pageBean);
        System.out.println("getTotal:"+pageBean.getTotal());
        System.out.println(goods);
        System.out.println(goodss);
        map.put("success",true);
        map.put("data",goodss);
        map.put("total",pageBean.getTotal());
        return  map;
    }


    private Map<String,Object> toJson(String msg,boolean flag,Object data){
        Map<String,Object> json=new HashMap<>();
        json.put("msg",msg);
        json.put("success",flag);
        json.put("data",data);
        return json;
    }

}
