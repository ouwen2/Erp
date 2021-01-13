package com.upup.purchase.mapper;

import com.upup.purchase.model.Returnorders;

public interface ReturnordersMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Returnorders record);

    int insertSelective(Returnorders record);

    Returnorders selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Returnorders record);

    int updateByPrimaryKey(Returnorders record);
}