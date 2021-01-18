package com.upup.sale.service.impl;

import com.upup.base.util.JsonResponseBody;
import com.upup.model.Store;
import com.upup.sale.mapper.GoodsMapper;

import com.upup.sale.model.Goods;
import com.upup.sale.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int deleteByPrimaryKey(Integer uuid) {
        return 0;
    }

    @Override
    public int insert(Goods record) {
        return 0;
    }

    @Override
    public int insertSelective(Goods record) {
        return 0;
    }

    @Override
    public JsonResponseBody<Goods> selectByPrimaryKey(Integer uuid) {
        Goods goods = goodsMapper.selectByPrimaryKey(uuid);
        System.out.println(goods);
        return new JsonResponseBody<>(goods);
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Goods record) {
        return 0;
    }

    @Override
    public JsonResponseBody<List<Goods>> queryNameAll() {
        List<Goods> list=goodsMapper.queryNameAll();
        return new JsonResponseBody<>(list);
    }

    @Override
    public JsonResponseBody<List<Store>> queryBynameAll(String name) {
        List<Store> list = goodsMapper.queryBynameAll(name);
        return new JsonResponseBody<>(list);
    }
}
