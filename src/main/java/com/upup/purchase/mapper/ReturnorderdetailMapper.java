package com.upup.purchase.mapper;

import com.upup.purchase.model.Returnorderdetail;

public interface ReturnorderdetailMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Returnorderdetail record);

    int insertSelective(Returnorderdetail record);

    Returnorderdetail selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Returnorderdetail record);

    int updateByPrimaryKey(Returnorderdetail record);
}