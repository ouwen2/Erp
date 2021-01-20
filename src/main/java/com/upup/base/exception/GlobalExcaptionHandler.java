package com.upup.base.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class GlobalExcaptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {

        ModelAndView mv = new ModelAndView();
            if(e instanceof UnauthorizedException){
                mv.addObject("msg","无权限异常");
                mv.addObject("success",false);
                mv.setView(new MappingJackson2JsonView());
            }else if(e instanceof BusinessException){
                mv.addObject("msg","业务类异常");
                mv.addObject("success",false);
                mv.setView(new MappingJackson2JsonView());
            }else if(e instanceof SQLException){
                mv.addObject("msg","SQL异常");
                mv.addObject("success",false);
                mv.setView(new MappingJackson2JsonView());
            }
            else{
                mv.addObject("msg","其他异常(代码有问题)");
                mv.addObject("success",false);
                mv.setView(new MappingJackson2JsonView());
            }

        return mv;
    }

    public Boolean isAjaxRequest(HttpServletRequest request){
        return request.getHeader("X-Requested-With")!=null?true:false;
    }

    public String getIp(HttpServletRequest request){
        return request.getHeader("x-forwarded-for");
    }
}
