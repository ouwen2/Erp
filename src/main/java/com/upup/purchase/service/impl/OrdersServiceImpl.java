package com.upup.purchase.service.impl;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.purchase.mapper.OrderdetailMapper;
import com.upup.purchase.mapper.OrdersMapper;
import com.upup.purchase.service.IOrdersService;
import com.upup.purchase.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
