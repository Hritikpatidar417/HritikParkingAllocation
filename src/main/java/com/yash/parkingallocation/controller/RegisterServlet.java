package com.yash.parkingallocation.controller;

import com.yash.parkingallocation.daoImpl.UserDaoImpl;
import com.yash.parkingallocation.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private RegisterService registerService;

    public RegisterServlet() {
        this.registerService = new RegisterService();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // request data from register page
        int userId = Integer.parseInt(request.getParameter("userId"));
        String mobileNo = request.getParameter("mobileNo");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        // Add user using service and dao
        String status = registerService.addUser(userId, mobileNo, userName, password);


        // Check if registration was successful
        if ("success".equalsIgnoreCase(status)) {
            request.setAttribute("registrationStatus", "Registration successful! Please log in.");
        } else {
            request.setAttribute("registrationStatus", "Registration failed! Please try again.");
        }


        // Forward to Login.jsp with massage success or failed
        request.getRequestDispatcher("/Login.jsp").forward(request, response);
    }



}