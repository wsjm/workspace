package day28;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		String sex=req.getParameter("sex");
		String age=req.getParameter("age");
		String address=req.getParameter("address");
		System.out.println(userName);
		System.out.println(password);
		System.out.println(sex);
		System.out.println(address);
		//System.out.println(Double.valueOf(age));
		//DButil dButil=new DButil();
		DButil.Dbutil(userName,password,sex,age,address);
		resp.getWriter().write("¥Ú”°≥…π¶");
		System.out.println("=======================");
		
	
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
