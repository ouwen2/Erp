package com.upup.purchase.mapper;

import com.upup.base.util.PageBean;
import com.upup.purchase.model.Orders;
import com.upup.purchase.vo.OrderSa;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Repository
public interface OrdersMapper {

    int deleteByPrimaryKey(Integer uuid);

    int insert(Orders record);

    int insertSelective(Orders record);

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
}