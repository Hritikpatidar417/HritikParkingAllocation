package com.ParkingAllocation.Controller.AdminController;

import com.ParkingAllocation.DaoImpl.ParkingDaoImpl;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/admin/removeParking")
public class RemoveParking extends HttpServlet {

    ParkingDaoImpl parkingDaoImpl;

    public RemoveParking() {
        this.parkingDaoImpl = new ParkingDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int slotId=Integer.parseInt(request.getParameter("slotId"));
            String status = parkingDaoImpl.removeParking(slotId);
            response.sendRedirect("/admin/ViewRemoveParkingSlot");
    }
}