<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css">
<script type="text/javascript" src="/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#submit").click(function(){
		
		
		if(window.confirm("是否提交")){
			alert("提交成功");
			location.reload();
		}
		//window.location.href="/taskOrder/Task.jsp"; 
	});
	
	
})


</script>


</head>
<body>
<div style=" padding:3px 2px;border-bottom:1px solid #ccc">添加任务单</div>
	<form id="ff" action="/InsertTaskOrder" method="post">
		<table style="padding-left: 30% ">
		<tr><td>任务情况:</td></tr>
			<tr>
				<td >来宾单位:</td>
				<td><input name="VisitorOrg" type="text" required="required"></input></td>
				<td >任务名称:</td>
				<td><input name="taskname" type="text" required="required"></input></td>
			</tr>
			<!-- <tr>
			
				<td>主宾姓名:</td>
				<td><input name="name" type="text"></input></td>
				<td>职务:</td>
				<td><input name="zhiwu" type="text"></input></td>
			<br/>
			</tr> -->
			<tr>
				<td >抵达时间:</td>
				<td><input name="VisitorDate" type="date" required="required"></input></td>
				<td required="required">离开时间:</td>
				<td><input name="leaveDate" type="date" required="required"></input></td>
			</tr>
			<tr>
			<td >人数:</td>
				<td ><input name="VisitorNum" type="text" required="required"></input></td>
				
				<!-- <td>男:<input name="name" type="radio"></input></td>
				
				<td>女:<input name="name" type="radio"></input></td>
			 -->
			 	<td>籍貫單位
			<select name="inviteOrgId">
			
			<option>12</option>
			<option>13</option>
			<option>14</option>
			</select></td>
			</tr>
			<tr>
			<td> 访问形式:
			<td>
			<select name="visittypeId">
			
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
			<option>6</option>
			<option>7</option>

			</select></td>
			
			
			</tr>
			<tr>
			<td>安排酒店:</td>
			<td><input name="hotel" type="text" required="required"></input></td>

			</tr>
			 <tr>
			
			<td>餐饮预算:</td><td><input type="text" name="mealsBudget" required="required"/></td>
			</tr>
			
			 <tr>

			<td>入住预算:</td><td><input type="text" name="liveBudget" required="required"/></td>
			
			</tr> 
			<tr> 
			<td>其他:</td>
			<td><input type="text" name="others" required="required"/></td>
			
			</tr>
			 <tr>
				<td>接待室处长:</td>
				<td><input name="directorId" type="text" required="required"></input></td>
			
			<td>接待人员:</td>
			<td><input name="staffId" type="text" required="required"></input></td>
			
			</tr> 
			<tr><td>承办处室:</td>
			<td> 
			<select name="officeId">
			
			<option>9</option>
			<option>10</option>
			<option>11</option>
			</select>
			</td>
			<td>任务状态: </td>
			<td>
			<select name="task_statusId">
			
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
			</select>
			</td>
			</tr>
			<br/>
			<tr>
				
				<td><input type="submit" id="submit" value="提交"></input>
				
				</td>
				<td><input type="button" id="button" value="保存"></input>
				
				</td>
				<td><input type="reset" value="重置"></input>
				
				</td>
				<!-- <td><input type="button" value="返回"></input> -->
				
				</td>
			</tr>
		</table>
	</form>
</body>
</html>