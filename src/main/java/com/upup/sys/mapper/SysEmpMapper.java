package com.upup.sys.mapper;

import com.upup.sys.model.SysEmp;
import org.springframework.stereotype.Repository;

@Repository
public interface SysEmpMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(SysEmp record);

    int insertSelective(SysEmp record);

    SysEmp selectByPrimaryKey(Integer uuid);

    SysEmp selectByName(String name);

    int updateByPrimaryKeySelective(SysEmp record);

    int updateByPrimaryKey(SysEmp record);


}