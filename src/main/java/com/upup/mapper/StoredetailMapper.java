package com.upup.mapper;

import com.upup.model.Storedetail;

public interface StoredetailMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Storedetail record);

    int insertSelective(Storedetail record);

    Storedetail selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Storedetail record);

    int updateByPrimaryKey(Storedetail record);
}