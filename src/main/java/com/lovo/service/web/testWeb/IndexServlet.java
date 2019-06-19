package com.lovo.service.web.testWeb;

import com.lovo.service.mybaits.studentCheck.dao.IStudentCheckDao;
import com.lovo.service.mybaits.studentCheck.entity.TStudent;
import com.lovo.service.mybaits.studentCheck.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter pw= response.getWriter();
//        Object stu = request.getSession().getAttribute("student");
//        if(null!=stu){
//            pw.write("1");
//        }else {
            String userName = request.getParameter("userName"); //标签中名字为userName的 value值
            String userPwd = request.getParameter("userPwd");
//            String remember = request.getParameter("remember");
            IStudentCheckDao dao = GetSession.creatSession().getMapper(IStudentCheckDao.class);
            TStudent student = null;
            student = dao.login(userName, userPwd);
            //如果用户存在，就把用户放入到session
            if (null != student) {
                HttpSession httpSession = request.getSession();
                httpSession.setMaxInactiveInterval(60 * 20);
//              if ("1".equals(remember)) {
//              Cookie cookie = new Cookie("myUserObj", student.getStudentName());
//              cookie.setMaxAge(60 * 60);
//              response.addCookie(cookie);
                httpSession.setAttribute("student", student);
                response.sendRedirect("next.html");
//                pw.write("2");
//////                }
            } else {
                //如果用户不存在就重定向到登录界面
                response.sendRedirect("index.html");
            }
        }
//    }
}
