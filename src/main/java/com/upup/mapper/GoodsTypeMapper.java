package com.upup.mapper;

import com.upup.model.GoodsType;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
}