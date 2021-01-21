package com.upup.sys.controller;

import com.upup.base.controller.BaseController;
import com.upup.base.util.*;
import com.upup.sys.model.SysEmp;
import com.upup.sys.service.ISysEmpService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("SysEmp")
public class SysEmpController extends BaseController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ISysEmpService iSysEmpService;

    @ResponseBody

    @RequestMapping("/passwordEmp")
    public JsonResponseBody passwordEmp(String pwd,HttpServletRequest request){
        String ipAddr = GetIpAddr.getIpAddr(request);
        SysEmp sysEmp = (SysEmp) redisTemplate.opsForValue().get(ipAddr);

        String salt = PasswordHelper.createSalt();
        sysEmp.setSalt(salt);
        sysEmp.setPwd(PasswordHelper.createCredentials(pwd,salt));
        iSysEmpService.updatePassword(sysEmp);

        redisTemplate.opsForValue().set(ipAddr,sysEmp);

        return new JsonResponseBody(ResponseStatus.STATUS_200,"修改密码成功");
    }

    @ResponseBody
    @RequestMapping("/exit")
    public JsonResponseBody exit(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        HttpSession session = SysContent.getRequest().getSession();
        SysEmp sysEmp = (SysEmp) session.getAttribute("user");

        redisTemplate.delete(GetIpAddr.getIpAddr(request)+"checkbox2");
        redisTemplate.delete(GetIpAddr.getIpAddr(request));
        return new JsonResponseBody(ResponseStatus.STATUS_200,"注销成功");
    }


    @RequestMapping("/login")
    @ResponseBody
    public ModelAndView login(boolean checkbox1,boolean checkbox2,SysEmp sysEmp, HttpServletRequest req) throws AuthenticationException {
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(
                sysEmp.getUsername(),
                sysEmp.getPwd()
        );

        String magess = "";
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            e.printStackTrace();
            magess = "账号错误";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            magess = "密码错误";
        }catch (Exception e){
            e.printStackTrace();
            magess = "账号或者密码错误";
        }

        HttpSession session = req.getSession();
        session.setAttribute("user",iSysEmpService.selectByName(sysEmp.getUsername()));
        SysContent.setRequest(req);

        //IP地址为键 sysEmp对象为值 存入redis
        String ipAddr = GetIpAddr.getIpAddr(req);
        redisTemplate.opsForValue().set(ipAddr+sysEmp.getUsername(),sysEmp.getPwd());

        sysEmp = iSysEmpService.selectByName(sysEmp.getUsername());
        redisTemplate.opsForValue().set(ipAddr,sysEmp);
        redisTemplate.expire(ipAddr,1800, TimeUnit.SECONDS);

        //如果点击了保存密码
        ArrayList<SysEmp> sysEmpArrayList = (ArrayList<SysEmp>)redisTemplate.opsForValue().get(ipAddr+"checkbox1");

            if(checkbox1){
                sysEmpArrayList = new ArrayList<>();
                sysEmpArrayList.add(sysEmp);
            }else{
                if (sysEmpArrayList!=null)
                    if(sysEmpArrayList.size()!=0){
                //如果这个人之前点击了保存密码 现在没有点击保存密码
                //这个人就是不想让这个账号保存密码了 那应该把这个账号从集合里删除
                for (int i = 0;i<sysEmpArrayList.size();i++){
                    if(sysEmpArrayList.get(i).getUuid()==sysEmp.getUuid()){
                        sysEmpArrayList.remove(i);
                        redisTemplate.delete(ipAddr+sysEmpArrayList.get(i).getUsername());
                    }
                }
            }
        }
        redisTemplate.opsForValue().set(ipAddr+"checkbox1",sysEmpArrayList);
        //如果点击了7天自动登录
        if(checkbox2){
            redisTemplate.opsForValue().set(ipAddr+"checkbox2",sysEmp);
        }

        ModelAndView mv = new ModelAndView();

        if (magess.equals("")){
            magess = "登陆成功";
            mv.addObject("magess",magess);
            mv.addObject("sysEmp",sysEmp);
        }else {
            mv.addObject("magess",magess);
        }
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

//    @RequiresRoles(value = {"管理员","高级用户"},logical = Logical.OR)
//    @RequiresPermissions(value = "SyeEmp/getEmpListPage")
    @RequestMapping("/getEmpListPage")
    @ResponseBody
    public JsonResponseBody getEmpListPage(SysEmp sysEmp,HttpServletRequest request){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        pageBean.setRows(5);
        List<Map<String, Object>> sysEmpByUserNamePage = iSysEmpService.getSysEmpByUserNamePage(sysEmp, pageBean);

        for (int i = 0;i<sysEmpByUserNamePage.size();i++) {
            //性别修改0为男,1为女
            if(sysEmpByUserNamePage.get(i).get("GENDER").equals(0)){
                sysEmpByUserNamePage.get(i).put("GENDER","男");
            }else{
                sysEmpByUserNamePage.get(i).put("GENDER","女");
            }
        }
        return new JsonResponseBody(sysEmpByUserNamePage,sysEmpByUserNamePage.size());
    }

    @ResponseBody
    @RequestMapping("updatePassword")
    public JsonResponseBody updatePassword(Integer empId){
        System.out.println("empId:"+empId);
        SysEmp sysEmp = new SysEmp();
        sysEmp.setUuid(empId);
        String salt = PasswordHelper.createSalt();
        sysEmp.setSalt(salt);
        sysEmp.setPwd(PasswordHelper.createCredentials("88888888",salt));
        System.out.println("sysEmp:"+sysEmp);
        iSysEmpService.updatePassword(sysEmp);
        return new JsonResponseBody(ResponseStatus.STATUS_200,"修改该用户的密码为:88888888");
    }
}
