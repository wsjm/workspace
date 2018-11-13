package day28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DButil {
	public static void Dbutil(String userName,String password,String sex,String age,String address){
		Connection con=null; 
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

	        //提供连接信息
	        String user="root";
	        String password1="root";
	        String url="jdbc:mysql://localhost:3306/keduo";

	        //根据连接信息获取连接对象
	         con= DriverManager.getConnection(url,user,password1);
	        //根据连接对象获取执行对象
	        
	        
	         preparedStatement= con.prepareStatement("insert into aaa values(?,?,?,?,?)");
	         preparedStatement.setString(1, userName);
	         preparedStatement.setString(2, password);
	         preparedStatement.setString(3, sex);
	         preparedStatement.setString(4, age);
	         preparedStatement.setString(5, address);
	         int preparedStatement2= preparedStatement.executeUpdate();
	         
	         
	         
	         System.out.println("--------");
			//根据连接对象执行连接
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	       
		
		
	}

}
