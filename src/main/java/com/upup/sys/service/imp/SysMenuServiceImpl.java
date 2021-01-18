package com.upup.sys.service.imp;

import com.upup.sys.mapper.SysMenuMapper;
import com.upup.sys.model.SysMenu;
import com.upup.sys.service.ISysMenuService;
import com.upup.sys.vo.SysEmpRole;
import com.upup.sys.vo.SysRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<SysMenu> getSysTreeList() {
        ArrayList<SysMenu> leftAsideByPid = sysMenuMapper.getLeftAsideByPid("0");
        for (SysMenu sysMenu : leftAsideByPid) {
            ArrayList<SysMenu> leftAsideByPid1 = sysMenuMapper.getLeftAsideByPid(sysMenu.getMenuid());
            for (SysMenu sysMenu2 : leftAsideByPid1) {
                sysMenu2.setSysMenus(sysMenuMapper.getLeftAsideByPid(sysMenu2.getMenuid()));
            }
            sysMenu.setSysMenus(leftAsideByPid1);
        }
        return leftAsideByPid;
    }

    @Override
    public List<SysMenu> getSysTreeByRoleUUIDList(Integer roleId) {
        SysRoleMenu sysRoleMenu = new SysRoleMenu(roleId);
        List<SysMenu> sysTreeByRoleUUIDList = sysMenuMapper.getSysTreeByRoleUUIDList(sysRoleMenu);
        for (SysMenu sysMenu : sysTreeByRoleUUIDList) {
            sysRoleMenu.setPid(sysMenu.getMenuid());
            List<SysMenu> sysTreeByRoleUUIDList1 = sysMenuMapper.getSysTreeByRoleUUIDList(sysRoleMenu);
            for (SysMenu sysMenu1 : sysTreeByRoleUUIDList1) {
                sysRoleMenu.setPid(sysMenu1.getMenuid());
                sysMenu1.setSysMenus(sysMenuMapper.getSysTreeByRoleUUIDList(sysRoleMenu));
            }
            sysMenu.setSysMenus(sysTreeByRoleUUIDList1);
        }
        System.out.println("sysTreeByRoleUUIDList:"+sysTreeByRoleUUIDList);
        return sysTreeByRoleUUIDList;
    }

    @Override
    public int deleteEmpRole(Integer empId) {
        return sysMenuMapper.delSysRoleMenu(empId);
    }

    @Override
    public int saveEmpRole(SysRoleMenu sysRoleMenu) {
        return sysMenuMapper.saveSysRoleMenu(sysRoleMenu);
    }
}
