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

	        //�ṩ������Ϣ
	        String user="root";
	        String password1="root";
	        String url="jdbc:mysql://localhost:3306/keduo";

	        //����������Ϣ��ȡ���Ӷ���
	         con= DriverManager.getConnection(url,user,password1);
	        //�������Ӷ����ȡִ�ж���
	        
	        
	         preparedStatement= con.prepareStatement("insert into aaa values(?,?,?,?,?)");
	         preparedStatement.setString(1, userName);
	         preparedStatement.setString(2, password);
	         preparedStatement.setString(3, sex);
	         preparedStatement.setString(4, age);
	         preparedStatement.setString(5, address);
	         int preparedStatement2= preparedStatement.executeUpdate();
	         
	         
	         
	         System.out.println("--------");
			//�������Ӷ���ִ������
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
