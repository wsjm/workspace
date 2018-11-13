package com.keduo.test;

public class Test2 {
public static void main(String[] args) throws InterruptedException {
	for(int i=0;i<100;i++){
	System.out.println("eeeeeee");
	
	}
	Test1 test1=new Test1();
	test1.start();
	Test3 test3=new Test3();
	test3.start();
	Test3.run(1);
	System.out.println("bbbbb");
	
}
}
