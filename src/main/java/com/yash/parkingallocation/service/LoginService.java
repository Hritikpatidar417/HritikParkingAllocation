package com.yash.parkingallocation.service;

import com.yash.parkingallocation.daoImpl.UserDaoImpl;
import com.yash.parkingallocation.entity.User;

public class LoginService {

    private UserDaoImpl userDao;

    public LoginService() {
        this.userDao=new UserDaoImpl();
    }

    public User validateUser(int userId, String password){
        User user=userDao.validateUser(userId,password);
        return user;
    }

}
