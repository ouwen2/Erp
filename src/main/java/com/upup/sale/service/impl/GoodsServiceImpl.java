package com.upup.sale.service.impl;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.sale.mapper.GoodsMapper;
import com.upup.sale.model.Goods;
import com.upup.sale.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public int insertSelective(Goods record) {
        return 0;
    }




    @Override
    public int updateByPrimaryKey(Goods record) {
        return 0;
    }

    @Override
    public JsonResponseBody<?> queryNameAll() {
        return null;
    }

    @Override
    public JsonResponseBody<List<Map<String,Object>>> querygoodall() {
        List<Map<String,Object>> list = goodsMapper.querygoodall();
        return new JsonResponseBody<>(list);
    }

    @Override
    public JsonResponseBody<Goods> selectSinglegood(String goodname) {
        Goods goods = goodsMapper.selectSinglegood(goodname);
        return new JsonResponseBody<>(goods);
    }

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
