package com.upup.sys.mapper;

import com.upup.sys.model.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer uuid);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}