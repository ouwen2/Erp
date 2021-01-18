package com.upup.sys.service.imp;

import com.upup.sys.mapper.SysMenuMapper;
import com.upup.sys.model.SysMenu;
import com.upup.sys.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SysMenuServiceImpl implements ISysMenuService {

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
    public ArrayList<SysMenu> getLeftAsideByPid(String pid) {
        return sysMenuMapper.getLeftAsideByPid(pid);
    }
}
