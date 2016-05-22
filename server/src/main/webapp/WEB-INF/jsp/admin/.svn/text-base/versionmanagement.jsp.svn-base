<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!Doctype html>
<html xmlns=http://www.w3.org/1999/xhtml>
<head>
<link href="/css/admin/versionmanagement.css" type="text/css"
	rel="stylesheet">
<link href="/css/admin/common.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/js/admin/versionmanagement.js"></script>
</head>
<body>
	<div id="versionJsp">
		<label>Selected Product Id:</label> <select id="selectProductId"
			onchange="selectOnchange()">
			<c:forEach var="id" items="${idList}">
				<option value="${id }">${id}</option>
			</c:forEach>
		</select>
		<div id="versionDiv">
			<iframe id="versionIframe" src="/versionofproduct?id=${idList[0]}"></iframe>
		</div>
	</div>
</body>
</html>
