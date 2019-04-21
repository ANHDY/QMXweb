<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
      //获取绝对路径路径 
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://"
                  + request.getServerName() + ":" + request.getServerPort()
                  + path + "/";
 %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath %>" />
	<meta charset="utf-8">
	<link rel="icon" type="imges/x-icon" href="D_qmx/img/logo.png">
	<title>启明星招新后台登录</title>
	<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
	<link rel="stylesheet" href="D_qmx/bootstrap-3.3.7/css/bootstrap.min.css">
	<script src="D_qmx/bootstrap-3.3.7/js/jquery.min.js"></script>
	<script src="D_qmx/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="D_qmx/csses/login.css">
</head>
<body>
	<div class="container box">
		<div class="container-small">
			<h2>启明星招新后台登录</h2>
			<form action="<%= request.getContextPath() %>/Login" method="post" >
				<div class="user">
					<span class="glyphicon glyphicon-user"></span>
					<input type="text" name="zhanghao" class="inputs">
				</div>
				<div class="user">
					<span class="glyphicon glyphicon-lock"></span>
					<input type="password" name="password" class="inputs">
				</div>
				<div class="Login">
					<input type="submit" class="logins" value="登录">
				</div>
			</form>
		</div>
	</div>
</body>
</html>