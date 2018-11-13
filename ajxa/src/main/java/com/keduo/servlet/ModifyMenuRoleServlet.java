package com.keduo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduo.entity.Menu;
import com.keduo.entity.Role;
import com.keduo.service.iBaseService;
import com.keduo.service.iMenuService;
import com.keduo.service.iRoleService;
import com.keduo.serviceImp.MenuServiceImpl;
import com.keduo.serviceImp.RoleServiceImpl;



/**
 * Servlet implementation class ModifyMenuRoleServlet
 */
public class ModifyMenuRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private iMenuService menuService;
	private iRoleService roleService;

	public ModifyMenuRoleServlet() {
		super();
		menuService = new MenuServiceImpl();
		roleService = new RoleServiceImpl();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求路径
		String path = request.getServletPath();
		String gotopage = null;
		iBaseService baseService = null;
		Object obj = null;
		switch (path) {
		case "/menumodify.do":
			gotopage = "menupage.do";
			baseService = menuService;
			
			String id_str = request.getParameter("id");
			String name = request.getParameter("name");
			String url = request.getParameter("url");
			int id = Integer.valueOf(id_str);
			obj = new Menu(id, name, url);
			
			break;
		case "/rolemodify.do":
			gotopage = "rolepage.do";
			baseService = roleService;
			
			String id_str1 = request.getParameter("id");
			String name1 = request.getParameter("name");
			int rid = Integer.valueOf(id_str1);
			obj = new Role(rid, name1);
			
			break;
		}

		boolean flag = baseService.modifyByid(obj);
		if (flag) {
			request.setAttribute("msg", "修改成功");
		}else {
			request.setAttribute("msg", "修改失败");
		}
		request.getRequestDispatcher(gotopage).forward(request, response);
	}

}
