package com.upup.basics.service.impl;

import com.upup.base.util.PageBean;

import com.upup.basics.mapper.GoodsMapper;
import com.upup.basics.model.Goods;
import com.upup.basics.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public int insertSelective(Goods record) {
        return 0;
    }

    @Override
    public Goods selectByPrimaryKey(Integer uuid) {
        return goodsMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return 0;
    }

    @Override
    public List<Goods> queryAllGoods(Goods goods) {
        return goodsMapper.queryAllGoods(goods);
    }

    @Override
    public List<Goods> queryGoodsPager(Goods goods, PageBean pageBean) {
        return goodsMapper.queryGoodsPager(goods);
    }

    @Override
    public int updateByPrimaryKey(Goods record) {
        return 0;
    }
}
