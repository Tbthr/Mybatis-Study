package com.lyq.model;

import com.lyq.mapper.UserMapper;
import com.lyq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author lyq_power
 * @date 2020/2/28 9:37 09s
 */
public class UserTest {
    @Test
    public void selectUser() {
        SqlSession session = MybatisUtils.getSession();
        //方法一: 旧
//        List<User> users = session.selectList("com.lyq.mapper.UserMapper.selectUser");

        //方法二: 新
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();

        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }
}
