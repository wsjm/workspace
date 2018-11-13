package com.keduo.service;

import com.keduo.dao.UserDao;
import com.keduo.user.User;


import java.sql.SQLException;
import java.util.List;

public class UserService {

    public List<User> findUserAll(String name){
        UserDao userDao=new UserDao();
        List<User> userList=null;
        try {
            userList=userDao.findUserAll(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
}
