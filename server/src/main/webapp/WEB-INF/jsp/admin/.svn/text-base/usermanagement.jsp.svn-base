<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!Doctype html>
<html xmlns=http://www.w3.org/1999/xhtml>
<head>
<link href="/css/admin/usermanagement.css" type="text/css"
	rel="stylesheet">
<link href="/css/admin/common.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/dwr/engine.js"></script>
<script type="text/javascript" src="/dwr/interface/adminService.js"></script>
<script type="text/javascript" src="/js/admin/usermanagement.js"></script>
</head>
<body>
	<div id="userJsp">
		<table id="userTable">
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>User Login:</td>
					<td><input readonly="readonly" id="login${user.id}"
						value="${user.login}" type="text" /></td>
					<td>User Name:</td>
					<td><input id="name${user.id}" value="${user.name}"
						type="text" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input value="${user.email}" id="email${user.id}"
						type="text" /></td>
					<td><input type="button" value="submit"
						onclick="modifyUser('${user.id}')" /></td>
				</tr>
				<tr>
					<td><br /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
