package com.keduo.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.keduo.dao.iUserDao;
import com.keduo.daoImp.UserDaoImpl;
import com.keduo.entity.User;
import com.keduo.service.iUserSrevice;
import com.keduo.util.Util;




public class UserServiceImpl implements iUserSrevice {
	private iUserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
	
	@Override
	public Map<String, Object> login(String loginname, String password)
			throws Exception {
		if (Util.isNull(loginname)) {
			throw new Exception();
		}
		
		if (Util.isNull(password)) {
			throw new Exception();
		}
		
		//通过用户名查询到 密码 dao层
//		String pwd = userDao.selectPasswordByLoginname(loginname);
		User user = userDao.selectPasswordByLoginname(loginname);
		//如果user对象为空， loginname 不存在
		if (user == null) {
			throw  new Exception();
		}
		
		//如果获取到的 密码 和 传入的 password 不匹配  密码错误
		if (!password.trim().equals(user.getPassword())) {
			throw new Exception();
		}
		
		//修改最后登录时间
		userDao.updateLastLogintimeByUid(user.getUid());
		
		Map<String, Object> map = new HashMap<>();
		map.put("uid", user.getUid());
		map.put("loginname", user.getLoginname());
		//匹配成功，返回登录成功
		return map;
	}

	@Override
	public boolean addUser(User user) {
		//为了保证数据安全性，可以再进行一次 用户名重复的判断
		if (existLoginname(user.getLoginname())) {
			return false;
		}
		//受影响行数
		int row =  userDao.insert(user);
		if (row > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean existLoginname(String loginname) {
		int id = userDao.selectIdByLoginname(loginname);
		if (id > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeById(int uid) {
		int row = userDao.deleteByUid(uid);
		if (row > 0) {
			return true;
		}
		return false;
	}

	@Override
	public User findById(int uid) {
		//申明User 变量  初始化为   null
		User user = userDao.selectUserByUid(uid);
		return user;
	}

	@Override
	public List<User> findAllUsers() {
		return null;
	}

	@Override
	public Map<String, Object> findAllPage(int page, int num) {
		Map<String, Object> map = new HashMap<>();
		List<User> list = null;
		//当前第几页
		page = page <= 0 ? 1 : page;
		//每页多少条
		num = num <= 0 ? 5 : num;
		//共多少页
		int allpage = userDao.allpage(num);
		page = page > allpage?allpage:page;
		
		//当没有内容时，allpage = 0
		if (allpage != 0) {
			list = userDao.selectAllLimit((page - 1)*num, num);
		}else {
			list = new ArrayList<>();
		}
		
		//避免没有数据时，最后一页  allpage = 0 的情况
//		map.put("page", page == 0?1:page);
//		map.put("allpage", allpage == 0?1:allpage);
//		map.put("num", num);
//		map.put("list", list);
		map.put("total", userDao.total());
		map.put("rows", list);
		
		return map;
	}

	@Override
	public boolean modifyByid(Object obj) {
		int row = userDao.updateUserByUid((User)obj);
		if (row > 0 ) {
			return true;
		}
		return false;
	}

}

