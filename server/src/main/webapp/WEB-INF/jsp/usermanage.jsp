<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!Doctype html>
<html xmlns=http://www.w3.org/1999/xhtml>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<link href="/css/common.css" type="text/css" rel="stylesheet">
<link href="/css/productphase.css" type="text/css" rel="stylesheet">
<script>
	function loadProducts() {
		createAjax("/loadproducts", null, loadProductsCallback);
	}

	function loadProductsCallback(response) {
		var productTable = document.getElementById("productTable");
		productTable.innerHTML = "";

		var titleArray = new Array("-1", "Mark", "Product Name");
		insertItemToProductTable(titleArray, productTable, 0)
		var length = response.length;

		for ( var i = 0; i < length; i++) {
			insertItemToProductTable(response[i], response[i], i + 1);
		}
		
		if(length>0){
		refreshRole(response[0][0]);
		}
	}

	function insertItemToProductTable(item, productTable, rowNumber) {
		var row = productTable.insertRow(rowNumber);
		row.id = item[0];
		row.onclick = "refreshRole(" + item[0] + ")";

		var markCell = row.insertCell(0);
		markCell.innerText = item[1];

		var nameCell = row.insertCell(1);
		nameCell.innerText = item[2];
	}

	function refreshRole(productId,productName) {
		if (productId < 0) {
			return;
		}

		var currentProduct = document.getElementById("currentProduct");
		currentProduct.innerText = productName;
		
		var currentProductId = document.getElementById("currentProductId");
		currentProductId.value = productId;
		
		var userId = document.getElementById("userId").value;

		var data = "productId=" + productId + "&userId=" + userId;
		createAjax("/userproductrole", data, refreshRoleCallback);
	}

	function refreshRoleCallback(response) {
		var noneRole = document.getElementById("noneRole");
		noneRole.checked = true;

		if (response != null) {
			var roleRadios = document.getElementsByName("role");
			for(var i=0;i<roleRadios.length;i++){
				if(response == roleRadios[i].value){
					roleRadios[i].checked = true;
					return ;
				}
			}
		}	
	}
	
	function updateUserRole(){
		var currentProductId = document.getElementById("currentProductId").value;
		var userId =  document.getElementById("userId").value
		if(currentProductId !=null && userId != null){
			var role = getSelectRole();
			data = "userId="+userId+"&productId="+currentProductId+"&role="+role;
			createAjax("/updateuserproductrole", data, updateUserRoleCallback);
		}
	}
	
	function updateUserRoleCallback(response){
		alert(response);
		if(response == "success"){
			var currentProduct = document.getElementById("currentProduct").innerText;
			var targetProductTr = findProductTr(currentProduct)
		
			var role = getSelectRole();		
			if(role == "none"){
			//delete
				targetProductTr.childNodes[1].innerText= "no";
			}
			else{
				targetProductTr.childNodes[1].innerText= "yes";
			}
		
		}
	}
	
	function findProductTr(productName){
		var tds = document.getElementsByTagName("td");
		for(var i=0;i<tds.length;i++){
			if(tds[i].innerText == productName){
				return tds[i].parentNode;
			}
		}
	}
	
	function getSelectRole(){
		var roleRadios = document.getElementsByName("role");
		for(var i=0;i<roleRadios.length;i++){
			if(roleRadios[i].checked){
				return roleRadios[i].value;			
			}
		}
		return null;
	}
</script>
</head>
<body>
	<div id="main_container" class="main_container" style="top: 200px">

		<input type="hidden" id="userId" value="${userId}" />
		<div>
			<table id="roleTable">
				<tr>
					<td>check</td>
					<td>role</td>
				</tr>
				<tr>
					<td><input type="radio" name="role" value="none" id="noneRole" /></td>
					<td>No Role</td>
				</tr>

				<c:forEach var="item" items="${roles}">
					<tr>
						<td><input type="radio" name="role" value="${item}" /></td>
						<td>${item}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<div>
				current chose product :<span id="currentProduct"></span> <input
					type="hidden" id="currentProductId" /> <input type="button"
					onclick="updateUserRole()" value="Update" class="deploybutton" />
			</div>

			<table id="productTable">
				<tr>
					<td>mark</td>
					<td>productName</td>
				</tr>
				<c:forEach var="product" items="${products}">
					<tr
						onclick="refreshRole(${product.productId},'${product.productName }')">
						<c:if test="${product.userOwn == true}">
							<td>yes</td>
						</c:if>
						<c:if test="${product.userOwn == false }">
							<td>no</td>
						</c:if>
						<td>${product.productName }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="copyright" class="copyright" style="bottom: 28px">Copyright
			&copy 2012</div>
	</div>

</body>
</html>