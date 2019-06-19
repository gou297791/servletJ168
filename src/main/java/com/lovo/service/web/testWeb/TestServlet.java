package com.lovo.service.web.testWeb;

import com.lovo.service.mybaits.test6_1.service.IJurisdictionService;
import com.lovo.service.mybaits.test6_1.service.impl.JurisdictionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.getRequestDispatcher("updateUser.jsp").forward(request,response);
//        request.getRequestDispatcher("addInsectPest.jsp").forward(request,response);
//        request.getRequestDispatcher("insectPest.jsp").forward(request,response);
//        request.getRequestDispatcher("insectPestMessage.jsp").forward(request,response);
    }
}
