package com.mybatis.test;

import com.mybatis.test.domain.Role;
import com.mybatis.test.mapper.RoleMapper;
import com.mybatis.test.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by yinhao on 17/12/20.
 */
public class Run {
    public static void main(String[] args) throws Exception{
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setRoleName("testName");
            role.setNote("testNote");
            int i = roleMapper.insertRole(role);
            roleMapper.deleteRole(i);
            sqlSession.commit();
        }catch (Exception e){
            System.err.println(e.getMessage());
            sqlSession.rollback();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }

    }
}
