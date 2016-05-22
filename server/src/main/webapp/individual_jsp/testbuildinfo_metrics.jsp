<div id="table_container">
				<br/><br/><span style="font-weight:bold">All metrics</span>
		    	<table cellpadding="5" style="width:70%; color:white;font-size:14px;">
		    	    <tr>
		    			<td>type</td><td>name</td>
		    			<td>oldvalue</td><td>newvalue</td>
                    </tr>
		    	    <c:forEach var="iterator" items="${metrics}">
		    			<tr>
		    				<td>${iterator.type}</td><td>${iterator.name}</td>
		    				<td>${iterator.oldValue}</td><td>${iterator.newValue}</td>
                        </tr>
		    		</c:forEach>
		    		<tr><td><br/></td></tr>
		    	</table>
</div>