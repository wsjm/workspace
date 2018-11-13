package com.keduo.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	static Properties ps = new Properties();
	static {
		try {
			ps.load(DBUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
			Class.forName(ps.getProperty("driverClassName"));//加载JDBC驱动
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取连接对象
	 * @return
	 * @throws SQLException
	 */
	public static Connection getconnection() throws SQLException {
		return DriverManager.getConnection(ps.getProperty("url"), ps.getProperty("user"), ps.getProperty("password"));		
	}
	/**
	 * 关闭资源
	 * @param con	Connection
	 * @param pstm	preparedStatement
	 * @param rs	ResultSet
	 * @throws SQLException
	 */
	public static void closeResource(Connection con,PreparedStatement pstm,ResultSet rs) throws SQLException {
		if(rs != null)
			rs.close();
		if(pstm !=null)
			pstm.close();
		if(con!=null)
			con.close();
	}
	
	public static PreparedStatement psValus(PreparedStatement pstm , Object...obj) throws SQLException {
		for(int i = 1 , len = obj.length ; i <= len ; i++) {
			pstm.setObject(i, obj[i-1]);
		}
		return pstm;
	}
}
