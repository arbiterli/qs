<%@include file="/common_jsp/head.jsp"%>
<script type="text/javascript" src="/js/scoretable.js">	
<script type="text/javascript" src="/js/testcase.js">	
</script>
<input style="visibility: hidden; height: 20px;" type="text"
	value='test' id="stage" />
<div id="product_name_title">Build NO. ${buildDetail.id}</div>
<div id="product_build_report_list" onclick="build_report_list_page()">Build
	Report List</div>
<%@include file="/individual_jsp/buildreport_status.jsp"%>
<div id="separate_line"></div>
<div class="metricScoreTable">
	<div id="score_table_container"></div>
</div>
<script>
	phase_update_score_table('${buildDetail.id}');
</script>
<div id="separate_line"></div>
<%@include file="/individual_jsp/testbuildinfo_metrics.jsp"%>
<div id="separate_line"></div>
<%@include file="/common_jsp/failedtestcase.jsp"%>
<input type="text" id="product_id" value='${productId}'
	style="visibility: hidden">
<input type="text" id="build_id" value='${buildId}'
	style="visibility: hidden">

<%@include file="/common_jsp/foot.jsp"%>
