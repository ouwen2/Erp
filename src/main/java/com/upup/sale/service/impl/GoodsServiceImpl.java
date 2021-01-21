package com.upup.sale.service.impl;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.model.Store;
import com.upup.model.Storedetail;
import com.upup.model.Supplier;
import com.upup.purchase.model.Orderdetail;
import com.upup.purchase.model.Orders;
import com.upup.purchase.model.Returnorderdetail;
import com.upup.purchase.model.Returnorders;
import com.upup.sale.mapper.GoodsMapper;

import com.upup.sale.model.Goods;
import com.upup.sale.service.IGoodsService;
import com.upup.sale.vo.GoodsVo;
import com.upup.sale.vo.OrderVo;
import com.upup.sale.vo.ReturnordersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int deleteByPrimaryKey(Integer uuid) {
        return 0;
    }

    @Override
    public int insert(Goods record) {
        return 0;
    }

    @Override
    public int insertSelective(Goods record) {
        return 0;
    }

    @Override
    public JsonResponseBody<Goods> selectByPrimaryKey(Integer uuid) {
        Goods goods = goodsMapper.selectByPrimaryKey(uuid);
        System.out.println(goods);
        return new JsonResponseBody<>(goods);
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Goods record) {
        return 0;
    }

    @Override
    public JsonResponseBody<List<Goods>> queryNameAll() {
        List<Goods> list=goodsMapper.queryNameAll();
        return new JsonResponseBody<>(list);
    }

    @Override
    public JsonResponseBody<List<Store>> queryBynameAll(String name) {
        List<Store> list = goodsMapper.queryBynameAll(name);
        return new JsonResponseBody<>(list);
    }

    @Override
    public int selectgetByhenduo(String storename, int glyuuid, int goodsuuid) {
        return goodsMapper.selectgetByhenduo(storename,glyuuid,goodsuuid);
    }

    @Override
    public int updateNumJian(int uuid, int nun) {

        return goodsMapper.updateNumJian(uuid,nun);
    }

    @Override
    public int updateOrdersDetail(Integer uuid) {
        return goodsMapper.updateOrdersDetail(uuid);
    }

    @Override
    public List<Integer> queryStateList(Integer ordersuuid) {
        return goodsMapper.queryStateList(ordersuuid);
    }

    @Override
    public int updateOrderscjstate(Integer ordersuuid) {
        return goodsMapper.updateOrderscjstate(ordersuuid);
    }

    @Override
    public JsonResponseBody<List<Supplier>> querySupplierAllList() {
        List<Supplier> list = goodsMapper.querySupplierAllList();
        return new JsonResponseBody<>(list);
    }

    @Override
    public JsonResponseBody<?> getBygoodesname(String goodname) {
        List<Goods> list = goodsMapper.getBygoodesname(goodname);
        return new JsonResponseBody<>(list);
    }

    @Override
    public int insertOrderssj(OrderVo orderVo) {
        return goodsMapper.insertOrderssj(orderVo);

    }

    @Override
    public int insertOrderxiangxi(List<GoodsVo> orderDetailList, int orderid) {
        return goodsMapper.insertOrderxiangxi(orderDetailList,orderid);
    }

    @Override
    public int updatereturn(Integer uuid) {
        return goodsMapper.updatereturn(uuid);
    }

    @Override
    public Orderdetail selectByid(Integer uuid) {
        return goodsMapper.selectByid(uuid);
    }
    @Override
    public Returnorders selectByorderid(Integer uuid) {
        return goodsMapper.selectByorderid(uuid);
    }

    @Override
    public int insertreturnorders(ReturnordersVo returnordersVo) {
        return goodsMapper.insertreturnorders(returnordersVo);
    }

    @Override
    public int updatemonryjia(Integer orderuuid, Float money) {
        return goodsMapper.updatemonryjia(orderuuid,money);
    }

    @Override
    public int selectsuppGetByname(String suppliername) {
        return goodsMapper.selectsuppGetByname(suppliername);
    }

    @Override
    public int insertreturnordersdetail(Orderdetail orderdetail) {
        return goodsMapper.insertreturnordersdetail(orderdetail);
    }

    @Override
    public JsonResponseBody<List<Map<String,Object>>> queryReturnorderdetailAllList(){
        List<Map<String,Object>> list = goodsMapper.queryReturnorderdetailAllList();
        return new JsonResponseBody<>(list);
    }

    @Override
    public JsonResponseBody<List<Returnorderdetail>> queryByreturnid(Integer orderuuid) {
        List<Returnorderdetail> list = goodsMapper.queryByreturnid(orderuuid);
        return new JsonResponseBody(list);
    }

    @Override
    public int updatesetstateY(Integer orderuuid) {
        return goodsMapper.updatesetstateY(orderuuid);
    }

    @Override
    public int updatesetreturnOrders(Integer orderuuid, Integer glyuuid, String shijian) {
        return goodsMapper.updatesetreturnOrders(orderuuid,glyuuid,shijian);
    }

    @Override
    public JsonResponseBody<List<Map<String, Object>>> queryReturnorderdetailAllListtype() {
        List<Map<String,Object>> list = goodsMapper.queryReturnorderdetailAllListtype();
        return new JsonResponseBody<>(list);
    }

    @Override
    public JsonResponseBody<?> queryByglyuuidAll(Integer glyuuid) {
        List<Store> list = goodsMapper.queryByglyuuidAll(glyuuid);
        return new JsonResponseBody<>(list);
    }

    @Override
    public int selectcangkuuuid(String storename, Integer glyuuid) {
        return goodsMapper.selectcangkuuuid(storename,glyuuid);
    }

    @Override
    public Storedetail selectcangkudetauiluuid(Integer storeuuid, Integer goodsuuid) {
        return goodsMapper.selectcangkudetauiluuid(storeuuid, goodsuuid);
    }

    @Override
    public int updateStoreJia(Integer storedetailuuid, Integer num) {
        return goodsMapper.updateStoreJia(storedetailuuid, num);
    }

    @Override
    public int updateStoreJian(Integer storedetailuuid, Integer num) {
        return goodsMapper.updateStoreJian(storedetailuuid, num);
    }

    @Override
    public int updateReturndetailstateH(Integer ordersuuid) {
        return goodsMapper.updateReturndetailstateH(ordersuuid);
    }

    @Override
    public List<String> queryStateListString(Integer ordersuuid) {
        return goodsMapper.queryStateListString(ordersuuid);
    }

    @Override
    public List<String> queryStateListStringss(Integer ordersuuid) {
        return goodsMapper.queryStateListStringss(ordersuuid);
    }

    @Override
    public int updatereturnorderssetstateH(Integer ordersuuid) {
        return goodsMapper.updatereturnorderssetstateH(ordersuuid);
    }

    @Override
    public List<Map<String, Object>> queryReturnorderdetailAllListPage(PageBean pageBean) {

        return goodsMapper.queryReturnorderdetailAllListPage();
    }


}
