package com.upup.sys.servce.imp;

import com.upup.base.util.PageBean;
import com.upup.sys.mapper.SysRoleMapper;
import com.upup.sys.model.SysRole;
import com.upup.sys.servce.ISysRoleServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServceImpl implements ISysRoleServce {

    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Override
    public int deleteByPrimaryKey(Integer uuid) {
        return sysRoleMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(SysRole record) {
        return sysRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRole record) {
        return sysRoleMapper.insertSelective(record);
    }

    @Override
    public SysRole selectByPrimaryKey(Integer uuid) {
        return sysRoleMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRole record) {
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRole record) {
        return sysRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SysRole> getSysRoleByRoleNamePage(SysRole sysRole, PageBean pageBean) {
        if(sysRole.getName()==null){
            sysRole.setName("");
        }
        return sysRoleMapper.getSysRoleByRoleNamePage(sysRole);
    }


}
