package com.upup.sys.controller;

import com.upup.base.controller.BaseController;
import com.upup.sys.model.SysMenu;
import com.upup.sys.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("Sys")
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



}
