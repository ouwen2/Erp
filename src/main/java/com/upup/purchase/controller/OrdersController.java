package com.upup.purchase.controller;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.purchase.model.Orders;
import com.upup.purchase.service.IOrdersService;
import com.upup.purchase.vo.OrderSa;
import com.upup.sys.vo.SysEmpDate;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/queryall")
    @ResponseBody
    public JsonResponseBody queryall(){

        return ordersService.queryall();
    }

    @RequestMapping("/SalesPage")
    @ResponseBody
    public JsonResponseBody SalesPage(OrderSa orderSa, HttpServletRequest request){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        pageBean.setRows(5);
        System.out.println(orderSa.toString());
        List<Map<String,Object>>  bySalesPage = ordersService.getBySalesPage(orderSa, pageBean);
        return new JsonResponseBody(ResponseStatus.STATUS_200,bySalesPage);
    }

}
