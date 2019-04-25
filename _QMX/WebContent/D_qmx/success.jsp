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
	<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
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
		</form>
		<button class="btn" data-toggle="modal" id="a3" data-target="#myModal">添加学生</button>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" 
		                	data-dismiss="modal" aria-hidden="true">&times;
		                </button>
		                <h4 class="modal-title" id="myModalLabel">学生信息</h4>
		            </div>
		            <form role="form" action="<%= request.getContextPath() %>/add" method="post" id="form1">
		            	<div class="modal-body">
							<div class="form-group">
								<label>姓名：</label>
								<input type="text" class="form-control" name="username" id="names" placeholder=" 姓名">
								<div id="namesId"></div>
							</div>
							<div class="form-group">
								<label>学号：</label>
								<input type="text" class="form-control " name="xuehao" placeholder=" 学号" id="xuehao">
								<div id="xuehaoId"></div>
							</div>
							<div class="form-group">
								<label>学院：</label>
								<input type="text" class="form-control " name="xueyuan" placeholder=" 学院" id="xueyuan">
								<div id="xueyuanId"></div>
							</div>
							<div class="form-group">
								<label>专业：</label>
								<input type="text" class="form-control " name="zhuanye" placeholder=" 专业" id="zhuanye">
								<div id="zhuanyeId"></div>
							</div>
							<div class="form-group">
								<label>QQ：</label>
								<input type="text" class="form-control " name="qq" placeholder=" QQ号" id="qq">
								<div id="qqId"></div>
							</div>
							<div class="form-group">
								<label>联系电话：</label>
								<input type="text" class="form-control " name="phone" placeholder=" 联系电话" id="dianhua">
								<div id="dianhuaId"></div>
							</div><br>
							<div class="men man">
								<span>性别：</span>
								<input class="input-b" type="radio" name="sex" value="男生" checked> 男生
								<input class="input-b" type="radio" value="女生" name="sex"> 女生
							</div></br>
							<div class="men"> 
								<span>组别：</span>
								<input class="input-b" type="radio" name="hobby" value="开发组" checked> 开发组
								<input class="input-b" type="radio" value="硬件组" name="hobby"> 硬件组
							</div></br>
							<input type="text" class="change " name="change" id="change" value="test">
		            	</div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		                <button type="submit" class="btn btn-primary">确定</button>
		            </div>
		            </form>
		        </div>
		    </div>
		</div>
		
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
		
		
		
		<table>
			
		</table>
	</div>
</body>
</html>