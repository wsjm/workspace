package com.keduo.est;

public class Windows1 extends Thread{
	private Object o;
	
	 public Windows1(Object o) {
		this.o=o;
	}
	@Override
		public  void run() {
		while(true){
			synchronized (o){
		Ticket ticket1=new Ticket();
		System.out.print("����һ");
		//System.out.println(ticket1.getNum());
		if (ticket1.getNum()<=0) {
			System.out.print("Ʊ������");
			break;
		}
		ticket1.sell();
		}
		}
	}
}
