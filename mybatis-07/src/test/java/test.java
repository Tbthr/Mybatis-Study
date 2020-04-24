import com.lyq.mapper.TeacherMapper;
import com.lyq.model.Teacher;
import com.lyq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author lyq_power
 * @date 2020/3/20 10:04 29s
 */
public class test {
    @Test
    public void testGetTeacher(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());
    }

    @Test
    public void testGetTeacher2(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());
    }
}
