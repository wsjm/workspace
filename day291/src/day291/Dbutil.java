package day291;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dbutil {
	public static void Dbutil(/*String userName,String password,String sex,String age,String address*/){
		String user="root";
		String password1="root";
		String url="jdbc:mysql://localhost:3306/keduo";
		Connection connection=null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//�ṩ������Ϣ��ȡ���Ӷ���
		  connection= DriverManager.getConnection(url, user, password1);
			//�������Ӷ���ִ������
		 PreparedStatement p= connection.prepareStatement("insert into aaa values(userName,password,sex,age,address)");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
