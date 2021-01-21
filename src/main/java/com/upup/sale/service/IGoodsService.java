package com.upup.sale.service;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.sale.model.Goods;

import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;

public interface IGoodsService {

    int insertSelective(Goods record);


    int updateByPrimaryKey(Goods record);

    JsonResponseBody<?> queryNameAll();

    JsonResponseBody<?> querygoodall();

    JsonResponseBody<?> selectSinglegood(String goodname);

    //删除
    int deleteByPrimaryKey(Integer uuid);

    //添加
    int insert(Goods record);


    //单个查询
    Goods selectByPrimaryKey(Integer uuid);

    //修改
    int updateByPrimaryKeySelective(Goods record);

    //查询
    List<Map<String,Object>> queryAllGoods(Goods goods);

    //分页查询
    List<Map<String,Object>> queryGoodsPage(Goods goods, PageBean pageBean);


}