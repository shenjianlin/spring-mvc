package com.spring.mvc.controller;


import com.spring.mvc.model.UserDo;
import com.spring.mvc.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ASUS on 2017/4/21.
 */
//@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    private  static Logger log= LoggerFactory.getLogger(LoginController.class);
    //把loginService层注入
    @Autowired
    private LoginService loginService ;
    /*这个方法就相当于spring-mvc.xml
    *<mvc:view-controller path="/login/init" view-name="login/login"/>
    * 这个方法
    * */
   /* @RequestMapping("/init")
    public String loginInit(){
        return "login/login";
    }*/

    @RequestMapping(value = "/valLogin",method = RequestMethod.POST)
    public String valLogin(UserDo user, HttpServletRequest request,HttpServletResponse response){
        log.debug("username:{},password:{}",user.getUserName(),user.getPassword());
        if(loginService.valLogin(user)){

            request.getSession().setAttribute("user",user);

            return "redirect:/user/list";
        }

        return "redirect:/login/init";
    }

}
