package DButil;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DButil {
	static Properties properties;
	
	static{
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//加载 文件
			 properties =new  Properties();
			properties.load(DButil.class.getResourceAsStream("/dbconfig.properties"));
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取连接
	public Connection getConnection() throws SQLException{
		String url= properties.getProperty("url");
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
		return (Connection) DriverManager.getConnection(url, user, password);
		
	}
	//关闭连接
	public void close(Connection con,Statement st,ResultSet rs){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
