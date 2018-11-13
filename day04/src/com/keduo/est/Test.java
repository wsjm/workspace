package com.keduo.est;

public class Test {

	public static void main(String[] args) {
		 Object o=new Object();
		Windows1 windows1=new Windows1(o);
		windows1.start();
		Windows2 windows2=new Windows2(o);
		Thread thread=new Thread(windows2);
		thread.start();
	}
}
