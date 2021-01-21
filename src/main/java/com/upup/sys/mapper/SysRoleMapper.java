package com.upup.sys.mapper;

import com.upup.sys.model.SysRole;
import com.upup.sys.vo.SysEmpRole;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> getSysRoleByRoleNamePage(SysRole sysRole);

    List<SysRole> getRoleListByEmpId(Integer empId);

    int deleteEmpRole(Integer empId);

    int saveEmpRole(SysEmpRole sysEmpRole);
}