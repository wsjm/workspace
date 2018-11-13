
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch("assets/img/backgrounds/1.jpg");
    
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('.login-form').on('submit', function(e) {
    	var flag = true;
    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    			flag=flag&false;
    		}
    		else {
    			$(this).removeClass('input-error');
    			flag=flag&true;
    		}
    	});
    	if(flag){
    		
    		var username = $('.login-form input[type="text"]').val();
    		var password = $('.login-form input[type="password"]').val();
    		$.getJSON("login.do",{uname:username,pwd:password},function(data){
        	if(data.flag){
        		//登录成功
        		window.location.href="/mainPage/mainindex.jsp";
        	}else{
        		$("#pp1").text(data.msg);
        		
        	}
        	
        });
    	}
    	return false;
    	
    });
    
    
    
});
