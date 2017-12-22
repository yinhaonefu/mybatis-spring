package com.mybatis.test.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yinhao on 17/12/22.
 */
public class SqlSessionFactoryUtil {

    private static Logger logger = Logger.getLogger(SqlSessionFactoryUtil.class.getName());

    private static SqlSessionFactory sqlSessionFactory = null;

    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    private SqlSessionFactoryUtil(){

    };

    public static SqlSessionFactory initSqlSessionFactory(){
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        }catch (Exception e){
            logger.log(Level.SEVERE,null,e);
        }
        synchronized (CLASS_LOCK){
            if(sqlSessionFactory == null){
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSqlSession(){
        if(sqlSessionFactory == null){
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }



}
