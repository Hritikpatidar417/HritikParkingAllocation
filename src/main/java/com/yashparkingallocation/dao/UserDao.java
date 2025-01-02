package com.yashparkingallocation.dao;

import com.yashparkingallocation.entity.ParkingModel;
import com.yashparkingallocation.entity.User;

public interface UserDao {
    public String addUser(int userId, String name, String password);
    public String addParkingSlot(ParkingModel parkingModel);

    public User validateUser(int userId, String password);
    public User getUserInformation(int userId);
}
