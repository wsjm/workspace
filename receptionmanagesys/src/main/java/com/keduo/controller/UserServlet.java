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
import com.keduo.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.trim().equals("/changePassword")) {
			String oldPassword = request.getParameter("oldPassword");
			String newPassword1 = request.getParameter("newPassword1");
			String newPassword2 = request.getParameter("newPassword2");
			System.out.println(oldPassword + "-" + newPassword1 + "=" + newPassword2);
			String msg = null;
			boolean flag = false;
			User user = (User)request.getSession().getAttribute("user");		
			if(user!=null) {
				if(!oldPassword.equals(user.getPassword())) {
					flag=false;
					msg="密码错误 ";
					Map map = new HashMap();
					map.put("flag", flag);
					map.put("msg", msg);
					String json = JSONObject.toJSONString(map);
					response.getWriter().println(json);
					return;
				}
				user.setPassword(newPassword1);
				int uid = user.getUid();
				flag = new UserServiceImpl().changePassword(uid,newPassword1);
				if(flag) {
					msg="修改成功";
				}else {
					msg="修改失败";
				}
				Map map = new HashMap();
				map.put("flag", flag);
				map.put("msg", msg);
				String json = JSONObject.toJSONString(map);
				response.getWriter().println(json);
			}else {
				flag=false;
				msg="请先登陆";
				Map map = new HashMap();
				map.put("flag", flag);
				map.put("msg", msg);
				String json = JSONObject.toJSONString(map);
				response.getWriter().println(json);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
