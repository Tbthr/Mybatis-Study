package model;

import com.lyq.mapper.UserMapper;
import com.lyq.model.User;
import com.lyq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * @author lyq_power
 * @date 2020/2/28 9:37 09s
 */
public class UserTest {

    static Logger logger=Logger.getLogger(UserTest.class);

    @Test
    public void selectUser() {
        logger.info("info：进入selectUser方法");
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }
}
