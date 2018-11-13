package com.keduo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.keduo.util.DButil;

public class selectUserService {
	public static void select() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rSet = null;			
			try {
				// 创建连接对象
				con = DButil.connection();
				// 创建执行对象
				ps = con.prepareStatement("select * from user ");
				// 返回结果集
				rSet = ps.executeQuery();
				while (rSet.next()) {
					System.out.println(rSet.getString(1)+"\t"+rSet.getString(2)+"\t"+rSet.getString(3)+"\t"+rSet.getString(4));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					DButil.close(con, rSet, ps);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		
	}
	
}