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
				// �������Ӷ���
				con = DButil.connection();
				// ����ִ�ж���
				ps = con.prepareStatement("select * from user ");
				// ���ؽ����
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