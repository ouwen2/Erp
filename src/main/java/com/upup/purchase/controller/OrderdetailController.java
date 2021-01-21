package com.upup.purchase.controller;

import com.upup.purchase.model.Orderdetail;
import com.upup.purchase.service.IOrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Orderdetail")
public class OrderdetailController {

    @Autowired
    private IOrderdetailService orderdetailService;


    //查询订单详情
    @RequestMapping("/selectByoid")
    @ResponseBody
    public List<Orderdetail> selectByoid(int orderuuid){
        System.out.println("编号:"+orderuuid);
        List<Orderdetail> list = orderdetailService.selectByoid(orderuuid);
        System.out.println(list);
        return list;
    }


    //入库  （修改订单状态）
    @RequestMapping("/updateOrderdetail")
    @ResponseBody
    public int updateOrderdetail(int ender,int orderuuid,int orderdetailGoodsId,int storeuuid){
        Orderdetail orderdetail=new Orderdetail();
        //设置对应的大订单id
        orderdetail.setOrdersuuid(orderuuid);
        //修改状态为入库
        orderdetail.setState("1");
        //设置入库的仓库
        orderdetail.setStoreuuid(storeuuid);
        //设置操作员工id
        orderdetail.setEnder(ender);
        //设置所对应的商品id
        orderdetail.setOrderdetailGoodsId(orderdetailGoodsId);
        //设置操作时间
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s =simpleDateFormat.format(date);
        orderdetail.setEndtime(s);

        System.out.println("小订单:"+orderdetail.toString());
        return  orderdetailService.updateOrderdetail(orderdetail);
    }


    //退货登记
    @RequestMapping("/updateTuiD")
    @ResponseBody
    public int updateTuiD(int orderuuid,int orderdetailGoodsId){
        Orderdetail orderdetail=new Orderdetail();
        orderdetail.setState("2");
        orderdetail.setOrdersuuid(orderuuid);
        orderdetail.setOrderdetailGoodsId(orderdetailGoodsId);
        return  orderdetailService.updateTuiD(orderdetail);
    }


    //退货审核
    @RequestMapping("/updateTuiS")
    @ResponseBody
    public int updateTuiS(int orderuuid,int orderdetailGoodsId){
        Orderdetail orderdetail=new Orderdetail();
        orderdetail.setState("3");
        orderdetail.setOrdersuuid(orderuuid);
        orderdetail.setOrderdetailGoodsId(orderdetailGoodsId);
        return  orderdetailService.updateTuiS(orderdetail);
    }

    //退货出库
    @RequestMapping("/updateTuiC")
    @ResponseBody
    public int updateTuiC(int orderuuid,int orderdetailGoodsId){
        Orderdetail orderdetail=new Orderdetail();
        orderdetail.setState("4");
        orderdetail.setOrdersuuid(orderuuid);
        orderdetail.setOrderdetailGoodsId(orderdetailGoodsId);
        return  orderdetailService.updateTuiC(orderdetail);
    }


}
