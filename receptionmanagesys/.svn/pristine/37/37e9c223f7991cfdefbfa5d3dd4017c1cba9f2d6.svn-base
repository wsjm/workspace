package com.keduo.service.impl;


import java.util.List;

import com.keduo.dao.MenuDao;
import com.keduo.dao.impl.MenuDaoImpl;
import com.keduo.entity.MainMenu;
import com.keduo.entity.Menu;
import com.keduo.service.MenuService;

public class MenuServiceImpl implements MenuService{
	MenuDao menuDao;
	public MenuServiceImpl() {
		menuDao = new MenuDaoImpl();
	}
	@Override
	public List<MainMenu> getSuperMenus(int rid) {
		// TODO Auto-generated method stub
		return menuDao.getSuperMenus(rid);
	}

	@Override
	public List<Menu> getChildMenus(int rid, int superMenuId) {
		// TODO Auto-generated method stub
		return menuDao.getChildMenus(rid, superMenuId);
	}
	



}
