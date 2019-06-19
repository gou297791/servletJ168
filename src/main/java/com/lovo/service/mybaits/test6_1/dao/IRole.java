package com.lovo.service.mybaits.test6_1.dao;

import com.lovo.service.mybaits.test6_1.entity.TJurisdiction;
import com.lovo.service.mybaits.test6_1.entity.TRole;
import com.lovo.service.mybaits.test6_1.entity.TUser;

import java.util.List;

/**
 * 角色表实体接口
 */
public interface IRole {
    /**
     * 添加角色
     * @param role 角色对象
     */
    public void addRole(TRole role);
    /**
     * 根据用户名查询所属角色
     * @param userName 用户姓名
     * @return 角色对象
     */
    public TRole findRoleByUserName(String userName);
    /**
     * 根据权限查询所属角色
     * @param jurisdictionName 权限
     * @return 角色对象
     */
    public TRole findRoleByJurisdictionName(String jurisdictionName);
    /**
     * 根据角色Id查询用户集合
     * @param roleId 角色ID
     * @return 角色ID对应的用户集合
     */
    public List<TUser> findUserListByRoleId(String roleId);
}
