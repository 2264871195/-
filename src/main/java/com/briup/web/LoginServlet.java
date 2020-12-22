package com.briup.web;

import com.briup.exception.CustomerException;
import com.briup.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //1,获取到用户名和密码
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        //调用service层的方法
        CustomerServiceImpl service = new CustomerServiceImpl();
        try {
            service.login(name,password);
            //登录成功,跳转到信息跳转到index.html
            request.setAttribute("name",name);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        } catch (CustomerException e) {
            e.printStackTrace();
            //登录失败跳转到登录界面
            request.setAttribute("loginerror",e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
