package com.keduo.entity;


public class Menu {

	private int mid;
	private String name;
	private String url;

	public Menu() {
		super();
		
	}

	public Menu(int mid, String name, String url) {
		super();
		this.mid = mid;
		this.name = name;
		this.url = url;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", name=" + name + ", url=" + url + "]";
	}

}
