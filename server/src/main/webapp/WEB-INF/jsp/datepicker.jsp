<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<title>jQuery UI Datepicker - Select a Date Range</title>
<link href="/css/jquery-ui.css" type="text/css" rel="stylesheet">
<script src="/js/jquery-1.8.1.js"></script>
<script src="/js/jquery.ui.core.js"></script>
<script src="/js/jquery.ui.widget.js"></script>
<script src="/js/jquery.ui.datepicker.js"></script>
<script>
	$(function() {
		$("#from").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 3,
			dateFormat: "yy-mm-dd",
			onSelect : function(selectedDate) {
				$("#to").datepicker("option", "minDate", selectedDate);
			}
		});
		$("#to").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 3,
			dateFormat: "yy-mm-dd",
			onSelect : function(selectedDate) {
				$("#from").datepicker("option", "maxDate", selectedDate);
			}
		});
	});
	
	$.clickfunction = function(){
		var from = $("#from").val();
		alert(from);
	}
</script>
</head>
<body>

	<div class="demo">

		<label for="from">From</label> <input type="text" id="from"
			name="from" /> <label for="to">to</label> <input type="text" id="to"
			name="to" />
		<button id="click" onclick="$.clickfunction()">button</button>
	</div>

</body>
</html>