package com.keduo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.keduo.service.iUserSrevice;
import com.keduo.serviceImp.UserServiceImpl;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private iUserSrevice userSrevice;

	public LoginServlet() {
		super();
		userSrevice = new UserServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 获取请求 uri
		String path = request.getServletPath();
		if (path.trim().equals("/logout.do")) {
			// session 移除 username
			request.getSession().removeAttribute("user");
			request.setAttribute("msg", "注销成功！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		// 获取参数，用户名 密码
		String loginname = request.getParameter("uname");
		String password = request.getParameter("pwd");

		String msg = null;
		boolean flag = false;
		if (loginname == null && password == null && loginname.trim().length() == 0 && password.trim().length() == 0) {
			// 没有接收到参数的情况
			msg = "用户名、密码没有传入！";
		} else {
			try {
				Map<String, Object> map = userSrevice.login(loginname, password);
				// 登录成功
				// session 中放入 map
				System.out.println(map+"************");
				request.getSession(true).setAttribute("user", map);
				msg = "登录成功";
				flag = true;
			} catch (Exception e) {
				msg = e.getMessage();
				flag = false;
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("flag", flag);
		map.put("msg", msg);
		String json = JSONObject.toJSONString(map);
		System.out.println(json);

		PrintWriter out = response.getWriter();
		out.println(json);
	}

}
