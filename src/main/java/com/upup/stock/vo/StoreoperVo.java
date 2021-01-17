package com.upup.stock.vo;


import com.upup.stock.model.Storeoper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class StoreoperVo extends Storeoper {

    private String sysEmpUuid;
    private String storeName;
    private String goodsName;


}
