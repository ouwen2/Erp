package com.upup.purchase.mapper;

import com.upup.purchase.model.Orders;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface OrdersMapper {

    int deleteByPrimaryKey(Integer uuid);

    int insert(Orders record);

    //添加订单
    int insertSelective(Orders orders);

    Orders selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Map<String,Object>> queryPage(String supliername);
}