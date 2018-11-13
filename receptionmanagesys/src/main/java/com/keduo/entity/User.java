package com.keduo.entity;

import java.util.Date;

import com.keduo.annotation.FieldName;
import com.keduo.annotation.TableName;
@TableName(tName = "t_user")
public class User {
	@FieldName(fName="uId",isPrimaryKey=true)
	private int uid;
	@FieldName(fName="uname")
	private String uname;
	@FieldName(fName="password")
	private String password;
	@FieldName(fName="statusId")
	private int statusId;
	private String realname;
	@FieldName(fName="staffId")
	private int staffId;
	@FieldName(fName="rid")
	private int rid;
	private Date lastLoginTime;
	private String role_str;//存放字典查到的角色名
	private String status;//存放字典查到的状态名
	private String staff;//存放字典查到的职位
	private String lastLoginTime_str; //存放最后登陆时间字符串
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String uname, String password, int statusId, String realname, int staffId, int rid,
			String role_str, String status, String staff) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.statusId = statusId;
		this.realname = realname;
		this.staffId = staffId;
		this.rid = rid;
		this.role_str = role_str;
		this.status = status;
		this.staff = staff;
	}
	public User(int uid, String uname, String password, int statusId, String realname, int staffId, int rid) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.statusId = statusId;
		this.realname = realname;
		this.staffId = staffId;
		this.rid = rid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRole_str() {
		return role_str;
	}
	public void setRole_str(String role_str) {
		this.role_str = role_str;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginTime_str() {
		return lastLoginTime_str;
	}
	public void setLastLoginTime_str(String lastLoginTime_str) {
		this.lastLoginTime_str = lastLoginTime_str;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", password=" + password + ", realname=" + realname
				+ ", lastLoginTime=" + lastLoginTime + ", role_str=" + role_str + ", status=" + status + ", staff="
				+ staff + ", lastLoginTime_str=" + lastLoginTime_str + "]";
	}
	
	
	
}
