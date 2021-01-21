package com.upup.sys.service;

import com.upup.base.util.PageBean;
import com.upup.sys.model.SysRole;
import com.upup.sys.vo.SysEmpRole;
import com.upup.sys.vo.SysRoleMenu;

import java.util.List;

public interface ISysRoleService {
    int deleteByPrimaryKey(Integer uuid);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> getSysRoleByRoleNamePage(SysRole sysRole, PageBean pageBean);

    List<SysRole> getRoleListByEmpId(Integer empId);

    int saveEmpRole(SysEmpRole sysEmpRole);

    int deleteEmpRole(Integer empId);

}