package com.upup.sys.model;

import lombok.ToString;

@ToString
public class SysRole {
    private Integer uuid;

    private String name;

    public SysRole(Integer uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public SysRole() {
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