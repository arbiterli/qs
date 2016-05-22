<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.glority.qualityserver.UserRole"%>
<!Doctype html>
<html xmlns=http://www.w3.org/1999/xhtml>
<head>
<title></title>
<link href="/css/admin/roleofuser.css" type="text/css" rel="stylesheet">
<link href="/css/admin/common.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/dwr/engine.js"></script>
<script type="text/javascript" src="/dwr/interface/adminService.js"></script>
<script type="text/javascript" src="/js/admin/roleofuser.js"></script>
</head>
<body>
	<div id="roleOfUserJsp">
		<table>
			<c:forEach var="role" items="${roles}">
				<tr>
					<td>Role Id:</td>
					<td><input readonly="readonly" type="text" value="${role.id}" /></td>
					<td>Product Id:</td>
					<td><input id="productId${role.id }" type="text"
						value="${role.productId }" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><select id="roleName${role.id}">
							<option><%=UserRole.INVALID_ROLE%></option>
							<option><%=UserRole.ROLE_ADMIN%></option>
							<option><%=UserRole.ROLE_GUEST%></option>
							<option><%=UserRole.ROLE_DEVELOPER%></option>
							<option><%=UserRole.ROLE_MANAGER%></option>
							<option><%=UserRole.ROLE_MARKETING%></option>
							<OPTION><%=UserRole.ROLE_BUSINESSOWNER%></OPTION>
					</select></td>
					<td>Scope:</td>
					<td><input id="scope${role.id}" type="text"
						value="${role.scope }" /></td>
				</tr>
				<tr>
					<td><input type="button" value="submit"
						onclick="modifyRole('${role.id}')" /></td>
				</tr>
				<script>
					setName('${role.name}', '${role.id}');
				</script>
			</c:forEach>
		</table>
	</div>
</body>
</html>