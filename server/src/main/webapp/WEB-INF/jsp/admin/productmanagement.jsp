<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!Doctype html>
<html xmlns=http://www.w3.org/1999/xhtml>
<head>
<link href="/css/admin/productmanagement.css" type="text/css"
	rel="stylesheet">
<link href="/css/admin/common.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
<script type="text/javascript" src="/dwr/engine.js"></script>
<script type="text/javascript" src="/dwr/interface/adminService.js"></script>
<script src="/js/admin/productmanagement.js"></script>
</head>
<body>
	<div id="productJsp">
		<table id="productTable">
			<c:forEach var="it" items="${productList}">
				<tr>
					<td>Product Id:</td>
					<td><input readonly="readonly" id="${it.id }" value="${it.id}"
						type="text" /></td>
					<td>Discarded : </td>
					<td><input type="checkbox" id="discarded${ it.id }" <c:if test="${it.discarded }">checked</c:if>></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input id="name${it.id}" value="${it.name}" type="text" /></td>
					<td>Default Version:</td>
					<td><input id="version${it.id}" value="${it.defaultVersion}"
						type="text" /></td>
				</tr>
				<tr>
					<td>Default Configure:</td>
					<td><input id="configure${it.id}"
						value="${it.defaultConfiguration}" type="text" /></td>
					<td>Create At:</td>
					<td><input id="create${it.id}" value="${it.createdAt}"
						type="text" /></td>
				</tr>
				<tr>
					<td>Product Group:</td>
					<td><input id="group${it.id }" value="${it.group}" type="text" /></td>
					<td>Display Name:</td>
					<td><input id="displayName${it.id }" value="${it.displayName}"
						type="text" /></td>
				</tr>
				<tr>
					<td>Trunk SVN:</td>
					<td><input id="svnUrl${it.id}" value="${it.trunkSvnUrl }" type="text" /></td>
				<tr>
					<td><input type="button"
						onclick="modifyProductInfo('${it.id }')" value="submit" /></td>
				</tr>
				<script>addDatePicker(${it.id});</script>
			</c:forEach>
		</table>
	</div>
</body>
</html>

