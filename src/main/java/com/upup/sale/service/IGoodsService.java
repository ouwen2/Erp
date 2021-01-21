package com.upup.sale.service;

import com.upup.base.util.JsonResponseBody;
import com.upup.sale.model.Goods;

public interface IGoodsService {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Goods record);

    int insertSelective(Goods record);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    JsonResponseBody<?> queryNameAll();

    JsonResponseBody<?> querygoodall();

    JsonResponseBody<?> selectSinglegood(String goodname);
}