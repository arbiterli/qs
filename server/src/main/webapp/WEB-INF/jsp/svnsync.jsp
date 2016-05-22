<%@include file="/common_jsp/head.jsp"%>
<input type="hidden" id="productId" value="${productId}"></input>
<input type="hidden" id="deployRevision" value="${deployRevision}"></input>
<input type="hidden" id="updateRevision" value="${deployRevision}"></input>
<input type="hidden" id="targetUrl" value="${targetUrl}"></input>
<script type="text/javascript" src="/js/jquery.dataTables.js"></script>
<link href="/css/jquery.dataTables.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/svnsync.js"></script>
<link href="/css/svnsync.css" type="text/css" rel="stylesheet">
<input id="refresh_btn" type="button" value="Refresh"/>
<span id="last_update_tag">Last update time: </span><span id="last_update"></span>
<div id="log"></div>
<div class="name_diff">Diff with preview</div>
<div id="diff_panel">
<table style="margin-top:0px;" cellpadding="0" cellspacing="0">
<tr>
  <td id="diff_container">
  <div id="diff_title">
    <div id="title_col">Action &nbsp; &nbsp; &nbsp; &nbsp; Path </div>
  </div>
  <div id="diff"></div>
  </td>
  <td id="update_container">
  <div id="note_div"><span>Update will take about one minute</span></div>
  <div id="update_btn"><div id="show_status">Update</div></div>
  </td>
</tr>
</table>
</div>
<div class="name_svn_diff">Svn diff</div>
<div id="svn_diff_panel">
<table style="margin-top:0px;" cellpadding="0" cellspacing="0">
<tr>
  <td id="svn_diff_container">
  <div id="svn_diff_title">
    <div id="title_col">Action &nbsp; &nbsp; &nbsp; &nbsp; Path </div>
  </div>
  <div id="svn_diff"></div>
  </td>
</tr>
</table>
</div>
<%@include file="/common_jsp/foot.jsp"%>
