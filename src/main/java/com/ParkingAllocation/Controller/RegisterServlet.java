package com.ParkingAllocation.Controller;

import com.ParkingAllocation.Entity.User;
import com.ParkingAllocation.JDBCUtils.JdbcUtils;
import com.ParkingAllocation.DaoImpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserDaoImpl userDaoImpl;

    public RegisterServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userId=Integer.parseInt(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String role = request.getParameter("role");
        String password = request.getParameter("password");

        String status = userDaoImpl.addUser(userId,userName,role,password);
        request.setAttribute("registrationStatus", status);
        request.getRequestDispatcher("/Login.jsp").forward(request, response);
    }


}