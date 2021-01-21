package com.upup.sale.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.model.Store;
import com.upup.model.Storedetail;
import com.upup.purchase.model.Orderdetail;
import com.upup.purchase.model.Orders;
import com.upup.purchase.model.Returnorderdetail;
import com.upup.purchase.model.Returnorders;
import com.upup.sale.model.Goods;
import com.upup.sale.service.IGoodsService;
import com.upup.sale.vo.GoodsVo;
import com.upup.sale.vo.OrderVo;
import com.upup.sale.vo.ReturnordersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/GoodsController")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;


    @RequestMapping("GoodNameAll")
    @ResponseBody
    public JsonResponseBody GoodNameAll() {
        return goodsService.queryNameAll();
    }

    @RequestMapping("GoodGetByName")
    @ResponseBody
    public JsonResponseBody GoodGetByName(Integer uuidd) {
        return goodsService.selectByPrimaryKey(uuidd);
    }

    @RequestMapping("StoreQueryByNameAll")
    @ResponseBody
    public JsonResponseBody StoreQueryByNameAll(String name) {
        return goodsService.queryBynameAll(name);
    }

    @RequestMapping("StoreChuKu")
    @ResponseBody
    public JsonResponseBody StoreChuKu(String goodsname, String storename,Integer goodsuuid,Integer num,Integer glyuuid ,Integer uuid,Integer ordersuuid) {
        JsonResponseBody jsonResponseBody = new JsonResponseBody();
        int i = goodsService.selectcangkuuuid(storename, glyuuid);
        if(i==0){
            System.out.println("没有仓库");
            jsonResponseBody.setMsg("没有当前仓库对应的商品");
            jsonResponseBody.setData("nostore");
            return jsonResponseBody;
        }
        Storedetail storedetail = new Storedetail();
        storedetail = goodsService.selectcangkudetauiluuid(i, goodsuuid);
        if(storedetail==null){
            System.out.println("没有仓库对应的数据");
        }

        System.out.println(uuid+"order");
        int i1 = goodsService.updateOrdersDetail(uuid);
        if(i1==0) {
            System.out.println("修改失败");
        }
        int i2 = goodsService.updateStoreJian(storedetail.getUuid(), num);
        List<String> strings = goodsService.queryStateListStringss(ordersuuid);
        if(strings.size()==1){
            goodsService.updateOrderscjstate(ordersuuid);
        }


        return null;
    }

    @RequestMapping("querySupplierAllList")
    @ResponseBody
    public JsonResponseBody querySupplierAllList() {
        System.out.println("sss");
        return goodsService.querySupplierAllList();
    }


    @RequestMapping("getBygoodesname")
    @ResponseBody
    public JsonResponseBody getBygoodesname(String goodname) {
        return goodsService.getBygoodesname(goodname);
    }

    @RequestMapping("/fuzaleixinchuanzhi")
    @ResponseBody
    public JsonResponseBody fuzaleixinchuanzhi(@RequestBody Map<String,Object> map) {
        JsonResponseBody jsonResponseBody = new JsonResponseBody();
        long time = new Date().getTime();
        String str =time+"";
        System.out.println(str);
        String first = str.substring(5,12);
        System.out.println(first);
        int intForFirs = Integer.parseInt(first);
        try {
            OrderVo ordervo = new OrderVo();
            GoodsVo goodsvo = new GoodsVo();
            List<Orderdetail>  list=(List<Orderdetail>) map.get("orderDetailList");
            System.out.println(list);
            Date date=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s =simpleDateFormat.format(date);
            //转化为json集合
            /*ObjectMapper mapper=new ObjectMapper();
            List<Orderdetail> list2= mapper.convertValue(map.get("orderDetailList"),new TypeReference<List<Orderdetail>>(){});
            list2.forEach(System.out::print);*/
            int supplierId =(Integer)map.get("ordersSupplierId");
            System.out.println(supplierId);
            Float totalmoney=Float.valueOf(map.get("ordersTotalmoney").toString());
            System.out.println(totalmoney);
            int creater=(Integer)map.get("creater");
            System.out.println(creater);
            ordervo.setSUPPLIERUUID(supplierId);
            ordervo.setTOTALMONEY(totalmoney);
            ordervo.setCREATETIME(s);
            ordervo.setType(1);
            ordervo.setState(1);
            ordervo.setCreater(creater);
            ordervo.setUuid(intForFirs);
           goodsService.insertOrderssj(ordervo);
           goodsvo.setOrderDetailList(list);
           goodsvo.setOrderid(intForFirs);
            int i = goodsService.insertOrderxiangxi(goodsvo.getOrderDetailList(), goodsvo.getOrderid());
             if(i!=0){
                 jsonResponseBody.setMsg("添加订单成功");
                 jsonResponseBody.setData(1);
             }else{
                 jsonResponseBody.setMsg("添加订单失败");
             }


        }catch (Exception e){
            e.printStackTrace();
        }


        return jsonResponseBody;
    }

    @RequestMapping("updatereturn")
    @ResponseBody
    public JsonResponseBody updatereturn(Integer uuid,Integer xdyuuid,String suppliername ) {
        int i = goodsService.updatereturn(uuid);
        //查询
        Orderdetail orderdetail = new Orderdetail();
        orderdetail=goodsService.selectByid(uuid);
        int orderuuid = orderdetail.getOrdersuuid();

        //供应商id
        int i1 = goodsService.selectsuppGetByname(suppliername);

        //逐渐
        Returnorders returnorders = new Returnorders();
        returnorders = goodsService.selectByorderid(orderuuid);
        ReturnordersVo returnordersVo = new ReturnordersVo();
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s =simpleDateFormat.format(date);
        if(returnorders==null){
        returnordersVo.setCREATETIME(s);
        returnordersVo.setTYPE(2);
        returnordersVo.setCREATER(xdyuuid);
        returnordersVo.setSUPPLIERUUID(i1);
        returnordersVo.setTOTALMONEY(orderdetail.getMoney());
        returnordersVo.setSTATE(2);
        returnordersVo.setWAYBILLSN(orderdetail.getOrdersuuid());
            System.out.println(returnordersVo);
            int insertreturnorders = goodsService.insertreturnorders(returnordersVo);
            System.out.println(insertreturnorders);
        }else{
            System.out.println("laile");
            goodsService.updatemonryjia(orderuuid,orderdetail.getMoney());
        }
        System.out.println(orderdetail.toString());
        goodsService.insertreturnordersdetail(orderdetail);

        return new JsonResponseBody(i);
    }

    @RequestMapping("queryReturnorderdetailAllList")
    @ResponseBody
    public JsonResponseBody queryReturnorderdetailAllList() {
        return goodsService.queryReturnorderdetailAllList();
    }

    @RequestMapping("queryByreturnid")
    @ResponseBody
    public JsonResponseBody queryByreturnid(Integer orderuuid,Integer glyuuid) {
        System.out.println(orderuuid);
        return goodsService.queryByreturnid(orderuuid);
    }

    @RequestMapping("updatesetstateY")
    @ResponseBody
    public JsonResponseBody updatesetstateY(Integer orderuuid,Integer glyuuid) {
        goodsService.updatesetstateY(orderuuid);
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s =simpleDateFormat.format(date);
        int i = goodsService.updatesetreturnOrders(orderuuid, glyuuid, s);
        return new JsonResponseBody(i);
    }

    @RequestMapping("queryReturnorderdetailAllListtype")
    @ResponseBody
    public JsonResponseBody queryReturnorderdetailAllListtype() {
        return goodsService.queryReturnorderdetailAllListtype();
    }

    @RequestMapping("queryByglyuuidAll")
    @ResponseBody
    public JsonResponseBody queryByglyuuidAll(Integer glyuuid) {
        return goodsService.queryByglyuuidAll(glyuuid);
    }
    @RequestMapping("StoreRuKu")
    @ResponseBody
    public JsonResponseBody StoreRuKu(String goodsname, String storename,Integer goodsuuid,Integer num,Integer glyuuid ,Integer uuid,Integer ordersuuid) {
        int i = goodsService.selectcangkuuuid(storename, glyuuid);
        if(i==0){
            System.out.println("没有仓库");
        }
        Storedetail storedetail = new Storedetail();
        storedetail = goodsService.selectcangkudetauiluuid(i, goodsuuid);
        if(storedetail==null){
            System.out.println("没有仓库对应的数据");
        }
        System.out.println(ordersuuid+"order");
        int i1 = goodsService.updateReturndetailstateH(uuid);
        if(i1==0) {
            System.out.println("修改失败");
        }
        int i2 = goodsService.updateStoreJia(storedetail.getUuid(), num);
        List<String> strings = goodsService.queryStateListString(ordersuuid);
        if(strings.size()==1){
        goodsService.updatereturnorderssetstateH(ordersuuid);
        }

        return null;
    }

    @RequestMapping("queryReturnorderdetailAllListPage")
    @ResponseBody
    public JsonResponseBody queryReturnorderdetailAllListPage(HttpServletRequest request) {
        PageBean pagebean = new PageBean();
        pagebean.setRequest(request);
        List<Map<String, Object>> maps = goodsService.queryReturnorderdetailAllListPage(pagebean);
        return new JsonResponseBody(maps);
    }

    }

