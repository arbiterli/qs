
<style type="text/css">
a:link {
	color: blue;
}

a:visited {
	color: black;
}

#deployTable td {
	width: 163px;
}
</style>
<div id="table_container">
	<table id="deployTable"
		style="width: 815px; color: white; font-size: 14px">
		<tr style="font-weight: bold">
			<td>Deployed Build</td>
			<td>Active Version</td>
			<td>Server Name</td>
			<td>Site URL</td>
			<c:if test='${permissionSetting.baseDeploy}'>
				<td>Operation</td>
			</c:if>
		</tr>
		<c:forEach var="iterator" items="${servers}">
			<tr id="server_table_tr_${iterator.id}">
				<td>${iterator.buildId}</td>
				<td>${iterator.activeVersion }</td>
				<td>${iterator.name}</td>
				<td><a href="${iterator.siteUrl}" target="_blank" class="url">${iterator.siteUrl}</a></td>
				<c:if test='${permissionSetting.baseDeploy}'>
					<td style="width: 450px;"><c:choose>
							<c:when test="${iterator.type == 'official'}">
								<c:if test="${iterator.deployScript != null }">
									<input type="button" value="Deploy" class="deploybutton"
										onclick="deployButtonClick(${iterator.id})" />
								</c:if>
							</c:when>
							<c:otherwise>
								<input type="button" value="Hot Update" class="deploybutton"
									onclick="window.open('${iterator.editUrl}')" />
							</c:otherwise>
						</c:choose> <input type="button" value="Manage" class="deploybutton"
						onclick="window.location.href='/servermanage?serverId=${iterator.id}'" />
				</c:if>
			</tr>
		</c:forEach>
		<c:if test='${permissionSetting.baseDeploy}'>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><input type="button" value="Create" class="deploybutton"
					onclick="createButtonClick()" /></td>
			</tr>
		</c:if>
	</table>
</div>