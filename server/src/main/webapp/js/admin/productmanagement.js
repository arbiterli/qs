/*
 * modify product information when the user change it
 * 
 * send adjax
 * 
 * author:CLB
 * 
 * date:2012-11-21
 */
function errh(msg, exc) {
	  alert("Error message is: " + msg + " - Error Details: " + dwr.util.toDescriptiveString(exc, 2) + "e.message: " + exc.message);
	}

	dwr.engine.setErrorHandler(errh);
function modifyProductInfo(id) {

	var product = {
		id : id,
		name : $('#name' + id).val(),
		group : $('#group' + id).val(),
		displayName : $('#displayName' + id).val(),
		trunkSvnUrl : $('#svnUrl' + id).val(),
		discarded : $('#discarded' + id)[0].checked
	}
	try{
	adminService.modifyProduct(product, dispalySuccessOrFailed);
	}
	catch(err){
		alert(err);
	}
}
/*
 * display whether the modification is success
 * 
 * 
 * author:CLB
 * 
 * date:2012-11-21
 */
function dispalySuccessOrFailed(response) {
	if ("success" == response.status) {
		alert("successfully");
	} else {
		alert("failed");
	}
}
/*
 * this method is to add datepicker to easy get date time
 * 
 * author:CLB
 * 
 * date:2012-11-21
 */
function addDatePicker(id) {
	$("#create" + id).datepicker({
		defaultDate : null,
		changeMonth : true,
		numberOfMonths : 1,
		dateFormat : 'yy-mm-dd'
	});
}