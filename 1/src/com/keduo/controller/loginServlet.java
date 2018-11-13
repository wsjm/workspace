package com.keduo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduo.util.DButil;


public class loginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rSet = null;
		try {
			// �������Ӷ���
			con = DButil.connection();
			// ����ִ�ж���
			ps = con.prepareStatement("select * from user where name=?");
			// ���ؽ����
			ps.setString(1,request.getParameter("name"));
			ResultSet rs = ps.executeQuery();
			try {
				//��ͨ�Ñ�
				if (rs.getLong(4)==1) {
					response.sendRedirect("user.jsp");
				}
				//����T
				else if(rs.getLong(4)==2){
					response.sendRedirect("manager.jsp");
				}
				//ϵ�y����T
				else {
					response.sendRedirect("superManager.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				DButil.close(con, rSet,ps );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
