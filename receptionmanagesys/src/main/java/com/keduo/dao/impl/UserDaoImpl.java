package com.keduo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.keduo.dao.UserDao;
import com.keduo.entity.User;
import com.keduo.util.DBUtil;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User queryUserByLoginName(String loginName) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		User user = null;
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement("select * from t_user where statusId = 1 and uname =?");
			pstm.setString(1, loginName);
			rs = pstm.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
				user.setRid(rs.getInt("rid"));
				user.setStatusId(rs.getInt("statusId"));
				user.setStaffId(rs.getInt("staffId"));
				user.setLastLoginTime(rs.getDate("lastLoginTime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtil.closeResource(con, pstm, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return user;
	}
	//修改最后登陆时间
	@Override
	public int updateLastLoginTime(int uid) {
		int row = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "UPDATE t_user SET lastLoginTime = NOW() WHERE uid = ?";
		
		try {
			conn = DBUtil.getconnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, uid);
			row = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.closeResource(conn, pstm, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return row;
		
	}
	@Override
	public int changePassword(int uid,String password) {
		int row = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "UPDATE t_user SET password=? WHERE uid=?";
		try {
			con=DBUtil.getconnection();
			pstm=con.prepareStatement(sql);
			pstm.setString(1, password);
			pstm.setInt(2, uid);
			row=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

}
