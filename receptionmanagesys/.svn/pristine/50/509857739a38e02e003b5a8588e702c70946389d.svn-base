<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css">
<script type="text/javascript" src="/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script>
	$(function(){
		$('#inviteOrg').combobox({    
		    url:'/getInviteOrg',    
		    valueField:'deptid',    
		    textField:'deptname'   
		}); 
	});
	function doSearch() {
		var opts = $("#tt").datagrid("options");
	    opts.url = "/TaskQueryServlet?method=queryBill";
		$('#tt').datagrid('load', {
			org : $('#inviteOrg').val(),
			date : $('#date').val(),
		});
	}
	function doClear(){
		$("#date").val("");
		$("#inviteOrg").combobox('clear');	
	}
</script>
</head>

<body>
	<table id="tt" class="easyui-datagrid"
		style="width: 100%; height: 500px" url=""
		toolbar="#tb" title="费用查询" iconCls="icon-save" rownumbers="true"
		pagination="true">
		<thead>
			<tr>
				<th field="inviteOrg" width="120" align="center">归属机关</th>
				<th field="taskId" width="120" align="center">任务编号</th>
				<th field="visitorDate_str" width="120" align="center">抵达时间</th>
				<th field="leaveDate_str" width="120" align="center">离开时间</th>
				<th field="visitorOrg" width="120" align="center">来访单位</th>
				<th field="visitorNum" width="120" align="center">来访人数</th>
				<th field="mealsBill" width="120" align="center">餐费</th>
				<th field="liveBill" width="120" align="center">住宿费</th>
				<th field="otherBill" width="120" align="center">其他费用</th>
				<th field="totalBill" width="120" align="center">总费用</th>
				<th field="staff" width="120" align="center">接待员</th>
				
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding: 3px">
		<span>时间</span> <input id="date" type="date" name="date" style="line-height: 26px; border: 1px solid #ccc"> 
		<span>归属机关</span> <input id="inviteOrg" name="org"  style="line-height: 26px; border: 1px solid #ccc">  
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">点击搜索</a>
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doClear()">清空搜索条件</a>
	</div>
</body>

</html>