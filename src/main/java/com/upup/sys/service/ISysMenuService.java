package com.upup.sys.service;

import com.upup.sys.model.SysMenu;
import com.upup.sys.vo.SysEmpRole;
import com.upup.sys.vo.SysRoleMenu;

import java.util.ArrayList;
import java.util.List;

public interface ISysMenuService {
    int deleteByPrimaryKey(String menuid);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String menuid);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    ArrayList<SysMenu> getLeftAsideByPid(String pid);

    List<SysMenu> getSysTreeList();

    List<SysMenu> getSysTreeByRoleUUIDList(Integer roleId);

    int deleteEmpRole(Integer empId);

    int saveEmpRole(SysRoleMenu sysRoleMenu);

    SysMenu selectByUrl(String url);
}