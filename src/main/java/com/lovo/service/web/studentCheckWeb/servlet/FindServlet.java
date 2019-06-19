package com.lovo.service.web.studentCheckWeb.servlet;

import com.lovo.service.mybaits.studentCheck.service.IStudentCheckService;
import com.lovo.service.mybaits.studentCheck.service.impl.StduentCheckServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class FindServlet extends HttpServlet {
    IStudentCheckService service=new StduentCheckServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/plain;charset=UTF-8");
        String studentName=request.getParameter("studentName");
        String checkType=request.getParameter("checkType");
        String checkStartDate=request.getParameter("checkStartDate");
        String checkEndDate=request.getParameter("checkEndDate");
        //获得起始位置
        String  startPage=   request.getParameter("startPage");
        //获得每页显示的行数
        String countPage =request.getParameter("countPage");

        Cookie cookie = new Cookie("studentName", studentName);
        response.addCookie(cookie);
        cookie = new Cookie("checkType", checkType);
        response.addCookie(cookie);
        cookie = new Cookie("checkStartDate", checkStartDate);
        response.addCookie(cookie);
        cookie = new Cookie("checkEndDate", checkEndDate);
        response.addCookie(cookie);

        Map<String,Object> map=new HashMap<>();
        map.put("startPage",Integer.parseInt(startPage));
        map.put("countPage",Integer.parseInt(countPage));
        map.put("studentName", studentName);
        map.put("checkType", checkType);
        map.put("checkStartDate", checkStartDate);
        map.put("checkEndDate", checkEndDate);
        String josn= null;
        try {
            josn = service.findCheckItem(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter pw = response.getWriter();
        pw.write(josn);
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}