package com.upup.sys.service;

import com.upup.sys.model.SysMenu;

import java.util.ArrayList;

public interface ISysMenuService {
    int deleteByPrimaryKey(String menuid);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String menuid);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    ArrayList<SysMenu> getLeftAsideByPid(String pid);

}