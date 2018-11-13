package com.keduo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.keduo.service.iMenuService;
import com.keduo.service.iPageBaseService;
import com.keduo.service.iRoleService;
import com.keduo.service.iUserSrevice;
import com.keduo.serviceImp.MenuServiceImpl;
import com.keduo.serviceImp.RoleServiceImpl;
import com.keduo.serviceImp.UserServiceImpl;


/**
 * Servlet implementation class PageServlet
 */
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private iMenuService menuService;
	private iUserSrevice userSrevice;
	private iRoleService roleService;

	public PageServlet() {
		super();
		
		menuService = new MenuServiceImpl();
		userSrevice = new UserServiceImpl();
		roleService = new RoleServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		iPageBaseService pageBaseService = null;
		// 申明要跳转的路径
		String gotopage = null;
		// 获取请求路径
		String path = request.getServletPath();
		switch (path) {
		case "/userpage.do":
			gotopage = "user/all.jsp";
			pageBaseService = userSrevice;
			break;
		case "/menupage.do":
			gotopage = "menu/all.jsp";
			pageBaseService = menuService;
			break;
		case "/rolepage.do":
			gotopage = "role/all.jsp";
			pageBaseService = roleService;
			break;
		}

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 当前页码
		String page_str = request.getParameter("page");
		// 每页多少条记录
		String num_str = request.getParameter("rows");
		System.out.println(num_str);

		int page = 0;
		int num = 0;

		if (page_str == null || page_str.trim().length() == 0) {
			page = 1;
		} else {
			page = Integer.valueOf(page_str);
		}

		if (num_str == null || num_str.trim().length() == 0) {
			num = 5;
		} else {
			num = Integer.valueOf(num_str);
		}

		Map<String, Object> map = pageBaseService.findAllPage(page, num);
		//{"num":5,"page":1,"list":[{"mid":1,"name":"登录操作","url":"login.do"},{"mid":2,"name":"查询单个用户","url":"queryuser.do"},{"mid":3,"name":"查询所有用户","url":"queryuserall.do"},{"mid":4,"name":"添加用户","url":"adduser.do"}}
		//List list= (List) map.get("list");
        //map转为json串
		String jsonString=JSONObject.toJSONString(map);
		System.out.println(jsonString);
		//total是总条数  rows是查询出来的数据
		//写回去
		PrintWriter pw=response.getWriter();
		pw.println(jsonString);

     
	}

}
