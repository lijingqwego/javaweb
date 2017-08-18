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
		
    </head>
    <body>
        <div id="loginbox">            
            <form class="form-vertical" action="${pageContext.request.contextPath }/login.action" method="post"  >
				 <div class="control-group normal_text">
				  <div id="message" >输入用户名和密码继续... </div>
				  </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_lg"><i class="icon-user"></i></span><input type="text" name="loginid" placeholder="loginid" />
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_ly"><i class="icon-lock"></i></span><input type="password" name="password" placeholder="password" />
                        </div>
                    </div>
                </div>
                <div class="form-actions" align="center">
                    <input type="submit" class="btn btn-success" value="    登录    ">
                </div>
            </form>
        </div>
        
    </body>

</html>
