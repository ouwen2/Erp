package com.upup.sys.service;

import com.upup.base.util.PageBean;
import com.upup.sys.model.SysEmp;

import java.util.List;
import java.util.Map;

public interface ISysEmpService {
    int deleteByPrimaryKey(Integer uuid);

    int insert(SysEmp record);

    int insertSelective(SysEmp record);

    SysEmp selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(SysEmp record);

    int updateByPrimaryKey(SysEmp record);

    SysEmp selectByName(String empName);

    List<Map<String,Object>> getSysEmpByUserNamePage(SysEmp sysEmp, PageBean pageBean);

    int updatePassword(SysEmp sysEmp);

}