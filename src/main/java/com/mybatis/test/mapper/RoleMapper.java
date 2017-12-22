package com.mybatis.test.mapper;

import com.mybatis.test.domain.Role;

/**
 * Created by yinhao on 17/12/20.
 *
 * 先暂时理解为mybatis执行时，会生成一个该接口的代理类
 * 代理类会根据关联了该接口全路径的映射文件（也就是RoleMapper.xml）中定义的sql的id，执行对应方法
 */
public interface RoleMapper {
    public Role getRole(long id);
    public int deleteRole(long id);
    public int insertRole(Role role);

}
