package com.ParkingAllocation.Dao;

import com.ParkingAllocation.Entity.ParkingHistory;
import com.ParkingAllocation.Entity.ParkingModel;

import java.util.Date;
import java.util.List;

public interface ParkingDao {
    public String addParking(String[] parkingTypeList);
    public String removeParking(int[] SlotIdList);
    public ParkingModel getParkingInformation(int parkingId);
    public String checkIn(int userId,int parkingSlot,String vehicleNo);
    public String checkOut(int parkingId);
    public List<ParkingHistory> viewParkingHistory(Date startDate, Date endDate);
    public List<ParkingModel> getAllParkingSlot();
}
