package com.keduo.dao;


import java.util.ArrayList;
import java.sql.Date;
import java.util.Map;

import com.keduo.entity.TaskOrder;
import com.mysql.fabric.xmlrpc.base.Data;

public interface TaskOrderDao{
	//添加任务单
	ArrayList<Object> add(String taskId,String VisitorOrg,String taskname,Date VisitorDate,Date leaveDate,int inviteOrgId,String hotel,double mealsBudget,double liveBudget,
			String others,int officeId,int directorId,int staffId,int task_statusId,int visittypeId);
	//根据任务单id查询
	ArrayList<Object> queryTaskOrderById(int task_statusId);
	
	//根据任务单VisitorOrg查询
	ArrayList<Object> queryTaskOrderByName(String VisitorOrg);
	//查询所有
	ArrayList<Object> queryTaskOrderAll(int page,int num);
	//根据任务单id修改(相当于被驳回后的修改)
	ArrayList<Object> updateTaskOrderById(String taskId, String VisitorOrg,String taskname,Date VisitorDate,Date leaveDate,int inviteOrgId,String hotel,double mealsBudget,double liveBudget,
			String others,int officeId,int directorId,int staffId,int task_statusId,int visittypeId);
	
	//
	
	//删除任务单
	boolean deleteTaskOrderById(String taskId,int task_statusId);
	//审核驳回？1：审查通过0：驳回（审核失败）
	int TaskOrder(int task_statusId);
	//来宾访问
}
