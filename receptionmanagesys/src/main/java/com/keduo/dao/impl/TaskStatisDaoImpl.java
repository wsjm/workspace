package com.keduo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.keduo.dao.TaskStaticsDao;
import com.keduo.entity.TaskOrder;
import com.keduo.util.DBUtil;
import com.keduo.util.SetTaskOrder;

public class TaskStatisDaoImpl implements TaskStaticsDao {

	@Override
	public Map<String, Object> queryOfficeReception(int year, int month, int num, int page) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<TaskOrder> taskList = new ArrayList<TaskOrder>();
		String sql = null;
		StringBuffer sql1 = new StringBuffer();
		String date = null;
		if (month < 10) {
			date = year + "0" + month;
		} else {
			date = year + "" + month;
		}
		sql1.append(
				"SELECT taskId,VisitorOrg,VisitorNum,VisitorDate,leaveDate,inviteOrgId,hotel,mealsBudget,liveBudget,officeId,staffId FROM taskorder t WHERE DATE_FORMAT(t.VisitorDate,'%Y%m') =");
		sql1.append(date);
		sql1.append(" limit ?,?");
		sql = sql1.toString();
//		System.out.println(sql);
		try {
			int count = 0;
			con = DBUtil.getconnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, (page - 1) * num);
			pstm.setInt(2, num);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TaskOrder taskOrder = new TaskOrder();
				taskOrder.setTaskId(rs.getString("taskId"));
				taskOrder.setVisitorOrg(rs.getString("VisitorOrg"));
				taskOrder.setVisitorNum(rs.getInt("VisitorNum"));
				taskOrder.setVisitorDate(rs.getDate("VisitorDate"));
				taskOrder.setInviteOrgId(rs.getInt("inviteOrgId"));
				taskOrder.setLeaveDate(rs.getDate("leaveDate"));
				taskOrder.setHotel(rs.getString("hotel"));
				taskOrder.setMealsBudget(rs.getDouble("mealsBudget"));
				taskOrder.setLiveBudget(rs.getDouble("liveBudget"));
				taskOrder.setOfficeId(rs.getInt("officeId"));
				taskOrder.setStaffId(rs.getInt("staffId"));
//				System.out.println(taskOrder);
				taskList.add(SetTaskOrder.setTaskOrder(taskOrder));
			}
//			 System.out.println(taskList);
			int total = taskList.size();
			int allpage = total / num + 1;
			map.put("count", count);// 具体批次
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
	public Map<String, Object> queryMonthGuestTaskList(int year, int month, int num, int page) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<TaskOrder> taskList = new ArrayList<TaskOrder>();
		String sql = null;
		StringBuffer sql1 = new StringBuffer();
		String date = null;
		if (month < 10) {
			date = year + "0" + month;
		} else {
			date = year + "" + month;
		}
		sql1.append(
				"SELECT taskId,VisitorOrg,VisitorNum,VisitorDate,leaveDate,visittypeId,inviteOrgId,hotel,mealsBudget,liveBudget,staffId FROM taskorder t WHERE DATE_FORMAT(t.VisitorDate,'%Y%m') =");
		sql1.append(date);
		sql1.append(" limit ?,?");
		sql = sql1.toString();
		// System.out.println(sql);
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, (page - 1) * num);
			pstm.setInt(2, num);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TaskOrder taskOrder = new TaskOrder();
				taskOrder.setTaskId(rs.getString("taskId"));
				taskOrder.setVisitorOrg(rs.getString("VisitorOrg"));
				taskOrder.setVisitorNum(rs.getInt("VisitorNum"));
				taskOrder.setVisitorDate(rs.getDate("VisitorDate"));
				taskOrder.setVisittypeId(rs.getInt("visittypeId"));
				taskOrder.setInviteOrgId(rs.getInt("inviteOrgId"));
				taskOrder.setLeaveDate(rs.getDate("leaveDate"));
				taskOrder.setHotel(rs.getString("hotel"));
				taskOrder.setStaffId(rs.getInt("staffId"));

				taskList.add(SetTaskOrder.setTaskOrder(taskOrder));
			}
			System.out.println(taskList);
			System.out.println("----------------------------");
			int total = taskList.size();
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
	public Map<String, Object> queryGuestTaskList(int year, int month, int num, int page) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<TaskOrder> taskList = new ArrayList<TaskOrder>();
		String sql = null;
		StringBuffer sql1 = new StringBuffer();
		String date = null;
		if (month < 10) {
			date = year + "0" + month;
		} else {
			date = year + "" + month;
		}
		sql1.append(
				"SELECT VisitorOrg,VisitorDate,taskId,VisitorNum,hotel,inviteOrgId,officeId,staffId FROM taskorder t WHERE DATE_FORMAT(t.VisitorDate,'%Y%m') =");
		sql1.append(date);
		sql1.append(" limit ?,?");
		sql = sql1.toString();
		// System.out.println(sql);
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, (page - 1) * num);
			pstm.setInt(2, num);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TaskOrder taskOrder = new TaskOrder();
				taskOrder.setVisitorOrg(rs.getString("VisitorOrg"));
				taskOrder.setVisitorDate(rs.getDate("VisitorDate"));
				taskOrder.setVisitorNum(rs.getInt("VisitorNum"));
				taskOrder.setHotel(rs.getString("hotel"));
				taskOrder.setInviteOrgId(rs.getInt("inviteOrgId"));
				taskOrder.setOfficeId(rs.getInt("officeId"));
				taskOrder.setStaffId(rs.getInt("staffId"));
				taskOrder.setTaskId(rs.getString("taskId"));

				taskList.add(SetTaskOrder.setTaskOrder(taskOrder));
			}
			// System.out.println(taskList);
			int total = taskList.size();
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
	public Map<String, Object> queryCityOfficeReception(int year, int month, int num, int page) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<TaskOrder> taskList = new ArrayList<TaskOrder>();
		String sql = null;
		StringBuffer sql1 = new StringBuffer();
		String date = null;
		if (month < 10) {
			date = year + "0" + month;
		} else {
			date = year + "" + month;
		}

		sql1.append(
				"SELECT taskId,VisitorOrg,VisitorNum,VisitorDate,leaveDate,inviteOrgId,hotel,mealsBudget,liveBudget,officeId,staffId FROM taskorder t WHERE  DATE_FORMAT(t.VisitorDate,'%Y%m') =");
		sql1.append(date);

		sql1.append(" limit ?,?");

		sql = sql1.toString();
		// System.out.println(sql);
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, (page - 1) * num);
			pstm.setInt(2, num);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TaskOrder taskOrder = new TaskOrder();
				taskOrder.setTaskId(rs.getString("taskId"));
				taskOrder.setVisitorOrg(rs.getString("VisitorOrg"));
				taskOrder.setVisitorNum(rs.getInt("VisitorNum"));
				taskOrder.setVisitorDate(rs.getDate("VisitorDate"));
				taskOrder.setInviteOrgId(rs.getInt("inviteOrgId"));
				taskOrder.setHotel(rs.getString("hotel"));
				taskOrder.setOfficeId(rs.getInt("officeId"));
				taskOrder.setStaffId(rs.getInt("staffId"));

				taskList.add(SetTaskOrder.setTaskOrder(taskOrder));
			}
			// System.out.println(taskList);
			int total = taskList.size();
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
	public Map<String, Object> queryAgencyCost(int year, int month, int num, int page) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<TaskOrder> taskList = new ArrayList<TaskOrder>();
		String sql = null;
		StringBuffer sql1 = new StringBuffer();
		String date = null;
		if (month < 10) {
			date = year + "0" + month;
		} else {
			date = year + "" + month;
		}
		sql1.append(
				"SELECT VisitorNum,inviteOrgId,hotel,mealsBudget,liveBudget,officeId,VisitorOrg FROM taskorder t WHERE DATE_FORMAT(t.VisitorDate,'%Y%m') =");
		sql1.append(date);
		sql1.append(" limit ?,?");
		sql = sql1.toString();
		// System.out.println(sql);
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, (page - 1) * num);
			pstm.setInt(2, num);
			rs = pstm.executeQuery();
			TaskOrder taskOrder1 = new TaskOrder();
			TaskOrder taskOrder2 = new TaskOrder();
			TaskOrder taskOrder3 = new TaskOrder();
			while (rs.next()) {
				if (rs.getInt("inviteOrgId") == 12) {
					taskOrder1.setInviteOrgId(rs.getInt("inviteOrgId"));
					taskOrder1.setVisitorOrg(rs.getString("VisitorOrg"));
					taskOrder1.setHotel(rs.getString("hotel"));
					taskOrder1.setVisitorNum(rs.getInt("VisitorNum"));
					taskOrder1.setMealsBudget(
							rs.getInt("VisitorNum") * rs.getDouble("mealsBudget") + taskOrder1.getMealsBudget());
					taskOrder1.setLiveBudget(
							rs.getInt("VisitorNum") * rs.getDouble("liveBudget") + taskOrder1.getLiveBudget());
					taskOrder1.setOfficeId(rs.getInt("officeId"));
					taskList.add(SetTaskOrder.setTaskOrder(taskOrder1));
				} else if (rs.getInt("inviteOrgId") == 13) {
					taskOrder2.setInviteOrgId(rs.getInt("inviteOrgId"));
					taskOrder2.setVisitorOrg(rs.getString("VisitorOrg"));
					taskOrder2.setHotel(rs.getString("hotel"));
					taskOrder2.setVisitorNum(rs.getInt("VisitorNum"));
					taskOrder2.setMealsBudget(
							rs.getInt("VisitorNum") * rs.getDouble("mealsBudget") + taskOrder1.getMealsBudget());
					taskOrder2.setLiveBudget(
							rs.getInt("VisitorNum") * rs.getDouble("liveBudget") + taskOrder1.getLiveBudget());
					taskOrder2.setOfficeId(rs.getInt("officeId"));
					taskList.add(SetTaskOrder.setTaskOrder(taskOrder2));
				} else if (rs.getInt("inviteOrgId") == 14) {
					taskOrder3.setInviteOrgId(rs.getInt("inviteOrgId"));
					taskOrder3.setVisitorOrg(rs.getString("VisitorOrg"));
					taskOrder3.setHotel(rs.getString("hotel"));
					taskOrder3.setVisitorNum(rs.getInt("VisitorNum"));
					taskOrder3.setMealsBudget(
							rs.getInt("VisitorNum") * rs.getDouble("mealsBudget") + taskOrder1.getMealsBudget());
					taskOrder3.setLiveBudget(
							rs.getInt("VisitorNum") * rs.getDouble("liveBudget") + taskOrder1.getLiveBudget());
					taskOrder3.setOfficeId(rs.getInt("officeId"));
					taskList.add(SetTaskOrder.setTaskOrder(taskOrder3));
				}

			}
			// System.out.println(taskList);
			int total = taskList.size();
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
	public Map<String, Object> queryMeetingGuests(int year, int month, int num, int page) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<TaskOrder> taskList = new ArrayList<TaskOrder>();
		String sql = null;
		StringBuffer sql1 = new StringBuffer();
		String date = null;
		if (month < 10) {
			date = year + "0" + month;
		} else {
			date = year + "" + month;
		}
		// 将数据查出循环里++最后放入map集合
		sql1.append(
				"SELECT inviteOrgId,VisitorDate,hotel,officeId,staffId,VisitorNum,mealsBudget,VisitorOrg,liveBudget FROM taskorder t WHERE DATE_FORMAT (t.leaveDate,'%Y%m') =");
		sql1.append(date);
		sql1.append(" limit ?,?");
		sql = sql1.toString();
		 System.out.println(sql);
		try {
			con = DBUtil.getconnection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, (page - 1) * num);
			pstm.setInt(2, num);
			rs = pstm.executeQuery();
			int count1=0;
			int count2=0;
			int count3=0;
			TaskOrder taskOrder1 = new TaskOrder();
			TaskOrder taskOrder2 = new TaskOrder();
			TaskOrder taskOrder3 = new TaskOrder();
			while (rs.next()) {
				if (rs.getInt("inviteOrgId") == 12) {
					count1++;
					taskOrder1.setInviteOrgId(rs.getInt("inviteOrgId"));
					taskOrder1.setVisitorOrg(rs.getString("VisitorOrg"));
					taskOrder1.setHotel(rs.getString("hotel"));
					taskOrder1.setVisitorNum(rs.getInt("VisitorNum"));
					taskOrder1.setMealsBudget(
							rs.getInt("VisitorNum") * rs.getDouble("mealsBudget") + taskOrder1.getMealsBudget()+rs.getInt("VisitorNum") * rs.getDouble("liveBudget") );
					
					taskOrder1.setOfficeId(rs.getInt("officeId"));
					
					taskOrder1.setCount(count1);
					taskList.add(SetTaskOrder.setTaskOrder(taskOrder1));
				} else if (rs.getInt("inviteOrgId") == 13) {
					count2++;
					taskOrder2.setInviteOrgId(rs.getInt("inviteOrgId"));
					taskOrder2.setVisitorOrg(rs.getString("VisitorOrg"));
					taskOrder2.setHotel(rs.getString("hotel"));
					taskOrder2.setVisitorNum(rs.getInt("VisitorNum"));
					taskOrder2.setMealsBudget(
							rs.getInt("VisitorNum") * rs.getDouble("mealsBudget") + taskOrder1.getMealsBudget()+rs.getInt("VisitorNum") * rs.getDouble("liveBudget"));
					
					taskOrder2.setOfficeId(rs.getInt("officeId"));
					
					taskOrder2.setCount(count2);
					taskList.add(SetTaskOrder.setTaskOrder(taskOrder2));
				} else if (rs.getInt("inviteOrgId") == 14) {
					count3++;
					taskOrder3.setInviteOrgId(rs.getInt("inviteOrgId"));
					taskOrder3.setVisitorOrg(rs.getString("VisitorOrg"));
					taskOrder3.setHotel(rs.getString("hotel"));
					taskOrder3.setVisitorNum(rs.getInt("VisitorNum"));
					taskOrder3.setMealsBudget(
							rs.getInt("VisitorNum") * rs.getDouble("mealsBudget") + taskOrder1.getMealsBudget()+rs.getInt("VisitorNum") * rs.getDouble("liveBudget"));
					taskOrder3.setOfficeId(rs.getInt("officeId"));
				
					taskOrder3.setCount(count3);
					taskList.add(SetTaskOrder.setTaskOrder(taskOrder3));
				}

			}
			// System.out.println(taskList);
			int total = taskList.size();
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
}
