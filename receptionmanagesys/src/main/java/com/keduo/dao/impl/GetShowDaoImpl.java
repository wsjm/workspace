package com.keduo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.keduo.dao.GetShowDao;
import com.keduo.util.DBUtil;

public class GetShowDaoImpl implements GetShowDao {

	@Override
	public List getInviteOrg() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement("SELECT deptid,deptname FROM dept WHERE superdeptId=1");
			rs = pstm.executeQuery();
			while(rs.next()) {
				Map org = new HashMap();
				org.put("deptid", rs.getInt("deptid"));
				org.put("deptname", rs.getString("deptname"));
				list.add(org);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List getVisittypeId() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement("SELECT * FROM visittype");
			rs = pstm.executeQuery();
			while(rs.next()) {
				Map org = new HashMap();
				org.put("visitTypeId", rs.getInt("visitTypeId"));
				org.put("visitTypeName", rs.getString("visitTypeName"));
				list.add(org);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List getStaff() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement("SELECT * FROM staff WHERE duty=\"接待员\"");
			rs = pstm.executeQuery();
			while(rs.next()) {
				Map org = new HashMap();
				org.put("staffId", rs.getInt("staffId"));
				org.put("realName", rs.getString("realName"));
				list.add(org);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List getOffice() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement("SELECT * FROM dept WHERE superdeptId=4");
			rs = pstm.executeQuery();
			while(rs.next()) {
				Map org = new HashMap();
				org.put("deptId", rs.getInt("deptId"));
				org.put("deptName", rs.getString("deptname"));
				list.add(org);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List getTask_status() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement("SELECT * FROM task_status");
			rs = pstm.executeQuery();
			while(rs.next()) {
				Map org = new HashMap();
				org.put("ststus_id", rs.getInt("status_id"));
				org.put("status_name", rs.getString("status_name"));
				list.add(org);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List getFeedback_status(int roleId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = DBUtil.getconnection();
			String sql = null;
			if (roleId == 1){
				sql = "SELECT * FROM feedback_status WHERE status_id = 7 OR status_id = 8;";
			}
			if (roleId == 2){
				sql = "SELECT * FROM feedback_status WHERE status_id = 5 OR status_id = 8;";
			}
			if (roleId == 3){
				sql = "SELECT * FROM feedback_status WHERE status_id = 6 OR status_id = 8;";
			}
			if (roleId == 4){
				sql = "SELECT * FROM feedback_status WHERE status_id >= 1 AND status_id <=4 OR status_id = 8;";
			}
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Map org = new HashMap();
				org.put("status_id", rs.getInt("status_id"));
				org.put("status_name", rs.getString("status_name"));
				list.add(org);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List getOfficeByStaffId(String staffId) {
		//SELECT d.* FROM dept d JOIN staff s ON d.deptid=s.deptId WHERE staffId=4 GROUP BY d.deptid
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement("SELECT d.* FROM dept d JOIN staff s ON d.deptid=s.deptId WHERE staffId=? GROUP BY d.deptid");
			pstm.setString(1, staffId);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Map org = new HashMap();
				org.put("deptId", rs.getInt("deptId"));
				org.put("deptName", rs.getString("deptname"));
				list.add(org);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List getStaffByOfficeId(String officeId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement("SELECT s.staffId,s.realName FROM staff s JOIN dept d ON d.deptid=s.deptId WHERE s.duty='接待员' AND d.deptid=? GROUP BY staffId");
			pstm.setString(1, officeId);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Map org = new HashMap();
				org.put("staffId", rs.getInt("staffId"));
				org.put("realName", rs.getString("realName"));
				list.add(org);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
