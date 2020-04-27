import com.lyq.mapper.UserMapper;
import com.lyq.model.User;
import com.lyq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void queryUserById(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.queryUserById(1);
        System.out.println(user1);
        sqlSession.close();

        // User user2 = mapper.queryUserById(2);
        // System.out.println(user2);
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper1 = session.getMapper(UserMapper.class);
        User user2 = mapper1.queryUserById(1);
        System.out.println(user2);

        System.out.println(user1 == user2);

        session.close();
    }
}