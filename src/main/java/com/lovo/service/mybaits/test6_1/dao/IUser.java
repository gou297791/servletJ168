package com.lovo.service.mybaits.test6_1.dao;

import com.lovo.service.mybaits.test6_1.entity.TUser;

import java.util.List;

public interface IUser {
    /**
     * 添加用户
     * @param user 用户对象
     */
    public void addUser(TUser user);

    /**
     * 登录
     * @param userName 用户名
     * @param password 密码
     * @return 用户信息，登录失败则返回null
     */
    public TUser login(String userName,String password);
}
