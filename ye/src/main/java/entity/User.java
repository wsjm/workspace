package entity;

import java.sql.Date;

import annotation.FieldAnnotation;
import annotation.TableName;
@TableName(TName="user")
public class User {
	@FieldAnnotation(isPK=true,Fname="uid")
    private  int uid;
	@FieldAnnotation(Fname="realname")
    private  String realname;
	@FieldAnnotation(Fname="loginname")
    private String loginname;
	@FieldAnnotation(Fname="password")
    private String password;
	@FieldAnnotation(Fname="sex")
    private  int sex;
	/*@FieldAnnotation(Fname="lastlogintime")
    private String lastlogintime;*/
	@FieldAnnotation(Fname="status")
    private int status;
	@FieldAnnotation(Fname="rid")
	private int rid;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String realname, String loginname, String password, int sex,  int status,
			int rid) {
		super();
		this.uid = uid;
		this.realname = realname;
		this.loginname = loginname;
		this.password = password;
		this.sex = sex;
		
		this.status = status;
		this.rid = rid;
	}
	public User(String realname, String loginname, String password, int sex,  int status,
			int rid) {
		super();
		this.realname = realname;
		this.loginname = loginname;
		this.password = password;
		this.sex = sex;
		
		this.status = status;
		this.rid = rid;
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
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "[uid=" + uid + ", realname=" + realname + ", loginname=" + loginname + ", password=" + password
				+ ", sex=" + sex  + ", status=" + status + ", rid=" + rid + "]"+"\n";
	}

    

}
