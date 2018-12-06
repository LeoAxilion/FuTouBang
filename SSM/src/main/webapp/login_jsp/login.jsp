<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<!Doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<base href="<%= basePath %>" />
		<title>This is my JSP</title>
	</head>
	<body>
		<h1>登录</h1>
		<p style="color:red;font-weight:900">${msg }</p>
		<form action="<c:url value='/LoginServlet'/>" method="post">
			用户名：<input type="text" name="username" value="${user.username }"/><span style="color:red">${errors.username }</span><br/>
			密   码：<input type="password" name="password" value="${user.password }"/><span style="color:red">${errors.password }</span><br/>
			验证码：<input type="text" name="verifyCode" value="${user.verifyCode }" size="3"/>
				  <img id="vCode" src="<c:url value='/VerifyCodeServlet'/>" border="2"/>
				  <a href="javascript:_change()">换一张</a><span style="color:red">${errors.verifyCode }</span><br/>
			<input type="submit" value="登录"/>
		</form>
	</body>
</html>