<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!Doctype html>
<html xmlns=http://www.w3.org/1999/xhtml>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
    <div id="update" class="separateContainer" style=" left:50px;top:150px;">
		<h4 style="padding-top: 50px">${param.title }</h4>
		<table id="updateTable" style="color:white;">
			<tr style = "font-size:14px;font-weight:bold;font-family:helvetica">
				<td>Version</td>
				<td>Create Time</td>
				<td>Hit Time</td>
				<td>Deployed By</td>
				<td></td>
			</tr>
			<c:forEach var="iterator" items="${param.updateHistory}">
				<c:choose>
					<c:when test="${iterator.active == true}">
						<tr style="color: red" style = "font-size:14px;font-family:helvetica">
							<td>${iterator.version }</td>
							<td>${iterator.createTime }</td>
							<td>${iterator.deployTime }</td>
							<td>${iterator.user }</td>
							<td>Running</td>
						</tr>
					</c:when>
					<c:when test="${iterator.active == false }">
						<tr style = "font-size:14px;font-family:helvetica">
							<td>${iterator.version }</td>
							<td>${iterator.deployTime }</td>
							<td>${iterator.user }</td>
						</tr>
					</c:when>
				</c:choose>
			</c:forEach>
		</table>
	</div>
</body>
</html>