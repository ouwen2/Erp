package com.upup.basics.service.impl;

import com.upup.base.util.PageBean;

import com.upup.basics.mapper.GoodsMapper;
import com.upup.basics.model.Goods;
import com.upup.basics.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    public GoodsMapper goodsMapper;



    @Override
    public int deleteByPrimaryKey(Integer uuid) {
        return goodsMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }

    @Override
    public Goods selectByPrimaryKey(Integer uuid) {
        return goodsMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return goodsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Map<String,Object>> queryAllGoods(Goods goods) {
        return goodsMapper.queryAllGoods(goods);
    }

    @Override
    public List<Map<String,Object>> queryGoodsPage(Goods goods, PageBean pageBean) {
        return goodsMapper.queryGoodsPager(goods);
    }

}
