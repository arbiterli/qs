$(function() {
	$("#servers ul li:even").css({
		"background-color" : "#f8f8f8"
	});

	$(".submetric:even").css({
		"background-color" : "#dfdfdf"
	});
	$(".submetric:odd").css({
		"background-color" : "#ffffff"
	});

	$(".server-head-img").toggle(function() {
		$(".server").hide(50);
	}, function() {
		$(".server").show(50);
	});
	
	setMetricStyle();
	addScoreClick();
	getFinalScore();
	setScoreColor();
});

function setMetricColor() {
	$(".metric").each(function(){
		var score = $(this).find(".score").text();
		$(this).find("div").not(".low").css({"color":getScoreColor(parseInt(score))});
	});
}

function hideLow(){
	$(".metric").each(function(){
		if($(this).find(".score").text() >= 60){
			$(this).find(".low").css({"color":'transparent',"background-image":"url()"});
		}
	});
}
function getFinalScore() {
	var runningScore = getScoreBy("running-quality");
	var codeScore = getScoreBy("code-quality");
	var issueScore = getScoreBy("issue-fix-ability");
}
function setScoreColor(){
	$(".finalscore").css({"color":getScoreColor(parseInt(getScoreBy("finalscore")))});
	$(".running-quality").css({"color":getScoreColor(parseInt(getScoreBy("running-quality")))});
	$(".code-quality").css({"color":getScoreColor(parseInt(getScoreBy("code-quality")))});
	$(".issue-fix-ability").css({"color":getScoreColor(parseInt(getScoreBy("issue-fix-ability")))});
}
function getScoreBy(className){
	return $("." + className).text();
}
function setMetricStyle() {
	addSubmetric();
	addSettingEmail();
	hideEmailSettingDiv();
	$(".metric:even").css({"background-color":"#ffffff"});
	$(".metric:odd").css({"bakcground-color":"#f8f8f8"});
	setMetricColor();
	hideLow();
}

function addScoreClick() {
	if($("#stage").val() == "PROD"){
		//finalScoreClick();
		codeQualityClick();
		runningQualityClick();
		issueFixClick();
	}
}

function finalScoreClick(){
	$(".finalscore").click(function(){
		var left = $(".finalscore-text").css("margin-left");
		setMetricArrowImage(left);
		addMetric(0);
	});
}

function codeQualityClick(){
	$(".code-quality").click(function(){
		var left = $(".code-quality-text").css("margin-left");
		setMetricArrowImage(left);
		addSubmetricBy(this);
	}).click();
}

function setMetricArrowImage(left){
	left = left.replace(/[^\d]/g,"");
	$(".all-metric-img").css({"margin-left":parseInt(left) - 10 + 'px'});
}

function runningQualityClick(){
	$(".running-quality").click(function(){
		var left = $(".running-quality-text").css("margin-left");
		setMetricArrowImage(left);
		addSubmetricBy(this);
	});
}

function issueFixClick(){
	$(".issue-fix-ability").click(function(){
		var left = $(".issue-fix-ability-text").css("margin-left");
		setMetricArrowImage(left);
		addSubmetricBy(this);
	});
}
function addSubmetricBy(dom){
	var index = $(dom).attr("id");
	addMetric(index);
};

function addMetric(index) {
	$("#all-metric").empty();
	if(index == -1 ){
		return ;
	}
	var productId = dwr.util.getValue("product-id");
	var buildId = dwr.util.getValue("build-id");
	var stageString = dwr.util.getValue("stage-string");
	basicDataService.getMetricScore(productId, index, buildId,
							stageString, function(data) {
		createMetric(data);
	});
}
function createMetric(data) {
	if(data == null){
		return;
	}
	var len = data.length;
	var html = "";
	for(var i=1; i<len; i++) {
		html += "<ul class='ul-metric' id=" + data[i][10] + ">";
		html += "<li class='metric'>";
		html += "<div class='low'>Low</div>";
		html += "<div class='name' style='margin-left:-7px;'>" + data[i][0] + "</div>";
		html += "<div class='data'>";
		html += "<div class='data-arrow'>&nbsp;</div>";
		html += "<div class='data-data'>";
		if(data[i][7] == null) {
			html += data[i][1];
		} else {
			html += "<a href=" + data[i][7] + " target='_blank'>" + data[i][1] + "</a>";
		}
		html += "</div>";
		html += "<div class='data-tip'>" + data[i][2] + "</div>";
		html += "</div>";
		html += "<div class='exception' style='padding-right:25px; width:81px; text-align: right;'>" + data[i][3] + "</div>";
		html += "<div class='power'>" + data[i][4] + "</div>";
		html += "<div class='score'>" + data[i][5] + "</div>";
		if(data[i][9])
		{
			html += "<div class='metric-img' id='metric-img" + i + "'></div>";
		}
		else {
			html += "<div id='metric-img" + i + "' style='background-image:url(/images/manager.png)' class='metric-img'></div>";
		}
		html += "</li></ul>";
		html += "<ul class='ul-submetric'></ul>";
	}
	$("#all-metric").append(html);
	setMetricStyle();
}
function hideEmailSettingDiv() {
	$('body').mousedown(function(e) {
		var left = $(".email-setting").offset().left;
		var maxleft = left + $(".email-setting").width();
		var top = $(".email-setting").offset().top;
		var maxtop = top + $(".email-setting").height();
		if(e.pageX < left || e.pageX > maxleft || e.pageY < top || e.pageY > maxtop){
			$(".email-setting > ul > li> input").val("");
			$("#error-message").hide();
			$(".email-setting").hide();
		}
	});
}

function addSettingEmail() {
	if($("#role").val() == "true") {
		addEmail();
		cancleButton();
		okButton();
	}
}
function addEmail() {
	$(".metric > .metric-img").click(function(){
		var parent = this;
		$("#email-setting-img").val($(this).attr("id"));
		$(".email-setting").css({
			"top" : $(this).offset().top + 41,
			"left" : $(this).offset().left - 220,
		});
		$(".email-setting").show(50,function(){
			var productId = $("#product-id").val();
			var scoreName = $(parent).parent().find(".name").text();
			$(".email-setting > ul > li> input").focus();
			$("#score-name").val(scoreName);
			scoreEmailSettingService.getEmail(productId, scoreName, function(data){
				$(".email-setting > ul > li > input").val(data);
			});
		});
	});
}

function okButton() {
	$(".ok").click(function(){
		var email = $("#email-addr-input").val();
		var productId = $("#product-id").val();
		var scoreName = $("#score-name").val();
		var regx = /^\S+@\S+.com$/;
		if(regx.exec(email)){
			scoreEmailSettingService.setScoreEmail(productId, scoreName, email, function(data){
				if(data != true){
					$("#error-message").text(data).show(50);
				} else {
					$("#email-addr-input").val("");
					$(".email-setting").hide(50);
					$("#error-message").hide();
					$("#" + $("#email-setting-img").val()).css({"background-image":"url(/images/manager-on.png)"});
				}
			});
		} else {
			$("#error-message").text("Email Incorrect!").show();
		}	
	});
}

function cancleButton() {
	$(".cancle").click(function(){
		$("#email-addr-input").val("");
		$(".email-setting").hide(50);
		$("#error-message").hide();
	});
}

function addSubmetric(){
	$(".ul-metric").each(function(){
		var parent = this;
		$(this).find(".metric > .name").click(function(){
			if($(parent).next(".ul-submetric").is(":empty")){
				var submetricIndex = $(parent).attr("id");
				var productId = dwr.util.getValue("product-id");
				var buildId = dwr.util.getValue("build-id");
				var stageString = dwr.util.getValue("stage-string");
				basicDataService.getMetricScore(
							 productId, submetricIndex, buildId,
							stageString, function(data) {
								if(data == null) {
									 return;
								}
								$(parent).next(".ul-submetric").append("<li class='li-img'><div class='div-img'></div></li>");
								$(parent).next(".ul-submetric").append("<li class='line'></li>");
								for(var i=1; i<data.length; i++){
									$(parent).next(".ul-submetric").append(createSubmetric(data[i]));
								}	
								$(parent).next(".ul-submetric").append('<li class="line"></li>');
								$(".submetric:even").css({"background-color":"#ffffff"});
								$(".submetric:odd").css({"bakcground-color":"#efeeee"});
								$(".submetric").each(function(){
									var data ;
									if($(this).find(".data-data > a").length > 0)
									{
										data = $(this).find(".data-data > a").text();
									} else {
										data = $(this).find(".data-data").text();
									}
									var exceptText = $(this).find(".submetric-exception").text();
									var excepted = exceptText.replace(/[^\d]/g, "");
									if(exceptText[0] == ">") {
										if(parseFloat(data) < parseFloat(excepted)){
											$(this).find(".data-arrow").html("&darr;");
										} else {
											$(this).find(".data-arrow").html("&nbsp;");
										}
									} else if(exceptText[0] == "<") {
										if(parseFloat(data) > parseFloat(excepted)){
											$(this).find(".data-arrow").html("&uarr;");
										} else {
											$(this).find(".data-arrow").html("&nbsp;");
										}
									} else {
										if(parseFloat(data) > parseFloat(excepted)){
											$(this).find(".data-arrow").html("&uarr;");
										} else if(parseFloat(data) < parseFloat(excepted)){
											$(this).find(".data-arrow").html("&darr;");
										} else {
											$(this).find(".data-arrow").html("&nbsp;");
										}
									}
								});
				});
			} else {
				if($(parent).next(".ul-submetric").css("display") == "block"){
					$(parent).next(".ul-submetric").hide(50);
				} else {
					$(parent).next(".ul-submetric").show(50);
				}
			}
		});
	});
}

function createSubmetric(data) {
	var html = "<li class='submetric'>";
	html += "<div class='otherlow'></div>";
	html += "<div class='submetric-name'>" + data[0] + "</div>";
	html += "<div class='submetric-data'>";
	html += "<div class='data-arrow'>&uarr;</div>"
	html += "<div class='data-data'>";
	if(data[7] == null) {
		html += data[1];
	} else {
		html += "<a href=" + data[7] + " target=_blank>" + data[1] + "</a>";
	}
	html += "</div>";
	html += "<div class='data-tip'>" + data[2] + "</div>";
	html += "</div>";
	html += "<div class='submetric-exception'>" + data[3] + "</div>";
	html += "<div class='submetric-power'>" + data[4] + "</div>";
	html += "<div class='submetric-score'>" + data[5] + "</div>";
	html += "<div class='submetric-img'></div>";
	html += "</li>";
	return html;	
}

function manager() {
	$(".email-setting").hide();
}

function addArrowForData() {
	$(".submetric").each(function() {
		var exceptation = $(this).find(".submetric-exception").text();
		if (exceptation == "") {
			return;
		}
		var data;
		if ($(this).find(".submetric-data .data-data a").length > 0) {
			data = $(this).find(".submetric-data .data-data a").text();
		} else {
			data = $(this).find(".submetric-data .data-data").text();
		}
		if (exceptation[0] == '<') {
			var exp = exceptation.substring(2);
			addUpArrow(this, data, exp);
		} else if (exceptation[0] == '>') {
			var exp = exceptation.substring(2);
			addDownArrow(this, data, exp);
		} else {
			var exp = exceptation;
			if (parseFloat(data) > parseFloat(exp)) {
				addUpArrow(this, data, exp);
			} else {
				addDownArrow(this, data, exp);
			}
		}
	});
}

function addUpArrow(dom, data, exp) {
	if (parseFloat(data) > parseFloat(exp)) {
		if ($(dom).find(".submetric-data .data-data a").length > 0) {
			var href = $(dom).find(".submetric-data .data-data a").text();
			$(dom).find(".submetric-data .data-data a").html("&uarr;" + href);
		} else {
			var href = $(dom).find(".submetric-data .data-data").text();
			$(dom).find(".submetric-data .data-data").html("&uarr;" + href);
		}
	}
}

function addDownArrow(dom, data, exp) {
	if (parseFloat(data) < parseFloat(exp)) {
		if ($(dom).find(".submetric-data .data-data a").length > 0) {
			var href = $(dom).find(".submetric-data .data-data a").text();
			$(dom).find(".submetric-data .data-data a").html("&darr;" + href);
		} else {
			var href = $(dom).find(".submetric-data .data-data").text();
			$(dom).find(".submetric-data .data-data").html("&darr;" + href);
		}
	}
}

function hotDeployPage() {
	var stage = $('#stage').val();
	var productId = $('#productId').val();
	window.location.href = "/deployhistory?productId=" + productId + "&stage="
			+ stage;
}

function deployButtonClick(stage, serverId) {
	window.location.href = "/serverbuildpage?serverId=" + serverId + "&buildId=" + $('#selectDropDown').val()
	    + "&stage=" + stage;
}

function updateButtonClick(serverId) {
	window.location.href = "/updateserverpage?serverId=" + serverId;
}

function createButtonClick() {
	var stage = document.getElementById("stage").value;
	var productId = document.getElementById('productId').value;

	window.location.href = "/createserverpage?stage=" + stage + "&productId="
			+ productId;
}

function goto_deploy_history_page() {
	var stage = document.getElementById("stage").value;
	var productId = document.getElementById('productId').value;

	window.location.href = "/deployhistory?productId=" + productId + "&stage="
			+ stage;
}

function picker() {
	var buildId = document.getElementById('selectDropDown').value;
	var activeBuild = document.getElementById('jinkensId').value;

	if (buildId != activeBuild) {
		var productId = dwr.util.getValue("productId");
		var stage = dwr.util.getValue("stage");

		buildService.updateActiveBuild(productId, buildId, stage,
				changeActiveBuild);
	}
}

function changeActiveBuild(response) {
	alert(response.status);
}

function changeBuild() {
	var buildId = document.getElementById('selectDropDown').value;
	document.getElementById('build_id').value = buildId;
	document.getElementById('score_table_container').innerHTML = "";
	phase_update_score_table(buildId);
	document.getElementById('failed_test_case_table').innerHTML = "";
	update_failed_test_case(buildId);
}

function goToDeployHisotyPage(productId, stage) {
	window.location.href = "/phasedeployhistory?productId=" + productId
			+ "&stage=" + stage;
}

function test_build_info_page() {
	window.location.href = "/build?productId="
			+ document.getElementById('productId').value + "&buildId="
			+ document.getElementById('buildId').value;
}

function updateBuildsInVersion() {
	var updateVersion = document.getElementById("versionSelect").value;
	var phase = document.getElementById("stage").value;

	basicDataService.getBuildsInVersion(updateVersion, phase,
			updateBuildsInVersionCallback);
}

function updateBuildsInVersionCallback(response) {
	if (response == null) {
		return;
	}

	var buildSelect = document.getElementById("selectDropDown");
	buildSelect.innerHTML = "";
	for ( var i = 0; i < response.length; i++) {
		try {
			buildSelect.add(new Option(response[i].jenkinsBuildId,
					response[i].buildId), null);
		} catch (e) { // in IE
			buildSelect.add(new Option(response[i].jenkinsBuildId,
					response[i].buildId));
		}
	}
	var phase = document.getElementById("stage").value;

	buildChangeInProdPhase();
}

function buildChangeInProdPhase() {
	var buildId = $('#selectDropDown').attr("value");
	var stage = $('#stage').val();
	if(stage == 'PROD')
		stage = 'PRODUCTION';
	$('#buildId').val(buildId);
	window.location = "/phase?buildId=" + buildId + "&productId="
			+ $('#product-id').val() + "&stage=" + stage;
}

function gotofailure(productId) {
	var data = "productId=" + productId;
	window.location.href = "/failurepage?" + data;
}

function BuildReportListPage() {
	window.location.href = "/buildlist?" + "productId="
			+ document.getElementById('productId').value;
}
