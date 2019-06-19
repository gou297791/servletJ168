package com.lovo.service.web.testWeb;

import com.lovo.service.mybaits.test6_1.service.IJurisdictionService;
import com.lovo.service.mybaits.test6_1.service.impl.JurisdictionServiceImpl;
import com.lovo.service.web.testWeb.myServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {
    IJurisdictionService jurisdictionService=new JurisdictionServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/plain;charset=UTF-8");
        String jurisdictionStr=jurisdictionService.findJurisdictionByUserName(myServlet.name);
        PrintWriter  pw=  response.getWriter();
        pw.write(jurisdictionStr);
    }
}
