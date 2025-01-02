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

@WebServlet("/admin/ViewRemoveParkingSlot")
public class ViewRemoveParkingSlot extends HttpServlet {

    private ParkingDaoImpl parkingDaoImpl=new ParkingDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user"); // Done for user security

        if(user!=null&& user.getRole().equals("admin")) {
            List<ParkingModel> parkingModelList = parkingDaoImpl.getAllParkingSlot();
            request.setAttribute("parking", parkingModelList);
            request.getRequestDispatcher("/admin/RemoveParking.jsp").forward(request, response);

        }else {
            response.sendRedirect("/login");
        }
    }

}
