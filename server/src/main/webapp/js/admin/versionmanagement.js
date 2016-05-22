/*
 * select onchange event to set iframe src 
 * 
 * author:CLB
 * 
 * date:2012-11-21
 */

function selectOnchange() {
	var productId = $('#selectProductId').val();
	var srcUrl = "/versionofproduct?productId=" + productId;
	$('#versionIframe')[0].src = srcUrl;
}