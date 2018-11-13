package com.keduo.est;

public class Ticket {

	//»ğ³µÆ±Àà
	private static int  num=100;
	
	
	public void sell() {
		
		System.out.println("Äã¹ºÂòµÄÊÇ"+(--num)+"ºÅÆ±");
	}


	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Ticket(int num) {
		super();
		this.num = num;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}
	
}
