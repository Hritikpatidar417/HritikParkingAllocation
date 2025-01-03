package com.yash.parkingallocation.controller;


import com.yash.parkingallocation.entity.ParkingHistory;
import com.yash.parkingallocation.entity.User;
import com.yash.parkingallocation.service.ParkingHistoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/user/ViewParkingHistory")
public class ViewParkingHistory extends HttpServlet {


    private ParkingHistoryService parkingHistoryService;


    public ViewParkingHistory() {
        this.parkingHistoryService = new ParkingHistoryService();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            User user = (User) request.getSession().getAttribute("user");
            if(user!=null)
            {
                List<ParkingHistory> parkingHistoryList=parkingHistoryService.viewAllUserParkingHistory(user.getUserId());
                request.setAttribute("parkingHistory", parkingHistoryList);
                request.getRequestDispatcher("/user/ParkingHistory.jsp").forward(request, response);
            }else {
                response.sendRedirect("/Login.jsp");
            }
    }
}
