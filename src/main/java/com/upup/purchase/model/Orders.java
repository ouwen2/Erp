package com.upup.purchase.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {

  //订单编号
  private Integer uuid;

  //创建时间
  private String createtime;

  //检查时间
  private String checktime;

  //开始时间
  private String starttime;

  //结束时间
  private String endtime;

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