package com.yashparkingallocation.controller;


import com.yashparkingallocation.daoImpl.ParkingDaoImpl;
import com.yashparkingallocation.entity.ParkingHistory;
import com.yashparkingallocation.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/user/ViewParkingHistory")
public class ViewParkingHistory extends HttpServlet {


    private ParkingDaoImpl parkingDaoImpl;


    public ViewParkingHistory() {
        this.parkingDaoImpl = new ParkingDaoImpl();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            User user = (User) request.getSession().getAttribute("user");
            if(user!=null)
            {
                List<ParkingHistory> parkingHistoryList=parkingDaoImpl.viewAllParkingHistory(user.getUserId());
                request.setAttribute("parkingHistory", parkingHistoryList);
                request.getRequestDispatcher("/User/ParkingHistory.jsp").forward(request, response);
            }else {
                response.sendRedirect("/login");
            }
    }
}
