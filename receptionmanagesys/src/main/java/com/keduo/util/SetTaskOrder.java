package com.keduo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.keduo.dao.UtilDao;
import com.keduo.dao.impl.UtilDaoImpl;
import com.keduo.entity.Bill;
import com.keduo.entity.TaskOrder;

/**
 * 将TaskOrder里面的外键全部处理掉
 * @author ztz
 *
 */
public class SetTaskOrder {
	public static TaskOrder setTaskOrder(TaskOrder taskOrder) {
		UtilDao u = new UtilDaoImpl();
		int inviteOrgId = taskOrder.getInviteOrgId();
		int officeId = taskOrder.getOfficeId();
		int directorId = taskOrder.getDirectorId();
		int staffId = taskOrder.getStaffId();
		int task_statusId = taskOrder.getTask_statusId();
		int visittypeId = taskOrder.getVisittypeId();
		int feedback_statusId = taskOrder.getFeedback_statusId();
		String taskId = taskOrder.getTaskId();
		Date visitorDate =taskOrder.getVisitorDate();
		Date leaveDate = taskOrder.getLeaveDate();
		Date feedbacksubmittime = taskOrder.getFeedbacksubmittime();
		if(inviteOrgId>0) {
			String inviteOrg=u.getInviteOrg(inviteOrgId);		//存储归属机关
			taskOrder.setInviteOrg(inviteOrg);
		}
		if(officeId>0) {
			String office=u.getOffice(officeId);		//存储承办处室
			taskOrder.setOffice(office);
		}
		if(directorId>0) {
			String director=u.getDirector(directorId);			//存储处长
			taskOrder.setDirector(director);
		}
		if(staffId>0) {
			String staff=u.getStaff(staffId);			//存储接待员
			taskOrder.setStaff(staff);
		}
		if(task_statusId>0) {
			String task_status=u.getTask_status(task_statusId);		//存储任务状态
			taskOrder.setTask_status(task_status);
		}
		if(visittypeId>0) {
			String visittype=u.getVisittype(visittypeId);		//存储访问形式
			taskOrder.setVisittype(visittype);
		}
		if(feedback_statusId>0) {
			String feedback_status=u.getFeedback_status(feedback_statusId);	//存储反馈单状态
			taskOrder.setFeedback_status(feedback_status);
		}
		if(taskOrder.getTask_statusId()>=4) {
			List<Bill> billList = u.getBills(taskId);
			double mealsBill=0;
			double liveBill=0;
			double otherBill=0;
			double totalBill=0;
			for (Bill bill : billList) {
				String billType = bill.getBilltype();
				double b = bill.getBill();
				totalBill+=b;
				if("餐费".equals(billType)) {
					mealsBill+=b;
					continue;
				}
				if("住宿费".equals(billType)) {
					liveBill += b;
					continue;
				}
				otherBill+=b;						
			}
			taskOrder.setMealsBill(mealsBill);
			taskOrder.setLiveBill(liveBill);
			taskOrder.setOtherBill(otherBill);
			taskOrder.setTotalBill(totalBill);
		}
		
		if(visitorDate !=null) {
			String visitorDate_str = new SimpleDateFormat("yyyy年MM月dd日").format(visitorDate);
			taskOrder.setVisitorDate_str(visitorDate_str);
		}
		if(leaveDate!=null) {
			String leaveDate_str = new SimpleDateFormat("yyyy年MM月dd日").format(leaveDate);
			taskOrder.setLeaveDate_str(leaveDate_str);
		}
		if(feedbacksubmittime!=null) {
			String feedbacksubmittime_str = new SimpleDateFormat("yyyy年MM月dd日").format(feedbacksubmittime);
			taskOrder.setFeedbacksubmittime_str(feedbacksubmittime_str);
		}		
		return taskOrder;
		
	}
}
