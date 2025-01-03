package com.yash.parkingallocation.service;

import com.yash.parkingallocation.daoImpl.ParkingDaoImpl;
import com.yash.parkingallocation.entity.ParkingHistory;

import java.util.Date;
import java.util.List;

public class ParkingHistoryService {

    private ParkingDaoImpl parkingDao;

    public ParkingHistoryService() {
        this.parkingDao=new ParkingDaoImpl();
    }

    public List<ParkingHistory> viewParkingHistory(Date startDate, Date endDate){
        List<ParkingHistory> parkingHistoryList=parkingDao.viewParkingHistory(startDate,endDate);
        return parkingHistoryList;
    }

    public List<ParkingHistory> viewAllParkingHistory(){
        List<ParkingHistory> parkingHistoryList=parkingDao.viewAllParkingHistory();
        return parkingHistoryList;
    }

    public List<ParkingHistory> viewAllUserParkingHistory(int employeeId)
    {
        List<ParkingHistory> parkingHistoryList=parkingDao.viewAllUserParkingHistory(employeeId);
        return parkingHistoryList;
    }

}
