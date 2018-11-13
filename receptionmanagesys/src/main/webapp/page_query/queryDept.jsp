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
		$('#staffId').combobox({    
		    url:'/getStaff',    
		    valueField:'staffId',    
		    textField:'realName',
		    limitToList:'true',
		    onChange:getOfficeByStaffId
		}); 
		$('#officeId').combobox({    
		    url:'/getOffice',    
		    valueField:'deptId',    
		    textField:'deptName',
		    limitToList:'true',
		    onChange:getStaffByOfficeId
		});
		$('#task_status').combobox({    
		    url:'/getTask_status',    
		    valueField:'ststus_id',    
		    textField:'status_name',
		    limitToList:'true'
		});
	});
	function doSearch() {
		var opts = $("#tt").datagrid("options");
	    opts.url = "/TaskQueryServlet?method=queryDept";
		$('#tt').datagrid('load', {
			taskId : $('#taskId').val(),
			staffId : $('#staffId').val(),
			officeId:$('#officeId').val(),
			task_status:$('#task_status').val()
		});
	}
	function getOfficeByStaffId(){
		
		var staffId = $("#staffId").val();
		var url = "/getOfficeByStaffId?staffId=" + staffId;
		$('#officeId').combobox('reload',url);  
		/* $('#officeId').combobox({    
		    url:'/getOfficeByStaffId?staffId=' + $(this).val(),    
		    valueField:'deptId',    
		    textField:'deptName'   
		}); */
		
	}
	function getStaffByOfficeId(){
		var officeId = $("#officeId").val();
		var url = "/getStaffByOfficeId?officeId=" + officeId;
		$('#staffId').combobox('reload',url);  
	}
	function doClear(){
		$("#taskId").val("");
		$("#staffId").combobox('clear');
		$("#officeId").combobox('clear');
		$("#task_status").combobox('clear');
		$("#task_status").combobox('reload','/getTask_status')
		$("#officeId").combobox('reload','/getOffice');
		$("#staffId").combobox('reload','/getStaff');
		
	}
</script>
</head>

<body>
	<table id="tt" class="easyui-datagrid"
		style="width: 100%; height: 500px" url=""
		toolbar="#tb" title="承办处室查询" iconCls="icon-save" rownumbers="true"
		pagination="true">
		<thead>
			<tr>
				<th field="inviteOrg" width="120" align="center">归属机关</th>
				<th field="taskId" width="120" align="center">任务编号</th>
				<th field="visitorDate_str" width="120" align="center">抵达时间</th>
				<th field="leaveDate_str" width="120" align="center">离开时间</th>
				<th field="visitorOrg" width="120" align="center">来访单位</th>
				<th field="visitorNum" width="120" align="center">来访人数</th>
				<th field="hotel" width="120" align="center">安排地点</th>
				<th field="visittype" width="120" align="center">任务形式</th>
				<th field="office" width="120" align="center">承办处室</th>
				<th field="staff" width="120" align="center">接待员</th>
				<th field="task_status" width="120" align="center">任务状态</th>
				
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding: 3px">
		<span>任务单号</span> <input id="taskId" name="taskId" style="line-height: 26px; border: 1px solid #ccc"> 
		
		<span>承办处室</span> <input id="officeId" name="officeId"  style="line-height: 26px; border: 1px solid #ccc" onchange="getStaffByOfficeId()">  
		<span>接待员</span> <input id="staffId"  name="staffId" style="line-height: 26px; border: 1px solid #ccc"> 
		<span>任务状态</span> <input id="task_status" name="task_status" style="line-height: 26px; border: 1px solid #ccc"> 
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">点击搜索</a>
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doClear()">清空搜索条件</a>
	</div>
</body>

</html>