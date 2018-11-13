package com.keduo.service.impl;

import java.sql.Date;
import java.util.Map;

import com.keduo.dao.FeedbackOrderDao;
import com.keduo.dao.impl.FeedbackOrderDaoImpl;
import com.keduo.dao.impl.TaskQueryDaoImpl;
import com.keduo.entity.Bill;
import com.keduo.entity.TaskOrder;
import com.keduo.service.FeedbackOrderService;

public class FeedbackOrderServiceImpl implements FeedbackOrderService{
	FeedbackOrderDao feedbackOrderDao;
	
	public FeedbackOrderServiceImpl() {
		feedbackOrderDao = new FeedbackOrderDaoImpl();
	}
	@Override
	public Map<String, Object> SelectFeedbackOrder(String taskId, int officeId, int inviteOrgId, int feedback_statusId,
			Date visitorDate, Date leaveDate, int num, int page) {
		// TODO Auto-generated method stub
		return feedbackOrderDao.SelectFeedbackOrder(taskId, officeId, inviteOrgId, 
				feedback_statusId, visitorDate, leaveDate, num, page);
	}

	@Override
	public int UpdateFeedbackOrder(TaskOrder taskorder) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> SelectFeedbackOrder(String taskId, String taskname, int officeId, int feedback_status,
			Date visitorDate, Date leaveDate, int num, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertFee(Bill bill) {
		// TODO Auto-generated method stub
		return feedbackOrderDao.insertFee(bill);
	}

	@Override
	public Map<String, Object> SelectFeedbackOrder(String taskId, String taskname, int feedback_statusId,
			Date visitorDate, Date leaveDate, int num, int page) {
		
		return feedbackOrderDao.SelectFeedbackOrder(taskId, taskname, feedback_statusId, visitorDate, leaveDate, num, page);
	}

	@Override
	public int CheckFeedbackOrder(TaskOrder taskorder) {
		// TODO Auto-generated method stub
		return 0;
	}

}
