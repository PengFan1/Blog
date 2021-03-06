<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home Web</title>
		<link href = "./css/nodejs.css" rel = "stylesheet"/>		
		<style></style>
	</head>
	<body>
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
					<div class = "login">
						<div class = "login-title"> 天翊三部：博客专业中文社区 </div>
						
						<div class="goto-login_1">
							<c:choose>
								<c:when test="${user!=null}">
									欢迎：${user.nikename} <div class = "cancellation"> <a href = "/cancellation"> 注销 </a> </div>
								</c:when>
								<c:otherwise>
									你可以 <a class ="button" href="/regist.jsp">注册</a> 或者
								</c:otherwise>
							</c:choose>
						</div>
						
						<div class="goto-login">
							<c:if test="${user!=null}">
								<a class="button" href="/release.jsp">写文章</a>
							</c:if>
						</div>
						
						<div class="goto-login">
							<c:choose>
								<c:when test="${user!=null}">
									<a class="button" href="#">个人中心</a>
								</c:when>
								<c:otherwise>
									<a class="button" href="/login.jsp">点击 登录</a>
								</c:otherwise>
							</c:choose>
						</div>
						
					</div>
					<div class = "ad">
						<img class = "ad-img" src = "./img/1.jpg">
						<img class = "ad-img" src = "./img/2.jpg">
						<img class = "ad-img" src = "./img/3.png">
						<img class = "ad-img" src = "./img/4.png">
						<img class = "ad-img" src = "./img/5.png">
					</div>
					<div class = "hot-blog">
						<div class = "hb">
							<span class = "hb-title"> 热门博文排行榜 </span>
						</div>
						<div class = "hb-c">
							<ul class = "hb-content">
								<li><a href = "#"> 第一条：吃吃吃吃吃吃 </a></li>
								<li><a href = "#"> 第二条：喝喝喝喝喝喝 </a></li>
								<li><a href = "#"> 第三条：玩玩玩玩玩玩 </a></li>
								<li><a href = "#"> 第四条：睡睡睡睡睡睡 </a></li>
								<li><a href = "#"> 第五条：皮皮皮皮皮皮 </a></li>
							</ul>
						</div>
					</div>
					<div class = "friendly">
						<div class = "f">
							<span class = "f-title"> 友情社区 </span>
						</div>
						<div class = "f-content">
							<img class = "f-img" src = "./img/6.png">
							<img class = "f-img" src = "./img/7.png">
							<img class = "f-img" src = "./img/8.png">
							<img class = "f-img" src = "./img/9.png">
						</div>
					</div>
					<div class = "qr-code">
						<div class = "qr">
							<span class = "qr-title"> 我的微信二维码 </span>
						</div>
						<div class = "qr-content">
							<img class = "qr-img" src = "./img/pang.jpg">
							<br>
							<a href = "#"> ↑此处应有二维码 </a>
						</div>
					</div>
				</div>
			</div>
			<div class = "main-left">
				<div class = "list-left">
					<div class = "list-left-head">
						<ul class = "list-left-menu">
							<li> <a href = "#" class = "active"> 全部 </a></li>
							<li> <a href = "#"> 精华 </a></li>
							<li> <a href = "#"> 分享 </a></li>
							<li> <a href = "#"> 问答 </a></li>
							<li> <a href = "#"> 招聘 </a></li>
							<li> <a href = "#"> 客户端测试 </a></li>
						</ul>
					</div>
					
					
					
					<c:forEach items="${blogs}" var="blog">
						<div class = "list-left-content">
						
							<div class = "auth"> <a href = "#"> <img src = "./img/327019.jpg"> </a></div>
							<div class = "number"> <span> 27/3127 </span> </div>
							<div class = "top"> <span class = "active"> ${blog.sort}  </span></div>
							<div class = "title"> 
								<a href = "/show?id=${blog.id}"> ${blog.title} </a> 
							</div>
							<div class = "time">
								<span class = "auth-img"> 
									<img src = "./img/35259101.png">
								</span> 
								<span class = "hour"> 27分钟 </span>
							</div>
						</div>
					</c:forEach>	
					
					<div class = "list-left-footer">
						<div class = "first-page"><a href = "#"> « </a></div>
						<div class = "other-page"><a class = "active" href = "#"> 1 </a></div>
						<div class = "other-page"><a href = "#"> 2 </a></div>
						<div class = "last-page"><a href = "#"> » </a></div>
					</div>
					
				</div>
			</div>
		</div>
		<div class ="footer">
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