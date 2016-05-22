
<script type="text/javascript" src="/dwr/interface/deployService.js"></script>
<script type="text/javascript" src="/dwr/interface/buildService.js"></script>		

<div id="separateContainer" class="separateContainer">
	<form id="serverInfoForm">
		<input type="hidden" name="phaseId" id="phaseId"
			value="${server.phaseId }" /> <input type="hidden" name="serverId"
			id="serverId" value="${server.id }" />

		<table style="color: white">
			<tr>
				<td>Server:</td>
				<td><input type="text" id="serverName" name="serverName"
					value="${server.name }" /></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Deploy Host:</td>
				<td><input type="text" id="serverUrl" name="serverUrl"
					value="${server.host }" /></td>
				<td>Type:</td>
				<td><input type="text" id="serverType" name="serverType"
					value="${server.type }" />
			</tr>
			<tr>
				<td>Username :</td>
				<td><input type="text" id="serverUsername"
					name="serverUsername" value="${server.username }" /></td>
				<td>Password :</td>
				<td><input type="password" id="serverPassword"
					name="serverPassword" value=""></td>
			</tr>
			<tr>
				<td>Site Url:</td>
				<td><input type="text" id="siteUrl" name="siteUrl"
					value="${server.siteUrl }" /></td>
				<td>Edit Url:</td>
				<td><input type="text" id="editUrl" name="editUrl"
					value="${server.editUrl }" /></td>
			</tr>
			<tr>
				<td>Deploy Script:</td>
				<td><input type="text" name="deployScript"
					value="${server.deployScript }"></td>
				<td>Deploy Protocol:</td>
				<td><input type="text" name="deployProtocol"
					value="${server.deployProtocol }"></td>
			</tr>
			<tr>
				<td>Server Change Check is Active</td>
				<td><input type="checkbox" name="checkIsActive" <c:if test="${server.checkIsActive}">checked</c:if> /></td>
				<td>Check Script</td>
				<td><input type="text" name="checkScript"
					value="${server.checkScript }" /></td>
			</tr>

			<tr class = "buildInfo">
				<td>Update Deploy Build</td>
				<td><input type="checkbox" id="updateDeployInfo" name="updateDeployInfo"
				 onclick="updateDeployInfoChange()"/></td>
				<td></td>
				<td></td>
			</tr>
			<tr class="deployedBuildInfo" >
				<td class="deployInfoItem">Build in Server:</td>
				<td class="deployInfoItem"><input type="text" id="deployedBuild" value="${buildInServer.buildId }" /></td>
				<td class="deployInfoItem">Jenkins Build in Server:</td>
				<td class="deployInfoItem"><input type="text" name="deployedJenkinsBuild"
					id="deployedJenkinsBuild" value="${buildInServer.jenkinsBuildId }" /></td>
			</tr>
			<tr>
			<td>Build To Be Deployed</td>
			</tr>
			<tr>
				<td>Build Id:</td>
				<td><input type="text" id="buildId"
					value="${buildDetail.id}"></td>
				<td>Jenks Id:</td>
				<td><input type="text" id="jenkinsId"
					value="${buildDetail.jenkinsBuildId}"></td>
			</tr>
			<tr>
				<td>Svn URL:</td>
				<td><input type="text" id="svnUrl"
					value="${buildDetail.svnUrl}"></td>
				<td>Svn Version:</td>
				<td><input type="text" id="jenkinsId"
					value="${buildDetail.svnVersion}"></td>
			</tr>			
			
			<tr class="newBuildInfo" >
				<td class="deployInfoItem">Active Build:</td>
				<td class="deployInfoItem"><input type="text" id="activeBuild" name="activeBuild"
					value="${activeBuild.buildId }" /></td>
				<td class="deployInfoItem">Active Jenkins Build:</td>
				<td class="deployInfoItem"><input type="text" name="actvieJenkinsBuild"
					id="actvieJenkinsBuild" value="${activeBuild.jenkinsBuildId }" /></td>
			</tr>

			<tr class="nagios">
				<td>Nagios is active</td>
				<td><input type="checkbox" name="nagiosIsActive"></td>
				<td></td>
				<td></td>
			</tr>
			<tr class="nagios">
				<td>Nagios URL</td>
				<td><input type="text" id="nagiosUrl" name="nagiosUrl">
				</td>
				<td>Nagios Host</td>
				<td><input type="text" id="nagiosHost" name="nagiosHost">
				</td>
			</tr>
			<tr class="nagios">
				<td>Nagios Username</td>
				<td><input type="text" id="nagiosUsername"
					name="nagiosUsername"></td>
				<td>Nagios Password</td>
				<td><input type="password" id="nagiosPassword"
					name="nagiosPassword"></td>
			</tr>
			<tr class="button">
				<td></td>
				<td></td>
				<td></td>
				<td><input type="button" class="deploybutton" id="updateButton"
					onclick="update()" value="Update" /> <input type="button"
					class="deploybutton" id="createButton" onclick="create()"
					value="Create" /> <input type="button" class="deploybutton"
					id="deployButton" onclick="baseDeploy(${buildDetail.id},'${stage}')" value="Deploy" /></td>
			</tr>
		</table>
	</form>
</div>