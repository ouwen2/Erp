package com.upup.sys.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.upup.sys.model.SysEmp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ToString
@Builder
@Data
@AllArgsConstructor
public class SysEmpDate extends SysEmp {
    private SysEmp sysEmp;

    private String birthday2;

    private String birthday3;


    public SysEmpDate() {
    }

    public SysEmpDate(SysEmp sysEmp, String birthday2) {
        this.sysEmp = sysEmp;
        this.birthday2 = birthday2;
    }

    public SysEmp getSysEmp() {
        return sysEmp;
    }

    public void setSysEmp(SysEmp sysEmp) {
        this.sysEmp = sysEmp;
    }

}