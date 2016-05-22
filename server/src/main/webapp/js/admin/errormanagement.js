/*
 * select on change event  to set iframe src
 * 
 * author:CLB
 * 
 * date:2012-11-21 
 * */
function selectOnChange() {
		$("#errorIframe")[0].src = "/errorofproduct?productId="
				+ $("#selectPId").val();
	}