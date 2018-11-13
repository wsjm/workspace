package com.keduo.service;

import java.util.List;

/*
 * 获取各种页面显示内容
 */
public interface GetShowService {
	List getInviteOrg();
	List getVisittypeId();
	List getStaff();
	List getOffice();
	List getTask_status();
	List getFeedback_status(int roleId);
	List getOfficeByStaffId(String staffId);
	List getStaffByOfficeId(String officeId);
	
}
