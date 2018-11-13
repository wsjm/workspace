<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="../easyui/jquery.min.js"></script>

 <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>

 <link href="../easyui/themes/default/easyui.css" rel="stylesheet" type="text/css"/>

 <link href="../easyui/themes/icon.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript">
function add(tc,url){
//是否存在
 
	if($("#tt").tabs('exists',tc)){
		$("#tt").tabs('select',tc);
	}else{
		$('#tt').tabs('add',{    
		    title:tc,    
		    content:'<iframe height=\"500px\" width=\"100%\" src=' +''+url+''+ '></iframe>',    
		    closable:true,    
		    tools:[{    
		        iconCls:'icon-mini-refresh',    
		        handler:function(){
		            alert('refresh');    
		        }    
		    }]    
		});
		
	}
	
	
   
}; 

</script>
</head>

<body class="easyui-layout">   


<a href="#" onclick="javascript:$('#pp').panel('open')">Open</a>

    <div data-options="region:'north'" style="height:100px;">1</div>   
     
    <div data-options="region:'west',title:'菜单列表',collapsible:false" style="width:100px;">
    <a href="javascript:add('用户列表','../index.jsp')"  >用户列表</a><br/>
   
     <a href="javascript:add('管理员列表','ajxa02.jsp')"  >管理员列表</a> 
</div>  
    
    
    
      
    <div data-options="region:'center'," style="padding:0px;background:#eee;">
    <div id="tt" class="easyui-tabs" style="height:400px;">   
    <div title="Tab1"  style="padding:20px;display:none;">   
        tab1
    </div>   
    <div title="Tab2" id="tab2" data-options="false" style="overflow:auto;padding:20px;display:none;">   
        tab2    
    </div>   
    <div title="Tab3" data-options="iconCls:'icon-reload'false" style="padding:20px;display:none;">   
        tab3    
    </div>   
    </div>   
</body>  

</html>