package receptionmanagesys;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.keduo.dao.impl.FeedbackOrderDaoImpl;
import com.keduo.entity.Bill;
import com.keduo.entity.TaskOrder;

public class Test02 {
	public static void main(String[] args) throws ParseException {
		FeedbackOrderDaoImpl fbod = new FeedbackOrderDaoImpl();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Bill bill = new Bill(0, "其他费", 200.5, new Date(sdf.parse("2018-10-01").getTime()), 15, "20181021124105");
		//fbod.SelectFeedbackOrder(null, 0, 0, 2, null, null, 5, 1);
		TaskOrder taskorder = new TaskOrder("20181023104110", null, null, 1,null, null, 16, "老赵家", 1, 1, null, 16, 5, 4, 1, 2);
		//int c = fbod.UpdateFeedbackOrder(taskorder);
		//System.out.println(c);
		
		//fbod.SelectFeedbackOrder("20181021124103", null, 0, 0, null, null, 5, 1);
		int a = fbod.insertFee(bill);
		System.out.println(a);

		//fbod.SelectFeedbackOrder(null, "来当地考查", 0, null, null, 5, 1);
		//TaskOrder taskorder2 = new TaskOrder();
//		taskorder2.setFeedbackcontext("1234");
//		taskorder2.setFeedbacksubmittime(new Date(sdf.parse("2018-10-05").getTime()));
//		taskorder2.setFeedback_statusId(4);
//		taskorder2.setTaskId("20181023104110");
//		int b = fbod.CheckFeedbackOrder(taskorder2);
//		System.out.println(b);
		
	}
}
