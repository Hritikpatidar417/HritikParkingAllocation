package com.yashparkingallocation.controller;

import com.yashparkingallocation.daoImpl.ParkingDaoImpl;
import com.yashparkingallocation.entity.ParkingModel;
import com.yashparkingallocation.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/dashboard")
public class Dashboard extends HttpServlet {

    private ParkingDaoImpl parkingDaoImpl;

    public Dashboard() {
        this.parkingDaoImpl = new ParkingDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user"); // Done for user security

        if(user!=null) {
            List<ParkingModel> parkingModelList = parkingDaoImpl.getAllParkingSlot();
            request.setAttribute("parking", parkingModelList);
            request.getRequestDispatcher("/user/Dashboard.jsp").forward(request, response);

        }else {
            response.sendRedirect("/login");
        }
    }

}
