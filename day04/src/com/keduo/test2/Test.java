package com.keduo.test2;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		while (true) {
		
			
		
		int carnum=0;
		Car car=new Car();
		CarRoom carRoom=new CarRoom(car);
		Thread thread=new Thread(carRoom);
		thread.start();
		
		CarRoomOut carRoomOut=new CarRoomOut(car);
		carRoomOut.start();
	}
	}

}
