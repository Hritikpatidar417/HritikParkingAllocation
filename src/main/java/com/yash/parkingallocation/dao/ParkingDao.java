package com.yash.parkingallocation.dao;

import com.yash.parkingallocation.entity.ParkingHistory;
import com.yash.parkingallocation.entity.ParkingModel;

import java.util.Date;
import java.util.List;

public interface ParkingDao {
    public String addParking(String[] parkingTypeList);
    public String removeParking(int SlotId);
    public ParkingModel getParkingInformation(int parkingId);
    public String checkIn(int userId,int parkingSlot,String vehicleNo);
    public String checkOut(int parkingId);
    public List<ParkingHistory> viewParkingHistory(Date startDate, Date endDate);
    public List<ParkingHistory> viewAllParkingHistory();
    public List<ParkingHistory> viewAllUserParkingHistory(int employeeId);
    public List<ParkingModel> getAllParkingSlot();
}
