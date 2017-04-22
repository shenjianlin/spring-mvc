package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ASUS on 2017/4/21.
 */
@Controller
public class IndexController {
    //<!-- 映射根目录，所访问的页面 -->
    //<mvc:view-controller path="/" view-name="index"/>

    /*这句话就相当于上面的*/
   /* @RequestMapping("/")
    public String indexPageShow() {
        return "index";
    }*/
}
