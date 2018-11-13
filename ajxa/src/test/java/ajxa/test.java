package ajxa;

import java.util.ArrayList;
import java.util.List;



import com.alibaba.fastjson.JSONObject;
import com.keduo.entity.Menu;
import com.keduo.entity.User;

public class test {

	public  void ft(){
		Menu menu=new Menu();
		menu.setName("登录");
		menu.setMid(12);
		Menu menu2=new Menu();
		menu2.setName("哈哈");
		menu2.setMid(22);
		ArrayList<Menu> menus=new ArrayList<Menu>();
		menus.add(menu2);
		menus.add(menu);
		//集合转换成json串
		String lists=JSONObject.toJSONString(menus);
		System.out.println(lists);
		//json串转换成对象
		String json="{\"mid\":22,\"name\":\"哈哈\"}";
		User user=  JSONObject.parseObject(json, User.class);
		System.out.println(user);
		String json1="[{\"mid\":22,\"name\":\"哈哈\"}]";
		List<Menu> mm= JSONObject.parseArray(json1, Menu.class);
		System.out.println(mm);
	}

}
