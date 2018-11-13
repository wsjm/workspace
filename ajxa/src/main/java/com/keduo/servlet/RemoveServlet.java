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
 * Servlet implementation class RemoveServlet
 */
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private iMenuService menuService;
	private iUserSrevice userSrevice;
	private iRoleService roleService;

	public RemoveServlet() {
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
		//获取传入参数
		//页码
		String page  = request.getParameter("page");
		//每一页记录条数
		String num  = request.getParameter("num");
		String path = "page="+page!=null?page:""+"&num="+num!=null?num:"";
		
		iBaseService baseService = null;
		// 申明要跳转的路径
		String gotopage = null;
		// 获取请求路径
		String path2 = request.getServletPath();
		switch (path2) {
		case "/userremove.do":
			gotopage = "userpage.do?"+path;
			baseService = userSrevice;
			break;
		case "/menuremove.do":
			gotopage = "menupage.do?"+path;
			baseService = menuService;
			break;
		case "/roleremove.do":
			gotopage = "rolepage.do?"+path;
			baseService = roleService;
			break;
		}
		
		//获取id
		String id_str = request.getParameter("id");
		String msg = null;
		if (id_str == null && id_str.trim().length() == 0) {
			msg = "id异常";
		}else {
			int id = Integer.valueOf(id_str);
			boolean flag = baseService.removeById(id);
			if (flag) {
				msg = "删除成功！";
			}else {
				msg = "删除失败";
			}
		}
		request.setAttribute("msg",msg);
		request.getRequestDispatcher(gotopage).forward(request, response);
	}

}
