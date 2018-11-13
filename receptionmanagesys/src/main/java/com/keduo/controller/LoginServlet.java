package com.keduo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.keduo.entity.User;
import com.keduo.exception.LoginnameWrongException;
import com.keduo.exception.PasswordWrongException;
import com.keduo.service.iUserService;
import com.keduo.service.impl.UserServiceImpl;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private iUserService userSrevice;

	public LoginServlet() {
		super();
		userSrevice = new UserServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		boolean flag = false;
		String msg = null;
		if (loginname == null && password == null && loginname.trim().length()==0
				&& password.trim().length()==0) {
			//没有接收到参数的情况
			msg =  "用户名、密码没有传入！";
			flag=false;
		}else {
			try {
				User user = userSrevice.login(loginname, password);
				// 登录成功
				// session 中放入user
				request.getSession().setAttribute("user", user);
				flag=true;
			} catch ( LoginnameWrongException | PasswordWrongException e) {
				msg = e.getMessage();
				flag=false;
			} 
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("flag", flag);
		map.put("msg", msg);
		
		String json=JSONObject.toJSONString(map);
		//System.out.println(json);
		response.getWriter().println(json);
		
				
	}

}
