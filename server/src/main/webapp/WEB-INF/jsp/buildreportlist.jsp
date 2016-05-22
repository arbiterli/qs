<%@include file="/common_jsp/head.jsp"%>
	<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
	<link rel="stylesheet" type="text/css" href="/css/jpaginate.css"
	media="screen" />
	<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
	<script type="text/javascript" src="/js/jquery.paginate.js"></script>
	<script src="/js/buildreportlist.js"></script>
	<div id="table_container">
		<div class="build_number_div">Build number:<input  readonly="readonly"  type="text" id="build_number" class="build_number"/></div>
		<div class="after_div">Build time: after<input type="text" id="time_after" class="time_after"/></div>
		<div class="before_div">Version: <input readonly="readonly"  type="text" id="build_version" class="build_version"/></div>
		<div class="version_div">before <input type="text" id="time_before" class="time_before"/>
			<input type="button" class="deploybutton" value="Search" onclick="list_search()" style="margin-left: 100px;"/>
		</div>
		<div class="ver_line"></div>
		<div class="deploy_line"></div>
	</div>
	<div id="table_container">
		<div id="table_title" class="table_title">List ALL</div>
	</div>
	<div id="table_container">
		    <style type="text/css">
		     	table td{height:33px;}
		    </style>
			<table id="searched_list_info" style="width:860px;border-color:#0c4f65;border-width:2px;cursor:pointer" border= "0" cellpadding="0" cellspacing="0">
				<tr style="background-color:#081d2e">
					<th>Build ID</th>
					<th>Time</th>
					<th>Version</th>
					<th>Tests</th>
					<th>Failed Test</th>
					<th>SVN URL</th>
					<th>SVN REVISION</th>
					<th>Certification</th>
				</tr>
				<c:forEach var="buildInfo" items="${buildInfoList}" varStatus="status">
					<tr id="${buildInfo.id}" onclick="goto_build_page(this)" <c:if test="${status.count % 2 == 0}">style="background-color:#3b585e"</c:if>>
						<td align="center">${buildInfo.jenkins_buildeid}</td>
						<td align="center">${buildInfo.created_at}</td>
						<td align="center">${buildInfo.version}</td>
						<td align="center">${buildInfo.testTotalCount}</td>
						<td align="center">${buildInfo.testFailureCount}</td>
						<td align="center">${buildInfo.svn_url}</td>
						<td align="center">${buildInfo.svn_revision}</td>
						<td align="center">${buildInfo.certification}</td>
					</tr>
				</c:forEach>
			</table>
	</div>
	<div id="buildReportListPaginate"></div>
	<input type="hidden" id="buildInfoPageCount" value="${buildInfoPageCount}" />
	<div id="table_container" style="height:60px"></div>
	<input type="hidden" id="productId" value="${productId }"/>
<%@include file="/common_jsp/foot.jsp"%>