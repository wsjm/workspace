package com.keduo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;




public class JDBCUtil {
	// 申明初始化 并加载 properties 类、文件
	private static Properties properties = new Properties();
	static {
		// 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
//			properties.load(new FileInputStream("mysql.properties"));
//			properties.load(JDBCUtil.class.getResourceAsStream("mysql.properties"));
			properties.load(JDBCUtil.class.getResourceAsStream("/mysql.properties"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static JDBCUtil jdbcUtil;

	private JDBCUtil() {
		super();
	}

	public static JDBCUtil getInstance() {
		if (jdbcUtil == null) {
			jdbcUtil = new JDBCUtil();
		}
		return jdbcUtil;
	}

	/**
	 * 获取连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	
	public Connection getConn() throws SQLException {
		// 申明 连接 参数
		// String url = "jdbc:mysql://localhost:3306/kd180601";
		// String user = "root";
		// String password = "root";

		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");

		Connection conn = null;
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public void close(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn, st);
	}

	public void close(Connection conn, Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public PreparedStatement psValus(PreparedStatement ps , Object...obj) throws SQLException {
		for(int i = 1 , len = obj.length ; i <= len ; i++) {
			ps.setObject(i, obj[i-1]);
		}
		return ps;
	}
}
