package com.ParkingAllocation.Dao;

import com.ParkingAllocation.Entity.ParkingModel;
import com.ParkingAllocation.Entity.User;

public interface UserDao {
    public String addUser(int userId, String name,String role, String password);
    public String addParkingSlot(ParkingModel parkingModel);
    public User validateUser(int userId, String password);
    public User getUserInformation(int userId);
}
