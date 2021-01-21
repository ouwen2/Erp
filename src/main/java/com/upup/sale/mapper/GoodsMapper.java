package com.upup.sale.mapper;

import com.upup.model.Store;
import com.upup.model.Storedetail;
import com.upup.model.Supplier;
import com.upup.purchase.model.Orderdetail;
import com.upup.purchase.model.Orders;
import com.upup.purchase.model.Returnorderdetail;
import com.upup.purchase.model.Returnorders;
import com.upup.sale.model.Goods;
import com.upup.sale.vo.GoodsVo;
import com.upup.sale.vo.OrderVo;
import com.upup.sale.vo.ReturnordersVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> queryNameAll();

    List<Store> queryBynameAll(String name);

    int selectgetByhenduo(@Param("stoream") String storeame, @Param("gyluuid")int glyuuid, @Param("goodsuuid")int goodsuuid);

    int updateNumJian(int uuid, int nun);

    int updateOrdersDetail(Integer uuid);

    List<Integer> queryStateList(Integer ordersuuid);

    int updateOrderscjstate(Integer ordersuuid);

    List<Supplier> querySupplierAllList();

    List<Goods> getBygoodesname(String goodname);

    int insertOrderssj(OrderVo orderVo);

    int insertOrderxiangxi(@Param("orderDetailList") List<GoodsVo> orderDetailList,@Param("orderid")int orderid);

   int updatereturn(Integer uuid);

   Orderdetail selectByid(Integer uuid);

    Returnorders selectByorderid(Integer orderuuid);

    int insertreturnorders(ReturnordersVo returnordersVo);

    int updatemonryjia(@Param("orderuuid")Integer orderuuid,@Param("money")Float money);

    int selectsuppGetByname(String suppliername);

    int insertreturnordersdetail(Orderdetail orderdetail);

    List<Map<String,Object>> queryReturnorderdetailAllList();

    List<Map<String,Object>> queryReturnorderdetailAllListtype();

    List<Returnorderdetail> queryByreturnid(Integer orderuuid);

    int  updatesetstateY(Integer orderuuid) ;

    int  updatesetreturnOrders(@Param("orderuuid")Integer orderuuid,@Param("glyuuid")Integer glyuuid,@Param("shijian")String shijian) ;

    List<Store> queryByglyuuidAll(Integer glyuuid);

    int selectcangkuuuid(@Param("storename") String storename,@Param("glyuuid")Integer glyuuid);

    Storedetail selectcangkudetauiluuid(@Param("storeuuid") Integer storeuuid, @Param("goodsuuid")Integer goodsuuid);

    int updateStoreJia(@Param("storedetailuuid") Integer storedetailuuid,@Param("num")Integer num);

    int updateStoreJian(@Param("storedetailuuid") Integer storedetailuuid,@Param("num")Integer num);

    int updateReturndetailstateH(Integer ordersuuid);

    List<String> queryStateListString(Integer ordersuuid);

    List<String> queryStateListStringss(Integer ordersuuid);

    int updatereturnorderssetstateH(Integer ordersuuid);

    List<Map<String,Object>> queryReturnorderdetailAllListPage();

}