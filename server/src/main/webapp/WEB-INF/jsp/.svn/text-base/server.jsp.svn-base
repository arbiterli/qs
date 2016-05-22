<%@include file="/common_jsp/head.jsp"%>
<script type="text/javascript" src="/dwr/interface/deployService.js"></script>
<script type="text/javascript" src="/dwr/interface/serverService.js"></script>
<script type="text/javascript" src="/js/server.js"></script>
<div id="table_container">
	<%@include file="/individual_jsp/serverinfo.jsp"%>
	<c:choose>
		<c:when test="${operation == 'create'}">
			<script>
				setServerInfoForCreate()
			</script>
		</c:when>
		<c:when test="${operation == 'deploy'}">
			<script>
				setServerInfoForDeploy()
			</script>
		</c:when>
		<c:when test="${operation == 'update'}">
			<script>
				setServerInfoForUpdate()
			</script>
		</c:when>
	</c:choose>

	<div class="separateContainer">
		<input type="button" value="Go Back" class="deploybutton"
			onclick="history.back()" />
	</div>
	<div id="deployResult" class="separateContainer"></div>

</div>
<%@include file="/common_jsp/foot.jsp"%>