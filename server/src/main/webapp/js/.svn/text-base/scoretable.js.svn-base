function phase_update_score_table(buildId) {
	var stage = document.getElementById("stage").value;
	var data = "buildId=" + buildId + "&stage=" + stage;
	basicDataService.getDetailedScore(buildId, stage, phase_update_score);
}
function phase_update_score(response) {
	if (response == null)
		return false;

	var scoreTableContainer = document.getElementById("score_table_container");
	scoreTableContainer.innerHTML = "";
	for ( var i = 0; i < response.length; i++) {
		var scoreTable = document.createElement("table");
		scoreTable.id = "scoreTable_" + i;
		scoreTable.className = "scoreTable"
		// TODO: move these to css
		scoreTable.cellPadding = "5";
		scoreTable.cellSpacing = "0";
		scoreTable.border = "0"
		updateScoreTable(response[i], scoreTable)
		scoreTableContainer.appendChild(scoreTable);
	}

}

function clearScoreContent() {
	var scoreTableContainer = document.getElementById("score_table_container");
	scoreTableContainer.innerHTML = "";
}

function updateScoreTable(response, scoreTable) {
	var title = new Array("Metric", "Data", "Score", "Power", "Final Score");
	insertTitle(scoreTable, title);

	var length = response.length;
	var totalScore = 0.0;
	for ( var i = 1; i < length; i++) {
		insertScore(scoreTable, response[i], i, title);
		totalScore += parseFloat(response[i][4]);
	}

	var totalScoreArray = new Array("", "", "", "Total Score : ", totalScore
			.toFixed(2));
	insertScore(scoreTable, totalScoreArray, length, title);

	// set font size and color of the final score
	// TODO: move this to css
	scoreTable.rows[length].cells[3].style.fontWeight = "bold";
	scoreTable.rows[length].cells[4].style.fontSize = "73px";
	scoreTable.rows[length].cells[3].style.color = "white";

	scoreTable.rows[length].cells[4].style.color = getColorByScore(totalScore);

	var newRow = scoreTable.insertRow(1);
	newRow.style.backgroundImage = "url(/image/u0_line.png)";
	newRow.style.backgroundRepeat = "no-repeat";
	for ( var i = 0; i < 5; i++)
		newRow.insertCell(i);

	newRow = scoreTable.insertRow(length + 1);
	newRow.style.backgroundImage = "url(/image/u0_line.png)";
	newRow.style.backgroundRepeat = "no-repeat";
	for ( var i = 0; i < 5; i++)
		newRow.insertCell(i);
}

function insertTitle(scoreTable, title) {
	var newRow = scoreTable.insertRow(0);

	newRow.style.fontSize = "14px";
	newRow.style.fontWeight = "bold";

	for ( var i = 0; i < title.length; i++) {
		var newCell = newRow.insertCell(i);
		newCell.style.paddingTop = "0.6cm";
		newCell.style.paddingBottom = "0.2cm";
		newCell.innerHTML = title[i];
		newCell.className = "scoreTable_td_" + i;
	}
}
/**
 * Insert a score to the score table. The data of a score will following the
 * rule: from 0 to title.length-1 are the data map to the title After that,
 * there may be some extra data as defined title.length -- holds the link to the
 * related report title.length + 1 -- holds the doc of the item
 * 
 * @param scoreTable
 * @param s
 * @param row
 * @param title
 */
function insertScore(scoreTable, s, row, title) {
	var newRow = scoreTable.insertRow(row);
	var score = s[2];
	newRow.style.color = getColorByScore(score);
	var columns = title.length;
	for ( var i = 0; i < columns; i++) {
		var newCell = newRow.insertCell(i);
		newCell.className = "scoreTable_td_" + i;
		if (i == 0 && s[columns] != null) {
			// If the item has link. add the link to the name
			// newCell.innerHTML = "<a href='" + s[columns] + "'
			// target='_blank'>" + s[i] + "</a>";
			newCell.innerHTML = s[i];
			newCell.onclick = function() {
				openURL(s[columns]);
			};
			newCell.onmouseover = function() {
				handCursor(this);
			};
		} else {
			newCell.innerHTML = s[i];
		}
	}
}

function getColorByScore(score) {
	var color;
	if (score < 60) {
		color = "red";
	} else if (score < 85) {
		color = "#FFD306";
	} else if (score >= 85) {
		color = "green";
	}
	return color;
}