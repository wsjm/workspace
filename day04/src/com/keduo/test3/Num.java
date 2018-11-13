package com.keduo.test3;

public class Num extends Thread{
	private Object o;

	public Num(Object o) {
		super();
		this.o = o;
	}

	@Override
	public void run() {
		synchronized (o) {
			for(int i=1;i<=52;i++){
				System.out.print(i+" ");
				o.notifyAll();
				if (i%2==0) {
					try {
						o.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(i>52){
						break;
					}
				}
			}
		}
	}
}
