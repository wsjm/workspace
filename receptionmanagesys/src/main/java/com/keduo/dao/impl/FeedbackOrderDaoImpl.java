package com.keduo.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.keduo.dao.FeedbackOrderDao;
import com.keduo.entity.Bill;
import com.keduo.entity.Role;
import com.keduo.entity.TaskOrder;
import com.keduo.util.DBUtil;
import com.keduo.util.SetTaskOrder;

public class FeedbackOrderDaoImpl extends BaseDaoImpl<TaskOrder> implements FeedbackOrderDao{

	@Override
	public Map<String, Object> SelectFeedbackOrder(String taskId, int officeId, int inviteOrgId, int feedback_statusId,
			Date visitorDate, Date leaveDate, int num, int page){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<TaskOrder> taskList = new ArrayList<TaskOrder>();
		int total = 0;
		String sql = null;
		StringBuffer sql1 = new StringBuffer();
			sql1.append("select * from taskorder where (task_statusId=4 or task_statusId=5)");
			if (taskId != null) {
				sql1.append(" and taskId='" + taskId + "' ");
			}
			if (officeId != 0) {
				sql1.append(" and officeId=" + officeId + " ");
			}
			if (inviteOrgId != 0) {
				sql1.append(" and inviteOrgId=" + inviteOrgId + " ");
			}
			if (feedback_statusId != 0) {
				if(feedback_statusId == 1) {
					sql1.append(" and feedback_statusId between 2 and 8");
				}else{
					sql1.append(" and feedback_statusId=" + feedback_statusId + " ");
				}
			}
			if (visitorDate != null) {
				sql1.append(" and visitorDate >='" +visitorDate + "' ");
			}
			if (leaveDate != null) {
				sql1.append(" and leaveDate <='" +leaveDate + "' ");
			}
			
			sql = sql1.toString();
			total = getTotal(sql);
			sql1.append(" limit ?,?");
			sql = sql1.toString();
			System.out.println(sql);
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, (page - 1) * num);
			pstm.setInt(2, num);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TaskOrder taskOrder = new TaskOrder();
				taskOrder.setTaskId(rs.getString("taskid"));
				taskOrder.setTaskname(rs.getString("taskname"));
				taskOrder.setVisitorOrg(rs.getString("VisitorOrg"));
				taskOrder.setVisitorNum(rs.getInt("VisitorNum"));
				taskOrder.setVisitorDate(rs.getDate("VisitorDate"));
				taskOrder.setLeaveDate(rs.getDate("leaveDate"));
				taskOrder.setInviteOrgId(rs.getInt("inviteOrgId"));
				taskOrder.setHotel(rs.getString("hotel"));
				taskOrder.setMealsBudget(rs.getDouble("mealsBudget"));
				taskOrder.setLiveBudget(rs.getDouble("livebudget"));
				taskOrder.setOthers(rs.getString("others"));
				taskOrder.setOfficeId(rs.getInt("officeId"));
				taskOrder.setDirectorId(rs.getInt("directorId"));
				taskOrder.setStaffId(rs.getInt("staffId"));
				taskOrder.setTask_statusId(rs.getInt("task_statusId"));
				taskOrder.setVisittypeId(rs.getInt("visittypeId"));
				taskOrder.setFeedbackcontext(rs.getString("feedbackcontext"));
				taskOrder.setFeedbacksubmittime(rs.getDate("feedbacksubmittime"));
				taskOrder.setFeedback_statusId(rs.getInt("feedback_statusId"));
				
				taskList.add(SetTaskOrder.setTaskOrder(taskOrder));
			}
			System.out.println(taskList);
			
			int allpage = total / num + 1;
			map.put("allpage", allpage);
			map.put("page", page);
			map.put("total", total);
			map.put("num", num);
			map.put("rows", taskList);
			return map;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeResource(con, pstm, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	

	@Override
	public int UpdateFeedbackOrder(TaskOrder taskorder) {
		// 申明受影响行数
		int row = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE taskorder SET taskname = ?, VisitorOrg = ?, VisitorNum = ?, VisitorDate = ?,"
				+ "leaveDate = ?, inviteOrgId = ?, hotel = ?, mealsBudget= ?, livebudget = ?, others = ?,"
				+ "officeId = ?, directorId = ?, staffId = ?, task_statusId = ?, visittypeId= ? where taskid = ?";
		try {
			// 获取连接
			conn = DBUtil.getconnection();
			ps = conn.prepareStatement(sql);
			DBUtil.psValus(ps, taskorder.getTaskname(), taskorder.getVisitorOrg(),
					taskorder.getVisitorNum(), taskorder.getVisitorDate(), taskorder.getLeaveDate(),
					taskorder.getInviteOrgId(), taskorder.getHotel(), taskorder.getMealsBudget(),
					taskorder.getLiveBudget(), taskorder.getOthers(), taskorder.getOfficeId(), 
					taskorder.getDirectorId(), taskorder.getStaffId(), taskorder.getTask_statusId(), 
					taskorder.getVisittypeId(), taskorder.getTaskId());
			// 执行sql
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeResource(conn, ps, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 返回受影响行数
		return row;
	}

	@Override
	public Map<String, Object> SelectFeedbackOrder(String taskId, String taskname, int officeId, int feedback_statusId,
			Date visitorDate, Date leaveDate, int num, int page) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int total = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		List<TaskOrder> taskList = new ArrayList<TaskOrder>();
		String sql = null;
		StringBuffer sql1 = new StringBuffer();
			sql1.append("select * from taskorder where (task_statusId=4 or task_statusId=5)");
			if (taskId != null) {
				sql1.append(" and taskId=" + taskId + " ");
			}
			if (taskname != null) {
				sql1.append(" and taskname='" + taskname + "' ");
			}
			if (officeId != 0) {
				sql1.append(" and officeId=" + officeId + " ");
			}
			if (feedback_statusId != 0) {
				sql1.append(" and feedback_statusId=" + feedback_statusId + " ");
			}
			if (visitorDate != null) {
				sql1.append(" and visitorDate >='" +visitorDate + "' ");
			}
			if (leaveDate != null) {
				sql1.append(" and leaveDate <='" +leaveDate + "' ");
			}
			sql = sql1.toString();
			total = getTotal(sql);
			sql1.append(" limit ?,?");
			sql = sql1.toString();
			System.out.println(sql);
			
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, (page - 1) * num);
			pstm.setInt(2, num);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TaskOrder taskOrder = new TaskOrder();
				taskOrder.setTaskId(rs.getString("taskid"));
				taskOrder.setTaskname(rs.getString("taskname"));
				taskOrder.setVisitorOrg(rs.getString("VisitorOrg"));
				taskOrder.setVisitorNum(rs.getInt("VisitorNum"));
				taskOrder.setVisitorDate(rs.getDate("VisitorDate"));
				taskOrder.setLeaveDate(rs.getDate("leaveDate"));
				taskOrder.setInviteOrgId(rs.getInt("inviteOrgId"));
				taskOrder.setHotel(rs.getString("hotel"));
				taskOrder.setMealsBudget(rs.getDouble("mealsBudget"));
				taskOrder.setLiveBudget(rs.getDouble("livebudget"));
				taskOrder.setOthers(rs.getString("others"));
				taskOrder.setOfficeId(rs.getInt("officeId"));
				taskOrder.setDirectorId(rs.getInt("directorId"));
				taskOrder.setStaffId(rs.getInt("staffId"));
				taskOrder.setTask_statusId(rs.getInt("task_statusId"));
				taskOrder.setVisittypeId(rs.getInt("visittypeId"));
				taskOrder.setFeedbackcontext(rs.getString("feedbackcontext"));
				taskOrder.setFeedbacksubmittime(rs.getDate("feedbacksubmittime"));
				taskOrder.setFeedback_statusId(rs.getInt("feedback_statusId"));
				
				taskList.add(SetTaskOrder.setTaskOrder(taskOrder));
			}
			System.out.println(taskList);
			int allpage = total / num + 1;
			map.put("allpage", allpage);
			map.put("page", page);
			map.put("total", total);
			map.put("num", num);
			map.put("rows", taskList);
			return map;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeResource(con, pstm, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public int insertFee(Bill bill) {
		// 申明受影响行数
		int row = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		String sql = "insert into bill values(null, ?, ?, ?, ?, ?);";
		try {
			// 获取连接
			con = DBUtil.getconnection();
			pstm = con.prepareStatement(sql);
			DBUtil.psValus(pstm, bill.getBilltype(), bill.getBill(), 
					bill.getBilltime(), bill.getShop(), bill.getFeedbackorder());
			// 执行sql
			row = pstm.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			DBUtil.closeResource(con, pstm, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return row;
}


	@Override
	public Map<String, Object> SelectFeedbackOrder(String taskId, String taskname, int feedback_statusId, Date visitorDate,
			Date leaveDate, int num, int page) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<TaskOrder> taskList = new ArrayList<TaskOrder>();
		String sql = null;
		int total = 0;
		StringBuffer sql1 = new StringBuffer();
			sql1.append("select * from taskorder where (task_statusId=4 or task_statusId=5)");
			if (taskId != null) {
				sql1.append(" and taskId='" + taskId + "' ");
			}
			if (taskname != null) {
				sql1.append(" and taskname='" + taskname + "' ");
			}
			if (feedback_statusId != 0) {
				if(feedback_statusId == 1) {
					sql1.append(" and feedback_statusId between 2 and 8");
				}else{
					sql1.append(" and feedback_statusId=" + feedback_statusId + " ");
				}
			}
			if (visitorDate != null) {
				sql1.append(" and visitorDate >='" +visitorDate + "' ");
			}
			if (leaveDate != null) {
				sql1.append(" and leaveDate <='" +leaveDate + "' ");
			}
			sql = sql1.toString();
			total = getTotal(sql);
			sql1.append(" limit ?,?");
			sql = sql1.toString();
			System.out.println(sql);
			
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, (page - 1) * num);
			pstm.setInt(2, num);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TaskOrder taskOrder = new TaskOrder();
				taskOrder.setTaskId(rs.getString("taskid"));
				taskOrder.setTaskname(rs.getString("taskname"));
				taskOrder.setVisitorOrg(rs.getString("VisitorOrg"));
				taskOrder.setVisitorNum(rs.getInt("VisitorNum"));
				taskOrder.setVisitorDate(rs.getDate("VisitorDate"));
				taskOrder.setLeaveDate(rs.getDate("leaveDate"));
				taskOrder.setInviteOrgId(rs.getInt("inviteOrgId"));
				taskOrder.setHotel(rs.getString("hotel"));
				taskOrder.setMealsBudget(rs.getDouble("mealsBudget"));
				taskOrder.setLiveBudget(rs.getDouble("livebudget"));
				taskOrder.setOthers(rs.getString("others"));
				taskOrder.setOfficeId(rs.getInt("officeId"));
				taskOrder.setDirectorId(rs.getInt("directorId"));
				taskOrder.setStaffId(rs.getInt("staffId"));
				taskOrder.setTask_statusId(rs.getInt("task_statusId"));
				taskOrder.setVisittypeId(rs.getInt("visittypeId"));
				taskOrder.setFeedbackcontext(rs.getString("feedbackcontext"));
				taskOrder.setFeedbacksubmittime(rs.getDate("feedbacksubmittime"));
				taskOrder.setFeedback_statusId(rs.getInt("feedback_statusId"));
				
				taskList.add(SetTaskOrder.setTaskOrder(taskOrder));
			}
			System.out.println(taskList);
			int allpage = total / num + 1;
			map.put("allpage", allpage);
			map.put("page", page);
			map.put("total", total);
			map.put("num", num);
			map.put("rows", taskList);
			return map;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeResource(con, pstm, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}


	@Override
	public int CheckFeedbackOrder(TaskOrder taskorder) {
		// 申明受影响行数
		int row = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE taskorder SET feedbackcontext = ?, feedbacksubmittime = ?, feedback_statusId = ? where taskid = ?;";
		try {
			// 获取连接
			conn = DBUtil.getconnection();
			ps = conn.prepareStatement(sql);
			DBUtil.psValus(ps, taskorder.getFeedbackcontext(), taskorder.getFeedbacksubmittime(), taskorder.getFeedback_statusId(),
					taskorder.getTaskId());
			// 执行sql
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.closeResource(conn, ps, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 返回受影响行数
		return row;
	}
	
	//获取查询总条数
			public static int getTotal(String sql) {
				Connection con = null;
				PreparedStatement pstm = null;
				ResultSet rs = null;
				int total = 0;
				try {
					con=DBUtil.getconnection();
					pstm=con.prepareStatement(sql);
					rs=pstm.executeQuery();
					while(rs.next()) {
						total++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return total;
				
			}

}
