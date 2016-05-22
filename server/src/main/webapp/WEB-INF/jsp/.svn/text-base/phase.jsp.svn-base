<%@include file="/include/head.jsp"%>
		<link rel="stylesheet" type="text/css" href="/css/phase.css"/>
		<script type="text/javascript" src="/js/phase.js"></script>
		<script type="text/javascript" src="/dwr/interface/scoreEmailSettingService.js"></script>
		<script type="text/javascript" src="/dwr/interface/basicDataService.js"></script>
		<script type="text/javascript" src="/dwr/interface/deployService.js"></script>
		<script type="text/javascript" src="/dwr/interface/buildService.js"></script>		
		<input type="hidden" id="email-setting-img"/>
		<input type="hidden" id="score-name"/>
		<input type="hidden" id="role" value="${permissionSetting.SCORE_EMAIL_SETTING}"/>
		<input type="hidden" id="stage" value="${stage }"/>
		<div id="product-name">${productName }</div>
		<div id="warning"></div>
		<c:choose>
		<c:when test="${hasServer}">
		    <div id="servers">
			<ul>
				<li class="server-head">
					<div class="server-head-servers">Servers</div>
					<div class="server-head-info">Version:${phaseStatus.activeBuild.version.version },
						deploy by ${servers[0].deploy.user }</div>
					<div class="server-head-img"></div>
				</li>
				<c:forEach var="item" items="${servers}">
					<li class="server">
						<div class="server-name">${item.server.name }</div>
						<div class="server-url">
							<a style="color:#646464;" href="${item.server.siteUrl}" target="_blank">${item.server.siteUrl}</a>
						</div>
						<div class="server-deployat">Deploy at:
							${item.deploy.deployTime}</div>
					</li>
				</c:forEach>
			</ul>
		    </div>
		</c:when>
		<c:otherwise>
		    <div style="height:20px;"></div>
		</c:otherwise>
		</c:choose>
		<c:if test='${permissionSetting.baseDeploy}'>
		<div id="deploy">
                    <table>
		        <tr>
			        <td style="width: 164px;">
			            <select id="selectDropDown" onchange="buildChangeInProdPhase()">
				        <c:forEach var="iterator" items="${phaseStatus.buildList}">
					        <c:if test="${buildId == iterator.id}">
						    <option value='${iterator.id}' selected>${iterator.jenkinsBuildId}</option>
					        </c:if>
					        <c:if test="${buildId != iterator.id}">
						    <option value='${iterator.id}'>${iterator.jenkinsBuildId}</option>
					        </c:if>
				        </c:forEach>
			            </select>
			        </td>
				<c:if test="${nextStageServerId != -1 }">
				<td style="width: 450px;">
			            <input type="button" value="Deploy" id="deployandcertify" class="deploybutton"
				            onclick="deployButtonClick('${stageString}','${nextStageServerId}')">
				</td>
				</c:if>
		        </tr>
	            </table>		
		</div>
		</c:if>		
		<div id="scores">
			<c:if test="${stage == 'PROD' }">
				<div class="finalscore" id="0">${finalscore }</div>
				<div class="finalscore-text">Final score</div>
				<div class="final-score-line"></div>
				<c:forEach begin="1" var="score" items="${scores}" varStatus="status">
					<c:if test="${status.index  == 1}">
						<div class="equal">=</div>
						<div class="code-quality" id="${score[10]}">${score[6] }</div>
						<div class="code-quality-text">${score[0] }</div>
					</c:if>
					<c:if test="${status.index == 2 }">
						<div class="add">+</div>
						<div class="running-quality" id="${score[10]}">${score[6] }</div>
						<div class="running-quality-text">${score[0] }</div>
					</c:if>
					<c:if test="${status.index == 3 }">
						<div class="add">+</div>
						<div class="issue-fix-ability" id="${score[10]}">${score[6] }</div>
						<div class="issue-fix-ability-text">${score[0] }</div>
					</c:if>
				</c:forEach>
			</c:if>
			<c:if test="${stage != 'PROD' }">
				<div class="finalscore">${finalscore }</div>
				<div class="finalscore-text">Code Quality</div>
				<div class="final-score-line"></div>
			</c:if>
		</div>
		<div class="all-metric" style="box-shadow: 0 0 0 #646464;">
			<div class="all-metric-img"></div>
			<ul class="all-metric-head">
					<li class="metric-head">
						<div class="otherlow"></div>
						<div class="name-head">Metrics</div>
						<div class="data-head">Data</div>
						<div class="exp-head">Expectation</div>
						<div class="power-head">Power</div>
						<div class="score-head">Score</div>
						<div class="submetric-img"></div>
					</li>
			</ul>
		</div>
		<div class="all-metric" id="all-metric">
			<c:forEach begin="1" var="score" items="${scores}" varStatus="status">
				<ul class="ul-metric" id="${score[10]}">
					<li class="metric">
						<div class="low">Low</div>
						<div class="name" style="margin-left:-7px;">${score[0]}</div>
						<div class="data">
							<div class='data-arrow'>&nbsp;</div>
							<div class="data-data">
								<c:choose>
									<c:when test="${score[7] == null}">
										 ${score[1]}		
									</c:when>
									<c:otherwise>
										<a href="${score[7]}" target="_blank"> ${score[1]}</a>
									</c:otherwise>
								</c:choose>
							</div>
							<div class="data-tip">${score[2]}</div>
						</div>
						<div class="exception" style="padding-left:30px; width:76px; text-align: left;">${score[3]}</div>
						<div class="power">${score[4]}</div>
						<div class="score">${score[5]}</div>
						<c:choose>
							<c:when test="${score[9] }">
								<div class="metric-img" id="metric-img${status.index }"></div>
							</c:when>
							<c:otherwise>
								<div id="metric-img${status.index }" style="background-image:url(/images/manager.png)" class="metric-img"></div>
							</c:otherwise>
						</c:choose>
					</li>
				</ul>
				<ul class="ul-submetric"></ul>
			</c:forEach>
		</div>
		<div class="email-setting">
			<div class="email-setting-img"></div>
			<div class="email-tip">When the score is RED</div>
			<div class="email-tip">daily email to :<br /> <br /></div>
			<div id="error-message" style="display:none; color:red;">123456</div>
			<ul>
				<li><input type="text" id="email-addr-input" /></li>
				<li>
					<div class="cancle">Cancle</div>
					<div class="ok">OK</div>
				</li>
			</ul>
			<input type="hidden" id="score-name" />
		</div>
<%@include file="/include/foot.jsp"%>