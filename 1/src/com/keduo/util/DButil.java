package com.keduo.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



public class DButil {
	static String user;
	static String password;
	static String url;
	static {

		try {
			// 创建连接
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接对象
			InputStream is = DButil.class.getClassLoader().getResourceAsStream("test.properties");
			// 创建properties对象
			Properties pro = new Properties();
			pro.load(is);
			// 获取连接信息
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			url = pro.getProperty("url");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection connection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static void close(Connection con, ResultSet rs, PreparedStatement ps) throws SQLException {
		if (con != null) {
			con.close();
		}
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
	}
}
