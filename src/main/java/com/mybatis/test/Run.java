package com.mybatis.test;

import com.mybatis.test.domain.Role;
import com.mybatis.test.mapper.RoleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by yinhao on 17/12/20.
 */
public class Run {
    public static void main(String[] args) throws Exception{
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().
                build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role = roleMapper.getRole(1);
        System.out.println(role.getRoleName());
    }
}
