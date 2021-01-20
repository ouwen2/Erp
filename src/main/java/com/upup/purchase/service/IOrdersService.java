package com.upup.purchase.service;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.purchase.model.Orders;
import com.upup.purchase.vo.OrderSa;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IOrdersService {

    int deleteByPrimaryKey(Integer uuid);

    int insert(Orders record);

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
}