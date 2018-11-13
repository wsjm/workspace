<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/json2.js"></script>

<script>
    $(function(){
    	$("#btn01").click(function(){
    		$.get("/Servlet01",function(data){
    			console.info(data);
    			
    			var t1=$("#tab01");
    			var title="<tr><th>名字</th><th>路径</th></tr>";
    			
    			$.each(JSON.parse(data),function(i,v){
    				title=title+"<tr>";
    				title=title+"<td>"+v.name+"</td>";
    				title=title+"<td>"+v.url+"</td>";
    				title=title+"</tr>";
    				console.info(i+":"+v);
    			}); 
    			
    			console.info(title);
    			t1.html(title);
    		});
    	});
    	
    });
</script>
</head>
<body>

    <input type="button" value="采用get方法点击获取数据" id="btn01">
    <input type="button" value="采用get方法（json）点击获取数据" id="btn02">
    <input type="button" value="采用getJson方法获取数据" id="btn03">
    <table border="1" id="tab01">
    
    </table>
</body>
</html>