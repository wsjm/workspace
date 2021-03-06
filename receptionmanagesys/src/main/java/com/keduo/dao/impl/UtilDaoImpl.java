package com.keduo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.keduo.dao.UtilDao;
import com.keduo.entity.Bill;
import com.keduo.util.DBUtil;

public class UtilDaoImpl implements UtilDao{

	@Override
	public String getInviteOrg(int inviteOrgId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String inviteOrg=null;
		try {
			con=DBUtil.getconnection();
			pstm=con.prepareStatement("select deptname from dept where deptid=?");
			pstm.setInt(1, inviteOrgId);
			rs=pstm.executeQuery();
			if(rs.next()) {
				inviteOrg=rs.getString("deptname");
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
		
		return inviteOrg;
	}

	@Override
	public String getOffice(int officeId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String office=null;
		try {
			con=DBUtil.getconnection();
			pstm=con.prepareStatement("select deptname from dept where deptid=?");
			pstm.setInt(1, officeId);
			rs=pstm.executeQuery();
			if(rs.next()) {
				office=rs.getString("deptname");
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
		
		return office;
	}

	@Override
	public String getDirector(int directorId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String director=null;
		try {
			con=DBUtil.getconnection();
			pstm=con.prepareStatement("select realName from staff where staffId=?");
			pstm.setInt(1, directorId);
			rs=pstm.executeQuery();
			if(rs.next()) {
				director=rs.getString("realName");
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
		
		return director;
	}

	@Override
	public String getStaff(int staffId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String staff=null;
		try {
			con=DBUtil.getconnection();
			pstm=con.prepareStatement("select realName from staff where staffId=?");
			pstm.setInt(1, staffId);
			rs=pstm.executeQuery();
			if(rs.next()) {
				staff=rs.getString("realName");
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
		
		return staff;
	}

	@Override
	public String getTask_status(int task_statusId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String task_status=null;
		try {
			con=DBUtil.getconnection();
			pstm=con.prepareStatement("select status_name from task_status where status_id=?");
			pstm.setInt(1, task_statusId);
			rs=pstm.executeQuery();
			if(rs.next()) {
				task_status=rs.getString("status_name");
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
		
		return task_status;
	}

	@Override
	public String getVisittype(int visittypeId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String visittype=null;
		try {
			con=DBUtil.getconnection();
			pstm=con.prepareStatement("select visitTypeName from visittype where visitTypeId=?");
			pstm.setInt(1, visittypeId);
			rs=pstm.executeQuery();
			if(rs.next()) {
				visittype=rs.getString("visitTypeName");
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
		
		return visittype;
	}

	@Override
	public String getFeedback_status(int feedback_statusId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String feedback_status=null;
		try {
			con=DBUtil.getconnection();
			pstm=con.prepareStatement("select status_name from feedback_status where status_id=?");
			pstm.setInt(1, feedback_statusId);
			rs=pstm.executeQuery();
			if(rs.next()) {
				feedback_status=rs.getString("status_name");
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
		
		return feedback_status;
	}
	public List<Bill> getBills(String taskId) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement("select * from bill where feedbackorder=" + taskId);
			rs = pstm.executeQuery();
			List<Bill> billList = new ArrayList<Bill>();
			double totalBill=0;
			while (rs.next()) {
				Bill bill = new Bill();
				bill.setBillId(rs.getInt("billId"));
				bill.setBilltype(rs.getString("billtype"));
				bill.setBill(rs.getDouble("bill"));
				bill.setBilltime(rs.getDate("billtime"));
				bill.setShop(rs.getInt("shop"));
				bill.setFeedbackorder(rs.getString("feedbackorder"));
				billList.add(bill);
				totalBill += rs.getDouble("bill");
			}
			return billList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
