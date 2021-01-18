package com.upup.purchase.service;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.purchase.vo.OrderVo;

import java.util.List;
import java.util.Map;


public interface IOrdersService {

    JsonResponseBody<?> insertSelective(OrderVo orderVo);

    List<Map<String,Object>> queryPage(String supliername, PageBean pageBean);
}