package com.keduo.service;

import java.util.List;
import java.util.Map;

import com.keduo.entity.User;




public interface iUserSrevice extends iPageBaseService , iBaseService<User>{
	
	/**
	 * 	登录
	 * @param loginname 用户名
	 * @param password 密码
	 * @return 登录状态  成功为 true
	 * @throws LoginnameIsNullException 用户名为空
	 * @throws LoginnameWrongException  用户名错误
	 * @throws PasswordIsNullException  密码为空
	 * @throws PasswordWrongException  密码错误
	 */
	public Map<String, Object> login(String loginname , String password) throws Exception;

	/**
	 * 新增用户
	 * @param user
	 * @return 新增 成功 true  失败 false
	 */
	public boolean addUser(User user);
	
	/**
	 * 判断用户是否存在
	 * @param loginname
	 * @return 存在 true  不存在  false
	 */
	public boolean existLoginname(String loginname);
	
	/**
	 * 查询所有用户 
	 * @return List<User > 集合，如果没有内容，返回集合对象长度为 0 
	 */
	public List<User> findAllUsers();
	
}

