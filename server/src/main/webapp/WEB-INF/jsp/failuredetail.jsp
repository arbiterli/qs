<%@include file="/common_jsp/head.jsp"%>
<script type="text/javascript" src="/js/failure.js"></script>
<div id="table_container">
	<input type="button" value="Go Back" onclick="history.go(-1)" />
	<table id="failureDetail">
		<tr>
			<td>Type :</td>
			<td>${detail.type }</td>
			<td>System Code :</td>
			<td>${detail.systemCode }</td>
		</tr>
		<tr>
			<td>Create Time :</td>
			<td>${detail.createTime }</td>
			<td>Update Time :</td>
			<td>${detail.updateTime }</td>
		</tr>
		<tr>
			<td>Dead Line :</td>
			<td>${detail.deadLine }</td>
			<td>Owner :</td>
			<td>${detail.owner }</td>
		</tr>
		<tr>
			<td>Current Status :</td>
			<td><span id="failureStatus">${detail.status }</span>
			</td>
			<td>Update Status :</td>
			<td><select id="statusSelect">
					<option value="new"
						<c:if test = "${detail.status =='new' }">selected="selected"</c:if>>New</option>
					<option value="fixed"
						<c:if test = "${detail.status =='fixed' }">selected="selected"</c:if>>Fixed</option>
					<option value="reopen"
						<c:if test = "${detail.status =='reopen' }">selected="selected"</c:if>>Reopen</option>
					<option value="ignored"
						<c:if test = "${detail.status =='ignored' }">selected="selected"</c:if>>Ignored</option>
			</select>
				<button type="button" onclick='updateFailureStatus(${detail.id})'>Update</button>
			</td>
		</tr>
	</table>
	<div>
		Detail:<br />${detail.info }
	</div>
</div>
<div id="table_container"></div>
<%@include file="/common_jsp/foot.jsp"%>