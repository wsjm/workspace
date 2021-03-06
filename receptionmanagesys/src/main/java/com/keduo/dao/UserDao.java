package com.keduo.dao;

import com.keduo.entity.User;

public interface UserDao extends BaseDao<User> {
	User queryUserByLoginName(String loginName);
	int updateLastLoginTime(int uid);
	int changePassword(int uid,String password);
}
