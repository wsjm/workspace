package day01;

import java.lang.reflect.Field;

public class Test {
	public static void main(String[] args) {
		User user=new User();
		//��ȡ�����
		 Class u= User.class;
		 //��ȡ������
		 Field[] f=u.getDeclaredFields();
		 for (Field field : f) {
			System.out.println(field.getName());
		}
	}

}
