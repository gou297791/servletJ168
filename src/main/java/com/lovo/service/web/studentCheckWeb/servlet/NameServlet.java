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

public class NameServlet extends HttpServlet {
    public static String name;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//设置请求的编码
        String studentName=request.getParameter("studentName");
        SqlSession session= GetSession.creatSession();
        IStudentCheckDao dao =session.getMapper(IStudentCheckDao.class);
        TStudent student=dao.findStudentByStudentName(studentName);
        PrintWriter pw = response.getWriter();
        if(null==student){
            pw.write("1");
        }
    }
}
