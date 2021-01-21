package com.upup.sale.service;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.model.Store;
import com.upup.model.Storedetail;
import com.upup.purchase.model.Orderdetail;
import com.upup.purchase.model.Orders;
import com.upup.purchase.model.Returnorderdetail;
import com.upup.purchase.model.Returnorders;
import com.upup.sale.model.Goods;
import com.upup.sale.vo.GoodsVo;
import com.upup.sale.vo.OrderVo;
import com.upup.sale.vo.ReturnordersVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;

public interface IGoodsService {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Goods record);

    int insertSelective(Goods record);


    JsonResponseBody<Goods> selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    JsonResponseBody<?> queryNameAll();

    JsonResponseBody<?> queryBynameAll(String name);

    int selectgetByhenduo(String storename, int glyuuid, int goodsuuid);

    int updateNumJian(int uuid, int nun);

    int updateOrdersDetail(Integer uuid);

    List<Integer> queryStateList(Integer ordersuuid);


    int updateOrderscjstate(Integer ordersuuid);

    JsonResponseBody<?> querySupplierAllList();

    JsonResponseBody<?> getBygoodesname(String goodname);

    int insertOrderssj(OrderVo orderVo);

    int insertOrderxiangxi(List<GoodsVo> orderDetailList, int orderid);

    int updatereturn(Integer uuid);

    Orderdetail selectByid(Integer uuid);

    Returnorders selectByorderid(Integer orderuuid);

    int insertreturnorders(ReturnordersVo returnordersVo);

    int updatemonryjia(Integer orderuuid, Float money);

    int selectsuppGetByname(String suppliername);

    int insertreturnordersdetail(Orderdetail orderdetail);

    JsonResponseBody<List<Map<String, Object>>> queryReturnorderdetailAllList();

    JsonResponseBody<List<Map<String, Object>>> queryReturnorderdetailAllListtype();


    JsonResponseBody<List<Returnorderdetail>> queryByreturnid(Integer orderuuid);

    int updatesetstateY(Integer orderuuid);

    int updatesetreturnOrders(Integer orderuuid, Integer glyuuid, String shijian);

    JsonResponseBody<?> queryByglyuuidAll(Integer glyuuid);

    int selectcangkuuuid(String storename, Integer glyuuid);

    Storedetail selectcangkudetauiluuid(Integer storeuuid, Integer goodsuuid);

    int updateStoreJia(Integer storedetailuuid, Integer num);

    int updateStoreJian(Integer storedetailuuid, Integer num);


    int updateReturndetailstateH(Integer ordersuuid);

    List<String> queryStateListString(Integer ordersuuid);

    List<String> queryStateListStringss(Integer ordersuuid);


    int updatereturnorderssetstateH(Integer ordersuuid);

    List<Map<String,Object>> queryReturnorderdetailAllListPage(PageBean pageBean);


}
