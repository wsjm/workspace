package com.keduo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.keduo.util.DButil;

public class userDao {
	public static void insertUser(String userId, String password, String age, String sex) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rSet = null;
		try {
			// 创建连接对象
			con = DButil.connection();
			// 创建执行对象
			ps = con.prepareStatement("insert into user values(?,?,?,?)");
			// 返回结果集
			ps.setString(1, userId);
			ps.setString(2, password);
			ps.setInt(3, Integer.parseInt(age));
			ps.setString(4, sex);
			ps.executeUpdate();
			while (rSet.next()) {
				System.out.println(rSet.getString(1) + "\t" + rSet.getString(2) + "\t" + rSet.getString(3) + "\t"
						+ rSet.getString(4));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DButil.close(con, rSet, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
}
