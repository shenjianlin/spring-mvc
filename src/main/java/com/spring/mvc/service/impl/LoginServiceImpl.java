package com.spring.mvc.service.impl;

import com.google.common.collect.Lists;
import com.spring.mvc.model.Score;
import com.spring.mvc.model.SystemRole;
import com.spring.mvc.model.UserDo;
import com.spring.mvc.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2017/4/20.
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService{

    private  static  List<UserDo> ls= Lists.newArrayList();
    private  static  List<Score> lscore= Lists.newArrayList();
    private  static  List<Score> lscore1= Lists.newArrayList();

    private  static SystemRole sr=new SystemRole();
    private  static SystemRole sr1=new SystemRole();

    static {
        lscore = initScore();
        lscore1 = initScore1();
        sr = initRole();
        sr1 = initRole1();
        ls  = initUserList();
    }
    private static SystemRole initRole1() {
        SystemRole sr=new SystemRole();
        sr.setRoleId("999");
        sr.setRoleName("系统管管理员");
        return sr;
    }

    private static SystemRole initRole() {
        SystemRole sr = new SystemRole();
        sr.setRoleId("888");
        sr.setRoleName("资料管理员");
        return sr;
    }

    private static List<Score> initScore1() {
        List<Score> lscore = Lists.newArrayList();
        Score score = new Score();
        score.setItem("语文");
        score.setScoreNum("90");
        lscore.add(score);

        Score score1 = new Score();
        score1.setItem("数学");
        score1.setScoreNum("99");
        lscore.add(score1);
        return lscore;
    }

    private static List<Score> initScore() {
        List<Score> lscore = Lists.newArrayList();
        Score score = new Score();
        score.setItem("语文");
        score.setScoreNum("100");
        lscore.add(score);

        Score score1 = new Score();
        score1.setItem("数学");
        score1.setScoreNum("69");
        lscore.add(score1);
        return lscore;
    }



    private static List<UserDo> initUserList() {
        UserDo user = new UserDo();
        user.setUserId("001");
        user.setUserName("张三");
        user.setPassword("123456");
        user.setAddress("河南郑州");
        user.setSex("男");
        user.setBirthday("1990-11-29");
        user.setEmail("zhangsan@gmail.com");
        user.setPhone("13612345678");

        user.setScores(lscore);

        user.setRole(sr);

        ls.add(user);

        UserDo user1 = new UserDo();
        user1.setUserId("002");
        user1.setUserName("李四");
        user1.setPassword("654321");
        user1.setAddress("河南商丘");
        user1.setSex("女");
        user1.setBirthday("1980-11-29");
        user1.setEmail("lisi@gmail.com");
        user1.setPhone("13987654321");

        user1.setScores(lscore1);

        user1.setRole(sr1);

        ls.add(user1);

        return ls;
    }


    @Override
    public List<UserDo> getUserList() {
        return ls;
    }

    @Override
    public Boolean valLogin(UserDo user) {
        String username = user.getUserName();
        String password = user.getPassword();
        for(UserDo u : ls){
            if(username.equals(u.getUserName()) && password.equals(u.getPassword())){
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    @Override
    public Boolean modifyUser(UserDo user) {
        for (UserDo u : ls){
            if(user.getUserId().equals(u.getUserId())){
                ls.remove(u);
                ls.add(user);
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean addUser(UserDo user) {
        ls.add(user);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteUser(String userId) {
        for (UserDo u : ls){
            if(userId.equals(u.getUserId())){
                ls.remove(u);
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;

    }

    @Override
    public UserDo getUserById(String userId) {
        for(UserDo u : ls){
            if(userId.equals(u.getUserId())){
                return u;
            }
        }

        return null;
    }
}
