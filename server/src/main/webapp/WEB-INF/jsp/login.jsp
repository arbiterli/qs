<%@include file="/common_jsp/head.jsp"%>
<script type="text/javascript">document.getElementById('email').style.visibility = 'hidden';</script>
<script type="text/javascript">document.getElementById('bookmark').style.visibility = 'hidden';</script>
	    <div id="login_empty"></div>
	    <form action="/j_security_check" method="post">
		    <table id="login_table" style="color:white;text-shadow:black 0 1px 1px">
		    	<tr>
		    		<td style="text-align:right;width:auto">Email:</td>
		    		<td><input type="text" name="j_username" id="j_username"
					class="inputEmail" /></td>
		    	</tr>
		    	<tr>
		    		<td style="width:auto">PassWord:</td>
		    		<td><input type="password" name="j_password"
					id="j_password" class="inputPasswd" /></td>
		    	</tr>
		    	<tr style="height:20px">
		    		<td style="width:auto"></td>
		    		<td style="color:red">${pageMessage}</td>
		    	</tr>
		    	<tr >
		    		<td style="width:auto"></td>
		    		<td>
		    			<input type="submit" value="Login" class="login" />
		    		</td>
		    	</tr>
		    </table>
	    </form>
<%@include file="/common_jsp/foot.jsp"%>