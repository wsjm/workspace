package com.keduo.est;

public class Ticket {

	//��Ʊ��
	private static int  num=100;
	
	
	public void sell() {
		
		System.out.println("�㹺�����"+(--num)+"��Ʊ");
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
