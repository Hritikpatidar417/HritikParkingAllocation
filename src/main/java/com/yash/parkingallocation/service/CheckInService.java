package com.yash.parkingallocation.service;

import com.yash.parkingallocation.daoImpl.ParkingDaoImpl;

public class CheckInService {

    private ParkingDaoImpl parkingDao;

    public CheckInService() {
        this.parkingDao = new ParkingDaoImpl();
    }

    public String checkIn(int userId, int parkingSlot, String vehicleNo){
        String status=parkingDao.checkIn(userId,parkingSlot,vehicleNo);
        return status;
    }
}
