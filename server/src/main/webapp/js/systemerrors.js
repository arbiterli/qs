$(function() {
	var id = $("#currentIndex").val();
	$("#" + id).find("span").css({
		"background-color" : "white"
	});
	$("tr:gt(0):odd").css({
		"background" : "#dfdfdf"
	});
	$("tr:gt(0):even").css({
		"background" : "#ffffff"
	});
});