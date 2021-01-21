package com.upup.basics.mapper;

import com.upup.basics.model.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SupplierMapper {
    List<Supplier> queryall();
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
    List<Supplier> querySupplierPage(Supplier supplier);

    //分页查询客户
    List<Supplier> queryCustomerPage(Supplier supplier);


}