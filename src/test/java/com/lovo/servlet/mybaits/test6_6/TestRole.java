package com.lovo.servlet.mybaits.test6_6;

import com.lovo.service.mybaits.test6_1.dao.IJurisdiction;
import com.lovo.service.mybaits.test6_1.dao.IRole;
import com.lovo.service.mybaits.test6_1.dao.IUser;
import com.lovo.service.mybaits.test6_1.entity.*;
import com.lovo.service.mybaits.uml.GetUUID;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;

import java.util.List;

public class TestRole {
    SqlSession session= GetSession.creatSession();
    IRole rDao=session.getMapper(IRole.class);
    IUser uDao=session.getMapper(IUser.class);
    IJurisdiction jDao=session.getMapper(IJurisdiction.class);

    @Test
    public void login(){
        TUser user=uDao.login("张三","123");
        System.out.printf(user.getUName());
    }
    @Test
    public void findUserListByRoleId(){
        List<TUser> list= rDao.findUserListByRoleId("f9a32111586042988df7b79702d9d6a0");
//        for (TUser user:list) {
//            System.out.printf(user.getUName()+"\n");
//        }
        System.out.printf(list.size()+"");
    }
    @Test
    public void findJurisdictionByUserName(){
        List<RoleDTO> dto= jDao.findJurisdictionByUserName("张三");
        System.out.printf(""+dto.size());
    }
    @Test
    public void FindRoleByJurisdictionName(){
        TRole role=rDao.findRoleByJurisdictionName("打野");
        System.out.printf(role.getRId()+"   "+role.getRName());
    }
    @Test
    public void FindRoleByUserName(){
        TRole role=rDao.findRoleByUserName("张三");
        System.out.printf(role.getRId()+"   "+role.getRName());
    }
    @Test
    public void TestAddRole(){
        TRole role=new TRole();
        role.setRId(GetUUID.createUUID());
        role.setRName("劫");
        rDao.addRole(role);
    }

    @Test
    public void TestAddUser(){
        TUser user=new TUser();
        user.setUId(GetUUID.createUUID());
        user.setRId("f9a32111586042988df7b79702d9d6a0");
        user.setUName("赵虎");
        user.setUPwdword("123");
        uDao.addUser(user);
    }
    @Test
    public void TestAddJurisdiction(){
        TJurisdiction jurisdiction=new TJurisdiction();
        jurisdiction.setJId(GetUUID.createUUID());
        jurisdiction.setRId("f9a32111586042988df7b79702d9d6a0");
        jurisdiction.setJName("上路");
        jurisdiction.setJUrl("取款机");
        jDao.addJurisdiction(jurisdiction);
    }
    @After
    public void after(){
        session.commit();
        session.close();
    }
}
