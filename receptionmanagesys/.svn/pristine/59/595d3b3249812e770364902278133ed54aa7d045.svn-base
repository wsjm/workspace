package com.keduo.dao;

import java.sql.Date;
import java.util.Map;

public interface TaskQueryDao {
		//归属机关查询
		Map<String,Object> queryInviteOrg(Date date,int org,int visittypeId,int num,int page);
		//承办处室查询
		Map<String,Object> queryDept(int staffId, int officeId, String taskId, int task_statusId, int num, int page);
		//费用查询
		Map<String,Object> queryBill(Date date, int org, int num, int page);
		//任务办结预警查询
		Map<String,Object> queryUnclosedTask(int num, int page);
		//费用超支查询
		Map<String,Object> queryOverspendTask(String date, int num, int page);
		//费用类型超出查询
		Map<String,Object> queryExceedBillTypeTask(String date, int num, int page);

}
