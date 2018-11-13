<%@ page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.div1{
	font-size: 30px;
	width: 80%;
	margin: auto;
	text-align: center;
}
.div1 table{
	width: 100%;
	margin-top: 100px;
}
.div1 td,th{
	padding: 15px;
}

</style>
</head>
<body>
	
	<div class="div1">
		<p>待安排维修信息</p>
		<table >
			<tr>
				<th>业主id</th>
				<th>标题</th>
				<th>问题描述</th>
				<th>报修时间</th>
				<th>处理情况</th>
			</tr>
			<c:forEach items="${accuseList}" var="accuse">
				<tr>
					<td>${accuse.accuseOwnerId }</td>
					<td>${accuse.accuseTitle }</td>
					<td>${accuse.accuseContext }</td>
					<td><fmt:formatDate value="${accuse.accuseTime }" pattern="yyyy年MM月dd日"/> </td>
					<td>${accuse.status }</td>
				</tr>

			</c:forEach>

		</table>
	</div>
</body>
</html>