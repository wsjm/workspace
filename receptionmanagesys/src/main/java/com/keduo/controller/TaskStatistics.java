package com.keduo.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.keduo.service.TaskQueryService;
import com.keduo.service.TaskStatisService;
import com.keduo.service.impl.TaskQueryServiceImpl;
import com.keduo.service.impl.TaskStatisServiceImpl;

/**
 * 任务统计 Servlet implementation class TaskStatistics
 */
public class TaskStatistics extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskStatistics() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String methodName = request.getParameter("method");
		Method method;
		try {
			method = com.keduo.controller.TaskStatistics.class.getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);
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

	private void queryOfficeReception(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int num;
		int year;
		int month;
		int page;
		String month_str;
		String year_str;
		String date = request.getParameter("date");
		System.out.println(date);
		String num_str = request.getParameter("rows");
		String page_str = request.getParameter("page");

		/*
		 * String month_str = date.substring(date.lastIndexOf("-")+1); String num_str =
		 * request.getParameter("rows"); String year_str = date.substring(0,
		 * date.lastIndexOf("-"));
		 */
		if (date != null) {
			month_str = date.substring(date.lastIndexOf("-") + 1);

			year_str = date.substring(0, date.lastIndexOf("-"));
		} else {
			 month_str = "0";

			 year_str = "0";
		}

		// System.out.println(year_str);
		// System.out.println(month_str);

		if (page_str == null || page_str.trim().length() == 0) {
			page = 1;// 如果页面没有传入page，则page=1当前第一页
		} else {
			page = Integer.valueOf(page_str);
		}

		if (num_str == null || num_str.trim().length() == 0) {
			num = 5;// 如果页面没有传入每页每数则默认每页5条记录
		} else {
			num = Integer.valueOf(num_str);
		}
		if (year_str == null || year_str.trim().length() == 0) {
			year = -1;
		} else {
			year = Integer.valueOf(year_str);
		}
		if (month_str == null || month_str.trim().length() == 0) {
			month = -1;
		} else {
			month = Integer.valueOf(month_str);
		}
		TaskStatisService taskStatisService = new TaskStatisServiceImpl();
		Map<String, Object> map = taskStatisService.queryOfficeReception(year, month, num, page);
		String json = JSONObject.toJSONString(map);
		response.getWriter().println(json);
		System.out.println(json);
	}

	private void queryMonthGuestTaskList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int num;
		int year;
		int month;
		int page;
		String month_str;
		String year_str;
		String date = request.getParameter("date");
		System.out.println(date);
		String num_str = request.getParameter("rows");
		String page_str = request.getParameter("page");

		/*
		 * String month_str = date.substring(date.lastIndexOf("-")+1); String num_str =
		 * request.getParameter("rows"); String year_str = date.substring(0,
		 * date.lastIndexOf("-"));
		 */
		if (date != null) {
			month_str = date.substring(date.lastIndexOf("-") + 1);

			year_str = date.substring(0, date.lastIndexOf("-"));
		} else {
			 month_str = "0";

			 year_str = "0";
		}
		
		if (page_str == null || page_str.trim().length() == 0) {
			page = 1;// 如果页面没有传入page，则page=1当前第一页
		} else {
			page = Integer.valueOf(page_str);
		}

		if (num_str == null || num_str.trim().length() == 0) {
			num = 5;// 如果页面没有传入每页每数则默认每页5条记录
		} else {
			num = Integer.valueOf(num_str);
		}
		if (year_str == null || year_str.trim().length() == 0) {
			year = -1;
		} else {
			year = Integer.valueOf(year_str);
		}
		if (month_str == null || month_str.trim().length() == 0) {
			month = -1;
		} else {
			month = Integer.valueOf(month_str);
		}
		TaskStatisService taskStatisService = new TaskStatisServiceImpl();
		Map<String, Object> map = taskStatisService.queryMonthGuestTaskList(year, month, num, page);
		String json = JSONObject.toJSONString(map);
		
		response.getWriter().println(json);
//		System.out.println(json);
		
	}

	private void queryGuestTaskList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int num;
		int year;
		int month;
		int page;
		String month_str;
		String year_str;
		String date = request.getParameter("date");
		System.out.println(date);
		String num_str = request.getParameter("rows");
		String page_str = request.getParameter("page");

		/*
		 * String month_str = date.substring(date.lastIndexOf("-")+1); String num_str =
		 * request.getParameter("rows"); String year_str = date.substring(0,
		 * date.lastIndexOf("-"));
		 */
		if (date != null) {
			month_str = date.substring(date.lastIndexOf("-") + 1);

			year_str = date.substring(0, date.lastIndexOf("-"));
		} else {
			 month_str = "0";

			 year_str = "0";
		}

		if (page_str == null || page_str.trim().length() == 0) {
			page = 1;// 如果页面没有传入page，则page=1当前第一页
		} else {
			page = Integer.valueOf(page_str);
		}

		if (num_str == null || num_str.trim().length() == 0) {
			num = 5;// 如果页面没有传入每页每数则默认每页5条记录
		} else {
			num = Integer.valueOf(num_str);
		}
		if (year_str == null || year_str.trim().length() == 0) {
			year = -1;
		} else {
			year = Integer.valueOf(year_str);
		}
		if (month_str == null || month_str.trim().length() == 0) {
			month = -1;
		} else {
			month = Integer.valueOf(month_str);
		}
		TaskStatisService taskStatisService = new TaskStatisServiceImpl();
		Map<String, Object> map = taskStatisService.queryGuestTaskList(year, month, num, page);
		String json = JSONObject.toJSONString(map);
		response.getWriter().println(json);
//		System.out.println(json);
	}

	private void queryCityOfficeReception(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int num;
		int year;
		int month;
		int page;
		String month_str;
		String year_str;
		String date = request.getParameter("date");
		System.out.println(date);
		String num_str = request.getParameter("rows");
		String page_str = request.getParameter("page");

		/*
		 * String month_str = date.substring(date.lastIndexOf("-")+1); String num_str =
		 * request.getParameter("rows"); String year_str = date.substring(0,
		 * date.lastIndexOf("-"));
		 */
		if (date != null) {
			month_str = date.substring(date.lastIndexOf("-") + 1);

			year_str = date.substring(0, date.lastIndexOf("-"));
		} else {
			 month_str = "0";

			 year_str = "0";
		}
		if (page_str == null || page_str.trim().length() == 0) {
			page = 1;// 如果页面没有传入page，则page=1当前第一页
		} else {
			page = Integer.valueOf(page_str);
		}

		if (num_str == null || num_str.trim().length() == 0) {
			num = 5;// 如果页面没有传入每页每数则默认每页5条记录
		} else {
			num = Integer.valueOf(num_str);
		}
		if (year_str == null || year_str.trim().length() == 0) {
			year = -1;
		} else {
			year = Integer.valueOf(year_str);
		}
		if (month_str == null || month_str.trim().length() == 0) {
			month = -1;
		} else {
			month = Integer.valueOf(month_str);
		}
		TaskStatisService taskStatisService = new TaskStatisServiceImpl();
		Map<String, Object> map = taskStatisService.queryCityOfficeReception(year, month, num, page);
		String json = JSONObject.toJSONString(map);
		response.getWriter().println(json);
	}

	private void queryAgencyCost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int num;
		int year;
		int month;
		int page;
		String month_str;
		String year_str;
		String date = request.getParameter("date");
		System.out.println(date);
		String num_str = request.getParameter("rows");
		String page_str = request.getParameter("page");

		/*
		 * String month_str = date.substring(date.lastIndexOf("-")+1); String num_str =
		 * request.getParameter("rows"); String year_str = date.substring(0,
		 * date.lastIndexOf("-"));
		 */
		if (date != null) {
			month_str = date.substring(date.lastIndexOf("-") + 1);

			year_str = date.substring(0, date.lastIndexOf("-"));
		} else {
			 month_str = "0";

			 year_str = "0";
		}

		if (page_str == null || page_str.trim().length() == 0) {
			page = 1;// 如果页面没有传入page，则page=1当前第一页
		} else {
			page = Integer.valueOf(page_str);
		}

		if (num_str == null || num_str.trim().length() == 0) {
			num = 5;// 如果页面没有传入每页每数则默认每页5条记录
		} else {
			num = Integer.valueOf(num_str);
		}
		if (year_str == null || year_str.trim().length() == 0) {
			year = -1;
		} else {
			year = Integer.valueOf(year_str);
		}
		if (month_str == null || month_str.trim().length() == 0) {
			month = -1;
		} else {
			month = Integer.valueOf(month_str);
		}
		TaskStatisService taskStatisService = new TaskStatisServiceImpl();
		Map<String, Object> map = taskStatisService.queryAgencyCost(year, month, num, page);
		String json = JSONObject.toJSONString(map);
		response.getWriter().println(json);
	}

	private void queryMeetingGuests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int num;
		int year;
		int month;
		int page;
		String month_str;
		String year_str;
		String date = request.getParameter("date");
		System.out.println(date);
		String num_str = request.getParameter("rows");
		String page_str = request.getParameter("page");

		/*
		 * String month_str = date.substring(date.lastIndexOf("-")+1); String num_str =
		 * request.getParameter("rows"); String year_str = date.substring(0,
		 * date.lastIndexOf("-"));
		 */
		if (date != null) {
			month_str = date.substring(date.lastIndexOf("-") + 1);

			year_str = date.substring(0, date.lastIndexOf("-"));
		} else {
			 month_str = "0";

			 year_str = "0";
		}
		if (page_str == null || page_str.trim().length() == 0) {
			page = 1;// 如果页面没有传入page，则page=1当前第一页
		} else {
			page = Integer.valueOf(page_str);
		}

		if (num_str == null || num_str.trim().length() == 0) {
			num = 5;// 如果页面没有传入每页每数则默认每页5条记录
		} else {
			num = Integer.valueOf(num_str);
		}
		if (year_str == null || year_str.trim().length() == 0) {
			year = -1;
		} else {
			year = Integer.valueOf(year_str);
		}
		if (month_str == null || month_str.trim().length() == 0) {
			month = -1;
		} else {
			month = Integer.valueOf(month_str);
		}
		TaskStatisService taskStatisService = new TaskStatisServiceImpl();
		Map<String, Object> map = taskStatisService.queryMeetingGuests(year, month, num, page);
		String json = JSONObject.toJSONString(map);
		response.getWriter().println(json);
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
