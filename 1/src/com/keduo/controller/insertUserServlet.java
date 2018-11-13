package com.keduo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduo.service.insertUserService;


@WebServlet("/insertUserServlet")
public class insertUserServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String age = request.getParameter("age");
			String sex = request.getParameter("sex");
			System.out.println(age);
			insertUserService.insertUser(userName, password, age, sex);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
