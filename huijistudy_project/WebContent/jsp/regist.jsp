<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
 
<head>
        <title>慧极科技</title><meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/matrix-login.css" />
        <link href="${pageContext.request.contextPath }/font-awesome/css/font-awesome.css" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
		<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>  
		
<script type="text/javascript">
$(function(){
	//校验账号是否可用
	$("#loginid").change(function(){
		//发送ajax请求校验账号是否可用
		var loginid = this.value;
		$.ajax({
			url:"${pageContext.request.contextPath }/checkLoginid.action",
			data: "loginid="+loginid,
			type:"POST",
			success:function(result){
				if(result.result!="success"){
					show_validate_msg("#loginid","error",result.result);
				}else{
					show_validate_msg("#loginid","success","用户名可用");
				}
				
			}
		});	 
	});
		
	$("#btn_regist").click(function(){
		//1.拿到要校验的数据.使用正则表达式
		var loginid = $("#loginid").val(); 
		var regloginid=  /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
		//小写或者大写的a-z或者0-9   或者_或者-  3到16位  或者中文2到5位
		if(!regloginid.test(loginid)){
			//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
			show_validate_msg("#loginid","error","账号可以是2-5位中文或者6-16位英文和数字的组合");
			return ;
		}else{
			show_validate_msg("#loginid","success"," ");
		}
		
		
		//2.用户名
		var username = $("#username").val(); 
		var regusername=  /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
		//小写或者大写的a-z或者0-9   或者_或者-  3到16位  或者中文2到5位
		if(!regusername.test(username)){
			//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
			show_validate_msg("#username","error","用户名可以是2-5位中文或者6-16位英文和数字的组合");
			return ;
		}else{
			show_validate_msg("#username","success"," ");
		}
		
		//3.校验密码
		var password = $("#password").val();
		var regpassword=/^[0-9a-zA-Z_#]{6,16}$/;//（6-16位数字和字母的组合） 
		if(!regpassword.test(password)){
			show_validate_msg("#password","error","密码格式不正确");
			return ;
		}else{
			show_validate_msg("#password","success"," ");
			
		}
		
		//4.校验确认密码
		var password2 = $("#password2").val(); //拿到email的值 
		var regpassword2=/^[0-9a-zA-Z_#]{6,16}$/;//（6-16位数字和字母的组合） 
		if(!regpassword2.test(password2)){
			show_validate_msg("#password2","error","密码格式不正确");
			return ;
		}else{
			show_validate_msg("#password2","success"," ");
			
		}
		//4.密码是否一致
		if(password2!=password){
			show_validate_msg("#password2","error","两次密码输入不一致");
			return ;
		}else{
			show_validate_msg("#password2","success"," ");
		}
		
		var userData={'loginid':loginid,'username':username,'password':password};
		
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath }/registUser.action",
			data:userData,
			success:function(result){
				if(result=="success"){
					confirm("恭喜您注册成功！");
					window.location.href="${pageContext.request.contextPath }/loginOut.action";
				}
			}
		});
	});
	
	function show_validate_msg(ele,status,msg){
		$(ele).next("span").text(" ");
		if("success"==status){
			$(ele).next("span").text(msg).css("color","green");
			
		}else if("error"==status){
			$(ele).next("span").text(msg).css("color","red");
		}
	};
});
	
</script>

<style type="text/css">
.control-label{
	color:white;
}
</style>

</head>
    <body>
        <div align="center">
			<h2 style="color:white;">用户注册</h2>
		</div>
        <div id="loginbox">
		<div class="widget-content nopadding">
			<form onsubmit="return false" class="form-horizontal">
				<div class="control-group">
					<label class="control-label">账号 :</label>
					<div class="controls">
						<input type="text" id="loginid" name="loginid"  class="span11"  />
						<span  class="help-block"></span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">用户名 :</label>
					<div class="controls">
						<input type="text" id="username" name="username"  class="span11"  />
						<span  class="help-block"></span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">密码 :</label>
					<div class="controls">
						<input type="password" id="password" name="password"  class="span11"  />
						<span  class="help-block"></span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">确认密码 :</label>
					<div class="controls">
						<input type="password" id="password2" class="span11"  />
						<span  class="help-block"></span>
					</div>
				</div>
				<div class="form-actions">
					<div align="center">
						<button id="btn_regist" class="btn btn-success">注册</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" class="btn btn-success" onclick = "window.history.back(-1);" value="取消">
					</div>
				</div>
			</form>
		   </div>
	   </div>

</body>
</html>