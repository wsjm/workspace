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


</script>
</head>
<body>
<div style=" padding:3px 2px;border-bottom:1px solid #ccc">录入费用</div>
	<form id="ff" action="/BillServlet" method="post">
		<table style="padding-left: 30%">
		<tr><td>费用明细:</td></tr>
			<tr>
				<td>费用类型:</td>
				<td><input name="billtype" type="text" required="required"></input></td>
			</tr>

			<tr>
				<td>费用金额/元:</td>
				<td><input name="bill" type="text" required="required" onkeyup="value=value.replace(/[^\d]/g,'') " ng-pattern="/[^a-zA-Z]/" placeholder="请输入数字"></input></td>
			</tr>
			<tr>
			    <td>消费时间:</td>
				<td><input name="billtime" type="date" required="required"></input></td>
			</tr>
			<tr>
			    <td>商户:</td>
				<td><input name="shop" type="text" required="required"></input></td>
			</tr>
			<tr>
			    <td>任务单编号:</td>
				<td><input name="feedbackorder" type="text" required="required"></input></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="提交"></input>
				
				</td>
				<td><input type="button" value="保存"></input>
				
				</td>
				<td><input type="reset" value="重置"></input>
				
				</td>
				<td><input type="button" value="返回"></input>
				
				</td>
			</tr>
		</table>
	</form>
</body>
</html>