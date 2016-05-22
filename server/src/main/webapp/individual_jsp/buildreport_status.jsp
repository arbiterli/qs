
<div id="table_container">
	<table style="width: 100%; color: white; font-size: 14px;">
		<tr>
			<td>Id:${buildDetail.id}</td>
			<td>Name: ${buildDetail.name}</td>
			<td>Stage: ${buildDetail.stage}</td>
		</tr>
		<tr>
			<td>Version: ${buildDetail.version}</td>
			<td>Build Time: ${buildDetail.buildTime}</td>
			<td>Lines Of Code: ${buildDetail.linesOfCode}</td>
		</tr>
		<tr>
			<td>Lines Of Comments: ${buildDetail.linesOfComments}</td>
			<td>Tests: ${buildDetail.tests}</td>
			<td>Failed Test: ${buildDetail.failedTest}</td>
		</tr>
		<tr>
			<td>Test Environments: ${buildDetail.testEnvironments}</td>
			<td>Certification: ${buildDetail.certification }</td>
			<td>
			    <a href="http://jenkins.glority.com:8080/job/${buildDetail.jenkinsBuildName}/${buildDetail.jenkinsBuildId}">
					Jenkins Build Id:${buildDetail.jenkinsBuildId}
				</a>
			</td>
		</tr>
	</table>
	<br /> <br />
</div>