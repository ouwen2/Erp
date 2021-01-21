package com.upup.purchase.controller;

import com.fasterxml.jackson.databind.ObjectReader;
import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.base.util.PageBean;
import com.upup.purchase.model.Orderdetail;
import com.upup.purchase.model.Orders;
import com.upup.purchase.service.IOrdersService;
import com.upup.purchase.vo.OrderSa;
import com.upup.sys.vo.SysEmpDate;
import com.upup.purchase.vo.OrderVo;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

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

    @RequestMapping("/TrendPage")
    @ResponseBody
    public JsonResponseBody TrendPage(String ytime, HttpServletRequest request){
        System.out.println(ytime);
        JsonResponseBody<?> byTrendPage = ordersService.getByTrendPage(ytime);
        if (null==byTrendPage) {
            return new JsonResponseBody<>(ResponseStatus.STATUS_204);
        }else {
            return new JsonResponseBody(ResponseStatus.STATUS_200, byTrendPage);
        }
    }

    @RequestMapping("/ByYear")
    @ResponseBody
    public JsonResponseBody ByYear(){
        List<Map<String, Object>> byYear = ordersService.getByYear();
        return new JsonResponseBody(ResponseStatus.STATUS_200,byYear);
    }

    //-----------------------------------采购


    //查询订单分页(根据供应商查询)
    @RequestMapping("/queryPage")
    @ResponseBody
    public List<Map<String,Object>> queryPage(HttpServletRequest request, String supliername){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        List<Map<String, Object>> maps = ordersService.queryPage(supliername, pageBean);
        return maps;
    }


    //查询订单分页(根据供应商查询 根据状态分类)
    @RequestMapping("/queryPageT")
    @ResponseBody
    public List<Map<String,Object>> queryPageT(HttpServletRequest request, String supliername,String state){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        List<Map<String, Object>> maps = ordersService.queryPageT(supliername, state, pageBean);
        return maps;
    }

    //查询订单分页(根据供应商查询 根据状态分类和类型 分页) 退货
    @RequestMapping("/queryPageC")
    @ResponseBody
    public List<Map<String,Object>> queryPageC(HttpServletRequest request, String supliername,String state
            ,String type){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        List<Map<String, Object>> maps = ordersService.queryPageC(supliername, state,type,pageBean);
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
            int creater=(Integer)map.get("creater");

            orderVo.setOrderDetailList(list);
            orderVo.setTotalmoney(totalmoney);
            Date date=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s =simpleDateFormat.format(date);
            orderVo.setCreatetime(s);
            orderVo.setSupplieruuid(supplierId);
            orderVo.setType("0");
            orderVo.setState("0");
            orderVo.setCreater(creater);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ordersService.insertSelective(orderVo);

    }


    //订单审核
    @RequestMapping("/updateOrderState")
    @ResponseBody
    public int updateOrderState(int checker,int orderuuid){
        Orders orders=new Orders();
        orders.setChecker(checker);
        orders.setState("1");
        orders.setUuid(orderuuid);
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s =simpleDateFormat.format(date);
        orders.setChecktime(s);
        return  ordersService.updateOrderState(orders);
    }

    //订单确认
    @RequestMapping("/updateOrderStateQ")
    @ResponseBody
    public int updateOrderStateQ(int starter,int orderuuid){
        Orders orders=new Orders();
        orders.setStarter(starter);
        orders.setState("2");
        orders.setUuid(orderuuid);
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s =simpleDateFormat.format(date);
        orders.setStarttime(s);
        return  ordersService.updateOrderStateQ(orders);
    }


    //判断外面的大订单是否为入库
    @RequestMapping("/selectQue")
    @ResponseBody
    public  List<Orderdetail> selectQue(int orderuuid){
        return ordersService.selectQue(orderuuid);
    }




}
