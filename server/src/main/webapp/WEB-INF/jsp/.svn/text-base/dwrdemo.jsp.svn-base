
	<head>
		<title>DWR Demo</title>
		<script type="text/javascript" src="/dwr/engine.js"></script>
		<script type="text/javascript" src="/dwr/util.js"></script>
		<script type="text/javascript" src="/dwr/interface/dwrService.js"></script>
		<script>
		
			function errorHandler(msg, exc) {
			  alert("Some error occured");
			}
			dwr.engine.setErrorHandler(errorHandler);
			
			function getDataFromServer() {
			  dwrService.getStuff({
			  	callback: getDataFromServerCallBack
			  });
			}
			
			function getDataFromServerCallBack(dataFromServer) {
				alert(dataFromServer);			  
			}
			
			function crashOnServer() {
				dwrService.crash({
					callback: crashed
				});
			}
			
			function crashed(dataFromServer) {
				alert(dataFromServer);
			}
			
			function updateStringToServer(value) {
				dwrService.updateString(value, function(dataFromServer){
					alert("update result: " + dataFromServer);
				});
			}
			
			function updateListToServer(value) {
				dwrService.updateList(value, function(dataFromServer){
					alert("update list result: " + dataFromServer);
				});
			}
		</script>
	</head>
	<body>
		<h3>DWR/Spring and Spring MVC</h3>
		<a href="#" onclick="getDataFromServer(); return false;">Retrieve test data</a><br/>
		<a href="#" onclick="crashOnServer(); return false;">I will crash</a><br/>
		<a href="#" onclick="updateStringToServer('ImGlority'); return false;">update string to server</a><br/>
		<a href="#" onclick="updateListToServer(['a', 'b', 'cc']); return false;">update list to server</a><br/>
	</body>
