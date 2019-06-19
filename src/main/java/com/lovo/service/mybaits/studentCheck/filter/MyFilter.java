package com.lovo.service.mybaits.studentCheck.filter;

import com.lovo.service.mybaits.studentCheck.dao.IStudentCheckDao;
import com.lovo.service.mybaits.studentCheck.entity.TStudent;
import com.lovo.service.mybaits.studentCheck.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义过滤器
 */
public class MyFilter implements  Filter {
    String encoding="UTF-8";
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding=filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);

        HttpServletRequest myRequest = (HttpServletRequest) request;
        String myUri=myRequest.getRequestURI();
        Object student = myRequest.getSession().getAttribute("student");


        if("/servletJ168_war/mainServlet.lovo".equals(myUri)&&null == student){
            request.getRequestDispatcher("next.html").forward(request,response);
        }else if("/servletJ168_war/main2Servlet.lovo".equals(myUri)&&null == student){
            request.getRequestDispatcher("regster.html").forward(request,response);
        }else if("/servletJ168_war/main3Servlet.lovo".equals(myUri)&&null == student){
            request.getRequestDispatcher("addCheck.html").forward(request,response);
        }else {
            //把request和response交给下一个过滤器，如果没有过滤器就交给servlet
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
