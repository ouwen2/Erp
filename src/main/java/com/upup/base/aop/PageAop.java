package com.upup.base.aop;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.upup.base.util.PageBean;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PageAop {

    @SneakyThrows
    @Around("execution(* *..*Service.*Page(..))")
    public Object invoke(ProceedingJoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        PageBean pageBean = null;
        for (Object arg : args) {
            if (arg instanceof PageBean){
                pageBean = (PageBean) arg;
            }
        }
        if(pageBean!=null&&pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }

        Object proceed = joinPoint.proceed(args);

        if(pageBean!=null&&pageBean.isPagination()){
            PageInfo pageInfo = new PageInfo((List) proceed);
        }
        return proceed;
    }
}
