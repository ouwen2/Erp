package com.upup.sys.servce.imp;

import com.upup.sys.mapper.SysMenuMapper;
import com.upup.sys.model.SysMenu;
import com.upup.sys.model.SysRole;
import com.upup.sys.servce.ISysMenuServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SysMenuServceImpl implements ISysMenuServce {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public int deleteByPrimaryKey(String menuid) {
        return sysMenuMapper.deleteByPrimaryKey(menuid);
    }

    @Override
    public int insert(SysMenu record) {
        return sysMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(SysMenu record) {
        return sysMenuMapper.insertSelective(record);
    }

    @Override
    public SysMenu selectByPrimaryKey(String menuid) {
        return sysMenuMapper.selectByPrimaryKey(menuid);
    }

    @Override
    public int updateByPrimaryKeySelective(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKey(record);
    }

    @Override
    public ArrayList<SysRole> getLeftAsideByPid(Integer pid) {
        return sysMenuMapper.getLeftAsideByPid(pid);
    }
}
