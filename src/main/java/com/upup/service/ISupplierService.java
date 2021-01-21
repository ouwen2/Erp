package com.upup.service;

import com.upup.base.util.JsonResponseBody;
import com.upup.model.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ISupplierService {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

    //查询
    JsonResponseBody<?> queryall();
}