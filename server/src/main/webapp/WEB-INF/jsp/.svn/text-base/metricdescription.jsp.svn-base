<%@include file="/common_jsp/head.jsp"%>
<script type="text/javascript" src="/js/metricdescription.js"></script>
<input type="button" value="Go Back" onclick="history.go(-1)" />
<div id="table_container">
	<span style="font-weight: bold">Metrics Name : ${metricname}</span><br />
	<table id="overviewTable"  cellpadding="5"
	    style="width: 70%; color: white; padding-bottom: 2cm; font-size: 14px"></table>
	<table id="metricsFormulaTable"  cellpadding="5"
	    style="width: 50%; color: white; padding-bottom: 2cm; font-size: 14px"></table>
	<table id="possibleFailureTable"  cellpadding="5"
	    style="width: 70%; color: white; padding-bottom: 2cm; font-size: 14px"></table>
	<div id="scoreOwnerTable" style="display:none">
	    <b>Owner who take response for this score</b>
		<table id="ownerTable"  cellpadding="5"
	    	style="width: 70%; color: white; padding-bottom: 2cm; font-size: 14px"></table>
	</div>
	<table id="QandATable"  cellpadding="5"
	    style="width: 70%; color: white; padding-bottom: 2cm; font-size: 14px"></table>
	<table id="referenceLinkTable" cellpadding="5"
		style="width: 70%; color: white; padding-bottom: 2cm; font-size: 14px"></table>
</div>
<script>
	loadMetricsDescription('${metricname}', '${productId}');
</script>
<input type="hidden" id="product_id" value="${productId }" />
<%@include file="/common_jsp/foot.jsp"%>