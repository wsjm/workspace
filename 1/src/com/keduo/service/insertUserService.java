package com.keduo.service;

import com.keduo.dao.userDao;

public class insertUserService {
	public static void insertUser(String userId,String password, String age, String sex) {
		// TODO Auto-generated method stub
		userDao.insertUser(userId, password, age, sex);
	}
}
