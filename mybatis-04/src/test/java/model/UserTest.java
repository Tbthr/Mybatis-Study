package model;

import com.lyq.mapper.UserMapper;
import com.lyq.model.User;
import com.lyq.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
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
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex",1);
        map.put("pageSize",3);

        List<User> userList = userMapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds() {
        SqlSession session = MybatisUtils.getSession();

        int currentPage = 2;  //第几页
        int pageSize = 2;  //每页显示几个
        RowBounds rowBounds = new RowBounds((currentPage-1)*pageSize,pageSize);

        //通过session.**方法进行传递rowBounds [此种方式现在已经不推荐使用了]
        List<User> users = session.selectList("com.lyq.mapper.UserMapper.getUserByRowBounds", null, rowBounds);

        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }
}
