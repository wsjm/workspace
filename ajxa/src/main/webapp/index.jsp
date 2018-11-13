<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		/* $("#i1").click(function () {
		 $("p").text("这是我修改的文字");
		 }) */
		$("#i1").click(function() {

			 $("p").load("/Servlet01",{name:"张三",age:12},function(data){
				 
				// console.info(data);
				var mo= JSON.parse(data);
				$.each(mo,function(i,v){
					console.info(i+":"+v);
				})
			 }); 
		})
	})
</script>
</head>
<body>
	this is index
	<%=request.getRequestURL()%>
	<a href="pages/ajxa01.jsp">this is ajxa01.jsp</a>
	<p>这是我的一段文字</p>
	<input type="button" id="i1" value="修改" />
<a href="pages/ajxa02.jsp">跳转页面</a>
<a href="pages/easyui01.jsp">easyui.jsp</a>
<a href="pages/json.jsp">点击我</a>
<a href="login.jsp">登录</a>
</body>
</html>