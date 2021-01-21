package com.upup.sale.service;

import com.upup.base.util.JsonResponseBody;
import com.upup.sale.model.Goods;

public interface IGoodsService {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Goods record);

    int insertSelective(Goods record);


    JsonResponseBody<Goods> selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    JsonResponseBody<?> queryNameAll();

    JsonResponseBody<?> queryBynameAll(String name);

}