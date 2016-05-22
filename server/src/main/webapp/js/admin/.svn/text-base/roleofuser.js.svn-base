/*
 * 
 * set role name
 * 
 * author:CLB
 * 
 * date:2012-11-21
 */

function setName(name, id) {
	$('#roleName' + id).val(name);
}

/*
 * modify role information whe the user change it
 * 
 * send adjax
 * 
 * author:CLB
 * 
 * date:2012-11-21
 */
function modifyRole(id) {

	var role = {
		id : id,
		name : $('#roleName' + id).val(),
		scope : $('#scope' + id).val(),
		productId : $('#productId' + id).val()
	};
	adminService.modifyRole(role, dispalySuccessOrFailed)
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