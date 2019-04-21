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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="icon" type="imges/x-icon" href="D_qmx/img/logo.png">
	<title>启明星</title>
	<link rel="stylesheet" type="text/css" href="D_qmx/bootstrap-3.3.7/css/bootstrap.min.css">
	<script src="D_qmx/bootstrap-3.3.7/js/jquery.min.js"></script>
	<script src="D_qmx/bootstrap-3.3.7/css/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="D_qmx/csses/qmx.css">
	<link rel="stylesheet" type="text/css" href="D_qmx/csses/hd.css">
</head>
<body>
	<div class="count-agileits" id="stats">
		<h3 class="heading">qi ming xing</h3>
		<div class="count-grids">
			<div class="col-md-3 count-grid">
				<div class="count">
					<div class="numscroller" >报</div>
					<div class="rw-words">
						<span>HTML</span>
						<span>CSS</span>
						<span>JavaScript</span>
						<span>bootstrap</span>
						<span>jQuery</span>
						<span>make difference</span>
					</div>
				</div>
			</div>
			<div class="col-md-3 count-grid">
				<div class="count">
					<div class="numscroller">名</div>
					<span></span>
					<div class="rw-words">
						<span>C</span>
						<span>C++</span>
						<span>Java Web</span>
						<span>算法</span>
						<span>AVR</span>
						<span>study</span>
					</div>
				</div>
			</div>
			<div class="col-md-3 count-grid">
				<div class="count">
					<div class="numscroller">成</div>
					<span></span>
					<div class="rw-words">
						<span>STM32</span>
						<span>COCOS-2dx</span>
						<span>AVR</span>
						<span>Arduino</span>
						<span>51</span>
						<span>family</span>
					</div>
				</div>
			</div>
			<div class="col-md-3 count-grid">
				<div class="count">
					<div class="numscroller">功</div>
					<span></span>
					<div class="rw-words">
						<span>Java Web</span>
						<span>Arduino</span>
						<span>STM32</span>
						<span>JavaScript</span>
						<span>COCOS-2dx</span>
						<span>friendly</span>
					</div>
				</div>
			</div>
		</div>
		<div class="box">
			<form role="form" action="<%= request.getContextPath() %>/stuUpdate" method="post" id="form1">
				<h2>确定信息✧٩(ˊωˋ*)و✧</h2>
				<div class="form-group">
					<input type="hidden" class="form-control" id="id"  name="id" value="${user.id}">
					<label>姓名：</label>
					<input type="text" class="form-control" name="username" id="names" value="<%= request.getParameter("username") %>">
					<div id="namesId"></div>
				</div>
				<div class="form-group" style="display:none;">
					<label>学号：</label>
					<input type="text" class="form-control " name="xuehao" id="xuehao" value="<%= request.getParameter("xuehao") %>">
					<div style="color:rgba(68, 59, 114, 0.7)">学号不可修改</div>
				</div>
				<div class="form-group">
					<label>学院：</label>
					<input type="text" class="form-control " name="xueyuan" id="xueyuan" value="<%= request.getParameter("xueyuan") %>">
					<div id="xueyuanId"></div>
				</div>
				<div class="form-group">
					<label>专业：</label>
					<input type="text" class="form-control " name="zhuanye" id="zhuanye" value="<%= request.getParameter("zhuanye") %>">
					<div id="zhuanyeId"></div>
				</div>
				<div class="form-group">
					<label>QQ：</label>
					<input type="text" class="form-control " name="qq" id="qq" value="<%= request.getParameter("qq") %>">
					<div id="qqId"></div>
				</div>
				<div class="form-group">
					<label>联系电话：</label>
					<input type="text" class="form-control " name="phone" id="dianhua" value="<%= request.getParameter("phone") %>">
					<div id="dianhuaId"></div>
				</div>
				<div class="form-group">
					<label>性别：</label>
					<input type="text" class="form-control radio-inline" name="sex"  value="<%= request.getParameter("sex") %>">
				</div>
				<div class="form-group">
					<label>选择组别：</label>
					<input type="text" class="form-control radio-inline" name="hobby" value="<%= request.getParameter("hobby") %>">
				</div>
				<input class="btn1 btn-primary" type="submit" value="确定修改"/>
				<a href="D_qmx/qmx.jsp" class="btn1 btn-primary">无误返回</a>
			</form>
		</div>
	</div>
</body>
</html>