package com.upup.basics.service;

import com.upup.base.util.PageBean;
import com.upup.basics.model.GoodsType;

import java.util.List;

public interface IGoodsTypeService {
    //删除
    int deleteByPrimaryKey(Integer uuid);

    //添加
    int insert(GoodsType record);

    //根据id查询
    GoodsType selectByPrimaryKey(Integer uuid);

    //修改
    int updateByPrimaryKey(GoodsType record);

    //查询
    List<GoodsType> queryAllGoodsType(GoodsType goodsType);

    //分页查询
    List<GoodsType> queryGoodsTypePager(GoodsType goodsType, PageBean pageBean);


}