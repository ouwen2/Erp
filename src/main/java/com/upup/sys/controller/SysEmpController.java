package com.upup.sys.controller;

import com.upup.base.controller.BaseController;
import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("SysEmp")
public class SysEmpController extends BaseController {

    @Autowired
    private ISysEmpService iSysEmpService;

    @RequestMapping("/login")
    @ResponseBody
    public ModelAndView login(SysEmp sysEmp, HttpServletRequest req) throws AuthenticationException {
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

        ModelAndView mv = new ModelAndView();

        if (magess.equals("")){
            magess = "登陆成功";
            mv.addObject("magess",magess);
        }else {
            mv.addObject("magess",magess);
        }
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

//    @RequiresRoles(value = {"管理员","高级用户"},logical = Logical.OR)
//    @RequiresPermissions(value = "/getEmpListPage")
    @RequestMapping("/getEmpListPage")
    @ResponseBody
    public JsonResponseBody getEmpListPage(SysEmp sysEmp,HttpServletRequest request){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        pageBean.setRows(5);
        List<Map<String, Object>> sysEmpByUserNamePage = iSysEmpService.getSysEmpByUserNamePage(sysEmp, pageBean);

        for (int i = 0;i<sysEmpByUserNamePage.size();i++) {
//            //因为没有用join 会查到重复的用户  手动去重复并且把roleName合并
//
//            for (int y = i+1;y<sysEmpByUserNamePage.size();y++){
//                if(sysEmpByUserNamePage.get(i).get("UUID").equals(
//                        sysEmpByUserNamePage.get(y).get("UUID"))){
//                    Object obj = sysEmpByUserNamePage.get(i).get("roleName")+","+sysEmpByUserNamePage.get(y).get("roleName");
//                    sysEmpByUserNamePage.get(i).put("roleName",obj);
//                    sysEmpByUserNamePage.remove(y);
//                    System.out.println("size:"+sysEmpByUserNamePage.size());
//                }
//            }
            //性别修改0为男,1为女
            if(sysEmpByUserNamePage.get(i).get("GENDER").equals(0)){
                sysEmpByUserNamePage.get(i).put("GENDER","男");
            }else{
                sysEmpByUserNamePage.get(i).put("GENDER","女");
            }
        }
        return new JsonResponseBody(sysEmpByUserNamePage,sysEmpByUserNamePage.size());
    }

    public JsonResponseBody updatePassword(Integer empId){

        return new JsonResponseBody();
    }
}
