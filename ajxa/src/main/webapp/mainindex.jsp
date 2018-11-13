<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../js/easyui/themes/icon.css">
<script type="text/javascript" src="../js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
     $(function(){
    	 $.getJSON('<%=request.getContextPath()%>/menusuid.do',function(data){
    		 
    		//v里面就是我们的菜单名字和地址  v.name v.url
    		//循环最主要是要把我们的左边所有菜单（a标签）准备好
    		var str="";
    		$.each(data,function(i,v){
    			 // <a href="javascript:addSelf('v.name',v.url)">v.name</a><br/>
    			  str=str+"<a href=\"javascript:addSelf('"+v.name+"','/"+v.url+"')\">"+v.name+"</a><br/>";
    			 console.info(v.url);
    		});
    		//把这些a标签添加到ms对应的div里面
    		
    		$("#ms").html(str);
    	 });
     });
     function addSelf(tc,urls){
    	 //如果这个选项卡存在的话，就不添加
    	 if($('#tt').tabs('exists',tc)){
    		//选中
    		 $('#tt').tabs('select',tc);
    	 }else{
    		 //如果不存在就需要添加
        	 $('#tt').tabs('add',{    
        		    title:tc,    
        		    content:'<iframe src= "<%=request.getContextPath()%>" + /../"+urls+ "+ " width="100%" height="400px"></iframe>"',    
        		    closable:true,    
        		    tools:[{    
        		        iconCls:'icon-mini-refresh',    
        		        handler:function(){    
        		            alert('refresh');    
        		        }    
        		    }]    
        	  });  
    	 } 	
    	 
     }
</script>
</head>
<body>
<body class="easyui-layout">   
    <div data-options="region:'north',collapsible:false" style="height:100px;"></div>   
    <div id="ms" data-options="region:'west',title:'菜单栏目',collapsible:false" style="width:200px;">
    </div>   
    <div data-options="region:'center'" style="background:#eee;">
       <div id="tt" class="easyui-tabs" style="height:450px;">   
          
      </div>  
  </div>   
</body> 
</body>
</html>