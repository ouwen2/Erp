package com.upup.sys.servce;

import com.upup.sys.model.SysEmp;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface ISysEmpServce {
    int deleteByPrimaryKey(Integer uuid);

    int insert(SysEmp record);

    int insertSelective(SysEmp record);

    SysEmp selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(SysEmp record);

    int updateByPrimaryKey(SysEmp record);

    SysEmp selectByName(String empName);
}