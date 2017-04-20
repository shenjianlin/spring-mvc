package com.spring.mvc.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ASUS on 2017/4/19.
 */
@Slf4j
@Controller
@RequestMapping("/mvc")
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hell() {
        log.debug("执行了 HelloController 中的 hello 方法");
        return "hello word ！";
    }

    @RequestMapping("/hello1")
    public String hello1() {
        log.debug("执行了 HelloController 中的 hello1 方法");
        return "hello";
    }
}
