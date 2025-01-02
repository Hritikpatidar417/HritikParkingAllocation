package com.yashparkingallocation.dao;

import com.yashparkingallocation.entity.ParkingHistory;
import com.yashparkingallocation.entity.ParkingModel;

import java.util.Date;
import java.util.List;

public interface ParkingDao {
    public String addParking(String[] parkingTypeList);
    public String removeParking(int SlotId);
    public ParkingModel getParkingInformation(int parkingId);
    public String checkIn(int userId,int parkingSlot,String vehicleNo);
    public String checkOut(int parkingId);
    public List<ParkingHistory> viewParkingHistory(Date startDate, Date endDate);
    public List<ParkingModel> getAllParkingSlot();
}
