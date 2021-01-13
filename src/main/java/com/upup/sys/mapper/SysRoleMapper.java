package com.upup.sys.mapper;

import com.upup.sys.model.SysRole;

import java.util.ArrayList;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

}