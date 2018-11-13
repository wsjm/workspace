package com.keduo.service.impl;


import java.util.ArrayList;
import java.sql.Date;

import com.keduo.dao.TaskOrderDao;
import com.keduo.dao.impl.TaskOrderDaoImpl;
import com.keduo.dao.impl.TaskQueryDaoImpl;
import com.keduo.service.TaskOrderaddService;

public class TaskOrderaddServiceImpl implements TaskOrderaddService{

	

	@Override
	public ArrayList<Object> queryTaskOrderById(int task_statusId) {
		TaskOrderDaoImpl taskOrderDaoImpl=new TaskOrderDaoImpl();
		
		return taskOrderDaoImpl.queryTaskOrderById(task_statusId);
	}

	@Override
	public ArrayList<Object> queryTaskOrderByName(String VisitorOrg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Object> queryTaskOrderAll(int page, int num) {
		TaskOrderDaoImpl taskOrderDaoImpl=new TaskOrderDaoImpl();
		return taskOrderDaoImpl.queryTaskOrderAll(page, num);
		 
	}

	

	@Override
	public boolean deleteTaskOrderById(String taskId, int task_statusId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int TaskOrder(int task_statusId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Object> add(String taskId, String VisitorOrg, String taskname, Date VisitorDate, Date leaveDate,
			int inviteOrgId, String hotel, double mealsBudget, double liveBudget, String others, int officeId,
			int directorId, int staffId, int task_statusId, int visittypeId) {
		TaskOrderDaoImpl taskOrderDaoImpl=new TaskOrderDaoImpl();
		return taskOrderDaoImpl.add(taskId, VisitorOrg, taskname, VisitorDate, leaveDate, inviteOrgId, hotel, mealsBudget, liveBudget, others, officeId, directorId, staffId, task_statusId, visittypeId);
	}

	@Override
	public ArrayList<Object> updateTaskOrderById(String taskId, String VisitorOrg, String taskname, Date VisitorDate,
			Date leaveDate, int inviteOrgId, String hotel, double mealsBudget, double liveBudget, String others,
			int officeId, int directorId, int staffId, int task_statusId, int visittypeId) {
		
		return null;
		
	}



	

	

	

}
