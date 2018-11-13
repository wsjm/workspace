package com.keduo.dao;

import java.util.List;

import com.keduo.entity.Menu;




public interface iMenuDao extends iPageBaseDao<Menu>{
	/**
	 * 新增菜单
	 * @param menu
	 * @return 受影响行数
	 */
	public int insertMenu(Menu menu);
	
	/**
	 * 通过ID删除菜单
	 * @param id
	 * @return 受影响行数
	 */
	public int deleteMenuById(int id);
	
	/**
	 * 通过ID查询菜单
	 * @param id
	 * @return 菜单对象，如果不存在返回 null
	 */
	public Menu selectMenuById(int id);
	
	/**
	 * 查询所有菜单
	 * @return List 集合对象，如果没有内容，返回长度为0 的集合对象
	 */
	public List<Menu> selectAllMenus();
	
	/**
	 * 通过id修改菜单
	 * @param id
	 * @return 受影响行数
	 */
	public int updateMenuById(Menu menu);
	
	/**
	 * 通过uid查找用户菜单
	 * @param uid
	 * @return 菜单集合，如果没有，返回集合长度为 0 
	 */
	public List<Menu> selectMenusByUid(int uid);
	public int total();
}

