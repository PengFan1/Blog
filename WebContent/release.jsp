<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Release Web</title>
<link href = "./css/nodejs.css" rel = "stylesheet"/>

	<style>
		
		.main {
			min-height: 400px;
		}
			
		.main .panel {
			margin-bottom: 13px;
		}
		
		.main .panel .inner {
			line-height: 2em;
		}
/* header ------------------------------------------------*/	
		.main .panel .header {
			padding: 10px;
			background-color: #f6f6f6;
			border-radius: 3px 3px 0 0;
		}
		
		.header .col_fade {
			color: #444;
		}
		
		.main .panel .header .breadcrumb {
			padding: 0;
			margin: 0;
			border: none;
			background: 0 0;
		}
		
		.main .panel .header .breadcrumb li	{
			display: inline-block;
		}
		
		.main .panel .header .breadcrumb a {
			color: #80bd01;
		}
		
		.main .panel .header .breadcrumb li .divider {
			padding: 0 5px;
			color: #ccc;
		}
		
		.main .panel .header .breadcrumb .active {
			color: #999;
		}
/* inner ------------------------------------------------*/
		.main .panel .inner {
			padding: 10px;
			border-radius: 0 0 3px 3px;
			background: #fff;
			
		}
		
		.panel .inner .form-horizontal{
			margin-top: 40px;
		}
		
		.form-horizontal .control-group {
			margin-bottom: 20px;
		}
		
		.form-horizontal .control-label {
			float: left;
			width: 160px;
			text-align: right;
			color: #3c3c3c;
		}
		
		.form-horizontal .controls {
			margin-left: 180px;
		}
		
		.input-xlarge {
			margin-bottom: 0;
			border: 1px solid #ccc;
			padding: 4px 6px;
			border-radius: 4px;
			width: 500px;
			box-shadow: 0 0 2px rgba(60,60,60,.5);
			
			color: rgb(0, 0, 0);
			font-size: 17px;
			font-family: 微软雅黑;
			font-weight: normal;
			background-color: transparent;
			
			text-align: center;
		}
		.input-xlarge2 {
			margin-bottom: 0;
			border: 1px solid #ccc;
			padding: 4px 6px;
			border-radius: 4px;
			width: 500px;
			height: 300px;
			box-shadow: 0 0 2px rgba(60,60,60,.5);
			
			color: rgb(0, 0, 0);
			font-size: 15px;
			font-family: 微软雅黑;
			font-weight: normal;
			background-color: transparent;
			
			text-align: left;
		}
		
		
		.form-horizontal .form-actions {
			padding-left: 180px;
		}
		
		.form-actions {
			padding: 19px 20px 20px;
			margin: 20px 0;
		}
		
		.span-primary {
			border-radius: 3px;
			background-color: #08c;
			border: none;
			padding: 3px 10px;
			letter-spacing: 2px;
			line-height: 2em;
			color: #fff;
			
			cursor: pointer;
			transition: all .2s ease-in-out;
		}
		
		.span-primary:hover {
			background-color: #05c;
		}
		
		.span-info {
			display: inline-block;
			padding: 3px 10px;
			border: none;
			letter-spacing: 2px;
			color: #fff;
			border-radius: 3px;
			
			background-color: #5bc0de;
			
			cursor: pointer;
			transition: all .2s ease-in-out;
		}
		.span-info:hover {
			background-color: #2f96b4;
		}
		
		.panel .inner a {
			color: #778087;
		}
		.forgot_password {
			margin-left: 1em;
		}
		
	</style>

</head>
<body>

<!-- 页眉 -->
	<div class = "nav_head">
		<div class="nav_two">
			<div class="nav_three">
				
				<a class="logo_herf" href="#">
					<img class="logo" src="./img/cnodejs_light.svg">
				</a>
				
				<from class = "serch-from">
					<input class="serch" type="text" />
				</from>
				
				<ul class="nav_ul">
					<li> <a href="/blog"> 首页 </a></li>
					<li> <a href="#"> 新手入门 </a></li>
					<li> <a href="#"> API </a></li>
					<li> <a href="#"> 关于 </a></li>
					<li> <a href="#"> 注册 </a></li>
					<li> <a href="#"> 登录 </a></li>
				</ul>
					
			</div>
		</div>
	</div>
	<div class = "main">
		<div class = "main-right">
			<div class = "list-right">
				<div class = "panel">
					<div class = "header">
						<span class = "col_fade"> 关于 </span>
					</div>
					<div class = "inner">
						<p>天翊三部：博客专业中文社区</p>
						<p>你可以在这里：</p>
						<ul>
							<li>向别人提出你遇到的问题</li>
							<li>帮助遇到问题的人</li>
							<li>分享自己的知识</li>
							<li>和其他人一起进步</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		<div class = "main-left">
			<div class = "list-left">
				<div class = "panel">
					<div class = "header">
						<ul class = "breadcrumb">
							<li>
								<a href = "#"> 主页 </a>
								<span class = "divider"> / </span>
							</li>
							<li class ="active">
								登录
							</li>
						</ul>
					</div>
					<div class = "inner">
					${msg}
						<div class = "form-horizontal">
						<form action = "/release" method = "post">
							<div class = "control-group">
								<!-- <label class = "control-label">标题</label> -->
								<div class = "controls">
									<input name = "title" class = "input-xlarge" size = "30" type="text" placeholder="请在这里输入博文标题"/>
								</div>
							</div>
							<div class = "control-group">
								<!-- <label class = "control-label">内容</label> -->
								<div class = "controls">
									<textarea name = "content" class = "input-xlarge2" size = "30" type="text" placeholder="请在这里输入博文内容"></textarea>
								</div>
							</div>
							<div class = "control-group">
								<!-- <label class = "control-label">分类</label> -->
								<div class = "controls">
										分类：<select name="blog_sort_id">
										    <option value="1">分类</option>
											<option value="2">精华</option>
											<option value="3">问答</option>
											<option value="4">招聘</option>
											<option value="5">客户端测试</option>
										</select>
								</div>
							</div>
							<div class = "form-actions">
								<input class = "span-primary" value = "发表" type = "submit"/>
								<a href = "regist.jsp">
									<span class = "span-info"> 取消 </span>
								</a>
								<a class = "forgot_password" href = "#">忘记密码了？</a>
							</div>
						</form>
						</div>
					</div>
				</div>
			</div>
		</div>	
	</div>
	<div class = "footer">
		<div class = "footer-main">
				<div class = "links">
					<a href = "#">STX</a>
					丨
					<a href = "#">天翊三部</a>
				</div>
				<div class = "col-fade">
					<p> 或许是不知梦的缘故，流离之人追逐光影~ </p>
					<p>
						服务器赞助商为
						<a href = "#">
							<img src = "./img/zan1.jpg">
						</a>
						，存储赞助商为
						<a href = "#">
							<img src = "./img/zan2.jpg">
						</a>
						，由
						<a href = "#">
							<img src="./img/zan3.jpg">
						</a>
						提供应用性能服务。
					</p>
					<p>
						本静态网页由个人随意搭建，如有雷同，纯属巧合。请到点击这里→
						<a href = "#">
							漂亮小姐姐哦！
						</a>
					</p>
				</div>
			</div>
	</div>
</body>
</html>