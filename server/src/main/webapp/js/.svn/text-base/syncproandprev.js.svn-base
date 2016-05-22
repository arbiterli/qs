$(document).ready(function(){
	$("#operation_button").click(function() {
		if ($("#operation_title").html() == "Sync To Production") {
			$.get("/dosynctopro?productId=" + $("#productId").val(), showSyncToProResult);
		}
		
		if ($("#operation_title").html() == "Sync From Production") {
			$.get("/dosyncfrompro?productId=" + $("#productId").val(), showSyncFromProResult);
		}
		
		$.blockUI({message: "<img src='/image/loadinfo.gif'></img>",
	            css: {
	                 cursor: 'default',
	                 width: '400px',
	                 border: 'none'
	               }});
	    $('.blockOverlay').css('cursor','default').click($.unblockUI);
	});
	
	$("#goback_button").click(function() {
		location.href = "/deployhistory?productId="+$("#productId").val()+"&stage=Production";
	});
	
});

function showSyncToProResult(result) {
	$('.blockOverlay').click();
	$("#change_list").html(result);
	$("#operation_button").val("Check");
	$("#operation_button").click(function(){
		window.open("http://"+$("#targetUrl").val());
	});
}

function showSyncFromProResult(result) {
	$("#change_list").html(result);
	$("#operation_button").val("Check");
	$("#operation_button").click(function(){
		window.open("http://"+$("#targetUrl").val());
	});
	$('.blockOverlay').click();
}
