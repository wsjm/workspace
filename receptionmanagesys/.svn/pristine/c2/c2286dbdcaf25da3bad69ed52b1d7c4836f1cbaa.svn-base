package com.keduo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.keduo.dao.UserDao;
import com.keduo.dao.impl.UserDaoImpl;
import com.keduo.entity.User;
import com.keduo.exception.LoginnameWrongException;
import com.keduo.exception.PasswordWrongException;
import com.keduo.service.iUserService;



public class UserServiceImpl implements iUserService {
	private UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
	
	@Override
	public User login(String loginName, String password)
			throws LoginnameWrongException, PasswordWrongException {
		
		//通过用户名查询到 密码 dao层
//		String pwd = userDao.selectPasswordByLoginname(loginname);
		User user = userDao.queryUserByLoginName(loginName);
		//如果user对象为空， loginname 不存在
		if (user == null) {
			throw  new LoginnameWrongException();
		}
		
		//如果获取到的 密码 和 传入的 password 不匹配  密码错误
		if (!password.trim().equals(user.getPassword())) {
			throw new PasswordWrongException();
		}
		
		//修改最后登录时间
		userDao.updateLastLoginTime(user.getUid());
		
		return user;
	}
	
	
	public boolean changePassword(int uid,String password) {
		int i = userDao.changePassword(uid,password);
		if(i==0) {
			return false;
		}else {
			return true;
		}
		
	}

	

}

