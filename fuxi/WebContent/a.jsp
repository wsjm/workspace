<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%-- <%@ include file="b.jsp" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!--  <form action="s1" method="post"> 
<input type="text" name="name">
<input type="password" name="password">
<input type="submit" value="提交">
</form> -->
<%
	//向application域中存储数据
	//application.setAttribute("name", "曹操");
	 String s=application.getInitParameter("url");
	 //获取pageContext域里面的数据
	 pageContext.setAttribute("name", "刘备");
	 request.setAttribute("name", "哈哈");
	 
	 String s1=(String) pageContext.getAttribute("name",pageContext.APPLICATION_SCOPE);
		String s2=(String)pageContext.getAttribute("name",pageContext.REQUEST_SCOPE);
%>
<%="数据存储成功"+s %>
<%=s1 %>
<%=s2 %>
</body>
</html>