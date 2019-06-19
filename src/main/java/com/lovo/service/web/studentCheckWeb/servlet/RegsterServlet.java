package com.lovo.service.web.studentCheckWeb.servlet;
import com.lovo.service.mybaits.studentCheck.dao.IStudentCheckDao;
import com.lovo.service.mybaits.studentCheck.entity.TStudent;
import com.lovo.service.mybaits.studentCheck.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegsterServlet extends HttpServlet {
    public static String name;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//设置请求的编码
        String userName=request.getParameter("userName"); //标签中名字为userName的 value值
        String userPwd=request.getParameter("userPwd");
        String trueName=request.getParameter("trueName");

        SqlSession session= GetSession.creatSession();
        IStudentCheckDao dao =session.getMapper(IStudentCheckDao.class);
        TStudent student=new TStudent();
        student.setUserName(userName);
        student.setUserPwd(userPwd);
        student.setStudentName(trueName);
        dao.regster(student);
        session.commit();
        response.sendRedirect("login.html");
    }
}
