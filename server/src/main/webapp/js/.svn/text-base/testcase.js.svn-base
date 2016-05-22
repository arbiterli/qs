/**
 * 
 */
function update_failed_test_case(buildId) {
	basicDataService.getTestCases(buildId, "fail", updatefailedTestCaseTable);
}
function updatefailedTestCaseTable(response) {
	if (response == null)
		return false;
	var successTestCaseTable = document
			.getElementById("failed_test_case_table");
	successTestCaseTable.innerHTML = "";
	for ( var i = 0; i < response.length; i++) {
		var newRow = successTestCaseTable.insertRow(i);
		for ( var j = 1; j < response[i].length; j++) {
			var newCell = newRow.insertCell(j - 1);
			newCell.innerHTML = response[i][j];
		}
	}
}

function update_success_test_case(buildId) {
	basicDataService
			.getTestCases(buildId, "success", updatefailedTestCaseTable);
}

function updatesuccessTestCaseTable(response) {
	var successTestCaseTable = document.getElementById("successTestCaseTable");
	successTestCaseTable.innerHTML = "";
	for ( var i = 0; i < response.length; i++) {
		var newRow = successTestCaseTable.insertRow(i);
		for ( var j = 1; j < response[i].length; j++) {
			var newCell = newRow.insertCell(j - 1);
			newCell.innerHTML = response[i][j];
		}
	}
}
