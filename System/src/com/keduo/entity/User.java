package com.keduo.entity;



import java.util.Date;

import com.keduo.annotation.Column;
import com.keduo.annotation.Table;
@Table(name="user")
public class User {
	@Column(cname="uId", isPk=true)
	private int uid;
	@Column(cname="realname")
	private String realname;
	@Column(cname="loginname")
	private String loginname;
	@Column(cname="password")
	private String password;
	@Column(cname="sex")
	private int sex;
	@Column(cname="lastlogintime")
	private String lastlogintime;
	@Column(cname="status")
	private int status;
	@Column(cname="rid")
	private int rid;

	public User() {
		super();
		
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

	public User( String realname, String loginname, String password, int sex, int status) {
		super();
		
		this.realname = realname;
		this.loginname = loginname;
		this.password = password;
		this.sex = sex;
		this.status = status;
	}

	public User(String realname, String loginname, String password, int sex, String lastlogintime, int status) {
		super();
		this.realname = realname;
		this.loginname = loginname;
		this.password = password;
		this.sex = sex;
		this.lastlogintime = lastlogintime;
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

	public String getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", realname=" + realname + ", loginname=" + loginname + ", password=" + password
				+ ", sex=" + sex + ", lastlogintime=" + lastlogintime + ", status=" + status + ", rid=" + rid+"]";
	}

}
