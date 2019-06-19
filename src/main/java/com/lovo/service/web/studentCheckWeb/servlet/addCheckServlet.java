package com.lovo.service.web.studentCheckWeb.servlet;

import com.lovo.service.mybaits.studentCheck.dao.IStudentCheckDao;
import com.lovo.service.mybaits.studentCheck.entity.TCheck;
import com.lovo.service.mybaits.studentCheck.entity.TStudent;
import com.lovo.service.mybaits.studentCheck.util.GetSession;
import com.lovo.service.web.studentCheckWeb.servlet.LoginServlet;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

public class addCheckServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");//设置请求的编码
        String studentName=request.getParameter("studentName");
        String checkType=request.getParameter("checkType");
        String checkStatus=request.getParameter("checkStatus");

        SqlSession session= GetSession.creatSession();
        IStudentCheckDao dao =session.getMapper(IStudentCheckDao.class);
        //判断用户是否存在，如果不存在返回到注册页面，如果存在把用户对象放入到录入信息对象
        TStudent student= dao.findStudentByStudentName(studentName);
        //用户考勤对象
        TCheck info=null;
        if(null!=student){
            //用户存在
            info=new TCheck();
            info.setStudent(student);//把学生对象放入到考勤对象
            info.setCheckType(checkType);
            info.setCheckStatus(checkStatus);
            info.setCheckDate(new Date(System.currentTimeMillis()));
            LoginServlet servlet=new LoginServlet();
            info.setCheckPerson(servlet.name);
            //保持考勤
            dao.addCheck(info);
            session.commit();
//            response.sendRedirect("message.html");
            request.getRequestDispatcher("message.html").forward(request,response);
        }
    }
}
