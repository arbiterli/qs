<div id="table_container" style="margin-top:-17px;">
			<span style="font-size:24px;font-weight:bold;color:white">Hot Deploy<br/><br/></span>
			<table style="text-shadow:black 0 1px 1px;margin-top:-5px;">
				<tr>
					<td rowspan="2">
						<div id="updatebutton" onclick="window.open('/svnpanel?productId=${productId}','_blank')" >
							<span style="line-height:70px;text-align:center">Update</span>
							<div id= "update_arrow"></div>
						</div>
					</td>
					<td rowspan="2">
						<button type="button" id="previewbutton" style="border:0px" onclick="window.open('${previewServer.siteUrl}','_blank')">
							<span>${previewServer.activeVersion}</span><br />
							<span  style="font-size:11px">PREVIEW</span>
						</button>
					</td>
					<td style="width:240px;">
						<div id="STPbutton" onclick="window.open('/synctopro?productId=${productId}','_blank')">
							<span style="line-height:70px;text-align:center">Sync To Production</span>
							<div id="arrow_right"></div>
						</div>
					</td>
					<td rowspan="2">
						<button type="button" id="productionbutton" style="border:0px" onclick="window.open('${productServer.siteUrl}','_blank')">
							 <span>${productServer.activeVersion}</span><br />
							 <span  style="font-size:11px">PRODUCTION</span>
						</button>
					</td>
				</tr>
			</table>
			<c:if test="${previewServer == null }">
			    <script type="text/javascript">
			    	document.getElementById('previewbutton').disabled = "disabled";
			    	document.getElementById('updatebutton').disabled = "disabled";
			    	document.getElementById('SFPbutton').disabled = "disabled";
			    	document.getElementById('SFPbutton').backgroundImage = "url(../image/btn-darkblue-s-disable.jpg)";
			    </script>
		   </c:if>
		   <c:if test="${productServer == null }">
		        <script type="text/javascript">
		        	document.getElementById('productionbutton').disabled = "disabled";
			    	document.getElementById('STPbutton').disabled = "disabled";
			    	document.getElementById('STPbutton').backgroundImage = "url(../image/btn-darkblue-s-disable.jpg)";
		        </script>
			</c:if>
</div>
