package com.keduo.dao;

import java.util.List;

import com.keduo.entity.MainMenu;
import com.keduo.entity.Menu;

public interface MenuDao extends BaseDao<Menu>{
	List<MainMenu> getSuperMenus(int rid);
	List<Menu> getChildMenus(int rid,int superMenuId);
}
