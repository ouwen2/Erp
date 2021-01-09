package com.upup.mapper;

import com.upup.model.Returnorders;

public interface ReturnordersMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Returnorders record);

    int insertSelective(Returnorders record);

    Returnorders selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Returnorders record);

    int updateByPrimaryKey(Returnorders record);
}