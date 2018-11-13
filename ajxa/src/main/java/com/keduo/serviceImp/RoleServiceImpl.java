package com.keduo.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.keduo.dao.iRoleDao;
import com.keduo.daoImp.RoleDaoImpl;
import com.keduo.entity.Role;
import com.keduo.service.iRoleService;



public class RoleServiceImpl implements iRoleService {
	private iRoleDao roleDao;

	public RoleServiceImpl() {
		roleDao = new RoleDaoImpl();
	}

	@Override
	public Map<String, Object> findAllPage(int page, int num) {
		Map<String, Object> map = new HashMap<>();
		List<Role> list = null;
		// 当前第几页
		page = page <= 0 ? 1 : page;
		// 每页多少条
		num = num <= 0 ? 5 : num;
		// 共多少页
		int allpage = roleDao.allpage(num);
		page = page > allpage ? allpage : page;

		// 当没有内容时，allpage = 0
		if (allpage != 0) {
			list = roleDao.selectAllLimit((page - 1) * num, num);
		} else {
			list = new ArrayList<>();
		}

		// 避免没有数据时，最后一页 allpage = 0 的情况
//		map.put("page", page == 0 ? 1 : page);
//		map.put("allpage", allpage == 0 ? 1 : allpage);
//		map.put("num", num);
//		map.put("list", list);
		map.put("total", roleDao.total());
		map.put("rows", list);

		return map;
	}

	@Override
	public boolean removeById(int id) {
		int row = roleDao.deleteRoleById(id);
		if (row > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Role findById(int id) {
		return roleDao.selectRoleById(id);
	}

	@Override
	public boolean modifyByid(Object obj) {
		int row = roleDao.updateRoleById((Role)obj);
		if (row > 0 ) {
			return true;
		}
		return false;
	}

}
