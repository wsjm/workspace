package com.keduo.test2;

import java.util.Random;

public class Car {

	private String Carlicense;


	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Car(String carlicense) {
		super();
		Carlicense = carlicense;
	}


	public String getCarlicense() {
		return Carlicense;
	}


	public void setCarlicense(String carlicense) {
		Carlicense = carlicense;
	}


	public static void carlicense(){
		//获取车牌
		char[] arr={'a','b','c','d','e','f','g','h','1','2','3','4','5','6','7','8','9'};
		char[] arr1=new char[6];
		for(int i=0;i<6;i++){
			int index= (int)(Math.random()*arr.length);
			int rand=arr[index];
			arr1[i]=(char)rand;
			//车牌号
			System.out.print(arr1[i]);
		}
		System.out.println();
	}
	
	

}
