/**
 * 
 */
/**
 * set server Info for create. clear buildInfo part, clear all input, and change
 * type to select.
 */
function setServerInfoForCreate() {
	clearElements("nagios");
	clearElements("deployedBuildInfo");
	clearElements("buildInfo");

	changeInputToSelect("serverType");
	enableButton("createButton");
}

function setServerInfoForUpdate() {

	// clearElements("newBuildInfo");
	// clearElements("deployedBuildInfo");
	clearElements("nagios");
	updateDeployInfoChange();
	removeElement("serverPassword");
	changeInputToSelect("serverType");
	enableButton("updateButton");
}

function setServerInfoForManage() {
	var inputs = document.getElementsByTagName("input");
	for ( var i = 2; i < inputs.length; i++) {
		inputs[i].disabled = true;
	}

	removeElement("serverPassword");
	removeElement("nagiosPassword");

	clearElements("buildInfo");

	clearElements("nagios");

	enableButton("null");
}

function setServerInfoForDeploy() {
	var inputs = document.getElementsByTagName("input");
	for ( var i = 1; i < inputs.length; i++) {
		inputs[i].disabled = true;
	}
	enableButton("deployButton");
	clearElements("buildInfo");
	clearElements("newBuildInfo");
	clearElements("nagios");
}

function removeElement(id) {
	var input = document.getElementById(id);
	var inputParent = input.parentNode;
	inputParent.innerHTML = "";
	inputParent.previousElementSibling.innerHTML = "";
}

function changeInputToSelect(id) {
	var input = document.getElementById(id);
	var inputValue = input.value;
	var inputParent = input.parentNode;

	var selectElement = document.createElement("select");
	selectElement.id = input.id;
	selectElement.name = input.name;
	try {
		selectElement.add(new Option("preview", "preview"), null);
		selectElement.add(new Option("official", "official"), null);
	} catch (e) { // IE
		selectElement.add(new Option("preview", "preview"));
		selectElement.add(new Option("official", "official"));
	}

	inputParent.innerHTML = "";
	inputParent.appendChild(selectElement);

	// set selected data
	var selectedOption = null;
	for ( var i = 0; i < selectElement.options.length; i++) {
		if (selectElement.options[i].value == inputValue) {
			selectElement.options[i].selected = "selected";
			break;
		}
	}
}
/**
 * refactor is not used nagios part.
 */
function clearElements(sclass) {
	var trs = document.getElementsByClassName(sclass);
	for ( var i = 0; i < trs.length; i++) {
		trs[i].innerHTML = "";
	}
}

function enableButton(id) {
	if (id != "updateButton") {
		document.getElementById("updateButton").style.display = "none";
	} else {
		document.getElementById("updateButton").disabled = false;
	}

	if (id != "createButton") {
		document.getElementById("createButton").style.display = "none";
	} else {
		document.getElementById("createButton").disabled = false;
	}

	if (id != "deployButton") {
		document.getElementById("deployButton").style.display = "none";
	} else {
		document.getElementById("deployButton").disabled = false;
	}
}

function create() {
	var server = getServerInfo("create");
	var phaseId = dwr.util.getValue("phaseId");
	serverService.createServer(phaseId, server, createServerCallback);
}

function createServerCallback(response){
	if("success" == response.status){
		window.location.href="servermanage?serverId="+response.serverId;
	}
	else{
		alert("create server failed");
	}
}


function update() {
	var server = getServerInfo("update");
	var phaseId = dwr.util.getValue("phaseId");
	serverService.updateServer(phaseId, server, updateServerCallback);
}

function updateServerCallback(response){
	if("success" == response.status){
		window.location.href="servermanage?serverId="+response.serverId;
	}
	else{
		alert("update server failed");
	}
}


function getServerInfo(type) {
	var server = {id:getServerIdForServer(type),
			phaseId:dwr.util.getValue("phaseId"),
			name:dwr.util.getValue("serverName"),
			host:dwr.util.getValue("serverUrl"),
			type:dwr.util.getValue("serverType"),
			username:dwr.util.getValue("serverUsername"),
			password:dwr.util.getValue("serverPassword"),
			siteUrl:dwr.util.getValue("siteUrl"),
			editUrl:dwr.util.getValue("editUrl"),
			deployScript:dwr.util.getValue("deployScript"),
			deployProtocol:dwr.util.getValue("deployProtocol"),
			checkIsActive:dwr.util.getValue("checkIsActive")[0] == "on",
			checkScript:dwr.util.getValue("checkScript"),
			buildId:getBuildIdForServer(type)};
	return server;
}

function getServerIdForServer(type){
	if("create" == type){
		return -1;
	} else if("update" == type){
		return dwr.util.getValue("serverId");
	}
}

function getBuildIdForServer(type){
	if("create" == type){
		return dwr.util.getValue("activeBuild");
	}else if("update" == type){
		if(document.getElementById("updateDeployInfo").checked){
			return dwr.util.getValue("activeBuild");
		}
		else{
			return dwr.util.getValue("deployedBuild");
		}
	}
}

function baseDeploy(buildId, stage) {
	document.getElementById("deployButton").disabled = "disabled";
	var serverId = document.getElementById("serverId").value;

	buildService.certifyBuild(buildId, stage, certificationCallback);
	deployService.baseDeploy(serverId, buildId, baseDeployCallBack);
}

function certificationCallback(response) {
	var deployResult = document.getElementById("deployResult");
	deployResult.innerHTML = "";
	deployResult.innerHTML = response.status + "\n";
}

function testFunction(response) {
	alert(response);
}

function baseDeployCallBack(response) {
	var deployResult = document.getElementById("deployResult");
	//deployResult.innerHTML = "";

	if (response.result == "success") {
		window.location.href = "/basedeployinfo?logKey=" + response.key
				+ "&serverId=" + document.getElementById("serverId").value;
	} else if (response.result == "fail") {
		var deployInfo = response.deployInfo;
		deployResult.innerHTML = deployInfo;
	} else if (response.result == "error") {
		deployResult.innerHTML = "Deploy ERROR";
	}
}
function updateDeployInfoChange() {
	var deployItems = document.getElementsByClassName("deployInfoItem");
	var updateDeployInfo = document.getElementById("updateDeployInfo");

	var display;
	if (updateDeployInfo.checked) {
		display = "";
	} else {
		display = "none";
	}

	for ( var i = 0; i < deployItems.length; i++) {
		deployItems[i].style.display = display;
	}
}

function deleteServer(serverId) {
	if (confirm("Do you want to delete server")) {
		serverService.deleteServer(serverId, deleteServerCallback);
	}
}

function deleteServerCallback(response) {
	if (response != null) {
		alert("delete server " + response);
		if ('success' == response.status) {
			var deleteTr = document.getElementById("server_table_tr_"
					+ response.serverId);
			deleteTr.innerHTML = "";
		}
	}
}
