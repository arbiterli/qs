/**
 * 
 */


function loadProductFailures(productId) {
	basicDataService.getProductFailures(productId, loadFailuresCallback);
}

function loadServerFailures(serverId) {
	basicDataService.getServerFailures(productId, loadFailuresCallback);
}

function loadFailuresCallback(response) {
	if (response == null) {
		return;
	}

	var failuresTable = document.getElementById('failuresTable');

	for ( var i = 0; i < response.length; i++) {
		var row = failuresTable.insertRow(i);

		if (i == 0)
			row.style.backgroundColor = "#081d2e";
		else if (i % 2 == 0)
			row.style.backgroundColor = "#3b585e";

		if (i != 0) {
			row.id = response[i][0];
			row.onclick = function() {
				linkToFailureDetailPage(this);
			}
		}

		for ( var j = 1; j < response[i].length; j++) {
			var cell = row.insertCell(j - 1);
			cell.innerHTML = response[i][j];
		}
	}
}

function linkToFailureDetailPage(obj) {
	window.location.href = '/failuredetail?failureId=' + obj.id;
}

function updateFailureStatus(failureId) {
	var status = document.getElementById("statusSelect").value;
	basicDataService.updateFailureStatus(failureId, status, updateFailureStatusCallback);
}

function updateFailureStatusCallback(response) {
	alert(response);
	if (response == 'success') {
		var status = document.getElementById("statusSelect").value;
		var currentStatus = document.getElementById("failureStatus");
		currentStatus.innerHTML = status;
	}
}

