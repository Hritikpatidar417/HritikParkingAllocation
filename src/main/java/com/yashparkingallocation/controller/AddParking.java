package com.yashparkingallocation.controller;

import com.yashparkingallocation.daoImpl.ParkingDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/admin/addParking")
public class AddParking extends HttpServlet {

    ParkingDaoImpl parkingDaoImpl;

    public AddParking() {
        this.parkingDaoImpl = new ParkingDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] parkingTypeList = request.getParameterValues("parkingTypeList");
        String status=parkingDaoImpl.addParking(parkingTypeList);
        request.getRequestDispatcher("/Status.jsp").forward(request, response);
    }

}
