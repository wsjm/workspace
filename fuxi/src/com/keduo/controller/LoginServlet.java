package com.keduo.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//对请求resquest乱码进行处理
		response.setCharacterEncoding("utf-8");
		//对响应response 进行乱码处理
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("你好啊  ");
		//获取页面中表单的数据
		String res=request.getParameter("name");
		ServletContext servletContext=request.getServletContext();
		//删除application中的数据
		servletContext.removeAttribute("name");
		response.getWriter().write("删除成功了吗!!!");
		//获取config对象
		ServletConfig config= getServletConfig();
		//请求转发
		request.getRequestDispatcher("/b.jsp").forward(request, response);
		//重定向
		//response.sendRedirect("b.jsp");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
