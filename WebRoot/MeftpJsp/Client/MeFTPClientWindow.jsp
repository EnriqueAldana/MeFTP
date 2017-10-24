<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>MeFTP - Client Window</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<!--  <script language="javaScript" src="<%=basePath%>MeFTPClientWIndow/MeftpUploadExt/ext-3.2.1/ext-all.js"></script>
	<script language="javaScript" src="<%=basePath%>MeFTPClientWIndow/MeftpUploadExt/ext-3.2.1/adapter/ext/ext-base.js"></script>
	-->
	<link rel="stylesheet" type="text/css"
			href="http://extjs.cachefly.net/ext-4.0.2a/resources/css/ext-all.css" />
		<!--<script type="text/javascript" src="http://extjs.cachefly.net/ext-4.0.2a/ext-all-debug.js"></script>  -->
	
	<script type="text/javascript" src="<%=basePath%>MEDSextjJS4.0.7/ext-all-debug.js"></script>
	
	<script language="javaScript" src="<%=basePath%>MeFTPClientWindowjs/MeFTPClientStore/MeFTPClientWindowStores.js"></script>
	
	<!--  
	<script language="javaScript" src="<%=basePath%>MeFTPClientWIndow/MeFTPClientWIndow/MeftpUploadExt/Ext.ux.AwesomeUploader.js"></script>
	<script language="javaScript" src="<%=basePath%>MeFTPClientWIndow/MeFTPClientWIndow/MeftpUploadExt/Ext.ux.AwesomeUploaderLocalization.js"></script>
	<script language="javaScript" src="<%=basePath%>MeFTPClientWIndow/MeFTPClientWIndow/MeftpUploadExt/Ext.ux.form.FileUploadField.js"></script>
	<script language="javaScript" src="<%=basePath%>MeFTPClientWIndow/MeFTPClientWIndow/MeftpUploadExt/Ext.ux.XHRUpload.js"></script>
	<script language="javaScript" src="<%=basePath%>MeFTPClientWIndow/MeFTPClientWIndow/MeftpUploadExt/Ext.ux.swfupload.js"></script>
	<script language="javaScript" src="<%=basePath%>MeFTPClientWIndow/MeFTPClientWIndow/MeftpUploadExt/swfupload.swfobject.js"></script>-->
	
	<script language="javaScript" src="<%=basePath%>MeFTPClientWindowjs/TransferTab/Ext.ux.MeFTP.TransferTab.AddRecipients.js"></script>
	<script language="javaScript" src="<%=basePath%>MeFTPClientWindowjs/TransferTab/Ext.ux.MeFTP.TransferTab.OptionalSettings.js"></script>
	<script language="javaScript" src="<%=basePath%>MeFTPClientWindowjs/TransferTab/TransferContentTab.js"></script>
	
	<script language="javaScript" src="<%=basePath%>MeFTPClientWindowjs/SendTab/SendFileList.js"></script>
	<script language="javaScript" src="<%=basePath%>MeFTPClientWindowjs/SendTab/Ext.ux.MeFTP.SendTab.Search.js"></script>
	<script language="javaScript" src="<%=basePath%>MeFTPClientWindowjs/SendTab/SentContentTab.js"></script>
	
	
	<script language="javaScript" src="<%=basePath%>MeFTPClientWindowjs/ReceivedTab/MeFtpSearchReceived.js"></script>
	<script language="javaScript" src="<%=basePath%>MeFTPClientWindowjs/ReceivedTab/ReceivedFileList.js"></script>
	<script language="javaScript" src="<%=basePath%>MeFTPClientWindowjs/ReceivedTab/ReceivedContentTab.js"></script>
	
	<style type="text/css">
	.x-form-file-wrap {
    position: relative;
    height: 22px;
}
.x-form-file-wrap .x-form-file {
	position: absolute;
	right: 0;
	-moz-opacity: 0;
	filter:alpha(opacity: 0);
	opacity: 0;
	z-index: 2;
    height: 22px;
}
.x-form-file-wrap .x-form-file-btn {
	position: absolute;
	right: 0;
	z-index: 1;
}
.x-form-file-wrap .x-form-file-text {
    position: absolute;
    left: 0;
    z-index: 3;
    color: #777;
}
	</style>
	<script type="text/javascript">
	
	Ext.onReady(function(){
		Ext.QuickTips.init();
		var bd = Ext.getBody();
		
		var tabPanel_Client = Ext.create('Ext.tab.Panel',{
			//height: 475,
    //width: 797,
    anchor	:	'100% 95%',
    //margins	:	'10 10 10 10',
    activeTab: 1,
    minTabWidth: 100,
			items:[
			clientPanel_transferTab,
			clientPanel_ReceivedTab,
			clientPanel_SendTab
			]
		});
		
		var fieldSet_Client = Ext.create('Ext.form.FieldSet',{
			id	: 'fieldSet_send_id',
			margins	:	'10 10 10 10',
			bodyPadding	:	10,
			title		:	'Some Name',
			anchor		:	'100% 100%',
			layout		:	'anchor',
			items	:	[
			tabPanel_Client
			]
		});
		
		var window  =  Ext.create('Ext.window.Window',{
			//anchor		:	'100% 100%',
			title		:	'MeFTP Transfer Files',
			margins		:	'20 20 20 20',
			height: 600,
    		width: 1100,
    		bodyPadding	:	'10 10 10 10',
    		layout	:	'anchor',
    		resizable	:	false,
    		plain		:	true,
    		closable	: 	false,
			constrain	: 	true,
			border		: 	false,
			modal		:	true,
			maximizable	:	true,
    		items		:	[
    			fieldSet_Client
    		]
		}).show();
	});
	</script>
  </head>
  
  <body>
  </body>
</html>
