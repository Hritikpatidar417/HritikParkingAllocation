package com.yash.parkingallocation.service;

import com.yash.parkingallocation.daoImpl.UserDaoImpl;
import com.yash.parkingallocation.entity.User;

public class RegisterService {

    private UserDaoImpl userDao;

    public RegisterService() {
        this.userDao=new UserDaoImpl();
    }

    public String addUser(int userId, String phoneNo, String name, String password)
    {
        String status=userDao.addUser(userId,phoneNo,name,password);
        return status;
    }
}
