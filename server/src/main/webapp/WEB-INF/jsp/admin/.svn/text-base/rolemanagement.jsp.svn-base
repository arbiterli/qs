<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!Doctype html>
<html xmlns=http://www.w3.org/1999/xhtml>
<head>
<link href="/css/admin/rolemanagement.css" type="text/css"
	rel="stylesheet">
<link href="/css/admin/common.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/admin/rolemanagement.js"></script>
</head>
<body>
	<div id="roleJsp">
		<label>User Login:</label> <select id="selectUser"
			onchange="selectUser()">
			<c:forEach var="user" items="${userList}">
				<option value="${user.id}">${user.login}</option>
			</c:forEach>
		</select>
		<div id="roleDiv">
			<iframe id="roleIframe" src="/roleofuser?userId=${userList[0].id}"></iframe>
		</div>
	</div>
</body>
</html>