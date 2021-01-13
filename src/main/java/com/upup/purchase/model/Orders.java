package com.upup.purchase.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private Integer uuid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date checktime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date starttime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
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