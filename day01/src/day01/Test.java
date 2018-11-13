package day01;

import java.lang.reflect.Field;

public class Test {
	public static void main(String[] args) {
		User user=new User();
		//获取类对象
		 Class u= User.class;
		 //获取属性名
		 Field[] f=u.getDeclaredFields();
		 for (Field field : f) {
			System.out.println(field.getName());
		}
	}

}
