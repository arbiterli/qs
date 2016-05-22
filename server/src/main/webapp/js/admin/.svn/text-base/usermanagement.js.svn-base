/*
 * modify user information when the user change it
 * 
 * send adjax
 * 
 * author:CLB
 * 
 * date:2012-11-21
 * 
 */

function modifyUser(id) {
	var user = {
		id : id,
		name : $('#name' + id).val(),
		email : $('#email' + id).val()
	};
	adminService.modifyUser(user, dispalySuccessOrFailed);
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
	if ("sucess" == response.status) {
		alert("successfully");
	} else {
		alert("failed");
	}
}