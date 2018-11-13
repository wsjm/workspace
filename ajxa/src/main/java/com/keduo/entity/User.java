package com.keduo.entity;


import java.util.Date;

public class User {
	// ID
	private int uid;
	// 真实姓名
	private String realname;
	// 登录名
	private String loginname;
	// 密码
	private String password;
	// 性别
	private int sex;
	// 最后登录日期
	private Date lastlogintime;
	// 状态
	private int status;
	// 角色組id
	private int rid;

	// 存放字典表查询出来的性别字符串
	private String sex_str;
	// 查询role表中的 角色的名字
	private String role_str;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String realname, String loginname, String password) {
		super();
		this.realname = realname;
		this.loginname = loginname;
		this.password = password;
	}

	public User(String realname, String loginname, String password, int sex) {
		super();
		this.realname = realname;
		this.loginname = loginname;
		this.password = password;
		this.sex = sex;
	}

	public User(int uid, String realname, String loginname, String password, int sex, int status) {
		super();
		this.uid = uid;
		this.realname = realname;
		this.loginname = loginname;
		this.password = password;
		this.sex = sex;
		this.status = status;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSex_str() {
		return sex_str;
	}

	public void setSex_str(String sex_str) {
		this.sex_str = sex_str;
	}

	public String getRole_str() {
		return role_str;
	}

	public void setRole_str(String role_str) {
		this.role_str = role_str;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", realname=" + realname + ", loginname=" + loginname + ", password=" + password
				+ ", sex=" + sex + ", lastlogintime=" + lastlogintime + ", status=" + status + ", rid=" + rid
				+ ", sex_str=" + sex_str + ", role_str=" + role_str + "]";
	}

}
