<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
    
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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="icon" type="imges/x-icon" href="D_qmx/img/logo.png">
	<title>启明星</title>
	<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
	<link rel="stylesheet" type="text/css" href="D_qmx/bootstrap-3.3.7/css/bootstrap.min.css">
	<script src="D_qmx/bootstrap-3.3.7/js/jquery.min.js"></script>
	<script src="D_qmx/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="D_qmx/csses/success.css">
	<script type="text/javascript" src="D_qmx/jses/qmx1.js"></script>
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
    	url="jdbc:mysql://localhost:3306/qmx?serverTimezone=GMT&&useSSL=false&useUnicode=true"
    	user="root"  password="root"/>
	<sql:query dataSource="${snapshot}" var="result">
		SELECT * from qmx;
	</sql:query>
	<div class="container download">
		<form class="header">
			<input type="text" placeholder="按学号查询" id="a1">
			<input type="button" id="a2" onclick="myFunction()" value="查找">
			<input type="button" id="a4" onclick="cancel()" value="取消查找">
			<input type="button" value="新增/隐藏"  id="a3" onclick="dis()">
		</form>
		<table id="b1">
			<tr>
				<th class="col-sm-1">姓名</th>
				<th class="col-sm-1">学号</th>
				<th class="col-sm-1">学院</th>
				<th class="col-sm-1">专业</th>
				<th class="col-sm-1">QQ号</th>
				<th class="col-sm-1">联系方式</th>
				<th class="col-sm-1">性别</th>
				<th class="col-sm-1">选择组别</th>
				<th class="col-sm-1">操作</th>
				<th class="col-sm-1">操作</th>
			</tr>
			<c:forEach items="${result.rows }" var="l">
				<tr>
					<td><c:out value="${l.姓名}"/></td>
					<td><c:out value="${l.学号}"/></td>
					<td><c:out value="${l.学院}"/></td>
					<td><c:out value="${l.专业}"/></td>
					<td><c:out value="${l.qq号}"/></td>
					<td><c:out value="${l.电话号码}"/></td>
					<td><c:out value="${l.性别}"/></td>
					<td><c:out value="${l.选择组别}"/></td>
					<th>
						<a href="Delete?序号=${l.id}" onclick="return window.confirm('确认删除吗?')">删除</a> 
					</th>
					<td><a href="Update?序号=${l.id}">修改</a></td>
				</tr>
			</c:forEach>
			
		</table>
		<!-- 增加 -->
		
		<form action="add" method="post">
		<table id="add" style="display:none">
	        <caption style="font-size:26px;text-align: center;">添加信息</caption>
	        <tr>
	        	<td>姓名:
	        		<input type="text" id="name" name="username"/>
	        	</td>
	        </tr>
	        <tr>
	        	<td>学号:
	        		<input type="text" id="iname" name="xuehao"/>
	        	</td>
	        </tr>
	        <tr>
	        	<td>学院:
	        		<input type="text" id="name1" name="xueyuan"/>
	        	</td>
	        </tr>
	        <tr>
	        	<td>专业:
	        		<input type="text" id="name2" name="zhuanye"/>
	        	</td>
	        </tr>
	        <tr>
	        	<td>qq号:
	        		<input type="text" id="name3" name="qq"/>
	        	</td>
	        </tr>
	        <tr>
	        	<td>手机:
	        		<input type="text" id="name4" name="phone"/>
	        	</td>
	        </tr>
	        <tr>
	        	<td>性别:
	        		<input type="text" id="name5" name="sex"/>
	        	</td>
	        </tr>
	        <tr>
	        	<td>组别:
	        		<input type="text" id="name6" name="hobby"/>
	        	</td>
	        </tr>
	        <tr>
	        	<td>
	        		<input type="submit" value="添加此信息" onclick="add()" class="abc" />
	        	</td>
	        </tr>
    	</table>
		</form>
		
		<table>
			
		</table>
	</div>
</body>
</html>