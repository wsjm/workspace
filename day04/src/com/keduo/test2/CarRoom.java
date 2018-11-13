package com.keduo.test2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CarRoom implements Runnable{
	
	private static int carnum;//车库已有车辆
	private static String Parking;
	private  Object o;
	public CarRoom(String Paking){
		this.Parking=Paking;
	}

	public CarRoom(Object o) {
		this.o=o;
		
	}
	

	public static int getCarnum() {
		return carnum;
	}

	public static void setCarnum(int carnum) {
		CarRoom.carnum = carnum;
	}

	public static String getParking() {
		return Parking;
	}

	public static void setParking(String parking) {
		Parking = parking;
	}

	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}

	public CarRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		//先车入库
		//获取车入库的时间
	
			synchronized (o) {


				Car car=new Car();
				o.notifyAll();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				System.out.println(df.format(new Date()));// 获取当前系统时间
				System.out.println("车库已有车辆:"+(++this.carnum)+"辆");
				System.out.print("入库车的车牌号是:");
				car.carlicense();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(carnum>=5){
				try {
					o.wait();
					carnum= new CarRoomOut(o).getCarnum();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
