package com.yashparkingallocation.controller;


import com.yashparkingallocation.daoImpl.ParkingDaoImpl;
import com.yashparkingallocation.entity.ParkingHistory;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet("/admin/ViewParkingHistory")
public class AdminViewParkingHistory extends HttpServlet {


    private ParkingDaoImpl parkingDaoImpl;


    public AdminViewParkingHistory() {
        this.parkingDaoImpl = new ParkingDaoImpl();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startDateParam = request.getParameter("startDate");
        String endDateParam = request.getParameter("endDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;

        try {
            if (startDateParam != null && !startDateParam.isEmpty()) {
                startDate = dateFormat.parse(startDateParam);
            }
            if (endDateParam != null && !endDateParam.isEmpty()) {
                endDate = dateFormat.parse(endDateParam);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Invalid date format. Please use 'yyyy-MM-dd'.");
        }

        List<ParkingHistory> parkingHistoryList = parkingDaoImpl.viewParkingHistory(startDate, endDate);
        request.setAttribute("parkingHistory", parkingHistoryList);
        request.getRequestDispatcher("/admin/ParkingHistory.jsp").forward(request, response);
    }
}
