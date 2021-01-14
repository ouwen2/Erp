package com.upup.sys.servce;

import com.github.pagehelper.Page;
import com.upup.base.util.PageBean;
import com.upup.sys.model.SysEmp;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface ISysEmpServce {
    int deleteByPrimaryKey(Integer uuid);

    int insert(SysEmp record);

    int insertSelective(SysEmp record);

    SysEmp selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(SysEmp record);

    int updateByPrimaryKey(SysEmp record);

    SysEmp selectByName(String empName);

    List<Map<String,Object>> getSysEmpByUserNamePage(SysEmp sysEmp, PageBean pageBean);
}