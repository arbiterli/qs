<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.glority.qualityserver.Constants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!Doctype html>
<html xmlns=http://www.w3.org/1999/xhtml>
<head>
<title>${title}</title>
<link href="/css/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/dwr/engine.js"></script>
<script type="text/javascript" src="/dwr/util.js"></script>
<script type="text/javascript" src="/dwr/interface/basicDataService.js"></script>
</head>
<body>
	<div id="main_container">
		<div id="header">
			<div id="email">
				${user.email} <span id="separator">|</span> <input id="logout"
					type="button" value="Logout"
					onclick="window.location.href='/j_spring_cas_security_logout'" />
			</div>
			<div id="logodiv">
				<div id="logo"></div>
			</div>
		</div>
		<div id="stretched_body">
			<div id="bookmark">
				<div id="label">
					<c:forEach var="it" items="${navigationLinks}" varStatus="status">
						<span id="left${it.title}" class="bookmark_left">&nbsp;</span>
						<span id="middle${it.title}" class="bookmart_middle"
							onclick='window.location.href="${it.link}"'>&nbsp;&nbsp;${it.title}&nbsp;&nbsp;</span>
						<span id="right${it.title}" class="bookmark_right">&nbsp;</span>

						<c:if test='${status.first}'>
							<script type="text/javascript">
								document.getElementById('left${it.title}').style.backgroundImage = "url(/image/brumch-off.png)";
							</script>
						</c:if>
						<c:if test='${status.last}'>
							<script type="text/javascript">
								document.getElementById('middle${it.title}').onclick = "";
							</script>
							<script type="text/javascript">
								document.getElementById('left${it.title}').style.backgroundImage = "url(/image/brumch-tail-on.png)";
							</script>
							<script type="text/javascript">
								document.getElementById('middle${it.title}').style.backgroundImage = "url(/image/brumch-on.png)";
							</script>
							<script type="text/javascript">
								document.getElementById('right${it.title}').style.backgroundImage = "url(/image/brumch-arrow-on.png)";
							</script>
						</c:if>
					</c:forEach>
				</div>
			</div>