package com.upup.purchase.model;

import lombok.*;

import java.util.Date;

@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orderdetail {
    private Integer uuid;

    private Integer goodsuuid;

    private String goodsname;

    private Integer price;

    private Integer num;

    private Integer money;

    private Date endtime;

    private Integer ender;

    private Integer storeuuid;

    private String state;

    private Integer ordersuuid;

}