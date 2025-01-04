package com.yash.parkingallocation.dao;

import com.yash.parkingallocation.entity.ParkingModel;
import com.yash.parkingallocation.entity.User;

public interface UserDao {
    public String addUser(int userId, String phoneNo, String name, String password);
    public User validateUser(int userId, String password);
    public User getUserInformation(int userId);
}
