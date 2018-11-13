package com.keduo.entity;

import annotation.Annotation;
import annotation.Table;
@Table(tname="owner")
public class owner{
	@Annotation(cname="ownerId",isPk=true)
	private int ownerId;
	@Annotation(cname="ownerName")
	private String ownerName;
	@Annotation(cname="ownerSex")
	private String ownerSex;
	@Annotation(cname="ownerAge")
	private int ownerAge;
	@Annotation(cname="ownerTel")
	private String ownerTel;
	@Annotation(cname="ownerPhone")
	private String ownerPhone;
	@Annotation(cname="ownerAddr")
	private String ownerAddr;
	
	public owner(int ownerId, String ownerName, String ownerSex, int ownerAge, String ownerTel, String ownerPhone,
			String ownerAddr) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownerSex = ownerSex;
		this.ownerAge = ownerAge;
		this.ownerTel = ownerTel;
		this.ownerPhone = ownerPhone;
		this.ownerAddr = ownerAddr;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerSex() {
		return ownerSex;
	}
	public void setOwnerSex(String ownerSex) {
		this.ownerSex = ownerSex;
	}
	public int getOwnerAge() {
		return ownerAge;
	}
	public void setOwnerAge(int ownerAge) {
		this.ownerAge = ownerAge;
	}
	public String getOwnerTel() {
		return ownerTel;
	}
	public void setOwnerTel(String ownerTel) {
		this.ownerTel = ownerTel;
	}
	public String getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public String getOwnerAddr() {
		return ownerAddr;
	}
	public void setOwnerAddr(String ownerAddr) {
		this.ownerAddr = ownerAddr;
	}
	@Override
	public String toString() {
		return "[ownerId=" + ownerId + ", ownerName=" + ownerName + ", ownerSex=" + ownerSex + ", ownerAge="
				+ ownerAge + ", ownerTel=" + ownerTel + ", ownerPhone=" + ownerPhone + ", ownerAddr=" + ownerAddr + "]";
	}
}
