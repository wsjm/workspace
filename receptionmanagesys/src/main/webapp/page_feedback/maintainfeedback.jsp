<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		$('#officeId').combobox({    
		    url:'/getOffice',    
		    valueField:'deptId',    
		    textField:'deptName'   
		}); 
		$('#inviteOrgId').combobox({    
			url:'/getInviteOrg',    
		    valueField:'deptid',    
		    textField:'deptname'    
		});
		$('#feedback_statusId').combobox({    
		    url:'/getFeedback_status',    
		    valueField:'status_id', 
		    textField:'status_name'   
		});
	});
	function doSearch() {
		$('#tt').datagrid('load', {
			taskid : $('#taskid').val(),
			officeId : $('#officeId').val(),
			inviteOrgId : $('#inviteOrgId').val(),
			feedback_statusId : $('#feedback_statusId').val(),
			visitorDate : $('#visitorDate').val(),
			leaveDate : $('#leaveDate').val(),
		});
	}
	function doClear(){

		$("#taskid").val("");
		$("#officeId").combobox('clear');
		$("#inviteOrgId").combobox('clear');
		$("#feedback_statusId").combobox('clear');
		$("#visitorDate").val("");
		$("#leaveDate").val("");
		
	}
</script>
</head>

<body>
	<table id="tt" class="easyui-datagrid"
		style="width: 100%; height: 500px" url="/FeedbackOrderServlet?method=queryFeedbackOrder"
		toolbar="#tb" title="任务反馈查询" iconCls="icon-save" rownumbers="true"
		pagination="true">
		<thead>
			<tr>
				<th field="taskId" width="120" align="center">任务单编号</th>
				<th field="taskname" width="120" align="center">任务单名称</th>
				<th field="office" width="120" align="center">承办处室</th>
				<th field="inviteOrg" width="120" align="center">归口机关</th>
			    <th field="feedback_status" width="120" align="center">业务状态</th>
				<th field="visitorDate" width="120" align="center">承办日期</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding: 3px">
	    <span>任务单编号</span> <input id="taskid" name="taskid" style="line-height: 26px; border: 1px solid #ccc"> 
		<span>承办处室</span> <input id="officeId" name="officeId" style="line-height: 26px; border: 1px solid #ccc"> 
		<span>归口机关</span> <input id="inviteOrgId" name="inviteOrgId" style="line-height: 26px; border: 1px solid #ccc"> 
		<br/>
		<span>业务状态</span> <input id="feedback_statusId" name="feedback_statusId"  style="line-height: 26px; border: 1px solid #ccc">	
		<span>承办日期</span> <input id="visitorDate" type="date" name="visitorDate" style="line-height: 26px; border: 1px solid #ccc"> 
		&emsp;&emsp;&emsp;&emsp;&emsp;
		<span>至</span> <input id="leaveDate" type="date" name="leaveDate" style="line-height: 26px; border: 1px solid #ccc"> 
		&emsp;&emsp;
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">点击搜索</a>
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doClear()">清空搜索条件</a>
	</div>
</body>

</html>