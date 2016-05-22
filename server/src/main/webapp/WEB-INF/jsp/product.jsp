<%@include file="/common_jsp/head.jsp"%>
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	 <script type="text/javascript" src="/js/product.js"></script>
	<script>
		google.load("visualization", "1", {
			packages : [ "corechart" ]
		});
	</script>
	<div id="product_name_title">${productName}</div>
	<div id="product_build_report_list" onclick="build_report_list_page()">Build Report List</div>
    <div id="product_trend_pic">
    	<div id="trend_chart"></div>
    	<div id="product_chart_title">${productName} score of latest time</div>
    	<div class="glority_com">Glority.com</div>
    	<div class="product_border">
    		<img src="/image/div-border.jpg" class="product_border_img"></img>
    	</div>
    </div>
	<div id="requirement">
		<div id="req_title">Requirement</div>
		<div id="req_score"></div>
		<div id="req_info"></div>
	</div>
	<div id="development">
		<div id="dev_title">Development</div>
		<div id= "dev_score" onclick="dev_page()"></div>
		<script type="text/javascript">
			document.getElementById('dev_score').style.visibility = "hidden";
		</script>
		<div id="dev_info"></div>
	</div>
	<div id="test">
		<div id="tes_title">Test Release</div>
		<div id="tes_score" onclick="tes_page()"></div>
		<script type="text/javascript">
			document.getElementById('tes_score').style.visibility = "hidden";
		</script>
		<div id="tes_info"></div>
	</div>
	<div id="stage">
		<div id="sta_title">Stage</div>
		<div id="sta_score" onclick="sta_page()"></div>
		<script type="text/javascript">
			document.getElementById('sta_score').style.visibility = "hidden";
		</script>
		<div id="sta_info"></div>
	</div>
	<div id="production">
		<div id="pro_title">Production</div>
		<div id="pro_score" onclick="pro_page()"></div>
		<script type="text/javascript">
			document.getElementById('pro_score').style.visibility = "hidden";
		</script>
		<div id="pro_info"></div>
	</div>
	<input id="product_id" type='text' value='${productId}' style="visibility:hidden"/>
	<input id="product_date" type="text"  style="visibility:hidden"/>
	<input id="hidden_dev_id" type="text" style="visibility:hidden"/>
	<input id="hidden_tes_id" type="text" style="visibility:hidden"/>
	<input id="hidden_sta_id" type="text" style="visibility:hidden"/>
	<input id="hidden_pro_id" type="text" style="visibility:hidden"/>
 	<script type="text/javascript"> product_draw_chart()</script>
<%@include file="/common_jsp/foot.jsp"%>
