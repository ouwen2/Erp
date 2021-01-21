package com.upup.purchase.service.impl;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.purchase.mapper.OrderdetailMapper;
import com.upup.purchase.mapper.OrdersMapper;
import com.upup.purchase.model.Orders;
import com.upup.purchase.service.IOrdersService;
import com.upup.purchase.vo.OrderSa;
import com.upup.purchase.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderdetailMapper orderdetailMapper;

    @Override
    public JsonResponseBody<Integer> insertSelective(OrderVo orderVo) {
        int i = ordersMapper.insertSelective(orderVo);
        if (i>0){
            orderdetailMapper.insert(orderVo.getOrderDetailList(),orderVo.getUuid());
        } else if(i==0){
            return new JsonResponseBody<>(ResponseStatus.STATUS_201);
        }
        return new JsonResponseBody<>(i);
    }

    @Override
    public List<Map<String,Object>> queryPage(String supliername, PageBean pageBean) {
        List<Map<String,Object>> list=ordersMapper.queryPage(supliername);
        return list;
    }

    @Override
    public int insertSelective(Orders record) {
        return 0;
    }

    @Override
    public Orders selectByPrimaryKey(Integer uuid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Orders record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Orders record) {
        return 0;
    }

    @Override
    public JsonResponseBody<?> queryall() {
        return null;
    }

    @Override
    public List<Map<String,Object>>  getBySalesPage(OrderSa orderSa, PageBean pageBean) {
        return ordersMapper.getBySalesPage(orderSa);
    }

    @Override
    public JsonResponseBody<?> getByTrendPage(String ytime) {
        List<Map<String, Object>> byTrendPage = ordersMapper.getByTrendPage(ytime);
        int a = byTrendPage.size();
        for (int i = 1; i <= 12 ; i++){
            boolean b = true;
            for (Map<String,Object> map : byTrendPage){
                int month =(Integer) map.get("moneys");
                if (i==month){
                    b=false;
                    break;
                }
            }
            if (b){
                Map<String,Object> map = new HashMap<>();
                map.put("moneys",i);
                map.put("totalmoney",0);
                byTrendPage.add(map);
            }
        }
        return new JsonResponseBody<>(byTrendPage);
    }

    @Override
    public List<Map<String, Object>> getByYear() {
        return ordersMapper.getByYear();
    }


}
