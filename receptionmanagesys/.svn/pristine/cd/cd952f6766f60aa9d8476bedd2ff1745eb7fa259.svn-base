package com.keduo.service.impl;

import java.util.Map;

import com.keduo.dao.TaskStaticsDao;
import com.keduo.dao.impl.TaskStatisDaoImpl;
import com.keduo.service.TaskStatisService;

public class TaskStatisServiceImpl implements TaskStatisService {
	@Override
	public Map<String, Object> queryOfficeReception(int year, int month, int num, int page) {
		// TODO Auto-generated method stub
		TaskStaticsDao taskStaticsDao = new TaskStatisDaoImpl();
		return taskStaticsDao.queryOfficeReception(year, month, num, page);
	}

	@Override
	public Map<String, Object> queryMonthGuestTaskList(int year, int month, int num, int page) {
		TaskStaticsDao taskStaticsDao = new TaskStatisDaoImpl();
		return taskStaticsDao.queryMonthGuestTaskList(year, month, num, page);
	}

	@Override
	public Map<String, Object> queryGuestTaskList(int year, int month, int num, int page) {
		TaskStaticsDao taskStaticsDao = new TaskStatisDaoImpl();
		return taskStaticsDao.queryGuestTaskList(year, month, num, page);
	}

	@Override
	public Map<String, Object> queryCityOfficeReception(int year, int month, int num, int page) {
		TaskStaticsDao taskStaticsDao = new TaskStatisDaoImpl();
		return taskStaticsDao.queryCityOfficeReception(year, month, num, page);
	}

	@Override
	public Map<String, Object> queryAgencyCost(int year, int month, int num, int page) {
		TaskStaticsDao taskStaticsDao = new TaskStatisDaoImpl();
		return taskStaticsDao.queryAgencyCost(year, month, num, page);
	}

	@Override
	public Map<String, Object> queryMeetingGuests(int year, int month, int num, int page) {
		TaskStaticsDao taskStaticsDao = new TaskStatisDaoImpl();
		return taskStaticsDao.queryMeetingGuests(year, month, num, page);
	}
}
