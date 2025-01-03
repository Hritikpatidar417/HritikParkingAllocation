package com.yash.parkingallocation.controller;

import com.yash.parkingallocation.daoImpl.ParkingDaoImpl;
import com.yash.parkingallocation.service.ParkingService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/admin/removeParking")
public class RemoveParking extends HttpServlet {

   private ParkingService parkingService;

    public RemoveParking() {
        this.parkingService = new ParkingService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int slotId=Integer.parseInt(request.getParameter("slotId"));
            String status = parkingService.removeParking(slotId);
            response.sendRedirect("/admin/ViewRemoveParkingSlot");
    }
}