package com.upup.sys.servce;

import com.upup.sys.model.SysMenu;
import com.upup.sys.model.SysRole;

import java.util.ArrayList;

public interface ISysMenuServce {
    int deleteByPrimaryKey(String menuid);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String menuid);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    ArrayList<SysRole> getLeftAsideByPid(Integer pid);

}