package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.User;
import serviceImpl.QueryUserAll1;

public class QueryUserAll extends HttpServlet{
	 String string;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理乱码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		//获取页面数据
		//String name= req.getParameter("tijiao");
		QueryUserAll1 all1= new QueryUserAll1();
		List<User> users=  all1.queryUserAll();
		for (User user : users) {
			string= JSON.toJSONString(user);
		}
		 PrintWriter pw=resp.getWriter();
	        pw.println(string);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
}
}
