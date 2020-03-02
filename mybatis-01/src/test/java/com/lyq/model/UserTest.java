package com.lyq.model;

import com.lyq.mapper.UserMapper;
import com.lyq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lyq_power
 * @date 2020/2/28 9:37 09s
 */
public class UserTest {
    @Test
    public void selectUser() {
        SqlSession session = MybatisUtils.getSession();
        //方法一: 旧
//        List<User> users = session.selectList("com.com.lyq.mapper.UserMapper.selectUser");

        //方法二: 新
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();

        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void selectUserById(){
        SqlSession session=MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
        session.close();
    }

    @Test
    public void selectUserTest(){
        SqlSession session=MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("value","%刘%");
        List<User> user = mapper.selectUserTest(map);
        for (User user1 : user) {
            System.out.println(user1);
        }
        session.close();
    }

    @Test
    public void addUser(){
        SqlSession session=MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int result = mapper.addUser(User.builder().name("test").pwd("666666").build());
        System.out.println(result);
        session.close();
    }

    @Test
    public void updateUserById(){
        SqlSession session=MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int result = mapper.updateUserById(User.builder().id(4).name("test1").pwd("123456").build());
        System.out.println(result);
        session.close();
    }

    @Test
    public void deleteUserById(){
        SqlSession session=MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int result = mapper.deleteUserById(4);
        System.out.println(result);
        session.close();
    }
}
