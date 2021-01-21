package com.upup.stock.vo;

import com.upup.stock.model.Inventory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class InventoryVo extends Inventory {
    private String min;
    private String max;
}
