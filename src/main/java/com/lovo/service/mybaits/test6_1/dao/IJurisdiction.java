package com.lovo.service.mybaits.test6_1.dao;

import com.lovo.service.mybaits.test6_1.entity.RoleDTO;
import com.lovo.service.mybaits.test6_1.entity.TJurisdiction;

import java.util.List;

public interface IJurisdiction {
    /**
     * 添加权限
     * @param jurisdiction 权限对象
     */
    public void addJurisdiction(TJurisdiction jurisdiction);
    /**
     * 根据用户查询对应角色的所有权限
     * @param userName 用户姓名
     * @return 对应角色的所有权限对象
     */
    public List<RoleDTO> findJurisdictionByUserName(String userName);
}
