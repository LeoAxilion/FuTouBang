<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ path + "/image/BCC/";
%>
<!Doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<base href="<%= basePath %>" />
		<title>登录页面</title>
		<style type="text/css">
			body{
				background-image:url(<%=basePath %>/pic_login/bg_login.jpg);
			}
			#main_login{
				width:500px;
				margin:0 auto;
			}
			.logo_login{
				margin:128px 0 20px 0;
			}
			input{
				border:0;
			}
			.p_login{
				font-size:18px;
				color:#074BA0;
				border-bottom:1px solid #074BA0;
			}
			.submit_login{
				margin:52px  0 0 316px;
				width:184px;
				height:60px;
				font-size:24px;
				color:white;
				background-color:#074BA0;
			}
			.input_login{
				height:30px;
				width:200px;
				outline:none;
				font-size:18px;
			}
			
		</style>
	</head>
	<body>
		<div id="main_login">
			<img src="<%=basePath %>/pic_login/logo_login.png" class="logo_login"/>
			<p style="color:red;font-weight:900">${msg }</p>
			<form action="<c:url value='/LoginServlet'/>" method="post">
					<p class="p_login">用户名：<input class="input_login" type="text" name="username" value="${user.username }"/></p>
					<br/>
					<p class="p_login">密&nbsp;码：<input class="input_login" type="password" name="password" value="${user.password }"/></p>
					<input class="submit_login" type="submit" value="登录" style="cursor:pointer"/>
			</form>
		</div>
	</body>
</html>