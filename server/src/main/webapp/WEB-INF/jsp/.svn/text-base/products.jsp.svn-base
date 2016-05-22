<%@include file="/include/head.jsp"%>
	<link rel="stylesheet" type="text/css" href="/css/products.css"></link>
	<script type="text/javascript" src="/js/products.js"></script>
	<c:forEach var="product" items="${products}" varStatus="status">
		<div class="product">
			<div class="empty"></div>
			<div class="productName">
				<span>${product.product.displayName}</span>
			</div>
			<div class="productVersion">
				<ul> 
					<li>Dev:${product.devStatus.activeBuild.version.version }</li>
					<li>Test:${product.testStatus.activeBuild.version.version }</li>
					<li>Stage:${product.stageStatus.activeBuild.version.version }</li>
					<li>Production:${product.prodStatus.activeBuild.version.version }</li>
				</ul>
			</div>
			<div class="productScore">
				<ul> 
					<li class="DEV">${product.devStatus.score}</li>
					<li class="TEST">${product.testStatus.score}</li>
					<li class="STAGE">${product.stageStatus.score}</li>
					<li class="PRODUCTION">${product.prodStatus.score}</li>
				</ul>
			</div>
			<input type="hidden" class="productId" value="${product.product.id}"/>
			<input type="hidden" class="DEVbuildId" value="${product.devStatus.activeBuild.id}"/>
			<input type="hidden" class="TESTbuildId" value="${product.testStatus.activeBuild.id}"/>
			<input type="hidden" class="STAGEbuildId" value="${product.stageStatus.activeBuild.id}"/>
			<input type="hidden" class="PRODUCTIONbuildId" value="${product.prodStatus.activeBuild.id}"/>
		</div>
	</c:forEach>
<%@include file="/include/foot.jsp"%>