package com.spring.mvc.controller;

import com.spring.mvc.model.UserDo;
import com.spring.mvc.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 前台页面传参
 * 1.url  ?key=value   @RequestParam("key")
 * 2.url /{value}    @PathVariable   key:@PathVariable("key")
 * 3.映射自定义对象    @ModelAttribute UserDo user  前台页面 input 通过 name名称获取 映射给user.属性
 * Created by ASUS on 2017/4/21.
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LoginService loginService;

    /**
     * 查询系统用户列表
     * @param map
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String userList(ModelMap map) {
        map.put("users", loginService.getUserList());
        return "user/userList";
    }
    /**
     * 新增页面初始化
     * @return
     * 在spring.xml中写入扫描
     *  <mvc:view-controller path="/user/addInit" view-name="user/userAdd"/>
     *  的话下面的就不用了
     */
   /* @RequestMapping(value = "/addInit",method = RequestMethod.GET)
    public String addInit(){
        return "user/userAdd";
    }*/

    /**
     * 新增用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute UserDo user) {
        loginService.addUser(user);
        return "redirect:/user/list";
    }

    /**
     * 修改页面初始化
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping(value = "/modifyInit", method = RequestMethod.GET)
    public String modifyInit(@RequestParam("userId") String userId, ModelMap model) {
        model.put("user", loginService.getUserById(userId));
        return "user/userModify";
    }


    /**
     * 修改用户初始化
     * @param userId
     * @param model
     * @return
     * value = "/modifyInit2/{userId}"和@PathVariable("userId")
     * 里面要相同
     */
    @RequestMapping(value = "/modifyInit2/{userId}", method = RequestMethod.GET)
    public String modifyInit2(@PathVariable("userId") String userId, Map<String, Object> model) {
        model.put("user", loginService.getUserById(userId));
        return "user/userModify";
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyUser(@ModelAttribute UserDo user) {
        loginService.modifyUser(user);
        return "redirect:/user/list";
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("userId") String userId) {
        loginService.deleteUser(userId);
        return "redirect:/user/list";
    }

    /**
     * 删除用户
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete2", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request) {

        String userId = String.valueOf(request.getParameter("userId"));
        loginService.deleteUser(userId);
        return "redirect:/user/list";
    }


    /**
     * json 数据处理  ajax
     * @param userId
     * @return
     */
    //http://localhost:8888/spring-mvc-demo/user/user.json/001
    @RequestMapping(value = "/user.json/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public UserDo viewUser(@PathVariable("userId") String userId) {
        log.debug("function viewUser userId={}", userId);
        UserDo userDO = loginService.getUserById(userId);

        return userDO;
    }

    /**
     * json 数据处理  ajax
     * @return
     */
    //http://localhost:8888/spring-mvc-demo/user/users.json
    @RequestMapping(value = "/users.json", method = RequestMethod.GET)
    public ResponseEntity<List<UserDo>> viewUser() {
        return new ResponseEntity<List<UserDo>>(loginService.getUserList(), HttpStatus.OK);
    }
}
