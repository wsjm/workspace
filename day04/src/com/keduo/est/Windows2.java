package com.keduo.est;

public class Windows2 implements Runnable{
	private Object o;
	 public Windows2(Object o) {
	this.o=o;
	}
	@Override
		public  void run() {
		while(true){
			synchronized (o) {
		Ticket ticket2=new Ticket();
		System.out.print("���ڶ�");
		if (ticket2.getNum()<=0) {
			System.out.println("Ʊ������");
			break;
		}
		ticket2.sell();
		}
		}
	}

}
