package com.upup.purchase.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.upup.purchase.model.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
public class OrderSa extends Orders  {
    private String toname;
    private String stime;
    private String etime;

    public OrderSa(String stime, String etime) {
        this.stime = stime;
        this.etime = etime;
    }

    public OrderSa() {
    }
}
