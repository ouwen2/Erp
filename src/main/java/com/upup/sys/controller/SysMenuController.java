package com.upup.sys.controller;

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

@Controller
@RequestMapping("Sys")
public class SysMenuController {

    @Autowired
    private ISysMenuServce iSysMenuServce;

    @RequestMapping("/getLeftAsideByPid")
    @ResponseBody
    public ModelAndView getLeftAsideByPid(Integer pid){
        ModelAndView modelAndView = new ModelAndView();

        ArrayList<SysRole> leftAsideByPid = iSysMenuServce.getLeftAsideByPid(pid);
        modelAndView.addObject(leftAsideByPid);
        System.out.println("=============OK=============");
        modelAndView.setView(new MappingJackson2JsonView());

        return modelAndView;
    }

}
