package com.keduo.test2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CarRoomOut extends Thread{
	private static int carnum;//车库已有车辆
	private static int num=5;
	private Object o;
	 public CarRoomOut(Object o) {
		this.o=o;
		
	}
	 
	public static int getCarnum() {
		return carnum;
	}

	public static void setCarnum(int carnum) {
		CarRoomOut.carnum = carnum;
	}

	public static int getNum() {
		return num;
	}

	public static void setNum(int num) {
		CarRoomOut.num = num;
	}

	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}

	@Override
	public void run() {
				//车出库
				//获取车出库的时间;
		
			synchronized (o) {
					o.notifyAll();
					
				SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				System.out.println(df1.format(new Date()));//获取当前时间
				
				int j= new CarRoom().getCarnum();
				System.out.println("========"+j);
				System.out.println("车库已有车辆："+(--j)+"辆");
				System.out.print("出库的车牌号是:");
				new Car().carlicense();
				if (carnum<=0) {
					
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
