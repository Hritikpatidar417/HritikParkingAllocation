package com.yash.parkingallocation.controller;

import com.yash.parkingallocation.entity.User;
import com.yash.parkingallocation.daoImpl.UserDaoImpl;
import com.yash.parkingallocation.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginValidationServlet")
public class LoginServlet extends HttpServlet {

    private LoginService loginService;

    public LoginServlet() {
        this.loginService=new LoginService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Validate Login");
        int userId = Integer.parseInt(request.getParameter("userId"));
        String password = request.getParameter("password");
        User user = loginService.validateUser(userId, password);

         //Validate User
        if (user != null && user.getRole().equals("user") ) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/user/dashboard");
        }else if ( user != null && user.getRole().equals("admin") ) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/admin/dashboard");
        } else {
            response.sendRedirect("/Login.jsp");
        }
    }
}
