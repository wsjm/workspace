<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../js/json2.js"></script>

<script type="text/javascript">
$(function(){
	$("#btn01").click(function(){
		$.get("/FeedbackOrderServlet",function(data){
			console.info(data);
			
		
			$.each(JSON.parse(data),function(i,v){
				
				console.info(i+":"+v);
			}); 
			
			
		});
	});
	
});
</script>
</head>
<body>
<input  type="button"  value="查询" />
<p>123</p>
<input type="button" value="采用get方法点击获取数据" id="btn01">
    <input type="button" value="采用get方法（json）点击获取数据" id="btn02">
    <input type="button" value="采用getJson方法获取数据" id="btn03">
    <table border="1" id="tab01">
    
    </table>
</body>
</html>