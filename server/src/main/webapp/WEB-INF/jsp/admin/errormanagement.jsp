<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!Doctype html>
<html xmlns=http://www.w3.org/1999/xhtml>
<head>
<link href="/css/admin/errormanagement.css" type="text/css"
	rel="stylesheet">
<link href="/css/admin/common.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/js/admin/errormanagement.js"></script>
</head>
<body>
	<div id="errorJsp">
		<select id="selectPId" onchange="selectOnChange()">
			<c:forEach var="id" items="${idList}">
				<option>${id }</option>
			</c:forEach>
		</select>
		<div id="errorDiv">
			<iframe id="errorIframe" src="/errorofproduct?productId=${idList[0]}"></iframe>
		</div>
	</div>
</body>
</html>