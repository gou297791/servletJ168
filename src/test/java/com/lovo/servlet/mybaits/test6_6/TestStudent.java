package com.lovo.servlet.mybaits.test6_6;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.lovo.service.mybaits.studentCheck.dao.IStudentCheckDao;
//import com.lovo.service.mybaits.studentCheck.entity.TStudent;
//import com.lovo.service.mybaits.studentCheck.service.IStudentCheckService;
//import com.lovo.service.mybaits.studentCheck.service.impl.StduentCheckServiceImpl;
//import com.lovo.service.mybaits.studentCheck.util.GetSession;
//import com.lovo.service.mybaits.test5_30.dao.IStudentDao;
//import com.lovo.service.mybaits.test5_30.dao.StudentSession;
//import com.lovo.service.mybaits.test5_30.dao.StudentSystem;
//import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//
//import java.sql.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

import com.lovo.service.tImg.GetSession;
import com.lovo.service.tImg.IImgDao;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class TestStudent {
    SqlSession session= GetSession.creatSession();

//    IStudentDao dao=session.getMapper(IStudentDao.class);
//    IStudentCheckDao sdao=session.getMapper(IStudentCheckDao.class);
//    IStudentCheckService service=new StduentCheckServiceImpl();
    IImgDao dao=session.getMapper(IImgDao.class);

    @Test
    public void addImg(){
        dao.addImg("1.png");
        session.commit();
    }
//    @Test
//    public void TestsLogin(){
//        StudentSystem s=new StudentSystem();
//        s.setUserName("张三");
//        s.setPass("666");
//        StudentSystem student=dao.login(s);
//        TStudent student=sdao.login("java","lovo");
//        System.out.printf(student.getStudentId()+"   "+student.getUserName()+"   "+student.getUserPwd()+"   "
//                +student.getStudentName());
//        try {
//            Map<String,Object> map=new HashMap<>();
//            map.put("startPage",70);
//            map.put("countPage",10);
//            map.put("studentName", null);
//            map.put("checkType", null);
//            map.put("checkStartDate", null);
//            map.put("checkEndDate", null);
//            String str=service.findCheckItem(map);
//            System.out.printf(""+str);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }


//    @Test
//    public void TestAddStudent(){
//        StudentSystem student=new StudentSystem();
//        student.setUserName("张龙");
//        student.setPass("上上下下");
//        student.setAge(25);
//        student.setGrade(88);
//        dao.insertStudent(student);
//        session.commit();
//    }
//    @Test
//    public void TestLogin(){
////        StudentSystem s=new StudentSystem();
////        s.setUserName("张三");
////        s.setPass("666");
////        StudentSystem student=dao.login(s);
//        StudentSystem student=dao.login("张三","666");
//        System.out.printf(student.getId()+"   "+student.getUserName()+"   "+student.getPass()+"   "
//                    +student.getAge()+"   "+student.getGrade());
//    }
//    @Test
//    public void TestFindStudentByName(){
//        StudentSystem student=dao.findStudentByName("张三");
//        System.out.printf(student.getId()+"   "+student.getUserName()+"   "+student.getPass()+"   "
//                +student.getAge()+"   "+student.getGrade());
//    }
//    @Test
//    public void TestAllStudent(){
//        List<StudentSystem> list=dao.findAllStudent();
//        for (StudentSystem s:list) {
//            System.out.printf(s.getId()+"   "+s.getUserName()+"   "+s.getPass()+"   "
//                    +s.getAge()+"   "+s.getGrade()+"\n");
//        }
//    }


//    //获得session
//    SqlSession session= null;
//    @Before
//    public  void before(){
//        session= StudentSession.creatSession();
//    }
//    @Test
//    public  void insertStudent(){
//        StudentSystem s=new StudentSystem();
//        s.setUserName("王五");
//        s.setPass("baba");
//        s.setAge(18);
//        s.setGrade(100);
//        session.update("student.insertStudent",s);
//        System.out.printf(s.getId()+"");
//        session.commit();//提交事务
//    }
//    @Test
//    public void login(){
//        StudentSystem s=new StudentSystem();
//        s.setUserName("java");
//        s.setPass("lovo");
//        StudentSystem student=session.selectOne("student.login",s);
//        if(null!=student){
//            System.out.printf("欢迎你，登陆成功\n");
//            System.out.printf(student.getId()+"   "+student.getUserName()+"   "+student.getPass()+"   "
//                    +student.getAge()+"   "+student.getGrade());
//        }else{
//            System.out.printf("账号或密码错误，请重新输入");
//        }
//    }
//    @Test
//    public  void findAllStudent(){
//        List<StudentSystem> list=    session.selectList("student.findAllStudent");
//        for (StudentSystem s:list) {
//            System.out.printf(s.getId()+"   "+s.getUserName()+"   "+s.getPass()+"   "
//            +s.getAge()+"   "+s.getGrade()+"\n");
//        }
//    }
//    @Test
//    public  void findStudentByName(){
//
//        StudentSystem s=new StudentSystem();
//        s.setUserName("张");
//        StudentSystem student=  session.selectOne("student.findStudentByName",s);
//        System.out.printf(student.getId()+"   "+student.getUserName()+"   "+student.getPass()+"   "
//                +student.getAge()+"   "+student.getGrade());
//    }
    @After
    public void after(){
        session.close();
    }
}
