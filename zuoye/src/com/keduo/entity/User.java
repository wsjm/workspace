package com.keduo.entity;

import annotation.Annotation;
import annotation.Table;

@Table(tname="user")
public class User {
	
	static int Id = 1001;
	@Annotation(cname="userId",isPk=true)
	private int userId;
	@Annotation(cname="username")
	private String username;
	@Annotation(cname="password")
	private String password;
	private int Status;//权限  权限为1则为业主，权限为2是物业人员，权限为3是系统管理员（默认boss,密码123456））
	{
		this.userId = Id;
		userId++;
	}
	public User(String username, String password, int status) {
		super();
		this.username = username;
		this.password = password;
		this.Status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		this.Status = status;
	}
	@Override
	public String toString() {
		return "[userId=" + userId + ", username=" + username + ", password=" + password + ", Status=" + Status
				+ "]";
	}
	
}
