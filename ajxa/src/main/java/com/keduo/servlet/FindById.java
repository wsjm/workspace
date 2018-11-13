package com.keduo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduo.service.iBaseService;
import com.keduo.service.iMenuService;
import com.keduo.service.iRoleService;
import com.keduo.service.iUserSrevice;
import com.keduo.serviceImp.MenuServiceImpl;
import com.keduo.serviceImp.RoleServiceImpl;
import com.keduo.serviceImp.UserServiceImpl;



/**
 * Servlet implementation class FindById 通过id 查找对应对象
 */
public class FindById extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private iMenuService menuService;
	private iUserSrevice userSrevice;
	private iRoleService roleService;

	public FindById() {
		super();
		menuService = new MenuServiceImpl();
		userSrevice = new UserServiceImpl();
		roleService = new RoleServiceImpl();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取id参数
		String id_str = request.getParameter("id");
		// 如果没有拿到 id 则返回首页
		if (id_str == null || id_str.trim().length() == 0) {
			response.sendRedirect("menusuid.do");
			return;
		}
		int id = Integer.valueOf(id_str);
		// 获取请求路径
		String path = request.getServletPath();
		String gotopage = null;
		iBaseService baseService = null;
		switch (path) {
		case "/userid.do":
			gotopage = "user/main_user.jsp";
			baseService = userSrevice;
			break;
		case "/menuid.do":
			gotopage = "menu/modify.jsp";
			baseService = menuService;
			break;
		case "/roleid.do":
			gotopage = "role/modify.jsp";
			baseService = roleService;
			break;
		}
		
		Object object = baseService.findById(id);
		request.setAttribute("obj", object);
		request.getRequestDispatcher(gotopage).forward(request, response);
	}

}
