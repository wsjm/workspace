package com.keduo.test2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CarRoomOut extends Thread{
	private static int carnum;//�������г���
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
				//������
				//��ȡ�������ʱ��;
		
			synchronized (o) {
					o.notifyAll();
					
				SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				System.out.println(df1.format(new Date()));//��ȡ��ǰʱ��
				
				int j= new CarRoom().getCarnum();
				System.out.println("========"+j);
				System.out.println("�������г�����"+(--j)+"��");
				System.out.print("����ĳ��ƺ���:");
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
