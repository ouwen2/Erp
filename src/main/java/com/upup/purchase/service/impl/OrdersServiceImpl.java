package com.upup.purchase.service.impl;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.purchase.mapper.OrdersMapper;
import com.upup.purchase.model.Orders;
import com.upup.purchase.service.IOrdersService;
import com.upup.purchase.vo.OrderSa;
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

    @Override
    public int deleteByPrimaryKey(Integer uuid) {
        return 0;
    }

    @Override
    public int insert(Orders record) {
        return ordersMapper.insert(record);
    }

    @Override
    public int insertSelective(Orders record) {
        return 0;
    }

    @Override
    public Orders selectByPrimaryKey(Integer uuid) {
        return ordersMapper.selectByPrimaryKey(uuid);
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
    public JsonResponseBody<List<Map<String,Object>>> queryall() {
        List<Map<String,Object>> list=ordersMapper.queryall();
        System.out.println(list);
        if(list.size()==0)
            return new JsonResponseBody<>(ResponseStatus.STATUS_202);

        return new JsonResponseBody<>(list);
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
