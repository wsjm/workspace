package com.keduo.entity;
//用户的实体类包，用于定义业主，物业人员和系统管理员。
public class user {
	private String userName;
	private String passWord;
	private int status;
	private int userId;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	@Override
	public String toString() {
		return " [userName=" + userName + ", passWord=" + passWord + ", status=" + status + ", userId=" + userId
				+ "]";
	}
	public user(String userName, String passWord, int status, int userId) {

		this.userName = userName;
		this.passWord = passWord;
		this.status = status;
		this.userId = userId;
	}
	public user() {
		
	}
	
	
}
