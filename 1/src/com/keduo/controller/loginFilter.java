package com.keduo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.keduo.util.DButil;

public class loginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html:charset=utf-8");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rSet = null;
		try {
			// 创建连接对象
			con = DButil.connection();
			// 创建执行对象
			ps = con.prepareStatement("select password from user where name=?");
			// 返回结果集
			ps.setString(1,request.getParameter("name"));
			rSet = ps.executeQuery();
			try {
				if (request.getParameter("password").equals(rSet.getString(3))) {
				chain.doFilter(request, response);
				}
				else {
					HttpServletResponse resp = (HttpServletResponse) response;
					//請求轉發到loginservlet層
					resp.sendRedirect("loginServlet");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			try {
				DButil.close(con,rSet,ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
				
}
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
