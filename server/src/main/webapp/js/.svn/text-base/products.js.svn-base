$(function(){
	$(".product").each(function(){
		var product = this;

		$(this).find(".productName > span").click(function(){
			var productId = getProductId(product);
			window.location = "/product?productId=" + productId;
		});

		$(this).find(".productScore ul li").each(function(){
			var score = $(this).html();
			$(this).css({"color":getScoreColor(score)})
				   .click(function(){
				   		var productId = getProductId(product);
				   		var stage = $(this).attr("class");
				   		var buildId = getBuildId(stage, product);
				   		window.location = "/phase?stage=" + stage + "&buildId=" + buildId + "&productId=" + productId;
				   });
		});
	});
});

function getProductId(product) {
	return $(product).find(".productId").val();
}

function getBuildId(stage, product) {
	return $(product).find("." + stage + "buildId").val();
}