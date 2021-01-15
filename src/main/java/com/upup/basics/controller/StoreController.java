package com.upup.basics.controller;

import com.upup.basics.model.Store;
import com.upup.basics.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/store")
public class StoreController {


    @Autowired
    public IStoreService storeService;

    @RequestMapping("/queryStoreAll")
    @ResponseBody
    public Map<String,Object> queryStoreAll(Store store){
        List<Store> goodss = storeService.queryAllStore(store);


        return toJson("ok",true,goodss);
    }

    @RequestMapping("/addStore")
    @ResponseBody
    public Map<String,Object> addStore(Store store){
//        System.out.println("goods:"+supplier);
        storeService.insert(store);
        return toJson("新增供应商成功",true,null);
    }

    @RequestMapping("/delGoodsAll")
    @ResponseBody
    public Map<String,Object> delGoodsAll(Store store){

        return null;
    }

    private Map<String,Object> toJson(String msg,boolean flag,Object data){
        Map<String,Object> json=new HashMap<>();
        json.put("msg",msg);
        json.put("success",flag);
        json.put("data",data);
        return json;
    }
}
