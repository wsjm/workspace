package com.keduo.entity;

import com.keduo.annotation.Column;
import com.keduo.annotation.Table;

@Table(name="role")
public class Role {
	@Column(cname="rid" ,isPk=true)
	private int rid;
	@Column(cname="name")
	private String name;

	public Role() {
		super();
		
	}

	public Role(int rid, String name) {
		super();
		this.rid = rid;
		this.name = name;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [rid=" + rid + ", name=" + name + "]";
	}

}
