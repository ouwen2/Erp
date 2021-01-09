package com.upup.mapper;

import com.upup.model.Returnorderdetail;

public interface ReturnorderdetailMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Returnorderdetail record);

    int insertSelective(Returnorderdetail record);

    Returnorderdetail selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Returnorderdetail record);

    int updateByPrimaryKey(Returnorderdetail record);
}