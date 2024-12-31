package com.ParkingAllocation.Controller.AdminController;

import com.ParkingAllocation.DaoImpl.ParkingDaoImpl;
import com.ParkingAllocation.Entity.ParkingModel;
import com.ParkingAllocation.Entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

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
        if ("success".equalsIgnoreCase(status)) {
            request.setAttribute("registrationStatus", "Registration successful! Please log in.");
        } else {
            request.setAttribute("registrationStatus", "Registration failed! Please try again.");
        }

//        RequestDispatcher rd=request.getRequestDispatcher("/Admin/Dashboard.jsp");
//        rd.forward(request,response);




        request.getRequestDispatcher("/Status.jsp").forward(request, response);

    }

}
