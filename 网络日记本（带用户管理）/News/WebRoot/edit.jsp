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
		<h1>修改信息:</h1>
		<form class="" action="<%=path%>/servlet/NewsServlet?action=update"
			method="post">
			<input type="hidden" value="${NewsBean.id}" name="id"></input>
			日记标题：
			<input type="text" name="title" value="${NewsBean.title}">
			限英文25字符，1中文等于2英文
			</input>
			<br />
			日记内容：
			<textarea name="text" rows="5" cols="100">${NewsBean.text}
</textarea>限500英文字符，1中文等于2英文
			<br />
			<input type="submit" value="更新">
		</form>
	</div>
	<button type="button" onclick="javascript:history.back(-1);">返回</button>
</body>
</html>
