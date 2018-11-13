package com.keduo.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.keduo.dao.TaskQueryDao;
import com.keduo.entity.Bill;
import com.keduo.entity.TaskOrder;
import com.keduo.util.DBUtil;
import com.keduo.util.SetTaskOrder;

public class TaskQueryDaoImpl implements TaskQueryDao {
	//归属机关查询
	@Override
	public Map<String, Object> queryInviteOrg(Date date, int org, int visittypeId, int num, int page) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<TaskOrder> taskList = new ArrayList<TaskOrder>();
		int total = 0;
		String sql = null;
		if (date == null && org == -1 && visittypeId == -1) {
			sql = "select * from taskorder where task_statusId=4 or task_statusId=5";
			total = getTotal(sql);
			sql = sql +" limit ?,?";
		} else {
			StringBuffer sql1 = new StringBuffer();
			sql1.append("select * from taskorder where (task_statusId=4 or task_statusId=5)");
			if (date != null) {
				String date1 = new SimpleDateFormat("yyyyMMdd").format(date);
				sql1.append(" and leaveDate=" + date1 + " ");
			}
			if (org > 0) {
				sql1.append(" and inviteOrgId=" + org + " ");
			}
			if (visittypeId > 0) {
				sql1.append(" and visittypeId=" + visittypeId + " ");
			}
			sql = sql1.toString();
			total = getTotal(sql);
			sql1.append(" limit ?,?");
			sql = sql1.toString();
		}
		
		//System.out.println(sql);
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
			//System.out.println(taskList);
			
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
	
	//承办处室查询
	@Override
	public Map<String, Object> queryDept(int staffId, int officeId, String taskId, int task_statusId, int num,
			int page) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<TaskOrder> taskList = new ArrayList<TaskOrder>();
		String sql = null;
		int total =0;
		if (staffId == -1 && officeId == -1 && taskId == null && task_statusId == -1) {
			sql = "select * from taskorder";
			total=getTotal(sql);
			sql = sql + " limit ?,?";
		} else {
			StringBuffer sql1 = new StringBuffer();
			sql1.append("select * from taskorder where");
			if (staffId != -1) {
				sql1.append(" and staffId=" + staffId + " ");
			}
			if (officeId > 0) {
				sql1.append(" and officeId=" + officeId + " ");
			}
			if (taskId != null) {
				sql1.append(" and taskId=" + taskId + " ");
			}
			if (task_statusId > 0) {
				sql1.append(" and task_statusId=" + task_statusId + " ");
			}
			sql = sql1.toString();
			//去掉第一个" and"
			sql = sql.replaceFirst(" and", "");
			total = getTotal(sql);
			sql = sql + " limit ?,?";
		}

		//System.out.println(sql);
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
			//System.out.println(taskList);
			
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
	//费用查询
	@Override
	public Map<String, Object> queryBill(Date date, int org, int num, int page) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<TaskOrder> taskList = new ArrayList<TaskOrder>();
		String sql = null;
		int total = 0;
		if (date == null && org == -1) {
			sql = "select * from taskorder where task_statusId=4 or task_statusId=5";
			total = getTotal(sql);
			sql = sql + " limit ?,?";
		} else {
			StringBuffer sql1 = new StringBuffer();
			sql1.append("select * from taskorder where (task_statusId=4 or task_statusId=5)");
			if (date != null) {
				String date1 = new SimpleDateFormat("yyyyMMdd").format(date);
				sql1.append(" and leaveDate=" + date1 + " ");
			}
			if (org > 0) {
				sql1.append(" and inviteOrgId=" + org + " ");
			}
			sql = sql1.toString();
			total = getTotal(sql);
			sql1.append(" limit ?,?");
			sql = sql1.toString();
		}

		//System.out.println(sql);
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
			//System.out.println(taskList);
			
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
	//任务办结预警（来宾离开后15天还未办结的任务）
	@Override
	public Map<String, Object> queryUnclosedTask(int num, int page) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<TaskOrder> taskList = new ArrayList<TaskOrder>();
		String sql = null;
		int total = 0;
		StringBuffer sql1 = new StringBuffer();
		sql1.append(
				"SELECT t.*,(TO_DAYS(NOW())-TO_DAYS(t.`leaveDate`)) exceeddays FROM taskorder t WHERE task_statusId=4 AND TO_DAYS(NOW())-TO_DAYS(leaveDate)>=15");
		sql = sql1.toString();
		total = getTotal(sql);
		sql1.append(" limit ?,?");
		sql = sql1.toString();
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
				taskOrder.setExceeddays(rs.getInt("exceeddays"));
				taskList.add(SetTaskOrder.setTaskOrder(taskOrder));
			}
			//System.out.println(taskmap);
			
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
	//费用超支预警
	@Override
	public Map<String, Object> queryOverspendTask(String date, int num, int page) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<TaskOrder> taskList = new ArrayList<TaskOrder>();
		String sql = null;
		int total = 0;
		if(date == null) {
			sql = "SELECT ta.*,(ta.mealsBudget + ta.liveBudget) totalBudget,bi.totalBill FROM taskorder ta  JOIN (SELECT SUM(bill) totalBill , b.feedbackorder FROM bill b GROUP BY b.feedbackorder  ) bi ON ta.taskid = bi.feedbackorder  WHERE  (ta.mealsBudget + ta.liveBudget) < bi.totalBill";
			total = getTotal(sql);
			sql = sql + " limit ?,?";
		}else {
			StringBuffer sql1 = new StringBuffer();
			sql1.append(
					"SELECT ta.*,(ta.mealsBudget + ta.liveBudget) totalBudget,bi.totalBill FROM taskorder ta  JOIN (SELECT SUM(bill) totalBill , b.feedbackorder FROM bill b GROUP BY b.feedbackorder  ) bi ON ta.taskid = bi.feedbackorder  WHERE  (ta.mealsBudget + ta.liveBudget) < bi.totalBill AND DATE_FORMAT(ta.leaveDate,'%Y%m') =");
			sql1.append(date);
			sql = sql1.toString();
			total = getTotal(sql);
			sql1.append(" limit ?,?");
			sql = sql1.toString();
		}
		
		//System.out.println(sql);
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
				double totalBudget = rs.getDouble("totalBudget");
				double totalBill = rs.getDouble("totalBill");
				taskOrder.setTotalBill(totalBill);
				taskOrder.setTotalBudget(totalBudget);
				taskList.add(SetTaskOrder.setTaskOrder(taskOrder));
			}
			//System.out.println(taskmap);
			
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
	//费用类型超出预警
	@Override
	public Map<String, Object> queryExceedBillTypeTask(String date, int num, int page) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<TaskOrder> taskList = new ArrayList<TaskOrder>();
		String sql = null;
		int total = 0;
		if(date==null) {
			sql = "SELECT t.*,bb.s FROM taskorder t JOIN (SELECT SUM(b.bill) s,b.feedbackorder FROM bill b WHERE b.billtype!='餐费' AND b.billtype!='住宿费' GROUP BY b.feedbackorder) bb ON bb.feedbackorder=t.taskid";
			total = getTotal(sql);
			sql = sql + " limit ?,?";
		}else {
			StringBuffer sql1 = new StringBuffer();
			sql1.append("SELECT t.*,bb.s FROM taskorder t JOIN (SELECT SUM(b.bill) s,b.feedbackorder FROM bill b WHERE b.billtype!='餐费' AND b.billtype!='住宿费' GROUP BY b.feedbackorder) bb ON bb.feedbackorder=t.taskid where DATE_FORMAT(t.leaveDate,'%Y%m') =");
			sql1.append(date);
			sql = sql1.toString();
			total = getTotal(sql);
			sql1.append(" limit ?,?");
			sql = sql1.toString();
		}
		
		//System.out.println(sql);
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
				taskOrder.setOtherBill(rs.getDouble("s"));
				taskList.add(SetTaskOrder.setTaskOrder(taskOrder));
			}
			//System.out.println(taskmap);
			
			int allpage = total / num + 1;
			map.put("allpage", allpage);
			map.put("page", page);
			map.put("total", total);
			map.put("num", num);
			map.put("rows", taskList);
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
		return map;
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
