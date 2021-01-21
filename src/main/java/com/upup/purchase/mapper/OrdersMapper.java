package com.upup.purchase.mapper;

import com.upup.base.util.PageBean;
import com.upup.purchase.model.Orderdetail;
import com.upup.purchase.model.Orders;
import com.upup.purchase.vo.OrderSa;
import org.apache.ibatis.annotations.Param;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Repository
public interface OrdersMapper {

    int deleteByPrimaryKey(Integer uuid);

    int insert(Orders record);

    Orders selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Map<String,Object>> queryall();

    /**
     * 销售统计
     * @param orderSa
     * @return
     */
    List<Map<String,Object>> getBySalesPage(OrderSa orderSa);

    /**
     * 销售趋势
     * @param ytime
     * @return
     */
    List<Map<String,Object>> getByTrendPage(String ytime);

    /**
     * 查询到所有的销售年份
     * @return
     */
    List<Map<String,Object>> getByYear();



    //----------------------采购
    //添加订单
    int insertSelective(Orders orders);

    //查询所有订单（根据供应商查询）分页
    List<Map<String,Object>> queryPage(String supliername);

    //查询所有订单（根据供应商查询）分页
    List<Map<String,Object>> queryPageT(@Param("supliername") String supliername, @Param("state") String state);

    //查询所有订单（根据供应商查询）分页
    List<Map<String,Object>> queryPageC(@Param("supliername") String supliername,@Param("state") String state
            ,@Param("type")String type);

    //根据订单编号修改订单状态（审核）
    int updateOrderState(Orders orders);

    //根据订单编号修改订单状态（确认）
    int updateOrderStateQ(Orders orders);

    //根据订单编号修改订单状态（入库）
    int updateOrderStateR(Orders orders);

    //查询订单下详情为 未入库
    List<Orderdetail> selectQue(int orderuuid);

    //退货登记
    int updateTuiD(Orders orders);

    //退货审核
    int updateTuiS(Orders orders);

    //退货出库
    int updateTuiC(Orders orders);


    //查询订单下详情为 退货登记
    List<Orderdetail> selectRu(int orderuuid);

    //查询订单下详情为 退货审核
    List<Orderdetail> selectDen(int orderuuid);

    //查询订单下详情为 退货出库
    List<Orderdetail> selectShen(int orderuuid);




}