<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		//调用webservice返回 集合list 
		$("#btu-ajax-list").click(function() {
			var username = $("#username").val();
			if ($.trim(username) == "") {
				alert("请输入姓名 ！ ");
				return;
			}
			//定义请求体 	  
			var str = '<?xml version="1.0" encoding="UTF-8"?>'
					+ '<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">'
					+ '<soap:Body><ns2:getStudentList xmlns:ns2="http://teach.cxf.hj.com.cn/">'
					+ '<arg0>'
					+ username
					+ '</arg0>'
					+ '</ns2:getStudentList></soap:Body></soap:Envelope>';

			//ajax调用webservice 服务 		  
			$.ajax({
				contentType : 'application/xml;charset="UTF-8"',
				dataType : 'xml',
				type : 'post',
				url : 'http://localhost:8088/ws_cxf_study_web/services/helloTeachService', //调用webservice服务 
				data : str,
				success : function(data) {
				//对返回后的数据进行解析
				$(data).find("return").each(function() {
				var sid = $(this).find("sid").text();
				var username = $(this).find("username").text();
				var address = $(this).find("address").text();
				var msg = sid+ ","+ username+ ","+ address;
				$("<div>").html(msg).css("border","1px solid blue").css({width : '50%'}).appendTo($("body"));
							});
						},error : function(xhr, status) {
							alert("出错了:" + status);
					}
				}, "xml");
			});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<label for="name">学号：</label>
	<input type="text" id="userid" name="userid" />
	<input type="button" id="btu-ajax" value="ajax调用webservice">
	<br />
	<label for="name">姓名：</label>
	<input type="text" id="username" name="username" />
	<input type="button" id="btu-ajax-list" value="ajax调用webservice-list">
	<br />
</body>
</html>