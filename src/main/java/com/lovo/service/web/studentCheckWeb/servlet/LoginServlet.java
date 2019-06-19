package com.lovo.service.web.studentCheckWeb.servlet;
import com.lovo.service.mybaits.studentCheck.dao.IStudentCheckDao;
import com.lovo.service.mybaits.studentCheck.entity.TStudent;
import com.lovo.service.mybaits.studentCheck.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    public String name;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName"); //标签中名字为userName的 value值
        String userPwd = request.getParameter("userPwd");
        SqlSession session=GetSession.creatSession();
        IStudentCheckDao dao=session.getMapper(IStudentCheckDao.class);
//        IStudentCheckDao dao = GetSession.creatSession().getMapper(IStudentCheckDao.class);
        TStudent student = null;
        student = dao.login(userName, userPwd);
        //如果用户存在，就把用户放入到session
        if (null != student) {
            HttpSession httpSession = request.getSession();
            httpSession.setMaxInactiveInterval(60 * 20);
            httpSession.setAttribute("student", student);
            name=student.getStudentName();
            response.sendRedirect("main.html");
        } else {
            //如果用户不存在就重定向到登录界面
            response.sendRedirect("login.html");
        }
    }
}
