package com.yash.parkingallocation.service;

import com.yash.parkingallocation.daoImpl.ParkingDaoImpl;

public class CheckOutService {

    private ParkingDaoImpl parkingDao;

    public CheckOutService() {
        this.parkingDao = new ParkingDaoImpl();
    }

    public String checkOut(int parkingId){
        String status=parkingDao.checkOut(parkingId);
        return status;
    }


}
