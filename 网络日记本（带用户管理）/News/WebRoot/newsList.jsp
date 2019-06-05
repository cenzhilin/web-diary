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

<script type="text/javascript">
	function del() {
		 
		if (confirm("你真的要删除这些日记吗？")) {
			var f = document.forms[0];
			f.action ="<%=path%>/servlet/NewsServlet?action=delete";
			f.submit();
		} else {
			return;
		}
	}
	function udel() {
		 
		if (confirm("你真的要删除这些用户吗？")) {
			var f = document.forms[2];
			f.action ="<%=path%>/servlet/NewsServlet?action=udelete";
			f.submit();
		} else {
			return;
		}
	}
</script>
</head>
<body background="<%=basePath%>images/bgs.jpg">

	<div class="">
		<div class="title" style=" text-align:center; font-size:60px">
			日记</div>
	</div>
	<hr>
	<div class="">
		<h1>发布历史:</h1>
		<form action="" method="post">
			<c:forEach var="n" items="${NL }">
		${n.id }
		<a href="<%=path%>/servlet/NewsServlet?action=show&id=${n.id }">${n.title }
				</a>
				<c:if test="${isManager}">&nbsp&nbsp&nbsp&nbsp <a
						href="<%=path%>/servlet/NewsServlet?action=toEdit&id=${n.id }">修改</a>
					<input type="checkbox" name="ids" value="${n.id }"></input>
				</c:if>
				<br />

			</c:forEach>
			<c:if test="${isManager}">
				<input type="button" value="删除" onclick="del();"></input>
			</c:if>
		</form>
	</div>
	<hr>
	<c:if test="${isManager}">
		<div>
			<h1>发布日记:</h1>
			<form class="" action="<%=path%>/servlet/NewsServlet?action=add"
				method="post">
				日记标题： <input type="text" name="title" value="限中文12，英文25"> </input> <br />
				日记文本：
				<textarea name="text" rows="5" cols="100">限500英文字符，1中文等于2英文
</textarea>
				<br /> <input type="submit" value="发布">
			</form>
		</div>
	</c:if>
	
	
	<div>
	<c:if test="${isManager}">
	
	<hr>
	<h1>用户管理：</h1>
	<form action="" method="post">
			
		<table border="1">
		<tr>
				<th>用户ID</th>
				<th>用户名</th>
				<th>密码</th>
				<th>是否管理员</th>
				<th>修改</th>
				<th>删除</th>
			</tr>
			<c:forEach var="u" items="${UL }">
			<tr>
			<td>${u.id }</td>
			<td>${u.name }</td>
			<td>${u.password }</td>
			<td>${u.ismanager }</td>
			<td><a href="<%=path%>/servlet/NewsServlet?action=toEditU&id=${u.id }">修改</a></td>
			<td><input type="checkbox" name="uids" value="${u.id}"></input></td>
		
			</tr>
			</c:forEach>
		</table>

				<br />

				<input type="button" value="删除" onclick="udel();"></input>
		
		</form>
	</c:if>
	</div>
	<button type="button" onclick="javascript:history.back(-1);">返回</button>
</body>
</html>
