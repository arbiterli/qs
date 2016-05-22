/*
 * Used for render metric description pages.
 */
function loadMetricsDescription(metricsName, productId) {
	var data = "metrics_name=" + metricsName;
	if (productId) {
		data += "&productId=" + productId;
	}
	createAjax("/metricsdescription/getMetricsDescriptionDetail", data, loadMetricDescriptionDetail);
 }

function gotoMetricDescription(metricsName, productId) {
	var data = "metrics_name=" + metricsName;
	if (productId) {
		data += "&productId=" + productId;
	}
	window.location.href = "/metricsdescription/getMetricsDescription?" + data;
}

function loadMetricDescriptionDetail(response) {
	if (response == null) {
	   return;
	}
	// render the overview.
	var overview = document.getElementById('overviewTable');
	var overviewRow = overview.insertRow(0);
	var cell = overviewRow.insertCell(0);
	cell.innerHTML = response["overview"];
    
	renderMetricFormulaTable(response);
	
	// rendered the possible failures.
	renderMetricDescriptionTable('possibleFailureTable', 'possibleFailures', response);
	
	// rendered the owner table
	renderScoreOwnerTable('ownerTable', 'owners', response);

	// render reference links.
	renderReferenceLinks('referenceLinks', response);
	
	// render the question and answers
	renderQuestionAndAnswerTable('QandATable', 'qAndAList', response);
  }
  
 function renderMetricFormulaTable(response) {
		var formulaTable = document.getElementById('metricsFormulaTable');
		var captionRow = formulaTable.insertRow(0);
		var captionCell = captionRow.insertCell(0);
		captionCell.innerHTML = "<b>Metric Score Calcalate Formula:</b>";
		
		var metricsformula = response['metricFormula'];
		
		var isSimpleFormula = (true != metricsformula['complexMetricScore']);
		if (isSimpleFormula) {
			var variableRow = formulaTable.insertRow(1);
			var variableCell = variableRow.insertCell(0);
			var isRated = metricsformula['rated'];
			var metricName = metricsformula['metricName'];
			if (isRated == true) {
				variableCell.innerHTML = "x is value of " + metricName + " per 1000 line";
			} else {
				variableCell.innerHTML = "x is value of " + metricName;
			}
			var title = new Array("Range", "score");
			insertMetricScoreFormulaTitle(formulaTable, title, 2);
			// insert the table.
			var scoreFormulas = metricsformula['scoreFormulas'];
			for (var i = 1;  i <= scoreFormulas.length; i++) {
				var newRow = formulaTable.insertRow( 2 + i);
				var rangeCell = newRow.insertCell(0);
				rangeCell.innerHTML = scoreFormulas[i - 1]['range'];
				
				var valueCell = newRow.insertCell(1);
				valueCell.innerHTML = scoreFormulas[i - 1]['value'];
			}
		} else {
			// rending complex formula
			var complexTableTitle = new Array("Sub Metric Score", "Power");
			insertMetricScoreFormulaTitle(formulaTable, complexTableTitle, 1);
			
			// insert the table.
			var scoreFormulas = metricsformula['scoreFormulaList'];
			for (var i = 1;  i <= scoreFormulas.length; i++) {
				var newRow = formulaTable.insertRow(1 + i);
				var buildItemCell = newRow.insertCell(0);
				buildItemCell.innerHTML = scoreFormulas[i - 1]['id'];
				buildItemCell.onclick = function() {
					var productId = document.getElementById('product_id').value;
					window.location.href = '/metricsdescription/getMetricsDescription?metrics_name='
						+ this.innerHTML + "&productId=" + productId;
				};
				buildItemCell.onmouseover = function() {
					handCursor(this);
				};
				var powerCell = newRow.insertCell(1);
				powerCell.innerHTML = parseInt(metricsformula['powerMap'][scoreFormulas[i - 1]['id']]) + "%";
			}
		}
 }
 
 function insertMetricScoreFormulaTitle(formulaTable, title, index) {
	 var newRow = formulaTable.insertRow(index);
	 newRow.style.fontSize = "14px";
	 newRow.style.fontWeight = "bold";
	 for (var i = 0; i < title.length; i++) {
		 var newCell = newRow.insertCell(i);
		 newCell.style.paddingTop = "0.6cm";
		 newCell.style.paddingBottom = "0.2cm";
		 newCell.innerHTML = title[i];
	 }
 }
 
 function renderScoreOwnerTable(tableName, name, response) {
	 var objectToRender = response[name];
	 if (objectToRender != null && objectToRender.length > 0) {
		document.getElementById("scoreOwnerTable").style.display = 'block';
		
		var table = document.getElementById(tableName);
		var scoreOwnerTableTitle = new Array("Contact", "Email");
		var newRow = table.insertRow(0);
		for (var i = 0; i < scoreOwnerTableTitle.length; i++) {
			 var newCell = newRow.insertCell(i);
			 newCell.innerHTML = scoreOwnerTableTitle[i];
		}

		for (var j = 0; j < objectToRender.length; j++) {
			var tableRow = table.insertRow(1 + j);
			var contactCell = tableRow.insertCell(0);
			contactCell.innerHTML = objectToRender[j]['contactName'];
			
			var emailCell = tableRow.insertCell(1);
			emailCell.innerHTML = objectToRender[j]['email'];
		}
	}	 
 }
 
 function renderReferenceLinks(name, response) {
 	var objectToRender = response[name];
	if (objectToRender != null && objectToRender.length > 0) {
		var referenceLinksTable = document.getElementById('referenceLinkTable');
		var captionRow = referenceLinkTable.insertRow(0);
		var captionCell = captionRow.insertCell(0);
		captionCell.innerHTML = "<b>References</b>";
		for (var j = 0; j < objectToRender.length; j++) {
			var tableRow = referenceLinksTable.insertRow(j + 1);
			var tableCell = tableRow.insertCell(0);
			tableCell.innerHTML = "<a href='" + objectToRender[j] + "'>" + objectToRender[j] +  "</a>";
		}
	}
 }

 function renderMetricDescriptionTable(tableName, name, response) {
    var objectToRender = response[name];
	if (objectToRender != null && objectToRender.length > 0) {
		var table = document.getElementById(tableName);
		var referenceLink = false;
		for (var j = 0; j < objectToRender.length; j++) {
			var tableRow = table.insertRow(j);
			var tableCell = tableRow.insertCell(0);
			tableCell.innerHTML = objectToRender[j];
		}
	}
 }
 
 function renderQuestionAndAnswerTable(tableName, name, response) {
     var questionAndAnswer = response[name];
	 if (questionAndAnswer != null && questionAndAnswer.length > 0) {
		var table = document.getElementById(tableName);
		var count = 0;
		for (var j = 0; j < questionAndAnswer.length; j++) {
			var tableRow = table.insertRow(count);
			count++;
			var tableQuestionCell = tableRow.insertCell(0);
			tableQuestionCell.innerHTML = questionAndAnswer[j].question;
			
			tableRow = table.insertRow(count);
			count++;
			var tableAnswerCell = tableRow.insertCell(0);
			tableAnswerCell.innerHTML = questionAndAnswer[j].answer;
		}
	 }
 }
