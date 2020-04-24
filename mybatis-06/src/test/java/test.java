import com.lyq.mapper.StudentMapper;
import com.lyq.model.Student;
import com.lyq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author lyq_power
 * @date 2020/3/20 10:04 29s
 */
public class test {
    @Test
    public void testGetStudents(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudent();
        students.forEach(System.out::println);
    }

    @Test
    public void testGetStudents2(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudent2();
        students.forEach(System.out::println);
    }
}
