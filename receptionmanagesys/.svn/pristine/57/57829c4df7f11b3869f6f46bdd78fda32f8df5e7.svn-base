package com.keduo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.keduo.entity.TaskOrder;
import com.keduo.service.impl.TaskOrderaddServiceImpl;

public class InsertTaskOrder extends HttpServlet{
	
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
	TaskOrderaddServiceImpl taskOrderaddServiceImpl= new TaskOrderaddServiceImpl();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	String taskid= request.getParameter("taskid");

	String VisitorOrg= request.getParameter("VisitorOrg");
	System.out.println(VisitorOrg);
	String taskname= request.getParameter("taskname");
	String VisitorDate1= request.getParameter("VisitorDate");
	String task_statusId1= request.getParameter("task_statusId");
	int task_statusId= Integer.parseInt(task_statusId1);
	String visittypeId1= request.getParameter("visittypeId");
	int visittypeId= Integer.parseInt(visittypeId1);
	
	String directorId1= request.getParameter("directorId");
	//int directorId= Integer.parseInt(directorId1);
	String staffId1= request.getParameter("staffId");
	//int staffId= Integer.parseInt(staffId1);

   

	String leaveDate1= request.getParameter("leaveDate");
	//String leaveDate=SFDate.format(leaveDate1);
	// Date date = (Date) sdf.parse(leaveDate1);
	System.out.println(leaveDate1);
	System.out.println(VisitorDate1);
	
	java.util.Date leaveDate2 = null;
	java.sql.Date leaveDate3 = null;
		try {
			
			leaveDate2=new java.util.Date(sdf.parse(leaveDate1).getTime());
            leaveDate3=new java.sql.Date(leaveDate2.getTime());
           /* java.sql.Date sqlDate1 = new java.sql.Date(date.getTime());
            System.out.println(sqlDate1);
            java.util.Date utilDate1 = new java.util.Date(sqlDate1.getTime());*/
           
      
           // System.out.println(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		 System.out.println(leaveDate3);
	
		
		String VisitorDate2= request.getParameter("VisitorDate");
		//String VisitorDate=SFDate.format(VisitorDate2);
		java.util.Date VisitorDate3= null;
		java.sql.Date VisitorDate4=null;
		try {
			
			  VisitorDate3=new java.util.Date(sdf.parse(VisitorDate2).getTime());
			   VisitorDate4=new java.sql.Date(VisitorDate3.getTime());
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(VisitorDate4);
			String inviteOrgId1= request.getParameter("inviteOrgId");
			int inviteOrgId = Integer.parseInt(inviteOrgId1);
			
			String hotel= request.getParameter("hotel");
			String mealsBudget1= request.getParameter("mealsBudget");
			double mealsBudget= Double.parseDouble(mealsBudget1);
			String liveBudget1= request.getParameter("liveBudget");
			double liveBudget= Double.parseDouble(liveBudget1);
			String others= request.getParameter("others");
			String officeId1= request.getParameter("officeId");
			int officeId= Integer.parseInt(officeId1);
			String director= request.getParameter("directorId");
			int directorId= Integer.parseInt(director);
			String staff= request.getParameter("staffId");
			System.out.println(staff);
			int staffId= Integer.parseInt(staff);
			TaskOrder taskOrder=new TaskOrder();
			
			
			//ArrayList<Object> arr=taskOrderaddServiceImpl.add(taskOrder.getTaskId(), VisitorOrg, taskname, VisitorDate3, leaveDate2, inviteOrgId, hotel, mealsBudget, liveBudget, others, officeId, directorId, staffId, task_statusId, visittypeId);
			ArrayList<Object> arr=taskOrderaddServiceImpl.add(taskOrder.getTaskId(), VisitorOrg, taskname, VisitorDate4, leaveDate3, inviteOrgId, hotel, mealsBudget, liveBudget, others, officeId, directorId, staffId, task_statusId, visittypeId);
			
			//ArrayList<Object> arr= taskOrderaddServiceImpl.taskOrderAdd( taskOrder.getTaskId(), VisitorOrg, taskname, VisitorDate, leaveDate, inviteOrgId, hotel, mealsBudget, liveBudget, others, officeId,directorId,staffId,task_statusId,visittypeId);
			/*for (Object object2 : arr) {
				
				String string= JSONObject.toJSONString(object2);
				PrintWriter printWriter=new PrintWriter(string);
				printWriter.write(string);
				System.out.println(object2);
			}*/
			/*String arr1=JSONObject.toJSONString(arr);
			PrintWriter printWriter=new PrintWriter(arr1);
			printWriter.write(arr1);*/
			
		} 
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
