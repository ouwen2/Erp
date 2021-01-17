package com.upup.purchase.mapper;

import com.upup.purchase.model.Orderdetail;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderdetailMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    Orderdetail selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
}