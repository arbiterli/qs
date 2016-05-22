<%@include file="/common_jsp/head.jsp"%>
<script type="text/javascript" src="/js/server.js"></script>
<div id="table_container">
		
		<%@include file="/individual_jsp/serverinfo.jsp"%>
		<script>
			setServerInfoForManage()
		</script>
		
		<div class="separateContainer">
			<input type="button" value="Go Back" class="deploybutton"
				onclick="history.back()" /> <input type="button" value="Edit"
				class="deploybutton"
				onclick="window.location.href='/updateserverpage?serverId=${server.id}'" />
			<input type="button" value="Delete" class="deploybutton"
				onclick="deleteServer(${server.id})" />
			<c:if test="${server.type == 'official' }">
				<input type="button" value="Deploy" class="deploybutton"
					onclick="window.location.href='/serverbuildpage?serverId=${server.id}'" />
			</c:if>
		</div>
		<div id="deployResult" class="separateContainer"></div>


	<div id="table_container">
		<span style="font-weight: bold">Failures</span><br />
		<table id="failuresTable" cellpadding="5"
			style="width: 70%; color: white; padding-bottom: 2cm; font-size: 14px"></table>
	</div>
	<script>
		loadServerFailures('${server.id}')
	</script>
</div>
<%@include file="/common_jsp/foot.jsp"%>