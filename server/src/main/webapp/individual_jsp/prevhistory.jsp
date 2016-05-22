<div id="table_container" style="margin-top:-17px;">
			<h4 style="padding-top: 40px">Preview History</h4>
			<table id="updateTable" style="color: white;width:615px">
				<tr>
					<td colspan="4">
						<table class="innerTable">
							<tr style="font-weight:bold;font-size:14px;">
								<td style="width:125px">Version</td>
								<td style="width:177px">Deploy Time</td>
								<td style="width:194px">Deployed By</td>
								<td style="width:118px"></td>
							</tr>
						</table>
					</td>
				</tr>
				<c:forEach var="iterator" items="${previewDeploys}">
					<tr>
						<td colspan="4">
								<table class="innerTable" id='${iterator.version}pre'>
									<tr style="font-size:14px">								 
										<td style="width:125px">${iterator.version }</td>
										<td style="width:177px">${iterator.createTime }</td>
										<td style="width:194px">${iterator.user }</td>
										<c:choose>
											<c:when test="${iterator.active == false }">
												<td style="width:118px"></td>
											</c:when>
											<c:when test="${iterator.active == true }">
												<td style="width:118px">Running</td>
												<script>
														document.getElementById('${iterator.version }pre').style.backgroundImage = 'url(/image/running.png)';
												</script>
											</c:when>
										</c:choose>						
									</tr>
								</table>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>