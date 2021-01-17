package com.upup.stock.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.stock.model.Inventory;
import com.upup.stock.model.Storedetail;
import com.upup.stock.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Inventory")
public class InventoryController {
    @Autowired
    private IInventoryService iInventoryService;


    @ResponseBody
    @RequestMapping("/Page")
    public JsonResponseBody Page(Inventory inventory, PageBean pageBean){
        List<Map<String, Object>> maps = iInventoryService.queryInventoryPage(inventory, pageBean);
        String msg="查询";
        if(msg!=null){
            int total = pageBean.getTotal();
           return new JsonResponseBody(maps,total);
        }else{
            return new JsonResponseBody(ResponseStatus.STATUS_202);
        }
    }

    @ResponseBody
    @RequestMapping("/ShPage")
    public JsonResponseBody ShPage(Inventory inventory, PageBean pageBean){
        List<Map<String, Object>> maps = iInventoryService.queryInventoryshPage(inventory, pageBean);
        String msg="查询";
        if(msg!=null){
            int total = pageBean.getTotal();
            return new JsonResponseBody(maps,total);
        }else{
            return new JsonResponseBody(ResponseStatus.STATUS_202);
        }
    }


    @RequestMapping("/Add")
    public void Add(Inventory inventory){
        inventory.setState("1");
        inventory.setCreater(2);
        inventory.setCreatetime(new Date());
        int insert = iInventoryService.insert(inventory);
    }

    @RequestMapping("/Update")
    public void Update(Inventory inventory){


//        Storedetail querykc = iInventoryService.querykc(inventory);


//        if(inventory.getType()=="1"){
//            Integer num = inventory.getNum();
//            Integer num1 = querykc.getNum();
//            Integer num2=num1-num;
//            querykc.setNum(num2);
//        }
//
//
//        if(inventory.getType()=="2"){
//            Integer num = inventory.getNum();
//            Integer num1 = querykc.getNum();
//            Integer num2=num1+num;
//            querykc.setNum(num2);
//        }
        inventory.setChecktime(new Date());

        int i = iInventoryService.updateByPrimaryKey(inventory);

    }


}
