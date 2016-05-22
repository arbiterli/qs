<%@include file="/common_jsp/head.jsp"%>
<script type="text/javascript" src="/js/jquery_blockUI.js"></script>
<script type="text/javascript" src="/js/syncproandprev.js"></script>
<link href="/css/syncproandprev.css" type="text/css" rel="stylesheet">
<input type="hidden" id="productId" value="${productId}"></input>
<input type="hidden" id="targetUrl" value="${targetUrl}"></input>
<div id="operation_title">${title}</div>
<div id="warning"></div>
<div id="product_info">
<c:choose>
  <c:when test="${infoMap.info == 'success'}">
     Current version: ${infoMap.currentVersion}
                     <span id="current_version"/></br>
                Deploy Time: ${infoMap.deployTime}<span id="deploy_time"/></br>
                User: ${infoMap.user} <span id="user"/></br>
  </c:when>
  <c:otherwise>
     <p id="no_data_p">${infoMap.info}</p>
  </c:otherwise>
</c:choose>
</div>
<div id="commit_div">
     New Version: ${nextVersion} <span id="new_version"/>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input id="operation_button" type="button" value="Commit"/>
    <input id="goback_button" type="button" value="Cancel"/>
</div>
<div id="change_list_title">
     Following changes will be made:
    <div id="change_list">
      ${diff}
    </div>
    <div id="blank_div"></div>
</div>
<%@include file="/common_jsp/foot.jsp"%>