package day30;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountServlet extends HttpServlet{
	private int num;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ��ͻ�����Ӧ���ݵ���
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter printWriter=resp.getWriter();
		
		//��ͬ�������������пͻ��˵��ۼӣ�
		synchronized (this) {
			printWriter.println(++num+"===============");
		}
		System.out.println(num);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}



}
