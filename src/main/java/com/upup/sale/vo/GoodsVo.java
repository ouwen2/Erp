package com.upup.sale.vo;

import lombok.Data;

import java.util.List;

@Data
public class GoodsVo {
   /* private Integer orderdetailGoodsId;
    private String orderdetailGoodname;
    private Float orderdetailPrice;
    private Integer orderdetailNum;
    private Float orderdetailMoney;
    private Integer orderid;
    private Integer SUPPLIERUUID;*/
   private Integer orderid;
   private List OrderDetailList;

}
