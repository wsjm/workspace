package com.keduo.service;


import com.keduo.entity.User;
import com.keduo.exception.LoginnameWrongException;
import com.keduo.exception.PasswordWrongException;


public interface iUserService {
	
	/**
	 * 	登录
	 * @param loginname 用户名
	 * @param password 密码
	 * @return 登录状态  成功为 true
	 * @throws LoginnameWrongException  用户名错误
	 * @throws PasswordWrongException  密码错误
	 */
	public User login(String loginname , String password) throws LoginnameWrongException , PasswordWrongException;

	
}

