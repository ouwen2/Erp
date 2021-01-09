package com.upup.model;

import java.util.Date;

public class Storeoper {
    private Integer uuid;

    private Integer sysEmpuuid;

    private Date opertime;

    private Integer storeuuid;

    private Integer goodsuuid;

    private Integer num;

    private String type;

    public Storeoper(Integer uuid, Integer sysEmpuuid, Date opertime, Integer storeuuid, Integer goodsuuid, Integer num, String type) {
        this.uuid = uuid;
        this.sysEmpuuid = sysEmpuuid;
        this.opertime = opertime;
        this.storeuuid = storeuuid;
        this.goodsuuid = goodsuuid;
        this.num = num;
        this.type = type;
    }

    public Storeoper() {
        super();
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getSysEmpuuid() {
        return sysEmpuuid;
    }

    public void setSysEmpuuid(Integer sysEmpuuid) {
        this.sysEmpuuid = sysEmpuuid;
    }

    public Date getOpertime() {
        return opertime;
    }

    public void setOpertime(Date opertime) {
        this.opertime = opertime;
    }

    public Integer getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(Integer storeuuid) {
        this.storeuuid = storeuuid;
    }

    public Integer getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(Integer goodsuuid) {
        this.goodsuuid = goodsuuid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}