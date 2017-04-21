package com.spring.mvc.service;

import com.spring.mvc.model.UserDo;

import java.util.List;

/**
 * Created by ASUS on 2017/4/20.
 */
public interface LoginService {

    public List<UserDo> getUserList();

    public Boolean valLogin(UserDo user);

    public Boolean modifyUser(UserDo user);

    public Boolean addUser(UserDo user);

    public Boolean deleteUser(String userId);

    public UserDo getUserById(String userId);
}

