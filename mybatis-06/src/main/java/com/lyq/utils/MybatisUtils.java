package com.lyq.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    //    使用Mybatis的第一步，获取sqlSessionFactory对象
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//        既然有了 SqlSessionFactory，顾名思义，我们就可以从中获得 SqlSession 的实例了。
//        SqlSession 完全包含了面向数据库执行 org.apache.ibatis.jdbc.SQL 命令所需的所有方法。
//       获取SqlSession连接，直接执行已映射的 SQL 语句。
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession(true);
    }

}