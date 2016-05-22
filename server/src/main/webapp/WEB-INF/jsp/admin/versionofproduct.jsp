<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!Doctype html>
<html xmlns=http://www.w3.org/1999/xhtml>
<head>
<link href="/css/admin/versionofproduct.css" type="text/css"
	rel="stylesheet">
<link href="/css/admin/common.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
<script type="text/javascript" src="/dwr/engine.js"></script>
<script type="text/javascript" src="/dwr/util.js"></script>
<script type="text/javascript" src="/dwr/interface/adminService.js"></script>
<script type="text/javascript" src="/js/admin/versionofproduct.js"></script>
</head>
<body>
	<div id="versionOfProductJsp">
		<table>
			<c:forEach var="it" items="${versionList }">
				<tr>
					<td>Version</td>
					<td><input id="version${it.id }" type="text"
						value="${it.version }" /></td>
					<td>Product Id:</td>
					<td><input id="pId${it.id }" type="text"
						value="${it.productId}" /></td>
				</tr>
				<tr>
					<td>Dev Start Time:</td>
					<td><input id="devStartTime${it.id }" type="text"
						value="${it.devStartTimeStr }" /></td>
					<td>Dev End Time:</td>
					<td><input id="devEndTime${it.id }" type="text"
						value="${it.devEndTimeStr}S" /></td>
				</tr>
				<tr>
					<td>Test Start Time:</td>
					<td><input id="testStartTime${it.id }" type="text"
						value="${it.testStartTimeStr}" /></td>
					<td>Test End Time:</td>
					<td><input id="testEndTime${it.id }" type="text"
						value="${it.testEndTimeStr}" /></td>
				</tr>
				<tr>
					<td>Stage Start Time:</td>
					<td><input id="stageStartTime${it.id }" type="text"
						value="${it.stageStartTimeStr }" /></td>
					<td>Stage End Time:</td>
					<td><input id="stageEndTime${it.id }" type="text"
						value="${it.stageEndTimeStr }" /></td>
				</tr>
				<tr>
					<td>Production Start Time:</td>
					<td><input id="proStartTime${it.id }" type="text"
						value="${it.productionStartTimeStr }" /></td>
					<td>Production End Time:</td>
					<td><input id="proEndTime${it.id }" type="text"
						value="${it.productionEndTimeStr }" /></td>
				</tr>
				<tr>
					<td>Svn Url:</td>
					<td><input id="svnUrl${it.id }" type="text"
						value="${it.svnUrl }" /></td>
					<td>Svn Revision:</td>
					<td><input id="svnRevision${it.id }" type="text"
						value="${it.svnRevision }" /></td>
				</tr>
				<tr>
					<td>Version Id:</td>
					<td><input id="versionId${it.id }" type="text"
						value="${it.id }" /></td>
					<td><input type="button" value="submit"
						onclick="modifyVersion('${it.id }')" /></td>
				</tr>
				<tr>
					<td><br /></td>
				</tr>
				<script>
					addDatePicker("devStartTime", ${it.id });
					addDatePicker("devEndTime", ${it.id });
					addDatePicker("testStartTime", ${it.id });
					addDatePicker("testEndTime", ${it.id });
					addDatePicker("stageStartTime", ${it.id });
					addDatePicker("stageEndTime", ${it.id });
					addDatePicker("proStartTime", ${it.id });
					addDatePicker("proEndTime", ${it.id });
				</script>
			</c:forEach>
		</table>
	</div>
</body>
</html>