<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/dwr/engine.js"></script>
<script type="text/javascript" src="/dwr/util.js"></script>
<script type="text/javascript" src="/dwr/interface/debugJobService.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	function doJob(input) {
		var id = input.id;
		if ('serverChangeCheck' == id) {
			debugJobService.debugServerChangeCheckJob(doWithResponse);
		} else if ('nagiosCheckJob' == id) {
			debugJobService.debugNagiosCheckJob(doWithResponse);
		} else if ('issueFixAbility' == id) {
			debugJobService.debugIssueFixAbilityJob(doWithResponse);
		} else if ('weeklyReport' == id) {
			debugJobService.debugWeeklyReportJob(doWithResponse);
		} else if ('synchronizeIssueJob' == id) {
			debugJobService.debugSynchronizeIssueJob(doWithResponse);
		} else if ('testrailInfoCheckJob' == id) {
			debugJobService.debugTestrailInfoCheckJob(doWithResponse);
		} else if ('debugScanReportJob' == id) {
			debugJobService.debugScanReportJob(doWithResponse);
		} else if ('systemErrorReportJob' == id) {
			debugJobService.debugSystemErrorReportJob(doWithResponse);
		} else if ('scoreCheckJob' == id) {
			debugJobService.debugScoreCheckJob(doWithResponse);
		} else if ('hotdeployCheckJob' == id) {
			debugJobService.debugHotdeployCheckJob(doWithResponse);
		} else if ('jenkinsSlaveOfflineMonitorJob' == id) {
			debugJobService.debugJenkinsSlaveOfflineMonitorJob(doWithResponse);
		}
	}

	function doWithResponse(response) {
		alert(response);
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="ServerChangeCheckJob"
		id="serverChangeCheck" onclick='doJob(this)'>
	<br />
	<input type="button" value="NagiosCheckJob" id="nagiosCheckJob"
		onclick='doJob(this)'>
	<br />
	<input type="button" value="IssueFixAbility" id="issueFixAbility"
		onclick='doJob(this)'>
	<br />
	<input type="button" value="WeeklyReport" id="weeklyReport"
		onclick='doJob(this)'>
	<br />
	<input type="button" value="SynchronizeIssueJob"
		id="synchronizeIssueJob" onclick='doJob(this)'>
	<br />
	<input type="button" value="TestrailInfoCheckJob"
		id="testrailInfoCheckJob" onclick='doJob(this)'>
	<br />
	<input type="button" value="DebugScanReportJob" id="debugScanReportJob"
		onclick='doJob(this)'>
	<br />
	<input type="button" value="systemErrorReportJob"
		id="systemErrorReportJob" onclick='doJob(this)'>
	<br />
	<input type="button" value="ScoreCheckJob" id="scoreCheckJob"
		onclick='doJob(this)'>
	<br />
	<input type="button" value="HotdeployCheckJob" id="hotdeployCheckJob"
		onclick='doJob(this)'>
	<br />
	<input type="button" value="JenkinsSlaveOfflineMonitorJob"
		id="jenkinsSlaveOfflineMonitorJob" onclick='doJob(this)'>
	<br />
</body>
</html>