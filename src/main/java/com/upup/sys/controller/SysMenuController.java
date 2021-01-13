package com.upup.sys.controller;

import com.upup.sys.model.SysMenu;
import com.upup.sys.model.SysRole;
import com.upup.sys.servce.ISysMenuServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Sys")
public class SysMenuController {

    @Autowired
    private ISysMenuServce iSysMenuServce;

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
