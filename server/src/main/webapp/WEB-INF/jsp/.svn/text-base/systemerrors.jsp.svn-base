<%@ include file="/include/head.jsp"%>
	<link rel="stylesheet" type="text/css" href="/css/systemerrors.css"/>
	<script type="text/javascript" src="/js/systemerrors.js"></script>
		<input type="hidden" value="${page.currentPage}" id="currentIndex"/>
		<table cellpadding ="0" class="error">
				<colgroup>
					<col class="col-error-from">
					<col class="col-error-owner">
					<col class="col-error-status">
					<col class="col-error-create-time">
					<col class="col-error-extern-info">
					<col class="col-error-info">
				</colgroup>
				<tbody>
					<tr class="error-head">
						<td class="error-head-from">From</td>
						<td class="error-head-owner"></td>
						<td class="error-head-status">Status</td>
						<td class="error-head-create-time">CreateTime</td>
						<td class="error-head-extern-info">ExternInfo</td>
						<td class="error-head-info">Info</td>
					</tr>
					<c:forEach var="error" items="${page.records}">
						<tr>
							<td class="error-from">${error.from }</td>
							<td class="error-owner"></td>
							<td class="error-status">${error.status }</td>
							<td class="error-create-time">${error.createTime }</td>
							<td class="error-extern-info">${error.externInfo }</td>
							<td class="error-info"><a href="/errordetail?errorId=${error.id}">${error.info }</a></td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
		<br/>
		<div class="pagination-div">
			<c:if test="${prePageLink != null }">
				<a class="pagination" href="${prePageLink }" style="width:50px;"><span style="width:50px;"> < pre</span></a>
			</c:if>
			<c:forEach var="link" items="${pageLinks}">
				<a id="${link.page}" class="pagination" href="${link.url }"><span>${link.page}</span></a>
			</c:forEach>
			<c:if test="${nextPageLink != null }">
				<a class="pagination" href="${nextPageLink}" style="width:50px;"><span style="width:50px;">next > </span></a>	
			</c:if>
		</div>
<%@ include file="/include/foot.jsp"%>