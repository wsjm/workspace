package com.keduo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.keduo.entity.MainMenu;
import com.keduo.entity.Menu;
import com.keduo.entity.User;
import com.keduo.service.MenuService;
import com.keduo.service.impl.MenuServiceImpl;

/**
 * Servlet implementation class MenuServlet
 */
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuService menuService = new MenuServiceImpl();
		User user = (User) request.getSession().getAttribute("user");
		
		String path = request.getServletPath();
		if (path.trim().equals("/getSuperMenus.do")) {
			if(user!=null) {
				int rid = user.getRid();
				//System.out.println(rid);
				List<MainMenu> mainMenuList = menuService.getSuperMenus(rid);
				//System.out.println(mainMenuList);
				String json = JSONObject.toJSONString(mainMenuList);
				//System.out.println(json);
				response.getWriter().println(json);
			}
			return;
		}
		if(user!=null) {
			int rid = user.getRid();
			String superMenuId_str = request.getParameter("mainMenuId");
			int superMenuId = Integer.valueOf(superMenuId_str);
			List<Menu> menuList = menuService.getChildMenus(rid, superMenuId);
			String json = JSONObject.toJSONString(menuList);
			response.getWriter().println(json);
		}
		
		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
