package com.upup.purchase.mapper;

import com.upup.purchase.model.Orderdetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderdetailMapper {

    int insert(@Param("orderDetailList") List<Orderdetail> orderDetailList, @Param("orderid") int orderid);



}