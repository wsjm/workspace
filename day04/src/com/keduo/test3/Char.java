package com.keduo.test3;

public class Char extends Thread {
 private Object o;
 
	public Char(Object o) {
	super();
	this.o = o;
}

	@Override
	public void run() {
		for(char i='A';i<='Z';i++){
			synchronized (o) {
				
				System.out.print(i+" ");
				o.notifyAll();
				if (i>'Z') {
					break;
				}
				try {
					o.wait();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}
