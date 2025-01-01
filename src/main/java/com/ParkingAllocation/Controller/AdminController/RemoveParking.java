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
        String[] slotIdListStr = request.getParameterValues("slotIdList");

        // Convert slotId to integers
        int[] slotIdList = new int[slotIdListStr.length];
        for (int i = 0; i < slotIdListStr.length; i++) {
            slotIdList[i] = Integer.parseInt(slotIdListStr[i]);


            String status = parkingDaoImpl.removeParking(slotIdList);

            request.getRequestDispatcher("/Status.jsp").forward(request, response);

        }

    }
}