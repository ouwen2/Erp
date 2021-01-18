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

    //订单编号
    private Integer uuid;

    //创建时间
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createtime;

  //检查时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date checktime;

    //开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date starttime;

    //结束时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date endtime;

    private String type;

    private Integer creater;

    private Integer checker;

    private Integer starter;

    private Integer ender;

    //供应商编号
    private Integer supplieruuid;

    //总订单金额
    private Float totalmoney;

    //状态
    private String state;

    //运单号
    private Integer waybillsn;

}