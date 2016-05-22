
/*
 * change iframe src when the user select special one
 *  
 * author:CLB
 * 
 * date:2012-11-21
 * */
function displayUserJsp(){
	$('#iframeJsp')[0].src = "/usermanagement";
}
function displayVersionJsp(){
	$('#iframeJsp')[0].src = "/versionmanagement";
}
function displayProductJsp(){
	$('#iframeJsp')[0].src = "/productmanagement";
}
function displayErrorJsp(){
	$('#iframeJsp')[0].src = "/errormanagement";
}
function displayRoleJsp(){
	$('#iframeJsp')[0].src = "/rolemanagement";
}