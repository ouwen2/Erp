package com.upup.mapper;

import com.upup.model.Inventory;

public interface InventoryMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Inventory record);

    int updateByPrimaryKey(Inventory record);
}