<%@include file="/common_jsp/head.jsp"%>
<script type="text/javascript" src="/js/failure.js"></script>
<input type="button" value="Go Back" onclick="history.go(-1)" />
<div id="table_container">
	<span style="font-weight: bold">Failures</span><br />
	<table id="failuresTable" cellpadding="5"
		style="width: 70%; color: white; padding-bottom: 2cm; font-size: 14px"></table>
</div>
<script>
	loadProductFailures('${productId}')
</script>
<%@include file="/common_jsp/foot.jsp"%>