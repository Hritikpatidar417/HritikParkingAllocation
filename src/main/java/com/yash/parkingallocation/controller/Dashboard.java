package com.yash.parkingallocation.controller;

import com.yash.parkingallocation.daoImpl.ParkingDaoImpl;
import com.yash.parkingallocation.entity.ParkingModel;
import com.yash.parkingallocation.entity.User;
import com.yash.parkingallocation.service.ParkingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/dashboard")
public class Dashboard extends HttpServlet {

    private ParkingService parkingService;

    public Dashboard() {
        this.parkingService = new ParkingService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user"); // Done for user security

        if(user!=null) {
            List<ParkingModel> parkingModelList = parkingService.getAllParkingSlot();
            request.setAttribute("parking", parkingModelList);
            request.getRequestDispatcher("/user/Dashboard.jsp").forward(request, response);

        }else {
            response.sendRedirect("/Login.jsp");
        }
    }

}
