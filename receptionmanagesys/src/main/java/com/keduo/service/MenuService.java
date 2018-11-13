package com.keduo.service;

import java.util.List;

import com.keduo.entity.MainMenu;
import com.keduo.entity.Menu;

public interface MenuService {
	List<MainMenu> getSuperMenus(int rid);
	List<Menu> getChildMenus(int rid,int superMenuId);
}
