<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!Doctype html>
<html xmlns=http://www.w3.org/1999/xhtml>
<head>
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<link href="/css/common.css" type="text/css" rel="stylesheet">
<link href="/css/productphase.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	function createUser() {
		var name = document.getElementById("name").value;
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
		var confirmPassword = document.getElementById("confirmPassword").value;

		if (name == null || name == "") {
			alert("name is empty");
			return;
		}

		if (password != confirmPassword) {
			alert("password is not the same");
			return;
		}

		data = "name=" + name + "&email=" + email + "&password=" + password;
		createAjax("/usercreate", data, createusercallback);
	}

	function createusercallback(response) {
		if (response.result == "success") {
			var userId = response.userId;
			if (confirm("go to user manager page?")) {
				window.location.href = "/usermanagepage?userId=" + userId;
			}
		} else if (response.result == "fail") {
			alert("failed to create user");
		}
	}
</script>
</head>
<body>
	<div id="main_container" class="main_container"
		style="top: 200px; left: 0px">

		<table>
			<tr>
				<td>Name :</td>
				<td><input type="text" id="name"></td>
				<td>Email :</td>
				<td><input type="text" id="email"></td>
			</tr>
			<tr>
				<td>Pasword :</td>
				<td><input type="password" id="password"></td>
				<td>Confirm Password :</td>
				<td><input type="password" id="confirmPassword"></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td><input style="top: 500px" type="button"
					onclick="createUser()" value="Create" class="deploybutton"></td>
			</tr>
		</table>
		<div id="copyright" class="copyright" style="bottom: 28px">Copyright
			&copy 2012</div>
	</div>

</body>
</html>