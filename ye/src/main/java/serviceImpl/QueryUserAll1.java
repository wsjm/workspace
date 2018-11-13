package serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.QueryUserAll;


public class QueryUserAll1 implements QueryUserAll{
	private UserDaoImpl userDaoImpl;

	public QueryUserAll1() {
		userDaoImpl =  new UserDaoImpl();
	}
	@Override
	public Map<String, Object> queryUserAll(int page, int num) {
		Map<String, Object> map = new HashMap<>();
		List<User> list = null;
		//当前第几页
		page = page <= 0 ? 1 : page;
		//每页多少条
		num = num <= 0 ? 5 : num;
		//共多少页
		int allpage = userDaoImpl.allpage(num);
		page = page > allpage?allpage:page;
		
		//当没有内容时，allpage = 0
		if (allpage != 0) {
			list = userDaoImpl.selectAllLimit((page - 1)*num, num);
		}else {
			list = new ArrayList<>();
		}
		
		//避免没有数据时，最后一页  allpage = 0 的情况
//		map.put("page", page == 0?1:page);
//		map.put("allpage", allpage == 0?1:allpage);
//		map.put("num", num);
//		map.put("list", list);
		map.put("total", userDaoImpl.total());
		map.put("rows", list);
		
		return map;
	}


}
