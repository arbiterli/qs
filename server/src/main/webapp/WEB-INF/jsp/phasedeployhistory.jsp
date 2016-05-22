<%@include file="/common_jsp/head.jsp"%>
<style>
a:link {
	color: blue;
	text-decoration: none
}

a:visited {
	color: white;
	text-decoration: none
}

a:hover {
	color: green;
	text-decoration: none
}
</style>
<link rel="stylesheet" type="text/css" href="/css/jpaginate.css"
	media="screen" />
<input type="button" value="Go Back" onclick="history.go(-1)" />
<div id="deployHistory">
	<table id="deployHistoryTable" bordercolor="#00526a" border="2"
		cellpadding="2" cellspacing="0" style="color: white;">
		<tr>
			<td>Status</td>
			<td>Deploy Type</td>
			<td>Version</td>
			<td>Preview Deploy Time</td>
			<td>Production Deploy Time</td>
			<td>Create Time</td>
			<td>Deploy By</td>
			<td>Log</td>
		</tr>
		<c:forEach var="deployItem" items="${deploys}">
			<tr>
				<td>${deployItem.result }</td>
				<td>${deployItem.type }</td>
				<td>${deployItem.version }</td>
				<td>${deployItem.previewDeployTime }</td>
				<td>${deployItem.productionDeployTime }</td>
				<td>${deployItem.createTime }</td>
				<td>${deployItem.deployUser }</td>	
				<c:choose>
			       <c:when test="${deployItem.log != null}">
			             <td><a href="/getlogpage?logKey=${deployItem.log}">log</a></td>
			       </c:when>
			       <c:otherwise>
			       		<td></td>
			       </c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
</div>
<div id="deployHistoryPaginate"></div>
<input type="hidden" id="stage" value="${stage}" />
<input type="hidden" id="productId" value="${productId }" />
<input type="hidden" id="count" value="${count }" />
<script type="text/javascript" src="/js/jquery.paginate.js"></script>
<script type="text/javascript" src="/js/phasedeployhistory.js"></script>
<%@include file="/common_jsp/foot.jsp"%>