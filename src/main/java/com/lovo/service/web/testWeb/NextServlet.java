package com.lovo.service.web.testWeb;

import com.lovo.service.mybaits.studentCheck.entity.TStudent;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从session 获得用户对象
        Object student = request.getSession().getAttribute("student");
        PrintWriter pw= response.getWriter();
        if(student!=null){
            TStudent s=(TStudent)student;
            pw.write(s.getStudentName());
        }else{
            pw.write("2");
        }
    }
}