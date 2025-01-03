package com.yash.parkingallocation.controller;


import com.yash.parkingallocation.daoImpl.ParkingDaoImpl;
import com.yash.parkingallocation.entity.ParkingHistory;
import com.yash.parkingallocation.service.ParkingHistoryService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebServlet("/admin/ViewParkingHistory")
public class AdminViewParkingHistory extends HttpServlet {


    private ParkingHistoryService parkingHistoryService;


    public AdminViewParkingHistory() {
        this.parkingHistoryService = new ParkingHistoryService();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ParkingHistory> parkingHistoryList=new ArrayList<>();
        String startDateParam = request.getParameter("startDate");
        String endDateParam = request.getParameter("endDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;


        try {
            if ((startDateParam != null && !startDateParam.isEmpty()) && ((endDateParam != null && !endDateParam.isEmpty())))
            {
                startDate = dateFormat.parse(startDateParam);
                endDate = dateFormat.parse(endDateParam);
                 parkingHistoryList = parkingHistoryService.viewParkingHistory(startDate, endDate);
                request.setAttribute("parkingHistory", parkingHistoryList);
                request.getRequestDispatcher("/admin/ParkingHistory.jsp").forward(request, response);
            }else{
                parkingHistoryList=parkingHistoryService.viewAllParkingHistory();
            }


        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Invalid date format. Please use 'yyyy-MM-dd'.");
        }finally {
            request.setAttribute("parkingHistory", parkingHistoryList);
            request.getRequestDispatcher("/admin/ParkingHistory.jsp").forward(request, response);
        }


    }
}
