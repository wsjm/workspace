package com.keduo.test;

public class Test1 extends Thread {

	@Override
	public void run() {
		System.out.println("aaaaa");
		for(int i=1;i<10;i++){
		System.out.println("cccccc");
		}
	}
}
