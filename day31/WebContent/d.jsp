
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body style="margin: 0;">
		<div style="width: 100%;border: 1px hidden red;">
			<div style="width: 100%;height: 50px;font-size: 45px;">
				<p>欢迎使用</p>
			</div>
			<div style="width: 100%;height: 300px;border: 1px hidden blue;font-size: 25px;margin-top: 50px">
				
				
				<p>欢迎您${sessionScope.user.userName}</p>
			</div>
		</div>
	</body>
</html>