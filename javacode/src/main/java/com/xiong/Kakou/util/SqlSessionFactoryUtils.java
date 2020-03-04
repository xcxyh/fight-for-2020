package com.xiong.Kakou.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/9/21 15:11
 * @description：
 * @modified By：
 * @version: $
 */
public class SqlSessionFactoryUtils {
    /**
     * 首先创建静态成员变量sqlSessionFactory，静态变量被所有的对象所共享。
     */

    //默认的MySQL的sqlSessionFactory
    public static SqlSessionFactory sqlSessionFactory_MySQL = null;

    //Oracle的sqlSessionFactory
    public static SqlSessionFactory sqlSessionFactory_PostGis = null;

    private SqlSessionFactoryUtils() {}

    //使用静态代码块保证线程安全问题
    static{

        String resource = "mybatisConfig.xml";

        try {

            InputStream inputStream = Resources.getResourceAsStream(resource);

            sqlSessionFactory_MySQL = new SqlSessionFactoryBuilder().build(inputStream,"mysql");

            InputStream inputStream1 = Resources.getResourceAsStream(resource);

            sqlSessionFactory_PostGis = new SqlSessionFactoryBuilder().build(inputStream1, "postgis");

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
