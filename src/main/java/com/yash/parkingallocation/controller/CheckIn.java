package com.yash.parkingallocation.controller;

import com.yash.parkingallocation.daoImpl.ParkingDaoImpl;
import com.yash.parkingallocation.entity.User;
import com.yash.parkingallocation.service.CheckInService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/user/checkIn")
public class CheckIn extends HttpServlet {


    private CheckInService checkInService;

    public CheckIn() {
        this.checkInService = new CheckInService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Parking controller");
        String vehicleNo=request.getParameter("vehicleNo");
        int parkingId=Integer.parseInt(request.getParameter("parkingId"));

        User user = (User) request.getSession().getAttribute("user");

        if (user != null) {
            try {
                String status=checkInService.checkIn(user.getUserId(),parkingId,vehicleNo);
                request.setAttribute("status",status);
                response.sendRedirect("/user/dashboard");

            } catch (Exception e) {
                throw new RuntimeException(e);

            }
        } else {
            response.sendRedirect("/Login.jsp");
        }
    }
}

