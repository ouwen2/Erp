package com.upup.stock.vo;


import com.upup.stock.model.Storedetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class StoredetailVo extends Storedetail {
    private String storeName;
    private String goodsName;
}