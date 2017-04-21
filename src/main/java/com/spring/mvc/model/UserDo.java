package com.spring.mvc.model;

import lombok.Data;

import java.util.List;

/**
 * Created by ASUS on 2017/4/20.
 */
@Data
public class UserDo {

    private String userId;
    private String userName;
    private String password;
    private String email;
    private String address;
    private String sex;
    private String birthday;
    private String phone;

    private List<Score> scores;

    private SystemRole role;

}
