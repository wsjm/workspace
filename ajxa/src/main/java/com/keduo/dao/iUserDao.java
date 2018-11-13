package com.keduo.dao;

import java.util.List;

import com.keduo.entity.User;



public interface iUserDao extends iPageBaseDao<User>{
	
	/**
	 * 	通过用户名获取密码
	 * @param loginname 用户名
	 * @return User 返回对象，如果不存在则返回 null  User（uid  password  loginname）
	 */
	public User selectPasswordByLoginname(String loginname);
	
	/**
	 * 根据uid修改最后登录时间
	 * @param uid
	 * @return 受影响行数
	 */
	public int updateLastLogintimeByUid(int uid);
	
	/**
	 * 新增用户
	 * @param user
	 * @return 受影响行数 （  0  没有新增成功    大于0  新增成功 ）
	 */
	public int insert(User user);
	
	/**
	 * 通过用户名查询ID
	 * @param loginname
	 * @return 用户id （如果不存在， id = 0 ，如果存在  id >0 ）
	 */
	public int selectIdByLoginname(String loginname);
	
	/**
	 * 通过uid删除用户（没有真正删除数据，只是修改了状态）
	 * @param uid
	 * @return 受影响行数 （  0  没有删除成功    大于0  删除成功 ）
	 */
	public int deleteByUid(int uid);
	
	/**
	 * 通过uid查询指定用户
	 * @param uid
	 * @return 如果用户不存在，返回 null  如果存在 返回 User 对象
	 */
	public User selectUserByUid(int uid);
	
	
	/**
	 * 通过uid修改用户
	 * @param uid
	 * @return 受影响行数 （  0  没有修改成功    大于0  修改成功 ）
	 */
	public int updateUserByUid(User user);
	
}