package com.upup.mapper;

import com.upup.model.Supplier;
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
    List<Supplier> queryall();
}