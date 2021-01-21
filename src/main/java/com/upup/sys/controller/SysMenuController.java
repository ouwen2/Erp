package com.upup.sys.controller;

import com.upup.base.controller.BaseController;
import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.ResponseStatus;
import com.upup.sys.model.SysMenu;
import com.upup.sys.service.ISysMenuService;
import com.upup.sys.vo.SysRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("SysMenu")
public class SysMenuController extends BaseController {

    @Autowired
    private ISysMenuService iSysMenuServce;

    @RequestMapping("/getLeftAsideByPid")
    @ResponseBody
    public List<SysMenu> getLeftAsideByPid(){
        ArrayList<SysMenu> leftAsideByPid = iSysMenuServce.getLeftAsideByPid("0");
        for (SysMenu sysMenu : leftAsideByPid) {
            sysMenu.setSysMenus(iSysMenuServce.getLeftAsideByPid(sysMenu.getMenuid()));
        }
        System.out.println("leftAsideByPid:"+leftAsideByPid);
        return leftAsideByPid;
    }

    @RequestMapping("/getSysTreeList")
    @ResponseBody
    public JsonResponseBody getSysTreeList() {
        List<SysMenu> sysTreeList = iSysMenuServce.getSysTreeList();
        System.out.println(sysTreeList);
        return new JsonResponseBody(sysTreeList);
    }

    @ResponseBody
    @RequestMapping("/savaSysMenu")
    public JsonResponseBody savaSysMenu(Integer roleId,String menuIdStr){
        String[] menuIds = menuIdStr.split(",");

        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        sysRoleMenu.setRoleUUID(roleId);

        iSysMenuServce.deleteEmpRole(roleId);
        for (String menuId : menuIds) {
            sysRoleMenu.setMenuId(menuId);
            iSysMenuServce.saveEmpRole(sysRoleMenu);
        }


        return new JsonResponseBody(ResponseStatus.STATUS_200,"保存权限成功");
    }

    @RequestMapping("/getSysTreeByRoleUUIDList")
    @ResponseBody
    public JsonResponseBody getSysTreeByRoleUUIDList(Integer roleUUID) {
        List<SysMenu> sysMenuList = iSysMenuServce.getSysTreeByRoleUUIDList(roleUUID);
        return new JsonResponseBody(sysMenuList);
    }

}
