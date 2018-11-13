package com.keduo.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduo.entity.Bill;
import com.keduo.service.impl.FeedbackOrderServiceImpl;
import com.keduo.service.impl.TaskOrderaddServiceImpl;

/**
 * Servlet implementation class BillServlet
 */
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FeedbackOrderServiceImpl feedbackOrderService= new FeedbackOrderServiceImpl();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String billtype_str = request.getParameter("billtype");
		String bill_str = request.getParameter("bill");
		String billtime_str = request.getParameter("billtime");
		String shop_str = request.getParameter("shop");
		String feedbackorder_str = request.getParameter("feedbackorder");		

		String billtype = null;
		Double bill = 0.0;
		Date billtime = null;
		int shop = 0;
		String taskid = null;
		if (billtype_str == null || billtype_str.trim().length() == 0) {
			billtype = null;
		} else {
			billtype = billtype_str;
		}
		if (bill_str == null || bill_str.trim().length() == 0) {
			bill = 0.0;
		} else {
			bill = Double.valueOf(bill_str);
		}
		if (billtime_str == null || billtime_str.trim().length() == 0) {
			billtime = null;
		} else {
			try {
				billtime = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(billtime_str).getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(shop_str == null || shop_str.trim().length() == 0) {
			shop = 0;
		}else {
			shop = Integer.parseInt(shop_str);
		}
		if(feedbackorder_str == null || feedbackorder_str.trim().length() == 0) {
			taskid = null;
		}else {
			taskid = feedbackorder_str;
		}
		
		System.out.println(shop);
		
		Bill Bill = new Bill();
		Bill.setBilltype(billtype);
		Bill.setBill(bill);
		Bill.setBilltime(billtime);
		Bill.setShop(shop);
		Bill.setFeedbackorder(taskid);	
		
		int a = feedbackOrderService.insertFee(Bill);
		
		if (a>0) {
			
		} else {
			
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
