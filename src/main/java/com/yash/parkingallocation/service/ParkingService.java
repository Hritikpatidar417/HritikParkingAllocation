package com.yash.parkingallocation.service;

import com.yash.parkingallocation.daoImpl.ParkingDaoImpl;
import com.yash.parkingallocation.entity.ParkingModel;

import java.util.List;

public class ParkingService {

    private ParkingDaoImpl parkingDao;

    public ParkingService() {
        this.parkingDao = new ParkingDaoImpl();
    }

    public String addParking(String[] parkingTypeList)
    {
        String status=parkingDao.addParking(parkingTypeList);
        return status;
    }

    public String removeParking(int slotId )
    {
        String status=parkingDao.removeParking(slotId);
        return status;
    }

    public ParkingModel getParkingInformation(int parkingId){
        ParkingModel parkingModel=parkingDao.getParkingInformation(parkingId);
        return parkingModel;
    }

    public List<ParkingModel> getAllParkingSlot(){
        List<ParkingModel> parkingModelList=parkingDao.getAllParkingSlot();
        return parkingModelList;
    }

}
