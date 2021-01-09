package com.upup.mapper;

import com.upup.model.Storeoper;

public interface StoreoperMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Storeoper record);

    int insertSelective(Storeoper record);

    Storeoper selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Storeoper record);

    int updateByPrimaryKey(Storeoper record);
}