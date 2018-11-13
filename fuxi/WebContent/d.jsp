<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach begin="0" end="5" var="i">${i }</c:forEach>
<c:out value="我是一个小小鸟"></c:out>

<c:if test="${3>6 }" var="s"><c:out value="我是一个小小鸟"></c:out></c:if>
${s }
${name}
${user.getName() }

${userList[0]}

<c:forEach begin="0" end="100" step="2" varStatus="vs">
<p>${vs.count}我是两只小鸟</p>

</c:forEach>

</body>
</html>