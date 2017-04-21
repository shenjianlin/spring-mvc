package com.spring.mvc.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ASUS on 2017/4/20.
 */
@Slf4j
public class UserInterceptor implements HandlerInterceptor {
    /**
     * 拦截器预处理方法
     *
     * @param request
     * @param response
     * @param o
     * @return true:继续执行拦截对象 false:终止调用拦截对象
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        log.debug("执行了 UserInterceptor 中的 preHandle 方法");

        //用户未登录 终止请求
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath()+"/login/init");
            return false;
        }

        return true;
    }

    /**
     * 拦截对象执行方法
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.debug("执行了 UserInterceptor 中的 postHandle 方法");
    }

    /**
     * 拦截完成后执行方法
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.debug("执行了 UserInterceptor 中的 afterCompletion 方法");
    }
}