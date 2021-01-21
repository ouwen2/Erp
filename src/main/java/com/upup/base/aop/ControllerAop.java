package com.upup.base.aop;

import com.upup.base.util.GetDateUtil;
import com.upup.base.util.GetIpAddr;
import com.upup.base.util.SysContent;
import com.upup.sys.model.SysEmp;
import com.upup.sys.model.SysLog;
import com.upup.sys.model.SysMenu;
import com.upup.sys.service.ISysEmpService;
import com.upup.sys.service.ISysLogService;
import com.upup.sys.service.ISysMenuService;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

@Component
@Aspect
public class ControllerAop {
    @Autowired
    private ISysLogService iSysLogService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ISysMenuService iSysMenuService;

    @Autowired
    private ISysEmpService iSysEmpService;

    @Around("execution(* *..*Controller.*(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = null;
        Object[] args = joinPoint.getArgs();//参数


        Signature signature = joinPoint.getSignature();
        Object target = joinPoint.getTarget();
        String className = target.getClass().getName();//获取完整类路径

        String method = signature.getName();//方法名

        if(method.equals("login")){
            joinPoint.proceed(args);
        }

        //SysEmp/updatePassword 截取Controller前的字符串/方法名
        //权限的名名也必须是这个格式
        String nameController = className.substring(className.lastIndexOf("."), className.length());
        String nameController2 = nameController.substring(1, nameController.lastIndexOf("Controller"));
        String nameController3 = nameController2+"/"+method;

        SysMenu sysMenu = iSysMenuService.selectByUrl(nameController3);

        //方法和参数拼接
        String name = className+"."+method+"(";
        for (Object arg : args) {
            if(arg!=null)
                name+=arg.toString()+" , ";
        }
        String name3 = name.substring(0, name.length() - 1);
        name3+=")";

        HttpSession session = SysContent.getRequest().getSession();
        SysEmp sysEmp = (SysEmp) session.getAttribute("user");

        SysLog sysLog = new SysLog();
        sysLog.setLogMethod(name3);
        if(sysEmp!=null) {
            sysLog.setUserName(sysEmp.getUsername());
            sysLog.setLogDate(new Timestamp(GetDateUtil.getDate().getTime()));
            sysLog.setLogIp(GetIpAddr.getIpAddr(SysContent.getRequest()));

            if (sysMenu != null) {
                sysLog.setMenuId(sysMenu.getMenuid());
                iSysLogService.insert(sysLog);
            }
        }

        proceed = joinPoint.proceed(args);
        return proceed;
    }
}
