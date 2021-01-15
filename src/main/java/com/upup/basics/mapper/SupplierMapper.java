package com.upup.basics.mapper;

import com.upup.basics.model.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SupplierMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

    //查询
    List<Supplier> queryAllSupplier(Supplier supplier);

    //分页查询
    List<Supplier> querySupplierPager(Supplier supplier);
}