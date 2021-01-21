package com.upup.sale.vo;

import lombok.Data;

import java.util.List;

@Data
public class OrderVo {
    private int uuid;
    private String CREATETIME;
    private Integer type;
    private Integer creater;
    private Float TOTALMONEY;
    private Integer state;
    private Integer SUPPLIERUUID;

}
