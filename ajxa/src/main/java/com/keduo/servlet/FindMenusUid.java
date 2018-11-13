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
import com.keduo.entity.Menu;
import com.keduo.service.iMenuService;
import com.keduo.serviceImp.MenuServiceImpl;


/**
 * Servlet implementation class FindMenusUid
 */
public class FindMenusUid extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private iMenuService menuService;
       
    public FindMenusUid() {
        super();
        menuService = new MenuServiceImpl();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 中 获取 uid
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Map<String, Object> map = (Map<String, Object>) request.getSession(true).getAttribute("user");
		
		if (map == null) {
			// session 中没有获取到 uid 则返回登录页面
			request.setAttribute("msg", "登录已失效，请重新登录");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		int uid = (int) map.get("uid");
		List<Menu> menus = menuService.getMenusByUid(uid);
        String menuJsonString=JSONObject.toJSONString(menus);
        PrintWriter pw=response.getWriter();
        pw.println(menuJsonString);
	}  

}
