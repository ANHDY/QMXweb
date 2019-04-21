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
	<title>启明星招新</title>
	<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
	<link rel="stylesheet" type="text/css" href="D_qmx/bootstrap-3.3.7/css/bootstrap.min.css">
	<script src="D_qmx/bootstrap-3.3.7/js/jquery.min.js"></script>
	<script src="D_qmx/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="D_qmx/font-awesome-4.7.0/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="D_qmx/csses/qmx.css">
	<script type="text/javascript" src="D_qmx/jses/qmx.js"></script>
	
</head>
<body>
	<header>
		<div class="container">
			<div class="yinru">
				<div class="up">
					<a href="D_qmx/login.jsp"><img src="D_qmx/img/logo2.png"></a>
				</div>
				<h1>启明星</h1>
				<p>今日之启明，明日之明星，是我们共同的信念。</p>
				<p>Make a difference 是我们执着的追求。</p>
				<a href="javascript:void(0)" onclick="document.getElementById('baoming').scrollIntoView();" class="maodian"><i class="down"><img src="D_qmx/img/01.png"></i></a>
			</div>
		</div>
	</header>
	<section>
		<div class="container" id="zhaoxin">
			<div class="col-xs-offset-2 col-sm-offset-0">
				<div class="signup col-md-3 col-sm-6 col-xs-10">
					<i class="fa fa-send-o"></i>
					<h3 class="exam">招新宣传</h3>
					<p>你可以开始慢慢了解启明星啦</p>
					<p class="day">9月3日~9月9日 第一周</p>
				</div>
			</div>
			<div class="col-xs-offset-2 col-sm-offset-0">
				<div class="signup col-md-3 col-sm-6 col-xs-10 singup1">
					<i class="fa fa-gg"></i>
					<h3 class="exam">招新报名</h3>
					<p>在此网站填写你的信息，加入我们</p>
					<p class="day">9月3日~9月9日 第一周</p>
				</div>
			</div>
			<div class="col-xs-offset-2 col-sm-offset-0">
				<div class="signup col-md-3 col-sm-6 col-xs-10">
					<i class="fa fa-pencil-square-o"></i>
					<h3 class="exam">笔试</h3>
					<p>在机房进行笔试，发短信告知地点时间</p>
					<p class="day">9月3日~9月9日 第一周</p>
				</div>
			</div>
			<div class="col-xs-offset-2 col-sm-offset-0">
				<div class="signup col-md-3 col-sm-6 col-xs-10 singup1">
					<i class="fa fa-handshake-o"></i>
					<h3 class="exam">面试</h3>
					<p>在工作室面对面交流，说出自己的想法</p>
					<p class="day">9月3日~9月9日 第一周</p>
				</div>
			</div>
		</div>
	</section>
	<section>
		<div class="container">
			<h2>Story About Us</h2>
			<div class="idea col-sm-8 col-sm-offset-2">
				<div class="col-md-5" style="text-align: center;">
					<img src="D_qmx/img/llogo.jpg">
					<div class="btn btn0">
						<a href="https://www.ctguqmx.com/question/">官方论坛</a>
					</div>
					<div class="btn btn0">
						<a href="https://baike.baidu.com/item/%E4%B8%89%E5%B3%A1%E5%A4%A7%E5%AD%A6%E5%90%AF%E6%98%8E%E6%98%9F%E5%88%9B%E6%96%B0%E5%AE%9E%E9%AA%8C%E5%AE%A4/18559411">百度百科</a>
					</div>
					<div class="btn btn0">
						<a href="D_qmx/img/qq.jpg">QQ群聊</a>
					</div>
				</div>
				<div class="col-md-7 idea_small">
					<p class="handline">启明星</p>
					<p>2009年3月，在学院领导的支持下，三峡大学计算机与信息学院的学生自发组织了一个实训实验室。这是第一个由学生自主管理自己的天地，它有一个充满活力而且响亮名字：“启明星”</p>
					<p>Make a difference是工作室的理念，来自李开复老师的一篇文章：“知道什么是make a difference吗？想象有两个世界，一个世界中有你，一个世界中没有你，让两者的不同最大，最大化你的影响力，这就是你一生的意义。” 希望所有人在工作室这个平台能实现自己的梦想，最大化自己的不同。同样，工作室的目的也在于此，让今天的你与昨天的你不同，让四年后的你与现在的你不同。 </p>
					<p>总之启明星工作室是同学们学习的乐园，是三峡大学的一大亮点组织。非常欢迎大家的加入。</p>
				</div>
			</div>
		</div>
		<div class="found">
			<div class="container">
				<div class="row">
					<div class="col-sm-7 col-xs-12">
						<p class="found_p">工作室成立以来从最初的十几名学生，到如今由开发组、硬件组共同组成了一百多名学生。工作室内部实现自我管理，不仅在老师的带领下完成各种项目，也通过自身的不断努力学习软件开发等相关技术。同时在老一代成员的带领下，不断地传承工作室的理念，促进工作室的发展。 工作室一方面解决同学们动手能力落后于其他高校的现状，促进同学们的就业，为同学们实现理想提供优良的环境与基石；另一方面工作室是同学们展示能力，提高技术的平台，这里集中了三峡大学最优秀的软件开发、网站制作、数据库开发、影视编辑、硬件编程、三维可视化、游戏开发的本科生。</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section>
		<div class="container">
			<h2>Welcome</h2>
			<div class="idea col-sm-8 col-sm-offset-2">
				<img src="D_qmx/img/02.jpg" class="col-sm-5 col-xs-12">
				<div class="col-sm-7  col-xs-12 idea_biaoyu">
					<p>在这里，我们尝试去学习新的技术；</p>
					<p>在这里，我们挑战更高难度的项目；</p>
					<p>在这里，让你我不同；</p>
					<p>启明星，在这里......</p>
				</div>
			</div>
		</div>
		<div class="found2">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<h3>我们的成绩</h3>
						<p class="found_p">2015年,获得国家级奖21项，省级奖21项，共42项</p>
						<p class="found_p"> 2016年,获得国家级奖8项，省级奖28项，共36项</p>
						<p class="found_p">2017年,获得国家级奖15项，省级奖46项，共61项</p>
						<p class="found_p">湖北省第十三届运动会成绩统计系统，项目经费3.7万元</p>
						<p class="found_p">宜昌市超高压输电公司车辆管理系统，项目经费1万元</p>
						<p class="found_p">更多精彩等你开启 . . .</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section class="introduce">
		<div class="container">
			<h2>各组简介</h2>
			<div class="data">
				<ul class="nav">
					<li class="active"><a href="#menu2" data-toggle="tab">开发组</a></li>
					<li><a href="#menu3" data-toggle="tab">硬件组</a></li>
				</ul>
			</div>
			<div class="tab-content">
				<div id="menu2" class="tab-pane fade in active">
					<img src="D_qmx/img/04.jpg" class="col-sm-6 col-xs-12 col-sm-offset-3">
					<p class="col-sm-8 col-sm-offset-2">开发组主要学习超文本标记语言HTML，脚本语言JavaScript，编程语言java PHP .NET。后台数据库，web后台服务器的管理，同时也可以学习java、C++、C、QT、OC等编程语言和竞赛算法以及android，COCOS-2dx,WP等平台的软件开发和游戏开发。组内成员在完成自己专业的学习以及前端学习的前提下可以根据自己的兴趣选择后台学习的语言,等基础积累到达一定程度后可选择向网络这一更深的领域学习。前期的学习每周都会有固定的任务需要成员拿出每周的学习成果来，每个学期结束亦有寒暑假任务进行学期答辩。组内答辩优秀者可进一步完善作品参加组间答辩。 </p>
				</div>
				<div id="menu3" class="tab-pane fade">
					<img src="D_qmx/img/05.jpg" class="col-sm-6 col-xs-12 col-sm-offset-3">
					<p class="col-sm-8 col-sm-offset-2">启明星硬件组主要学习51,AVR,STM32,Arduino单片机开发，涉足嵌入式系统及智能硬件开发。聚集了众多喜欢编程，热爱硬件设计与开发的三大学子。硬件组思想自由，开容并包，每位同学都可以尽情阐述自己的观点和想法。我们每个周日的晚安排有例会，每位成员轮流总结一周的学习情况，其他成员可提问和补充，轮流总结完毕后是我们的每周一讲，大约进行40分钟，每位同学都有机会将自己最近一段时间学到的新知识或者新的想法分享给大家，感兴趣的同学可以下去后查阅了解更多或者更加深入的学习。 </p>
				</div>
			</div>
		</div>
	</section>
	<section class="info">
		<div class="container" id="baoming">
			<h2>报名啦 ✧٩(ˊωˋ*)و✧</h2>
			<div class="box">
				<form role="form" action="<%= request.getContextPath() %>/BaoMing" method="post" id="form1">
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
					</div>
					<div class="men">
						<p>性别：</p>
						<label class="radio-inline col-sm-push-1 col-xs-push-1">
							<input type="radio" name="sex" value="男生" checked>男生
						</label>
						<label class="radio-inline col-sm-push-1 col-xs-push-1">
							<input type="radio" value="女生" name="sex">女生
						</label>
					</div></br>
					<div class="men">
						<p>选择组别：</p>
						<label class="radio-inline col-sm-push-1 col-xs-push-1">
							<input type="radio" name="hobby" value="开发组" checked>开发组
						</label>
						<label class="radio-inline col-sm-push-1 col-xs-push-1">
							<input type="radio" name="hobby" value="硬件组">硬件组
						</label>
					</div>
					<input class="btn1 btn-primary" type="submit" value="报名" />
				</form>
			</div>
		</div>
	</section>
	<footer>
		Copyright © 2019 <span class="glyphicon glyphicon-heart"></span> Design by 启明星
	</footer>

</body>
</html>