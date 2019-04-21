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
	<title>启明星管理员注册</title>
	<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
	<link rel="stylesheet" href="D_qmx/bootstrap-3.3.7/css/bootstrap.min.css">
	<script src="D_qmx/bootstrap-3.3.7/js/jquery.min.js"></script>
	<script src="D_qmx/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="D_qmx/csses/login.css">
	<script type="text/javascript">
		$(document).ready(function() {
			//alert("测试jQuery是否能用");
			$("#form1").submit(function() {
				var name = $("#name").val();//获取提交的值
				if (name.length == 0) {//进行判断，如果获取的值为0那么提示账号不能为空
					//alert("aa");//测试使用
					$("#nameError").html("账号不能为空");
					return false;
				}
			
				//密码验证不能为空
				var password=$("#password").val();
				if(password.length==0){
					$("#passwordError").html("密码不能为空");
					return false;
				}
			
				//确认密码进行验证
				var relpassword=$("#relpassword").val();
				if(relpassword.length==0){
					$("#relpasswordError").html("确认密码不能为空");
					return false;
				}
			
				if(password!=relpassword){
					$("#relpasswordError").html("确认密码输入不正确，请重新输入!");
					return false;
				}
			
			});
		});
	</script>
</head>
<body>
	<div class="container box">
		<div class="container-small">
			<h2>管理员注册</h2>
			<form id="form1" action="<%= request.getContextPath() %>/Register" method="post" >
				<div class="user">
					<span class="glyphicon glyphicon-user"></span>
					<input type="text" name="zhanghao" id="name" class="inputs" placeholder=" 用户名">
				</div>
				<div id="nameError"></div>
				<div class="user">
					<span class="glyphicon glyphicon-lock"></span>
					<input type="password" name="password" id="password" class="inputs" placeholder=" 密码">
				</div>
				<div id="passwordError"></div>
				<div class="user">
					<span class="glyphicon glyphicon-lock"></span>
					<input type="password" name="repassword" id="relpassword" class="inputs" placeholder=" 确认密码">
				</div>
				<div id="relpasswordError"></div>
				<div class="Login">
					<input type="submit" class="logins" value="注册">
				</div>
				<div class="form-group pull-right">已有账号 &nbsp;&nbsp;<a href="D_qmx/login.jsp">登录</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>