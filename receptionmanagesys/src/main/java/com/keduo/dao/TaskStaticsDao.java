package com.keduo.dao;

import java.util.Map;

public interface TaskStaticsDao {
//	接待办公室接待情况统计表，
	Map<String,Object> queryOfficeReception(int year, int month, int num, int page);
//	来宾月报表，
	Map<String,Object> queryMonthGuestTaskList(int year, int month, int num, int page);
// 	部门来宾情况统计表，
	Map<String,Object> queryGuestTaskList(int year, int month, int num, int page);
//	市接待办公室接待任务通报，
	Map<String,Object> queryCityOfficeReception(int year, int month, int num, int page);
//	各机关费用明细月报表
	Map<String,Object> queryAgencyCost(int year, int month, int num, int page);
//	部门、党政考察团及会议宾客统计表
	Map<String,Object> queryMeetingGuests(int year, int month, int num, int page);
}
