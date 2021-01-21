package com.upup.basics.service;

import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.basics.model.Supplier;

import java.util.List;


public interface ISupplierService {
    //删除供应商或客户信息
    int deleteByPrimaryKey(Integer uuid);

    //添加供应商或客户信息
    int insert(Supplier record);

    //添加供应商或客户信息2
    int insert2(Supplier record);

    //供应商或客户名单个查询
    Supplier selectByPrimaryKey(String supplier);

    //修改供应商或客户信息
    int updateByPrimaryKey(Supplier record);

    //查询
    List<Supplier> queryAllSupplier(Supplier supplier);

    //分页查询供应商
    JsonResponseBody<?> querySupplierPage(Supplier supplier,PageBean pageBean);

    //分页查询客户
    JsonResponseBody<?>  queryCustomerPage(Supplier supplier,PageBean pageBean);
}