package com.upup.purchase.service.impl;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.purchase.mapper.OrderdetailMapper;
import com.upup.purchase.mapper.OrdersMapper;
import com.upup.purchase.model.Orderdetail;
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
        return  new JsonResponseBody<>(ordersMapper.queryall());
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

    //-------------------------采购
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
    public List<Map<String, Object>> queryPageT(String supliername, String state,PageBean pageBean) {
        return ordersMapper.queryPageT(supliername,state);
    }

    @Override
    public List<Map<String, Object>> queryPageC(String supliername, String state, String type,PageBean pageBean) {
        return ordersMapper.queryPageC(supliername,state,type);
    }

    @Override
    public int updateOrderState(Orders orders) {
        return ordersMapper.updateOrderState(orders);
    }

    @Override
    public int updateOrderStateQ(Orders orders) {
        return ordersMapper.updateOrderStateQ(orders);
    }

    @Override
    public int updateOrderStateR(Orders orders) {
        return ordersMapper.updateOrderStateR(orders);
    }


    @Override
    public List<Orderdetail> selectQue(int orderuuid) {
        return ordersMapper.selectQue(orderuuid);
    }

    @Override
    public List<Orderdetail> selectRu(int orderuuid) {
        return ordersMapper.selectRu(orderuuid);
    }

    @Override
    public List<Orderdetail> selectDen(int orderuuid) {
        return ordersMapper.selectDen(orderuuid);
    }

    @Override
    public List<Orderdetail> selectShen(int orderuuid) {
        return ordersMapper.selectShen(orderuuid);
    }

    @Override
    public int updateTuiD(Orders orders) {

        return ordersMapper.updateTuiD(orders);
    }

    @Override
    public int updateTuiS(Orders orders) {
        return ordersMapper.updateTuiS(orders);
    }

    @Override
    public int updateTuiC(Orders orders) {
        return ordersMapper.updateTuiC(orders);
    }


}
