<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="s2" method="post">
哈哈  你进入了另外一个页面呦!!!
</form>

<%
//获取application域中的数据
 String s=(String)application.getAttribute("name");

%>
<%=s %>
el 表达式获取:${name}
脚本获取:<%=s %>
</body>
</html>