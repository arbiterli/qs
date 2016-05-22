$(function(){
	$('#head #email input').click(function(){
		window.location = "/j_spring_cas_security_logout";
	});
	
	$("#navigation > span").not(".rear").each(function(){
		var left = $(this).offset().left + $(this).width() + 19;
		var top = $(this).offset().top;
		$arrow = $("<div class='nav-arrow'></div>");
		$arrow.css({'top':top,'left':left});
		$('body').append($arrow);
	});
});


function getScoreColor(score) {
	if(parseInt(score) < parseInt($("#passingScore").val())) {
		return "#f52f18";
	} else if (parseInt(score) < parseInt($("#excellentScore").val())) {
		return "orange";
	} else {
		return "#14c475";
	}
}

// these 2 api should only be removed if all call to these 2 methods are removed.
function getAjaxData(passUrl, passData, renderFunction) {
    var ajaxData = {
        type : 'GET',
        contentType : 'application/json',
        url : passUrl,
        cache : false,
        dataType : 'json',
        data : passData,
        success : function(data) {
            renderFunction(data);
        }
    };
    return ajaxData;
}

function createAjax(passUrl, passData, renderFunction) {
    var ajaxData = getAjaxData(passUrl, passData, renderFunction);
    ajaxData.success = function(data) {
        renderFunction(data);
    };
    jQuery.ajax(ajaxData);
}

function doLogout() {
	window.location.href = "/j_security_logout";
}

/**
 * change the mouse to hand shap
 */
function handCursor(obj) {
	obj.style.cursor = 'hand';
	obj.style.cursor = 'pointer';
}

/**
 * go to give url in current window
 * 
 */
function goURL(url) {
	window.location.href = url;
}
/**
 * open the given url in new window, if the browser disabled to open new window,
 * go to the url in current window
 * 
 */
function openURL(url) {
	var newWindow = window.open(url);
	var checkNewWindow = function() {
		if (newWindow == undefined)
			goURL(url);
	};
	setTimeout(checkNewWindow, 50);
}

function setScreenHeight() {
	window.setInterval("_setScreenHeight()", 100);
}
function _setScreenHeight() {
	var height = document.getElementById('stretched_body').offsetHeight;
	var visible_height = document.documentElement.clientHeight;
	var header_height = 90;
	var footer_height = 55;
	if (height + header_height + footer_height < visible_height)
		document.getElementById('stretched_body').style.minHeight = visible_height
				- header_height - footer_height + "px";
}

function build_report_list_page() {
	window.location.href = "/buildlist?" + "productId="
			+ document.getElementById('product_id').value;
}
function goto_product_list_page() {
	window.location.href = "/productlist";
}

$(document).ready(function() {
	$("#product_trend_pic").css("position", "none");
});