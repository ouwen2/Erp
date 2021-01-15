package com.upup.basics.service;

import com.upup.base.util.PageBean;
import com.upup.basics.model.Goods;

import java.util.List;


public interface IGoodsService {
    //删除
    int deleteByPrimaryKey(Integer uuid);

    //添加
    int insert(Goods record);

    int insertSelective(Goods record);

    //单个查询
    Goods selectByPrimaryKey(Integer uuid);

    //修改
    int updateByPrimaryKeySelective(Goods record);

    //查询
    List<Goods> queryAllGoods(Goods goods);

    //分页查询
    List<Goods> queryGoodsPager(Goods goods, PageBean pageBean);

    int updateByPrimaryKey(Goods record);
}