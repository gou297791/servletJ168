package com.lovo.service.web.testWeb;

import com.lovo.service.mybaits.test6_1.dao.IUser;
import com.lovo.service.mybaits.test6_1.entity.GetSession;
import com.lovo.service.mybaits.test6_1.entity.TUser;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class myServlet extends HttpServlet {
    public static String name;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//设置请求的编码
        String userName=    request.getParameter("userName"); //标签中名字为userName的 value值
        String password=request.getParameter("password");

        SqlSession session= GetSession.creatSession();
        IUser uDao=session.getMapper(IUser.class);
        TUser u=null;
        u=uDao.login(userName,password);
        session.close();
        //设置返回的编码
//        response.setCharacterEncoding("GBK");
        //为浏览器设置编码
        response.setHeader("Content-type","text/html;charset=UTF-8");
        PrintWriter pw= response.getWriter();
        if(null!=u) {
            name=userName;
            response.sendRedirect("jurisdictionTable.html");
        }else{
            response.sendRedirect("logintest6_6.html");
        }
        pw.close();
    }
}
