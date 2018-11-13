package com.keduo.service.impl;

import java.sql.Date;
import java.util.Map;

import com.keduo.dao.TaskQueryDao;
import com.keduo.dao.TaskStaticsDao;
import com.keduo.dao.impl.TaskQueryDaoImpl;
import com.keduo.dao.impl.TaskStatisDaoImpl;
import com.keduo.service.TaskQueryService;

public class TaskQueryServiceImpl implements TaskQueryService {
	TaskQueryDao taskQueryDao;

	public TaskQueryServiceImpl() {
		taskQueryDao = new TaskQueryDaoImpl();
	}

	@Override
	public Map<String, Object> queryInviteOrg(Date date, int org, int visittypeId, int num, int page) {

		return taskQueryDao.queryInviteOrg(date, org, visittypeId, num, page);
	}

	@Override
	public Map<String, Object> queryDept(int staffId, int officeId, String taskId, int task_statusId, int num,
			int page) {
		// TODO Auto-generated method stub
		return taskQueryDao.queryDept(staffId, officeId, taskId, task_statusId, num, page);
	}

	@Override
	public Map<String, Object> queryBill(Date date, int org, int num, int page) {
		// TODO Auto-generated method stub
		return taskQueryDao.queryBill(date, org, num, page);
	}

	@Override
	public Map<String, Object> queryUnclosedTask(int num, int page) {
		// TODO Auto-generated method stub
		return taskQueryDao.queryUnclosedTask(num, page);
	}

	@Override
	public Map<String, Object> queryOverspendTask(String date, int num, int page) {
		// TODO Auto-generated method stub
		return taskQueryDao.queryOverspendTask(date, num, page);
	}

	@Override
	public Map<String, Object> queryExceedBillTypeTask(String date, int num, int page) {
		// TODO Auto-generated method stub
		return taskQueryDao.queryExceedBillTypeTask(date, num, page);
	}

	

}
