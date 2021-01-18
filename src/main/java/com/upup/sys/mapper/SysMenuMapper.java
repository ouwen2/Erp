package com.upup.sys.mapper;

import com.upup.sys.model.SysMenu;
import com.upup.sys.model.SysRole;
import com.upup.sys.vo.SysRoleMenu;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SysMenuMapper {
    int deleteByPrimaryKey(String menuid);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String menuid);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    ArrayList<SysMenu> getLeftAsideByPid(@Param("pid") String pid);

    List<SysMenu> getSysTreeByRoleUUIDList(SysRoleMenu sysRoleMenu);

    int saveSysRoleMenu(SysRoleMenu sysRoleMenu);

    int delSysRoleMenu(Integer roleuuid);
}