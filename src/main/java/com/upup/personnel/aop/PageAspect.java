package com.upup.personnel.aop;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.upup.base.util.PageBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PageAspect {

    @Around("execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] params=proceedingJoinPoint.getArgs();
        PageBean pageBean=null;
        for(Object param:params){
            if(param instanceof PageBean){
                pageBean=(PageBean) param;
                break;
            }
        }
        if(null!=pageBean&&pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }
        Object proceed = proceedingJoinPoint.proceed(params);

        if(null!=pageBean&&pageBean.isPagination()){
           List list=(List)proceed;
            PageInfo pageInfo=new PageInfo();
            pageBean.setTotal(pageInfo.getTotal()+"");
        }

        return proceed;
    }
}
