package com.keduo.test3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="products")
public class Product {
	
	private String name;

	private String descri;
	
	private double price;
	
	public Product() {
		super();
	}
	public Product(String name, String descri, double price) {
		super();
		this.name = name;
		this.descri = descri;
		this.price = price;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name="descri")
	public String getDescri() {
		return descri;
	}
	public void setDescri(String descri) {
		this.descri = descri;
	}
	@XmlElement(name="price")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "product[name="+name+" descri="+descri+" price="+price+"]";
	}
	

}
