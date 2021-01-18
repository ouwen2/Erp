package com.upup.base.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalExcaptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {

        ModelAndView mv = new ModelAndView();
        if(isAjaxRequest(httpServletRequest)){
            mv.addObject("msg","这个是ajax请求");
            mv.setView(new MappingJackson2JsonView());
        }else{
            if(e instanceof UnauthorizedException){
                mv.addObject("msg","无权限异常");
                mv.addObject("success",false);
                mv.setView(new MappingJackson2JsonView());
            }else if(e instanceof BusinessException){
                mv.addObject("msg","业务类异常");
                mv.addObject("success",false);
                mv.setView(new MappingJackson2JsonView());
            }
//            else{
//            }
        }
        mv.addObject("msg","其他异常");
        mv.addObject("success",false);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    public Boolean isAjaxRequest(HttpServletRequest request){
        return request.getHeader("X-Requested-With")!=null?true:false;
    }

    public String getIp(HttpServletRequest request){
        return request.getHeader("x-forwarded-for");
    }
}
