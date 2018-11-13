package receptionmanagesys;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.keduo.dao.impl.MenuDaoImpl;
import com.keduo.dao.impl.TaskOrderDaoImpl;
import com.keduo.entity.MainMenu;
import com.keduo.entity.TaskOrder;
import com.alibaba.fastjson.JSONObject;
import com.keduo.dao.impl.TaskStatisDaoImpl;
import com.keduo.service.impl.TaskQueryServiceImpl;
import com.mysql.fabric.xmlrpc.base.Data;

public class Test01 {
	public static void main(String[] args) throws ParseException {
		//new TaskQueryServiceImpl().queryInviteOrg(null, -1, -1, 1, 1);
		//Date date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-28").getTime());
		//String json = JSONObject.toJSONString(new TaskQueryServiceImpl().queryInviteOrg(date, 12, 2, 2, 1));
		//System.out.println(json);
		//new TaskQueryServiceImpl().queryDept(-1, -1, null, 4, 1, 1);
		//new TaskQueryServiceImpl().queryBill(null, 12, 1, 1);
		//new TaskQueryServiceImpl().queryOverspendTask(2018, 10, 1, 1);
		//System.out.println(new TaskQueryServiceImpl().queryExceedBillTypeTask(2018, 9, 5, 1));
		//new TaskStaticsDaoImpl().queryAgencyCost(2018, 10, 5, 1);
		//List<MainMenu> mainMenuList = new MenuDaoImpl().getSuperMenus(3);
		//System.out.println(mainMenuList);
		
		TaskOrderDaoImpl taskOrderDaoImpl=new TaskOrderDaoImpl();
		System.out.println(taskOrderDaoImpl.queryTaskOrderAll(3, 8));
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
		Date date=new Date(2018, 10, 01);
		TaskOrder taskOrder=new TaskOrder();
		taskOrderDaoImpl.add(taskOrder.getTaskId(), "hah a", "难受", date, date, 13, "吴氏酒店", 121212.2, 232323.3, "meiyou ", 10, 5, 6, 4, 5);
		
		
		
	}
}
