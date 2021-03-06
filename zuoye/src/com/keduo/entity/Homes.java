package com.keduo.entity;

import annotation.Annotation;
import annotation.Table;
@Table(tname="homes")
public class Homes {
	@Annotation(cname="homesId" ,isPk=true)
	private int homesId;
	@Annotation(cname="homes_address")
	private String homes_address;
	@Annotation(cname="homes_type")
	private String homes_type;
	@Annotation(cname="homes_area")
	private int homes_area;
	@Annotation(cname="homes_ownerId")
	private int homes_ownerId;
	public Homes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Homes(int homesId, String homes_address, String homes_type, int homes_area, int homes_ownerId) {
		super();
		this.homesId = homesId;
		this.homes_address = homes_address;
		this.homes_type = homes_type;
		this.homes_area = homes_area;
		this.homes_ownerId = homes_ownerId;
	}
	public int getHomesId() {
		return homesId;
	}
	public void setHomesId(int homesId) {
		this.homesId = homesId;
	}
	public String getHomes_address() {
		return homes_address;
	}
	public void setHomes_address(String homes_address) {
		this.homes_address = homes_address;
	}
	public String getHomes_type() {
		return homes_type;
	}
	public void setHomes_type(String homes_type) {
		this.homes_type = homes_type;
	}
	public int getHomes_area() {
		return homes_area;
	}
	public void setHomes_area(int homes_area) {
		this.homes_area = homes_area;
	}
	public int getHomes_ownerId() {
		return homes_ownerId;
	}
	public void setHomes_ownerId(int homes_ownerId) {
		this.homes_ownerId = homes_ownerId;
	}
	@Override
	public String toString() {
		return " homesId=" + homesId + "\t homes_address=" + homes_address + "\t homes_type=" + homes_type
				+ "\t homes_area=" + homes_area + "\t homes_ownerId=" + homes_ownerId +"<br/>";
	}
	
}
