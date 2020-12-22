package com.briup.web;

import com.briup.bean.Customer;
import com.briup.exception.CustomerException;
import com.briup.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 该Servlet完成注册功能*/
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //1,接收注册数据并封装成Customer对象
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String zipCode = request.getParameter("zipCode");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        Customer customer=new Customer(name,password,zipCode,address,telephone,email);
        //2,调用service层的方法
        CustomerServiceImpl service = new CustomerServiceImpl();
        try {
            service.register(customer);
            //注册成功
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        } catch (CustomerException e) {
            e.printStackTrace();
            //注册失败,跳转到注册界面
            request.setAttribute("registererror",e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }
}
