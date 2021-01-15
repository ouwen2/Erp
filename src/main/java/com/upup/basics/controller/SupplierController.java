package com.upup.basics.controller;

import com.upup.basics.model.Supplier;
import com.upup.basics.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    public ISupplierService supplierService;

    @RequestMapping("/querySupplierAll")
    @ResponseBody
    public Map<String,Object> querySupplierAll(Supplier supplier){
        List<Supplier> goodss = supplierService.queryAllSupplier(supplier);


        return toJson("ok",true,goodss);
    }

    @RequestMapping("/addSupplier")
    @ResponseBody
    public Map<String,Object> addSupplier(Supplier supplier){
//        System.out.println("goods:"+supplier);
        supplierService.insert(supplier);
        return toJson("新增供应商成功",true,null);
    }

    @RequestMapping("/delGoodsAll")
    @ResponseBody
    public Map<String,Object> delGoodsAll(Supplier supplier){

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
