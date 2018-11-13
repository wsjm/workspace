package com.keduo.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	static Properties ps = new Properties();
	static {
		try {
			ps.load(DBUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
			Class.forName(ps.getProperty("driverClassName"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取数据库连接对象
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(ps.getProperty("url"), ps.getProperty("user"), ps.getProperty("password"));

	}
	//关闭资源
	public static void closeResource(Connection con, Statement stm, ResultSet rs) throws SQLException {
		if (rs != null)
			rs.close();
		if (stm != null)
			stm.close();
		if (con != null)
			con.close();
	}
}
