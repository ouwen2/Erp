package com.upup.purchase.service;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.purchase.model.Orderdetail;
import com.upup.purchase.model.Orders;
import com.upup.purchase.vo.OrderSa;
import com.upup.base.util.PageBean;
import com.upup.purchase.vo.OrderVo;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface IOrdersService {

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    JsonResponseBody<?> queryall();

    /**
     * 销售统计
     * @param orderSa
     * @return
     */
    List<Map<String,Object>>  getBySalesPage(OrderSa orderSa, PageBean pageBean);

    /**
     * 销售趋势
     * @param ytime
     * @return
     */
    JsonResponseBody<?> getByTrendPage(String ytime);

    /**
     * 查询到所有的销售年份
     * @return
     */
    List<Map<String,Object>> getByYear();

    //--------------------------采购

    //添加订单
    JsonResponseBody<?> insertSelective(OrderVo orderVo);

    //查询分页  （供应商）
    List<Map<String,Object>> queryPage(String supliername, PageBean pageBean);

    //查询所有订单（根据供应商查询）分页
    List<Map<String,Object>> queryPageT(String supliername, String state,PageBean pageBean);

    List<Map<String,Object>> queryPageC(String supliername, String state, String type,PageBean pageBean);


    //根据订单编号修改订单状态（审核）
    int updateOrderState(Orders orders);

    //根据订单编号修改订单状态（确认）
    int updateOrderStateQ(Orders orders);

    //根据订单编号修改订单状态（入库）
    int updateOrderStateR(Orders orders);

    //查询订单下详情为入库
    List<Orderdetail> selectQue(int orderuuid);

    //查询订单下详情为 退货登记
    List<Orderdetail> selectRu(int orderuuid);

    //查询订单下详情为 退货审核
    List<Orderdetail> selectDen(int orderuuid);

    //查询订单下详情为 退货出库
    List<Orderdetail> selectShen(int orderuuid);

    //退货登记
    int updateTuiD(Orders orders);

    //退货审核
    int updateTuiS(Orders orders);

    //退货出库
    int updateTuiC(Orders orders);



}