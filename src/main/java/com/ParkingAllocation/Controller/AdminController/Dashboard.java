package com.ParkingAllocation.Controller.AdminController;

import com.ParkingAllocation.DaoImpl.ParkingDaoImpl;
import com.ParkingAllocation.Entity.ParkingModel;
import com.ParkingAllocation.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/dashboard")
public class Dashboard extends HttpServlet {

    private ParkingDaoImpl parkingDaoImpl;

    public Dashboard() {
        this.parkingDaoImpl = new ParkingDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        if(user!=null) {
            List<ParkingModel> parkingModelList = parkingDaoImpl.getAllParkingSlot();
            request.setAttribute("parking", parkingModelList);
            request.getRequestDispatcher("/Admin/Dashboard.jsp").forward(request, response);

        }else {
            response.sendRedirect("/login");
        }
    }

}
