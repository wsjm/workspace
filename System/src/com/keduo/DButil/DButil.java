package com.keduo.DButil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DButil {
	public static Properties properties;
//���ݿ������
	 static{
		 try {
			 //�ȼ�������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡProperties
			Properties properties=new Properties();
			//����
			properties.load(DButil.class.getResourceAsStream("/mysql.properties"));
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	 }
	 //��ȡ���Ӷ���
	 public Connection getConnection() throws SQLException {
		  String user="root";
	        String password="root";
	        String url="jdbc:mysql://localhost:3306/keduo";
		return DriverManager.getConnection(url, user, password);
		
	}
	 //�ر���Դ
	 public void close(Connection con, Statement st, ResultSet rs){
		 if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (rs!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	 }
}
