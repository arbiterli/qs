<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.glority.qualityserver.Constants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="glority,quality,portal" />
<meta name="description" content="quality portal" />
<title>${title}</title>
<script type="text/javascript" src="/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/dwr/engine.js"></script>
<script type="text/javascript" src="/dwr/util.js"></script>
<script type="text/javascript" src="/dwr/interface/basicDataService.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="/css/common.css"/>
</head>
<body>
	<div id="header">
		<div id="email">
			${user.email } | <input type="button" id="logout"
				onclick="window.location.href='/j_spring_cas_security_logout'" />
		</div>
		<div id="logo">Quality Portal</div>
	</div>
	<input type="hidden" id="passingScore" value="${passingScore }"/>
	<input type="hidden" id="excellentScore" value="${excellentScore }"/>
	<div id="content">
		<input type="hidden" value="${stageString }" id="stage-string" /> 
		<input type="hidden" value="${productId}" id="product-id" />
		<input type="hidden" value="${buildId }" id="build-id"/>
		<div id="navigation">
			<c:forEach var="it" items="${navigationLinks}" varStatus="status">
				<c:if test="${status.index == 0 }">
					<span class="rear"></span>
				</c:if>
				<span class="nav-span">
					<a style="color:#646464;" href="${it.link }">${it.title }</a>
				</span>
			</c:forEach>
		</div>
		<br />