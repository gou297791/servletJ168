package com.lovo.servlet.mybaits.test5_;

import com.lovo.service.mybaits.test5_30.db.GetSession;
import com.lovo.service.mybaits.test5_30.entity.UserEntity;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TMybaits {

    @Test
    public  void findListUser(){
        //获得session
       SqlSession session= GetSession.creatSession();
       //SqlSession已经封装了CRUD,我们只需要调用它的方法
       List<UserEntity> list=  session.selectList("user.selectUser3");
        for (UserEntity t:list) {
            System.out.printf(t.getId()+"  "+t.getUserName()+"  "+t.getPass()+"  "+t.getAge());
        }
        session.close();
    }
}
