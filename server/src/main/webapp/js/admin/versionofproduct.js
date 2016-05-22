/*
 * add date picker to easily get date
 * 
 * author:CLB
 * 
 * date:2012-11-21
 */

function addDatePicker(input, id) {
	$("#" + input + id).datepicker({
		defaultDate : null,
		changeMonth : true,
		numberOfMonths : 1,
		dateFormat : 'yy-mm-dd'
	});

}

/*
 * modify version when the suer change it
 * 
 * send adjax
 * 
 * author:CLB
 * 
 * date:2012-11-21
 * 
 */
function errh(msg, exc) {
	  alert("Error message is: " + msg + " - Error Details: " + dwr.util.toDescriptiveString(exc, 2) + "e.message: " + exc.message);
	}

	dwr.engine.setErrorHandler(errh);
function modifyVersion(id) {
	var versionExt = {
		id : id,
		productId : $('#pId' + id).val(),
		version : $('#version' + id).val(),
		devStartTimeStr : $('#devStartTime' + id).val(),
		devEndTimeStr : $('#devEndTime' + id).val(),
		testStartTimeStr : $('#testStartTime' + id).val(),
		testEndTimeStr : $('#testEndTime' + id).val(),
		stageStartTimeStr : $('#stageStartTime' + id).val(),
		stageEndTimeStr : $('#stageEndTime' + id).val(),
		productionStartTimeStr : $('#proStartTime' + id).val(),
		prodcutionEndTimeStr : $('#proEndTime' + id).val(),
		svnUrl : $('#svnUrl' + id).val(),
		svnRevision : $('#svnRevision' + id).val()
	};
	adminService.modifyVersion(versionExt, dispalySuccessOrFailed);
}

/*
 * display whether the modification is success
 * 
 * author:CLB
 * 
 * date:2012-11-21
 * 
 */
function dispalySuccessOrFailed(response) {
	if ("success" == response.status) {
		alert("successfully");
	} else {
		alert("failed");
	}
}