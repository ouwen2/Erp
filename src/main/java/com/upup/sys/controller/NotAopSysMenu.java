package com.upup.sys.controller;

import com.upup.base.util.GetIpAddr;
import com.upup.sys.model.SysEmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("Not")
public class NotAopSysMenu {

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/doLoginCreated")
    @ResponseBody
    public ModelAndView doLoginCreated(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();

        String ipAddr = GetIpAddr.getIpAddr(request);
        SysEmp sysEmp = new SysEmp();
        String magess1 = "无";
        String magess2 = "无";

        //保存密码判断
        ArrayList<SysEmp> sysEmpArrayList = (ArrayList<SysEmp>)redisTemplate.opsForValue().get(ipAddr+"checkbox1");
        //如果有值 就是这个ip地址 有账号点击了保存密码
        if(sysEmpArrayList!=null){
            if(sysEmpArrayList.size()!=0){
                magess1 = "保存密码";
                sysEmp = sysEmpArrayList.get(sysEmpArrayList.size()-1);
            }
        }
        //7天自动登录判断
        SysEmp sysEmp2 = (SysEmp)redisTemplate.opsForValue().get(ipAddr+"checkbox2");
        if(sysEmp2!=null){
            magess2 = "7天自动登录";
            sysEmp = sysEmp2;
        }

        //明文密码set进对象
        if(sysEmp.getUuid()!=null){
            String pwd = (String)redisTemplate.opsForValue().get(ipAddr+sysEmp.getUsername());
            sysEmp.setPwd(pwd);
        }

        modelAndView.addObject(sysEmp);
        modelAndView.addObject("magess1",magess1);
        modelAndView.addObject("magess2",magess2);
        modelAndView.setView(new MappingJackson2JsonView());
        return modelAndView;
    }
}
