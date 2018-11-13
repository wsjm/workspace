<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	$("#b1").click(function (req) {
		$.get("/Servlet01",{name:"王五"},function(data){
			$("p").text("哈哈  我把你改了");
			console.info(data);
			
		});
	})
})
</script>
</head>
<body>
<p>这是我的一段文字</p>
<input type="button" value="修改" id="b1" />
</body>
</html>