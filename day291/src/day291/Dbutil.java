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
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//提供连接信息获取连接对象
		  connection= DriverManager.getConnection(url, user, password1);
			//根据连接对象执行连接
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
