package com.keduo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.keduo.entity.Menu;
import com.keduo.entity.User;

public class Servlet01  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��������
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ����
		/*String name= req.getParameter("name");
		String age=req.getParameter("age");
		
		 String str="{\"mid\":22,\"name\":\"哈哈\"}";
	        User user=  JSONObject.parseObject(str, User.class);
	       PrintWriter printWriter=resp.getWriter();
	       printWriter.write("user");
		
		//Ӧ��
		PrintWriter printWriter= resp.getWriter();
		printWriter.write("name");
		System.out.println("doget=================="+name);*/
		Menu m=new Menu();
		m.setName("登录");
		m.setUrl("/login");
		Menu m1=new Menu();
		m1.setName("查询所有");
		m1.setUrl("/queryalll");
		//集合menus里面的数据来源数据库(调用业务层里面的查询方法【调用dao层里面的查询方法jdbc】)
		List<Menu> menus=new ArrayList<Menu>();
		menus.add(m);
		menus.add(m1);
		//String list1=JSONObject.toJSONString(m);
		String listS=JSONObject.toJSONString(menus);
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw=resp.getWriter();
		pw.println(listS);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
	}
	
}
