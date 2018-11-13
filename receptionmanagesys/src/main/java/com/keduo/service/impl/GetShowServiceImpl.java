package com.keduo.service.impl;

import java.util.List;

import com.keduo.dao.GetShowDao;
import com.keduo.dao.impl.GetShowDaoImpl;
import com.keduo.service.GetShowService;

public class GetShowServiceImpl implements GetShowService{
	GetShowDao dao;
	public GetShowServiceImpl() {
		dao = new GetShowDaoImpl();
	}
	@Override
	public List getInviteOrg() {
		
		return dao.getInviteOrg();
	}

	@Override
	public List getVisittypeId() {
		// TODO Auto-generated method stub
		return dao.getVisittypeId();
	}
	@Override
	public List getStaff() {
		// TODO Auto-generated method stub
		return dao.getStaff();
	}
	@Override
	public List getOffice() {
		// TODO Auto-generated method stub
		return dao.getOffice();
	}
	@Override
	public List getTask_status() {
		// TODO Auto-generated method stub
		return dao.getTask_status();
	}
	@Override
	public List getFeedback_status(int roleId) {
		// TODO Auto-generated method stub
		return dao.getFeedback_status(roleId);
	}
	@Override
	public List getOfficeByStaffId(String staffId) {
		// TODO Auto-generated method stub
		return dao.getOfficeByStaffId(staffId);
	}
	@Override
	public List getStaffByOfficeId(String officeId) {
		// TODO Auto-generated method stub
		return dao.getStaffByOfficeId(officeId);
	}

	
}
