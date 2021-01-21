package com.upup.purchase.mapper;

import com.upup.purchase.model.Orderdetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderdetailMapper {

    //添加订单详情
    int insert(@Param("orderDetailList") List<Orderdetail> orderDetailList, @Param("orderid") int orderid);

    //根据订单编号查询所对应的订单
    List<Orderdetail> selectByoid(int orderuuid);

    //入库
    int updateOrderdetail(Orderdetail orderdetail);

    //退货登记
    int updateTuiD(Orderdetail orderdetail);

    //退货审核
    int updateTuiS(Orderdetail orderdetail);

    //退货出库
    int updateTuiC(Orderdetail orderdetail);


}