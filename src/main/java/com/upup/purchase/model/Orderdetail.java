package com.upup.purchase.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orderdetail {


    private Integer uuid;
    //商品编号
    private Integer goodsuuid;
    //商品名称
    private String goodsname;
    //商品价格
    private Float price;
    //商品数量
    private Integer num;
    //金额
    private Float money;

    //结束日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date endtime;

    //库管员
    private Integer ender;

    //仓库编号
    private Integer storeuuid;

    //状态
    private String state;

    //订单编号
    private Integer ordersuuid;


}