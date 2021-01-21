package com.upup.sys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

@ToString
@Data
@AllArgsConstructor
public class SysLog {
    private Integer uuid;

    private String logIp;

    private String logMethod;

    private String userName;

    private Timestamp logDate;

    private String menuId;

    public SysLog() {
        super();
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public String getLogMethod() {
        return logMethod;
    }

    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getLogDate() {
        return logDate;
    }

    public void setLogDate(Timestamp logDate) {
        this.logDate = logDate;
    }
}