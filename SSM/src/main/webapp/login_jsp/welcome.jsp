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
<h1>欢迎登录本系统</h1>
<c:choose>
	<c:when test="${empty sessionScope.sessionUser }">滚</c:when>
	<c:otherwise>
		${sessionScope.sessionUser }
	</c:otherwise>
</c:choose>
	</body>
</html>