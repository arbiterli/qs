<%@include file="/common_jsp/head.jsp"%>
<script type="text/javascript" src="/js/server.js"></script>
<c:if test="${ finished== false }">
	<script>
		setTimeout('window.location.reload()', 10000);
	</script>
</c:if>

<div id="table_container">
	<%@include file="/individual_jsp/serverinfo.jsp"%>
	<script>
		setServerInfoForDeploy();
	</script>
</div>


<div id="table_container" style="text-align: center">Deploy
	Information</div>
<div id="table_container">
	<input type="button" value="Go to Check" class="deploybutton"
		onclick="window.open('${deployDetail.siteUrl }','_blank')" /> <input
		type="button" value="Go Back" class="deploybutton"
		onclick="history.back()" />
</div>
<div id="table_container">
	<table style="width: 858px; text-align: center; color: white">
		<c:forEach items="${deployInfoList}" var="deployInfo">
			<tr>
				<td style="text-align: left;">${deployInfo}</td>
			</tr>
		</c:forEach>
		<c:if test="${ finished == true}">
			<tr style="text-align: left">
				<td>Deploy Finished</td>
			</tr>
		</c:if>
		<c:if test="${ finished== false }">
			<tr style="text-align: left">
				<td>Deploying ...</td>
			</tr>
		</c:if>
	</table>
</div>
<%@include file="/common_jsp/foot.jsp"%>