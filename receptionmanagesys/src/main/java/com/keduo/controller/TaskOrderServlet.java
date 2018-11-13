package com.keduo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.keduo.entity.TaskOrder;
import com.keduo.service.impl.TaskOrderaddServiceImpl;

/**
 * 任务单管理
 * Servlet implementation class TaskOrderServlet
 */
public class TaskOrderServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskOrderaddServiceImpl taskOrderaddServiceImpl= new TaskOrderaddServiceImpl();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String taskid= request.getParameter("taskid");
		String task_statusId1= request.getParameter("task_statusId");
		int task_statusId= Integer.parseInt(task_statusId1);
		/*
		
	
		String VisitorOrg= request.getParameter("VisitorOrg");
		System.out.println(VisitorOrg);
		String taskname= request.getParameter("taskname");
		String VisitorDate1= request.getParameter("VisitorDate");
		
		String visittypeId1= request.getParameter("visittypeId");
		int visittypeId= Integer.parseInt(visittypeId1);
		
		String directorId1= request.getParameter("directorId");
		int directorId= Integer.parseInt(directorId1);
		String staffId1= request.getParameter("staffId");
		int staffId= Integer.parseInt(staffId1);
		
		
		
		 String leaveDate1= request.getParameter("leavaDate");
		 System.out.println(VisitorDate1);
	try {	
			Date VisitorDate = (Date) sdf.parse(VisitorDate1);
			
			 Date leaveDate;
			
				leaveDate = (Date) sdf.parse(leaveDate1);
				String inviteOrgId1= request.getParameter("inviteOrgId");
				int inviteOrgId = Integer.parseInt(inviteOrgId1);
				
				String hotel= request.getParameter("hotel");
				String mealsBudget1= request.getParameter("mealsBudget");
				Double mealsBudget= Double.parseDouble(mealsBudget1);
				String liveBudget1= request.getParameter("liveBudget");
				Double liveBudget= Double.parseDouble(liveBudget1);
				String others= request.getParameter("others");
				String officeId1= request.getParameter("officeId");
				int officeId= Integer.parseInt(officeId1);
				String director= request.getParameter("director");
				String staff= request.getParameter("staff");
				TaskOrder taskOrder=new TaskOrder();
				
				ArrayList<Object> arr= taskOrderaddServiceImpl.add(taskOrder.getTaskId(), VisitorOrg, taskname, VisitorDate, leaveDate, inviteOrgId, hotel, mealsBudget, liveBudget, others, officeId, directorId, staffId, task_statusId, visittypeId);
				//ArrayList<Object> arr= taskOrderaddServiceImpl.taskOrderAdd( taskOrder.getTaskId(), VisitorOrg, taskname, VisitorDate, leaveDate, inviteOrgId, hotel, mealsBudget, liveBudget, others, officeId,directorId,staffId,task_statusId,visittypeId);
				for (Object object2 : arr) {
					
					String string= JSONObject.toJSONString(object2);
					PrintWriter printWriter=new PrintWriter(string);
					printWriter.write(string);
					System.out.println(object2);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
	//根据任务单id查询
	
			
		
		 System.out.println("------------");*/
		
		ArrayList<Object> arrayList=  taskOrderaddServiceImpl.queryTaskOrderById(task_statusId);
		for (Object object : arrayList) {
			String string= JSONObject.toJSONString(object);
			PrintWriter printWriter=new PrintWriter(string);
			printWriter.write(string);
			System.out.println(object);
		}
	//根据任务单id删除  其中任务单的删除只有任务单的状态为草稿（task_statusId=1）
		
		if (taskOrderaddServiceImpl.deleteTaskOrderById(taskid, task_statusId)) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
		String methodName = request.getParameter("method");
		System.out.println(methodName);
		Method method;
		try {
			method = TaskOrderServlet.class.getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request,response);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void queryTaskOrderAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("===============");
		String staffId_str=request.getParameter("staffId");//接待员
		String officeId_str = request.getParameter("officeId");//承办处室
		String taskId = request.getParameter("taskId");//任务ID
		String task_status_str = request.getParameter("task_status");//任务状态
		String page_str = request.getParameter("page");
		String num_str = request.getParameter("rows");
		int num = 0;
		int page =0;
		
		if (page_str == null || page_str.trim().length() == 0) {
			page = 1;//如果页面没有传入page，则page=1当前第一页
		} else {
			page = Integer.valueOf(page_str);
		}

		if (num_str == null || num_str.trim().length() == 0) {
			num = 5;//如果页面没有传入每页每数则默认每页5条记录
		} else {
			num = Integer.valueOf(num_str);
		}
		
		TaskOrderaddServiceImpl taskOrderaddServiceImpl=new TaskOrderaddServiceImpl();
		ArrayList<Object> arrayList =  taskOrderaddServiceImpl.queryTaskOrderAll(page, num);
		System.out.println(arrayList);
		int total=arrayList.size();
		 Map map=new HashMap();
		 
		 int allpage = total / num + 1;
			map.put("allpage", allpage);
			map.put("page", page);
			map.put("total", total);
			map.put("num", num);
			map.put("rows", arrayList);
		String json = JSONObject.toJSONString(map);
		System.out.println(json);
		response.getWriter().println(json);
	}
	public static void s(int page,int num){
		TaskOrderaddServiceImpl taskOrderaddServiceImpl=new TaskOrderaddServiceImpl();
		ArrayList<Object> arrayList =  taskOrderaddServiceImpl.queryTaskOrderAll(page, num);
		System.out.println(arrayList); 
	}

}
