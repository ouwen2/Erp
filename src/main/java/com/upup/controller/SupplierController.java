package com.upup.controller;


import com.upup.base.util.JsonResponseBody;
import com.upup.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/spulier")
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;

    @RequestMapping("/queryall")
    @ResponseBody
    public JsonResponseBody queryall(){
        return supplierService.queryall();
    }

}
