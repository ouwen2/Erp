package com.upup.basics.service;

import com.upup.base.util.PageBean;
import com.upup.basics.model.Supplier;

import java.util.List;


public interface ISupplierService {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

    //查询
    List<Supplier> queryAllSupplier(Supplier supplier);

    //分页查询
    List<Supplier> querySupplierPager(Supplier supplier, PageBean pageBean);
}