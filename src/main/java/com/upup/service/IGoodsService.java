package com.upup.service;

import com.upup.base.util.JsonResponseBody;
import com.upup.sale.model.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IGoodsService {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    JsonResponseBody<?> querygoodall();

    JsonResponseBody<?> selectSinglegood(String goodname);
}