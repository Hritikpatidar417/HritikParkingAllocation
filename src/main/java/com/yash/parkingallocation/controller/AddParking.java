package com.yash.parkingallocation.controller;

import com.yash.parkingallocation.service.ParkingService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/admin/addParking")
public class AddParking extends HttpServlet {

    private ParkingService parkingService;

    public AddParking() {
        this.parkingService = new ParkingService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] parkingTypeList = request.getParameterValues("parkingTypeList");
        String status=parkingService.addParking(parkingTypeList);
        request.getRequestDispatcher("/Status.jsp").forward(request, response);
    }

}
