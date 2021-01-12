package com.upup.purchase.model;

import lombok.*;

import java.util.Date;

@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private Integer uuid;

    private Date createtime;

    private Date checktime;

    private Date starttime;

    private Date endtime;

    private String type;

    private Integer creater;

    private Integer checker;

    private Integer starter;

    private Integer ender;

    private Integer supplieruuid;

    private Integer totalmoney;

    private String state;

    private Integer waybillsn;

}