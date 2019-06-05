<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body background="<%=basePath%>images/bgs.jpg">

	<div class="">
		<div class="title" style=" text-align:center; font-size:60px">
			日记</div>
	</div>
	<hr>

	<div>
		<h1>修改用户:</h1>
		<form class="" action="<%=path%>/servlet/NewsServlet?action=updateU"
			method="post">
			<input type="hidden" value="${UserBean.id}" name="id"></input>
			用户名：
			<input type="text" name="name" value="${UserBean.name}">
			
			</input>
			<br />
			用户密码：
			<input type="text" name="password"  value="${UserBean.password}">
			</input>
			<br />
			<input type="submit" value="更新">
		</form>
	</div>
	<button type="button" onclick="javascript:history.back(-1);">返回</button>
</body>
</html>
