package com.keduo.service;

import java.util.List;

import com.keduo.entity.Menu;




public interface iMenuService extends iPageBaseService , iBaseService<Menu>{

	/**
	 * 通过uid查找用户菜单
	 * @param uid
	 * @return 菜单集合，如果没有，返回集合长度为 0 
	 */
	public List<Menu> getMenusByUid(int uid); 
}
