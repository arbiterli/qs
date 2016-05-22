function product_draw_chart() {
	var productId = dwr.util.getValue('product_id');
	basicDataService.getProductHistoryScores(productId, _product_draw_chart);
}

function _product_draw_chart(response) {
	document.getElementById('product_date').value = response[response.length - 1][0];
	for ( var i = 1; i < response.length; i++) {
		response[i][0] = response[i][0].substring(response[i][0].length - 5,
				response[i][0].length);
	}
	var data = google.visualization.arrayToDataTable(response);
	var options = {
		hAxis : {
			textStyle : {
				color : 'black',
				fontSize : 10
			},
			showTextEvery : 3
		},
		vAxis : {
			textStyle : {
				color : 'black',
				fontSize : 10
			},
			gridlines : {
				color : '#dbdbdb'
			}
		},
		legend : {
			textStyle : {
				color : 'black',
				fontSize : 10
			},
			position : 'bottom'
		},
		textShadow : 'black 0 0 0',
		position : 'relative',
		pointSize : 3,
		width : 1050,
		height : 225,
		backgroundColor : 'transparent',
		tooltipFontSize : 10,
		tooltipFontFamily : 'helvetica'
	};
	var visualization = new google.visualization.LineChart(document
			.getElementById('trend_chart'));
	visualization.draw(data, options);
	getScoreInfoBySendAdjax();
	$('div').find('iframe').contents().find('body').css('background',
			'transparent');
}

/*
 * get score and detail information by send adjax
 * 
 * author:CLB
 * 
 */
function getScoreInfoBySendAdjax() {
	var productId = dwr.util.getValue("product_id");
	var date = dwr.util.getValue("product_date");
	basicDataService.getProductDetails(productId, date, updateScoreInfoHiddenInputValue);
}

var NO_DATA = "N/A";
/**
 * 
 * update score and information and hidden input value.
 * 
 * author:CLB
 * 
 */
function updateScoreInfoHiddenInputValue(response) {
	if (response == null) {
		return false;
	}
	updatePhaseInfo("req", response);
	updatePhaseInfo("dev", response);
	updatePhaseInfo("test", response);
	updatePhaseInfo("stage", response);
	updatePhaseInfo("prod", response);

}

/*
 * get innerhtml
 * 
 * author:CLB
 * 
 */
function getInnerHtmlForInfo(info) {
	var html = "<table style='width:170px;'><tr><td></td><td style=\'width:43px;\'></td><td style=\'width:23px;\'></td></tr>";
	for (i = 0; i < info.length; i++) {
		if (i == 1) {
			html += "<tr><td style=\'text-align:left;\'>" + info[i][0]
					+ "</td><td style=\'text-align:right;\' colspan=\'2\'>"
					+ info[i][1] + "</td></tr>";
		} else if (i == 3 && info[i][0] == "Last Downtime:") {
			html += "<tr><td style=\'text-align:left;\'>" + "Last Down:"
					+ "</td><td style=\'text-align:right;\' colspan=\'2\'>"
					+ info[i][1] + "</td></tr>";
		} else {
			html += "<tr><td style=\'text-align:left;\' colspan=\'2\'>"
					+ info[i][0] + "</td><td style=\'text-align:right;\'>"
					+ info[i][1] + "</td></tr>";
		}
	}
	html += "</table>";
	return html;
}

/**
 * update the block info based on the response
 * 
 * @param block
 * @param response
 */
function updatePhaseInfo(phase, response) {
	var phaseInfo = getPhaseInfo(phase, response);
	if (phaseInfo.length > 0) {
		if (phaseInfo[0][0] != NO_DATA) {
			// no requirement block, set score and block info
			if (phaseInfo[0][1] != NO_DATA) {
				setScore(phaseInfo[0]);
				setPhaseInfo(phaseInfo[1]);
				// update hidden block.
				$(phaseInfo[2][0]).val(phaseInfo[2][1]);
			}
		} else {
			setPhaseInfo(phaseInfo[1]);
		}
	}
}

function setPhaseInfo(phaseInfo) {
	var phaseHtml = getInnerHtmlForInfo(phaseInfo[1]);
	$(phaseInfo[0]).html(phaseHtml);
}

/**
 * set the score related part, set score, color and let the score to be shown
 * 
 * @param scoreItem
 */
function setScore(scoreItem) {
	if (scoreItem[1] < 60) {
		$(scoreItem[0])[0].style.color = "red";
	} else if (scoreItem[1] < 85) {
		$(scoreItem[0])[0].style.color = "orange";
	} else {
		$(scoreItem[0])[0].style.color = "green";
	}

	$(scoreItem[0]).html(scoreItem[1]);

	$(scoreItem[0])[0].style.visibility = "visible";
}

/**
 * get block info
 * 
 * info contains score for block, and other detail info
 * 
 * the return value is info[2], info[0] is the score info, info[0][0] is the div
 * id in page which to show, info[0][1] is the score. info[1] is the other
 * detail info, this is a length not decided.
 * 
 * @param block
 * @param response
 * @returns {Array}
 */
function getPhaseInfo(phase, response) {
	if ("req" == phase) {
		return getRequirementInfo(response);
	} else if ("dev" == phase) {
		return getDevInfo(response, response.devStatus);
	} else if ("test" == phase) {
		return getTestInfo(response, response.testStatus);
	} else if ("stage" == phase) {
		return getStageInfo(response, response.stageStatus);
	} else if ("prod" == phase) {
		return getProdInfo(response, response.prodStatus);
	} else {
		return new Array();
	}
}

function getRequirementInfo(response) {

	var reqInfo = new Array();
	reqInfo[0] = new Array("Planed Version:",
			dataFormat(null));
	reqInfo[1] = new Array("Dead Line:",
			dataFormat(null));
	reqInfo[2] = new Array("Iusses:", null);
	reqInfo[3] = new Array("Iusse Clearified:",
			dataFormat(null));
	reqInfo[4] = new Array("Tese Case Defined:",
			dataFormat(null));
	reqInfo[5] = new Array("Tese Case Reviewed:",
			dataFormat(null));

	var phaseInfo = new Array();
	phaseInfo[0] = new Array(NO_DATA, NO_DATA);
	phaseInfo[1] = new Array("#req_info", reqInfo);
	return phaseInfo;
}

function getDevInfo(response, status) {
	var activeBuild = getActiveBuild(status.activeBuild.id);
	
	var devInfo = new Array();
	devInfo[0] = new Array("Version:", dataFormat(status.activeBuild.version.version));
//	devInfo[1] = new Array("DeadLine:",
//			dataFormat(response.development.endTime));
//	devInfo[2] = new Array("Open Iussues:",
//			dataFormat(response.development.openIssues));
//	devInfo[3] = new Array("Closed Issues:",
//			dataFormat(response.development.closedIssues));
//	devInfo[4] = new Array("Test Cases:",
//			dataFormat(response.development.testCases));
//	devInfo[5] = new Array("Test Case Automated:",
//			dataFormat(response.development.testCaseAutomated));
//	devInfo[6] = new Array("Svn commits:",
//			dataFormat(response.development.svnCommits));
//	devInfo[7] = new Array("Latest Build number:", activeBuild[1]);
//	devInfo[8] = new Array("ATC Failed/Total:",
//			dataFormat(response.development.actFailedRate));

	var phaseInfo = new Array();
	phaseInfo[0] = new Array("#dev_score",
			dataFormat(response.devStatus.score));
	phaseInfo[1] = new Array("#dev_info", devInfo);
	phaseInfo[2] = new Array("#hidden_dev_id", activeBuild[0]);
	return phaseInfo;
}

function getTestInfo(response, status) {
	var activeBuild = getActiveBuild(status.activeBuild.id);
	
	var testInfo = new Array();
	testInfo[0] = new Array("Version:", dataFormat(status.activeBuild.version.version));
	testInfo[1] = new Array("DeadLine:",
			dataFormat(null));
	testInfo[2] = new Array("Test Cases:",
			dataFormat(null));
	testInfo[3] = new Array("Test Case Automated:",
			dataFormat(null));
	testInfo[4] = new Array("Svn commits:",
			dataFormat(null));

	testInfo[5] = new Array("Latest Build number:", activeBuild[1]);

	testInfo[6] = new Array("ATC Failed/Total:",
			dataFormat(null));

	var phaseInfo = new Array();
	phaseInfo[0] = new Array("#tes_score",
			dataFormat(status.score));
	phaseInfo[1] = new Array("#tes_info", testInfo);
	phaseInfo[2] = new Array("#hidden_tes_id", activeBuild[0]);
	return phaseInfo;
}

function getStageInfo(response, status) {
	var activeBuild = getActiveBuild(status.activeBuild.id);
	
	var stageInfo = new Array();
	stageInfo[0] = new Array("Version:", dataFormat(status.activeBuild.version.version));
	stageInfo[1] = new Array("Start Time:",
			dataFormat(null));
	stageInfo[2] = new Array("Test Failure/Total:",
			dataFormat(null) + "/"
					+ dataFormat(null));
	stageInfo[3] = new Array("Build Number:", activeBuild[1]);
	stageInfo[4] = new Array("ATC Failed/Total:",
			dataFormat(null));

	var phaseInfo = new Array();
	phaseInfo[0] = new Array("#sta_score", dataFormat(status.score));
	phaseInfo[1] = new Array("#sta_info", stageInfo);
	phaseInfo[2] = new Array("#hidden_sta_id", activeBuild[0]);
	return phaseInfo;
}

function getProdInfo(response, status) {
	var activeBuild = getActiveBuild(status.activeBuild.id);
	
	var productInfo = new Array();
	productInfo[0] = new Array("Version:", dataFormat(status.activeBuild.version.version));;
	productInfo[1] = new Array("Start Time:",
			dataFormat(null));
	productInfo[2] = new Array("Invalid change:",
			dataFormat(null));
	productInfo[3] = new Array("Last Downtime:",
			dataFormat(null));
	productInfo[4] = new Array("New Issues:",
			dataFormat(null));
	productInfo[5] = new Array("Build Number:", activeBuild[1]);
	productInfo[6] = new Array("Test Failure/Total:",
			dataFormat(null));
	productInfo[7] = new Array("ATC Failed/Total:",
			dataFormat(null));
	productInfo[8] = new Array("Auto Deploy", "");

	var phaseInfo = new Array();
	phaseInfo[0] = new Array("#pro_score",
			dataFormat(status.score));
	phaseInfo[1] = new Array("#pro_info", productInfo);
	phaseInfo[2] = new Array("#hidden_pro_id", activeBuild[0]);
	return phaseInfo;
}

/**
 * parse build to jenkins build and build.
 * 
 * @param build
 */
function getActiveBuild(activeBuild){
	var build = new Array();
	if(dataFormat(activeBuild) == NO_DATA){
		build[0] = NO_DATA;
		build[1] = NO_DATA;
	} else {
		build[0] = dataFormat(activeBuild.buildId);
		build[1] = dataFormat(activeBuild.jenkinsBuildId);
	}
	
	return build;
}

/**
 * format the data, if the data is undefined or null, return the NO_DATA
 * 
 * @param data
 * @returns
 */
function dataFormat(data) {
	if (data == undefined || data == null) {
		return NO_DATA;
	} else {
		return data;
	}
}


function dev_page() {
	var url = "/phase?buildId="
			+ document.getElementById('hidden_dev_id').value;
	url += "&stage=DEV";
	url += "&date=" + document.getElementById('product_date').value;
	url += "&productId=" + document.getElementById('product_id').value;
	window.location.href = url;
}
function tes_page() {
	var url = "/phase?buildId="
			+ document.getElementById('hidden_tes_id').value;
	url += "&stage=TEST";
	url += "&date=" + document.getElementById('product_date').value;
	;
	url += "&productId=" + document.getElementById('product_id').value;
	window.location.href = url;
}
function sta_page() {
	var url = "/phase?buildId="
			+ document.getElementById('hidden_sta_id').value;
	url += "&stage=STAGE";
	url += "&date=" + document.getElementById('product_date').value;
	;
	url += "&productId=" + document.getElementById('product_id').value;
	window.location.href = url;
}
function pro_page() {
	var url = "/phase?buildId="
			+ document.getElementById('hidden_pro_id').value;
	url += "&stage=PRODUCTION";
	url += "&date=" + document.getElementById('product_date').value;
	url += "&productId=" + document.getElementById('product_id').value;
	window.location.href = url;
}
