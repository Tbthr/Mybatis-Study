import com.lyq.mapper.BlogMapper;
import com.lyq.model.Blog;
import com.lyq.utils.IDUtils;
import com.lyq.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {
    @Test //插入语句
    public void insert(){
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();

        blog.setId(IDUtils.getID());
        blog.setTitle("Mybatis so easy");
        blog.setAuthor("Mr.1");
        blog.setCreateTime(new Date());
        blog.setViews(999);
        mapper.insertBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Spring so easy");
        mapper.insertBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Math so easy");
        mapper.insertBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Mysql so easy");
        mapper.insertBlog(blog);

        sqlSession.close();
    }

    @Test
    //Where-IF语句，查询blog。动态的根据插入的不同参数，进行不同的查询。可以同时满足多个条件
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map<String, String> map = new HashMap<>();
        // map.put("title","Mybatis so easy");
        // map.put("views","999");
        map.put("order","true");

        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    //Where-choose-when-otherwise语句，查询blog。类似switch语句。只能满足最先的那个条件。
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map<String, String> map = new HashMap<>();
        map.put("title","Mybatis so easy");

        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    //    set-if语句更新Blog
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map<String, java.io.Serializable> map = new HashMap<>();
        map.put("id","1");
        map.put("views",777);
        mapper.updateBlog(map);
        sqlSession.close();
    }
    @Test
    //    for-each语句
    public void queryBlogForEach(){
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        //通过id查询。将List集合存到Map里面，List里面都是id
        Map map = new HashMap();
        List<String> list = new ArrayList<>();
        list.add("1");
        map.put("ids",list);
        List<Blog> blogs = mapper.queryBlogForEach(map);
        blogs.forEach(System.out::println);
        sqlSession.close();
    }
}