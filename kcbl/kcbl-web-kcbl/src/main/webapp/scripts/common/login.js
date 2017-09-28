(function($){
	$(document).ready(function(){
		$("#login").click(function(){
			if($("#account").val()==""){
				HostApp.toast('用户名不能为空');
				return;
			}else if($("#password").val()==""){
				HostApp.toast('密码不能为空');
				return;
			}else{
				var options={
						url:'/kcbl-web-kcbl/blxx/login.action',
						type:'POST',
						dataType:'JSON',
						success:function(data){
							var flag=data.flag;
							if(flag=="true"){
								window.location.href='/kcbl-web-kcbl/blxx/toblList.action';
							}else{
								HostApp.toast('用户名或密码不正确');
							}
						},
						error:function(){
							HostApp.toast('系统繁忙');
						}
				}
				$("#login-form").ajaxSubmit(options); 
			}
		});
	});
	
})(jQuery);
