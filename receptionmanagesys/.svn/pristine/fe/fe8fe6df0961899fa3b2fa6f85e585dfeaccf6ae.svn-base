package com.keduo.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.keduo.dao.FeedbackOrderDao;
import com.keduo.dao.impl.FeedbackOrderDaoImpl;
import com.keduo.entity.Bill;
import com.keduo.entity.TaskOrder;
import com.keduo.service.FeedbackOrderService;
import com.keduo.service.TaskQueryService;
import com.keduo.service.impl.FeedbackOrderServiceImpl;
import com.keduo.service.impl.TaskOrderaddServiceImpl;
import com.keduo.service.impl.TaskQueryServiceImpl;

/**
 * 反馈单管理
 * Servlet implementation class FeedbackOrderServlet
 */
public class FeedbackOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FeedbackOrderService feedbackOrderService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackOrderServlet() {
        super();
        feedbackOrderService = new FeedbackOrderServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String methodName = request.getParameter("method");
		Method method = null;
		try {
			method = com.keduo.controller.FeedbackOrderServlet.class.getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/**
	 * 承办处室、接待处长、总值班室查询
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void queryFeedbackOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String taskid_str = request.getParameter("taskid");//任务单id
		String officeId_str = request.getParameter("officeId");//承办处室
		String inviteOrgId_str = request.getParameter("inviteOrgId");//接口机关
		String feedback_statusId_str = request.getParameter("feedback_statusId");//承办时间
		String VisitorDate_str = request.getParameter("visitorDate");//承办时间
		String leaveDate_str = request.getParameter("leaveDate");//承办时间
		String page_str = request.getParameter("page");//当前页码
		String num_str = request.getParameter("rows");//每页条数

		int num = 0;
		int page = 0;
		String taskid = null;
		int officeId = 0;
		int inviteOrgId = 0;
		int feedback_statusId = 0;
		Date VisitorDate = null;
		Date leaveDate = null;
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
		if(taskid_str == null || taskid_str.trim().length() == 0) {
			taskid = null;
		}else {
			taskid = taskid_str;
		}
		if(officeId_str == null || officeId_str.trim().length() == 0) {
			officeId = 0;
		}else {
			officeId = Integer.valueOf(officeId_str);
		}
		if(inviteOrgId_str == null || inviteOrgId_str.trim().length() == 0) {
			inviteOrgId = 0;
		}else {
			inviteOrgId = Integer.valueOf(inviteOrgId_str);
		}
		if(feedback_statusId_str == null || feedback_statusId_str.trim().length() == 0) {
			feedback_statusId = 0;
		}else {
			feedback_statusId = Integer.valueOf(feedback_statusId_str);
		}
		if (VisitorDate_str == null || VisitorDate_str.trim().length() == 0) {
			VisitorDate = null;//如果页面没有传入date，则date=null
		}else{
			VisitorDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(VisitorDate_str).getTime());
		}
		if (leaveDate_str == null || leaveDate_str.trim().length() == 0) {
			leaveDate = null;//如果页面没有传入date，则date=null
		}else{
			leaveDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(leaveDate_str).getTime());
		}
		
		System.out.println(taskid + officeId + inviteOrgId + feedback_statusId + VisitorDate + leaveDate + num +page);
				
		Map<String,Object> map = feedbackOrderService.SelectFeedbackOrder(taskid, officeId, inviteOrgId, feedback_statusId, VisitorDate, leaveDate, num, page);
		String json = JSONObject.toJSONString(map);
		//System.out.println(json);
		response.getWriter().println(json);
		
	}
	/**
	 * 承办处室、接待处长、总值班室查询
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void checkFeedbackOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String taskid_str = request.getParameter("taskid");//任务单id
		String taskname_str = request.getParameter("taskname");//任务名字
		String feedback_statusId_str = request.getParameter("feedback_statusId");//反馈单状态
		String VisitorDate_str = request.getParameter("visitorDate");//承办时间
		String leaveDate_str = request.getParameter("leaveDate");//承办时间
		String page_str = request.getParameter("page");//当前页码
		String num_str = request.getParameter("rows");//每页条数

		int num = 0;
		int page = 0;
		String taskid = null;
		String taskname = null;
		int feedback_statusId = 0;
		Date VisitorDate = null;
		Date leaveDate = null;
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
		if(taskid_str == null || taskid_str.trim().length() == 0) {
			taskid = null;
		}else {
			taskid = taskid_str;
		}
		if(taskname_str == null || taskname_str.trim().length() == 0) {
			taskname = null;
		}else {
			taskname = taskname_str;
		}
		if(feedback_statusId_str == null || feedback_statusId_str.trim().length() == 0) {
			feedback_statusId = -1;
		}else {
			feedback_statusId = Integer.valueOf(feedback_statusId_str);
		}
		if (VisitorDate_str == null || VisitorDate_str.trim().length() == 0) {
			VisitorDate = null;//如果页面没有传入date，则date=null
		}else{
			VisitorDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(VisitorDate_str).getTime());
		}
		if (leaveDate_str == null || leaveDate_str.trim().length() == 0) {
			leaveDate = null;//如果页面没有传入date，则date=null
		}else{
			leaveDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(leaveDate_str).getTime());
		}
		
		System.out.println(taskid + taskname + feedback_statusId + VisitorDate + leaveDate + num + page);
		
		Map<String,Object> map = feedbackOrderService.SelectFeedbackOrder(taskid, taskname, feedback_statusId, VisitorDate, leaveDate, num, page);
		String json = JSONObject.toJSONString(map);
		//System.out.println(json);
		response.getWriter().println(json);
		
	}
	
	private void insertFee(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		String billtype_str = request.getParameter("billtype");
		String bill_str = request.getParameter("bill");
		String billtime_str = request.getParameter("billtime");
		String shop_str = request.getParameter("shop");
		String feedbackorder_str = request.getParameter("feedbackorder");		

		String billtype = null;
		Double bill = 0.0;
		Date billtime = null;
		int shop = 0;
		String taskid = null;
		if (billtype_str == null || billtype_str.trim().length() == 0) {
			billtype = null;
		} else {
			billtype = billtype_str;
		}
		if (bill_str == null || bill_str.trim().length() == 0) {
			bill = 0.0;
		} else {
			bill = Double.valueOf(bill_str);
		}
		if (billtime_str == null || billtime_str.trim().length() == 0) {
			billtime = null;
		} else {
			billtime = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(billtime_str).getTime());
		}
		if(feedbackorder_str == null || feedbackorder_str.trim().length() == 0) {
			taskid = null;
		}else {
			taskid = feedbackorder_str;
		}
		
		System.out.println(billtype + bill + billtime + taskid);
		
		Bill Bill = new Bill();
		Bill.setBilltype(billtype);
		Bill.setBill(bill);
		Bill.setBilltime(billtime);
		Bill.setFeedbackorder(taskid);	
		
		int a = feedbackOrderService.insertFee(Bill);
		
		if (a>0) {
			
		} else {
			
		}
				
	
	}
}
