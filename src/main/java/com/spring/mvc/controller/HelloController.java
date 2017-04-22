package com.spring.mvc.controller;


import com.spring.mvc.model.Score;
import com.spring.mvc.model.SystemRole;
import com.spring.mvc.model.UserDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * Created by ASUS on 2017/4/20.
 */
@Slf4j
@Controller
@RequestMapping("/mvc")
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    @ResponseBody
    public String hell() {
        log.debug("执行了 HelloController 中的 hello 方法");
        return "hello word ！";
    }
    //累心最好用包装类
    @GetMapping(value = "/hello1")
    public String hello1(Integer id) {
        // 这里放个ID可以把ID打印出来
        log.debug("执行了 HelloController 中的 hello1 方法 {}",id );
        return "hello";
    }


    //@RequestMapping("/hello1")
    //http://localhost:8888/spring-mvc/mvc/hello1/1
    //这种方法后面直接跟个值就行了
   /* @GetMapping(value = "/hello1/{id}")
    public String hello1(@PathVariable("id") int id) {
       // 这里放个ID可以把ID打印出来
        log.debug("执行了 HelloController 中的 hello1 方法 {}",id );
        return "hello";
    }*/
  /*  @GetMapping(value = "/hello1/")
    //http://localhost:8888/spring-mvc/mvc/hello1?id=1
    //这种方法要这样传值
    public String hello1(@RequestParam int id) {
        // 这里放个ID可以把ID打印出来
        log.debug("执行了 HelloController 中的 hello1 方法 {}",id );
        return "hello";
    }
*/
    /**
     * 测试Boolean转换String
     * @param bool
     * @return
     */
    //http://localhost:8888/spring-mvc/mvc/converter?bool=no
    @RequestMapping(value = "/converter", method = RequestMethod.GET)
    @ResponseBody
    public String converter(Boolean bool) {
        return bool.toString();
    }
    /**
     * 测试日期类型的装换
     * formatter
     */
    //http://localhost:8888/spring-mvc/mvc/formatter/date?date=2016-07-01
    @RequestMapping(value = "/formatter/date", method = RequestMethod.GET)
    @ResponseBody
    public String formatterDate(Date date) {
        return date.toString();
    }


    //http://localhost:8888/spring-mvc/mvc/converter/date?date=2016-07-01
    @RequestMapping(value = "/converter/date", method = RequestMethod.GET)
    @ResponseBody
    public String converterDate(Date date) {
        log.debug("执行了 converterDate 中的 converterDate 方法");
        return date.toString();
    }


    /**
     * json 数据的绑定 Chrome DHC工具
     * {"item":"语文","scoreNum":"100"}
     * @param score
     * @return
     */
    @RequestMapping(value = "/score.json", method = RequestMethod.POST)
    @ResponseBody
    public String jsonBinding(@RequestBody Score score) {
        log.debug("执行了 HelloController 中的 jsonBinding 方法");
        return score.toString();
    }
}