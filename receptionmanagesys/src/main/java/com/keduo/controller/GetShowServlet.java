package com.keduo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.keduo.entity.User;
import com.keduo.service.GetShowService;
import com.keduo.service.impl.GetShowServiceImpl;

/**
 * Servlet implementation class GetShowServlet
 */
public class GetShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GetShowService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetShowServlet() {
		super();
		service = new GetShowServiceImpl();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		// 获取所有机关
		if (path.trim().equals("/getInviteOrg")) {
			List list = service.getInviteOrg();
			String json = JSONObject.toJSONString(list);
			// System.out.println(json);
			response.getWriter().println(json);
			return;
		}
		// 获取所有来访形式
		if (path.trim().equals("/getVisittypeId")) {
			List list = service.getVisittypeId();
			String json = JSONObject.toJSONString(list);
			response.getWriter().println(json);
			return;
		}
		// 获取所有处室
		if (path.trim().equals("/getOfficeId")) {
			System.out.println("getofficeid");
			List list = service.getOffice();
			String json = JSONObject.toJSONString(list);
			response.getWriter().println(json);
			return;
		}
		
		// 获取所有接待员
		if (path.trim().equals("/getStaff")) {
			//System.out.println("getstaff");
			List list = service.getStaff();
			String json = JSONObject.toJSONString(list);
			response.getWriter().println(json);
			return;
		}
		// 根据接待员获取承办处室
		if (path.trim().equals("/getOfficeByStaffId")) {
			//System.out.println("getOfficeByStaffId");
			String staffId = request.getParameter("staffId");
			//System.out.println("staffId" + "==" + staffId);
			List list = service.getOfficeByStaffId(staffId);
			String json = JSONObject.toJSONString(list);
			response.getWriter().println(json);
			return;
		}

		// 根据承办处室获取接待员
		if (path.trim().equals("/getStaffByOfficeId")) {
			//System.out.println("getStaffByOfficeId");
			String officeId = request.getParameter("officeId");
			//System.out.println("officeId=" + officeId);
			List list = service.getStaffByOfficeId(officeId);
			String json = JSONObject.toJSONString(list);
			response.getWriter().println(json);
			return;
		}
		// 获取所有承办处室
		if (path.trim().equals("/getOffice")) {
			//System.out.println("getoffice");
			List list = service.getOffice();
			String json = JSONObject.toJSONString(list);
			response.getWriter().println(json);
			return;
		}
		// 获取所有任务状态
		if (path.trim().equals("/getTask_status")) {
			List list = service.getTask_status();
			String json = JSONObject.toJSONString(list);
			response.getWriter().println(json);
			return;
		}
		// 获取所有反馈状态
		if (path.trim().equals("/getFeedback_status")) {
			int roleId = 0;
			User user = (User) request.getSession().getAttribute("user");
			roleId = user.getRid();
			List list = service.getFeedback_status(roleId);
			String json = JSONObject.toJSONString(list);
			response.getWriter().println(json);
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
