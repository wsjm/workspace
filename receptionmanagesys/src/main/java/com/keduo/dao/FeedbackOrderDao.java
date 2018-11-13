package com.keduo.dao;

import java.sql.Date;
import java.util.Map;

import com.keduo.entity.Bill;
import com.keduo.entity.Role;
import com.keduo.entity.TaskOrder;

public interface FeedbackOrderDao extends BaseDao<TaskOrder>{
	//维护--任务反馈单查询
	Map<String,Object> SelectFeedbackOrder(String taskId, int officeId, int inviteOrgId, int feedback_statusId,
			Date visitorDate, Date leaveDate, int num, int page);
	//任务反馈单修改
	int UpdateFeedbackOrder(TaskOrder taskorder);
	
	//费用录入--任务反馈单查询
	Map<String,Object> SelectFeedbackOrder(String taskId, String taskname, int officeId, int feedback_status,
			Date visitorDate, Date leaveDate, int num, int page);
	//费用录入
	int insertFee(Bill bill);
	
	//审核复核--任务反馈单查询
	Map<String,Object> SelectFeedbackOrder(String taskId, String taskname, int feedback_statusId,
			Date visitorDate, Date leaveDate, int num, int page);
	//承办处室处长、接待主任审核、总值班室复核
	int CheckFeedbackOrder(TaskOrder taskorder);
	
}
