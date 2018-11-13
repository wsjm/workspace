package com.keduo.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.keduo.dao.iMenuDao;
import com.keduo.daoImp.MenuDaoImpl;
import com.keduo.entity.Menu;
import com.keduo.service.iMenuService;



public class MenuServiceImpl implements iMenuService{
	private iMenuDao menuDao;
	
	public MenuServiceImpl() {
		menuDao = new MenuDaoImpl();
	}

	@Override
	public Map<String, Object> findAllPage(int page, int num) {
		Map<String, Object> map = new HashMap<>();
		List<Menu> list = null;
		//当前第几页
		page = page <= 0 ? 1 : page;
		//每页多少条
		num = num <= 0 ? 5 : num;
		//共多少页
		int allpage = menuDao.allpage(num);
		page = page > allpage?allpage:page;
		
		//当没有内容时，allpage = 0
		if (allpage != 0) {
			list = menuDao.selectAllLimit((page - 1)*num, num);
		}else {
			list = new ArrayList<>();
		}
		
		//避免没有数据时，最后一页  allpage = 0 的情况
		//map.put("page", page == 0?1:page);
		//map.put("allpage", allpage == 0?1:allpage);
		//map.put("num", num);
		map.put("total", menuDao.total());
		map.put("rows", list);
		
		return map;
	}

	@Override
	public boolean removeById(int id) {
		int row = menuDao.deleteMenuById(id);
		if (row > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Menu> getMenusByUid(int uid) {
		return menuDao.selectMenusByUid(uid);
	}

	@Override
	public Menu findById(int id) {
		return menuDao.selectMenuById(id);
	}

	@Override
	public boolean modifyByid(Object obj) {
		int row = menuDao.updateMenuById((Menu)obj);
		if (row > 0 ) {
			return true;
		}
		return false;
	}

}
