package com.upup.basics.model;


import lombok.ToString;
import org.springframework.stereotype.Repository;

@Repository
@ToString
public class Store {
    private Integer uuid;

    private String name;

    private Integer sysEmpuuid;

    public Store(Integer uuid, String name, Integer sysEmpuuid) {
        this.uuid = uuid;
        this.name = name;
        this.sysEmpuuid = sysEmpuuid;
    }

    public Store() {
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

    public Integer getSysEmpuuid() {
        return sysEmpuuid;
    }

    public void setSysEmpuuid(Integer sysEmpuuid) {
        this.sysEmpuuid = sysEmpuuid;
    }
}