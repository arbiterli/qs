/*
 * date picker for time_after and time_before
 * 
 * the function run just the end of loading page
 * 
 * author:LHP
 * 
 */
$(function() {
	$("#time_after").datepicker({
		defaultDate : null,
		changeMonth : true,
		numberOfMonths : 1,
		dateFormat : "yy-mm-dd",
		onSelect : function(selectedDate) {
			$("#time_before").datepicker("option", "minDate", selectedDate);
		}
	});
	$("#time_before").datepicker({
		defaultDate : null,
		changeMonth : true,
		numberOfMonths : 1,
		dateFormat : "yy-mm-dd",
		onSelect : function(selectedDate) {
			$("#time_after").datepicker("option", "maxDate", selectedDate);
		}
	});
});


function clearPage() {
	document.getElementById('searched_list_info').innerHTML = "";
	document.getElementById('buildReportListPaginate').innerHTML = "";
}

function list_search() {	
	var startTime = document.getElementById('time_after').value;
	var endTime = document.getElementById('time_before').value;
	var productId =dwr.util.getValue("productId");
	
	var info = "Time before:  " + endTime +"  Time after:  " + startTime;
	document.getElementById('table_title').innerHTML = info;
	clearPage();
	
	basicDataService.getBuildsInfo(productId, startTime, endTime, 1, __updateSearchTable);
}

function goto_build_page(obj) {
	window.location.href = "/build?productId=" + dwr.util.getValue("productId") + "&buildId="
			+ obj.id;
}

$(document).ready(function(){
	if ($('#buildInfoPageCount').val() > 1) {
		$("#buildReportListPaginate").paginate({
	        count : $('#buildInfoPageCount').val(),
	        start : 1,
	        display : 5,
	        border : true,
	        border_color : '#fff',
	        text_color : '#fff',
	        background_color : 'black',
	        border_hover_color : '#ccc',
	        text_hover_color : '#000',
	        background_hover_color : '#fff',
	        images : true,
	        mouse : 'press',
	        onChange : function(page) {
	        	basicDataService.getBuildsInfo(dwr.util.getValue("productId"), "", "", page, __updateTTable);
	        }
	    });
	}
});


function __updateTTable(response) {
	var table = document.getElementById('searched_list_info');
	table.innerHTML = "";
	table.style.borderColor = "#07799c";
	for (var i = 0; i < response.length - 1; i++) {
		var newRow = table.insertRow(i);
		newRow.id = response[i].id;
		if (i % 2 != 0) {
			newRow.style.backgroundColor = "#3b585e";
		}
		newRow.onclick = function() {
			goto_build_page(this);
		};
		newRow.innerHTML='<td align="center">' + response[i].jenkins_buildeid + '</td>'
					   + '<td align="center">' + response[i].created_at + '</td>'
					   + '<td align="center">' + response[i].version + '</td>'
					   + '<td align="center">' + response[i].testTotalCount + '</td>'
					   + '<td align="center">' + response[i].testFailureCount + '</td>'
					   + '<td align="center">' + response[i].svn_url + '</td>'
					   + '<td align="center">' + response[i].svn_revision + '</td>'
					   + '<td align="center">' + response[i].certification + '</td>';
	}
	insertTableHead(table);
	document.getElementById("buildInfoPageCount").value = response[response.length - 1].buildInfoPageCount;
}

function insertTableHead(table) {
	var newRow = table.insertRow(0);
	newRow.innerHTML="<th>Build ID</th><th>Time</th><th>Version</th><th>Tests</th><th>Failed Test</th><th>SVN URL</th><th>SVN REVISION</th><th>Certification</th>";
	newRow.style.backgroundColor="#081d2e";
}

function __updateSearchTable(response) {
	__updateTTable(response);
	if (jQuery("#buildInfoPageCount").val() > 1) {
		jQuery("#buildReportListPaginate").paginate({
	        count : $('#buildInfoPageCount').val(),
	        start : 1,
	        display : 5,
	        border : true,
	        border_color : '#fff',
	        text_color : '#fff',
	        background_color : 'black',
	        border_hover_color : '#ccc',
	        text_hover_color : '#000',
	        background_hover_color : '#fff',
	        images : true,
	        mouse : 'press',
	        onChange : function(page) {
	            basicDataService.getBuildsInfo(dwr.util.getValue("productId"),
	            		document.getElementById('time_after').value,
	            		document.getElementById('time_before').value,
	            		page,
	            		__updateTTable);
	        }
	    });
	}
}