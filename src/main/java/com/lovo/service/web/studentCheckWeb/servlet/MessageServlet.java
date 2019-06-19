package com.lovo.service.web.studentCheckWeb.servlet;

import com.lovo.service.mybaits.studentCheck.service.IStudentCheckService;
import com.lovo.service.mybaits.studentCheck.service.impl.StduentCheckServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
public class MessageServlet extends HttpServlet {
    IStudentCheckService service=new StduentCheckServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/plain;charset=UTF-8");

        String studentName=null;
        String checkType=null;
        String checkStartDate=null;
        String checkEndDate=null;
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if ("studentName".equals(c.getName())) {
                studentName = c.getValue();
            }
            if ("checkType".equals(c.getName())) {
                checkType = c.getValue();
            }
            if ("checkStartDate".equals(c.getName())) {
                checkStartDate = c.getValue();
            }
            if ("checkEndDate".equals(c.getName())) {
                checkEndDate = c.getValue();
            }
        }
        //获得起始位置
        String  startPage=   request.getParameter("startPage");
        //获得每页显示的行数
        String countPage =request.getParameter("countPage");

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

//    IStudentCheckService service=new StduentCheckServiceImpl();
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doGet(request,response);
//    }
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setHeader("Content-type", "text/plain;charset=UTF-8");
//        String studentName=request.getParameter("studentName");
//        String checkType=request.getParameter("checkType");
//        String checkStartDate=request.getParameter("checkStartDate");
//        String checkEndDate=request.getParameter("checkEndDate");
////        System.out.printf(studentName+"   "+checkType+"   ");
//        Date startDate=null;
//        Date endDate=null;
//        if(checkStartDate!=null&&checkStartDate!=""){
////            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            startDate=Date.valueOf(checkStartDate);
//        }
//        if(checkEndDate!=null&&checkEndDate!=""){
//            endDate=Date.valueOf(checkEndDate);
//        }
//        String checkStr=service.findCheckItem(studentName,checkType,startDate, endDate);
//        PrintWriter  pw=  response.getWriter();
//        pw.write(checkStr);
//        pw.close();
//    }
//}
