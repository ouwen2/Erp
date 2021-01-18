package com.upup.purchase.controller;

import com.fasterxml.jackson.databind.ObjectReader;
import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.purchase.model.Orderdetail;
import com.upup.purchase.model.Orders;
import com.upup.purchase.service.IOrdersService;
import com.upup.purchase.vo.OrderVo;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/queryPage")
    @ResponseBody
    public List<Map<String,Object>> queryPage(HttpServletRequest request, String supliername){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        List<Map<String, Object>> maps = ordersService.queryPage(supliername, pageBean);

//        Map<String,Object> map = new HashMap<>();
//        map.put("total",8);
//        System.out.println(map);
//        maps.add(map);
        return maps;

    }


    @RequestMapping("/insertSelective")
    @ResponseBody
    public JsonResponseBody insertSelective(@RequestBody Map<String,Object> map){
        OrderVo orderVo=new OrderVo();
        try {
           List<Orderdetail>  list=(List<Orderdetail>) map.get("orderDetailList");
           System.out.println(list);
           int supplierId =(Integer)map.get("ordersSupplierId");
            Float totalmoney=Float.valueOf(map.get("ordersTotalmoney").toString());

           orderVo.setOrderDetailList(list);
           orderVo.setTotalmoney(totalmoney);
           orderVo.setCreatetime(new Date());
           orderVo.setSupplieruuid(supplierId);
           orderVo.setType("0");
           orderVo.setState("0");
        }catch (Exception e){
            e.printStackTrace();
        }
        return ordersService.insertSelective(orderVo);

    }




}
