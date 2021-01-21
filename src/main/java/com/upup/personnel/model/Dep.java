package com.upup.personnel.model;

import lombok.Builder;
import lombok.ToString;

import java.io.Serializable;

@Builder
@ToString
public class
Dep implements Serializable {
    private Integer uuid;

    private String name;

    private String tele;

    public Dep(Integer uuid, String name, String tele) {
        this.uuid = uuid;
        this.name = name;
        this.tele = tele;
    }

   /* public Dep(Integer uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }
*/
    public Dep() {
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

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }
}