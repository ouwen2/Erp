package com.upup.sys.mapper;

import com.upup.sys.model.SysMenu;

public interface SysMenuMapper {
    int deleteByPrimaryKey(String menuid);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String menuid);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}