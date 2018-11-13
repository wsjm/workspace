package com.keduo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduo.entity.User;


public class Servlet3 extends HttpServlet{
	User user=new User("1","2","3");
	ArrayList userList=new ArrayList();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//乱码处理
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		req.setAttribute("name","曹操");
		
		userList.add(user);
		
	req.setAttribute("userList", userList);
	req.setAttribute("user", user);
	//请求转发
	req.getRequestDispatcher("/d.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
