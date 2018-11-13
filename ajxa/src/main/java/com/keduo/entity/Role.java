package com.keduo.entity;

public class Role {
	private int rid;
	private String name;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
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
