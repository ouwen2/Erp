package com.upup.sys.controller;

import com.upup.base.controller.BaseController;
import com.upup.base.util.JsonResponseBody;
import com.upup.base.util.PageBean;
import com.upup.base.util.ResponseStatus;
import com.upup.sys.model.SysEmp;
import com.upup.sys.service.ISysEmpService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("SysEmp")
public class SysEmpController extends BaseController {

    @Autowired
    private ISysEmpService iSysEmpServce;

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
            mv.addObject("magess",magess);
        }else {
            mv.addObject("magess",magess);
        }
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/getEmpListPage")
    @ResponseBody
    public JsonResponseBody getEmpListPage(SysEmp sysEmp,HttpServletRequest request){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        pageBean.setRows(5);
        List<Map<String, Object>> sysEmpByUserNamePage = iSysEmpServce.getSysEmpByUserNamePage(sysEmp, pageBean);

        for (Map<String, Object> stringObjectMap : sysEmpByUserNamePage) {
            if(stringObjectMap.get("GENDER").equals(0)){
                stringObjectMap.put("GENDER","男");
            }else{
                stringObjectMap.put("GENDER","女");
            }
        }

        return new JsonResponseBody(ResponseStatus.STATUS_200,sysEmpByUserNamePage);
    }


}
