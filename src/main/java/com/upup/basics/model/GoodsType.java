package com.upup.basics.model;

import lombok.ToString;
import org.springframework.stereotype.Repository;

@Repository
@ToString
public class GoodsType {
    private Integer uuid;

    private String name;

    public GoodsType(Integer uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public GoodsType() {
        super();
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}