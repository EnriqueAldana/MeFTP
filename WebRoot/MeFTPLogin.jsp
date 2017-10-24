<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>MeFTP - Log In Service</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="Log In Page">    
    <link rel="stylesheet" type="text/css"
			href="http://extjs.cachefly.net/ext-4.0.2a/resources/css/ext-all.css" />
	<script type="text/javascript" src="<%=basePath%>MEDSextJS4/ext-all.js"></script>
	
	<style type="text/css">	
.x-message-box .ext-mb-download {
    background: url('AdminImages/download.gif') no-repeat scroll 6px 0px transparent;
    height: 48px!important;
}

.x-message-box .ext-mb-delete {
    background: url('AdminImages/confirm.png') no-repeat scroll 10px 6px transparent;
    height: 48px!important;
}

.x-message-box .ext-mb-saveuser{
	background: url('AdminImages/saveconfirm.png') no-repeat scroll 10px 6px transparent;
	height: 48px!important;
}

body {
    padding:20px;
    padding-top:32px;
}
.x-body {
    font-family:helvetica,tahoma,verdana,sans-serif;
    font-size:13px;
}
p {
    margin-bottom:15px;
}
h1 {
    font-size:18px;
    margin-bottom:20px;
}
h2 {
    font-size:14px;
    color:#333;
    font-weight:bold;
    margin:10px 0;
}
.example-info{
    width:150px;
    border:1px solid #c3daf9;
    border-top:1px solid #DCEAFB;
    border-left:1px solid #DCEAFB;
    background:#ecf5fe url( info-bg.gif ) repeat-x;
    font-size:10px;
    padding:8px;
}
pre.code{
    background: #F8F8F8;
    border: 1px solid #e8e8e8;
    padding:10px;
    margin:10px;
    margin-left:0px;
    border-left:5px solid #e8e8e8;
    font-size: 12px !important;
    line-height:14px !important;
}
.msg .x-box-mc {
    font-size:14px;
}
#msg-div {
    position:absolute;
    left:35%;
    top:10px;
    width:300px;
    z-index:20000;
}
#msg-div .msg {
    border-radius: 8px;
    -moz-border-radius: 8px;
    background: #F6F6F6;
    border: 2px solid #ccc;
    margin-top: 2px;
    padding: 10px 15px;
    color: #555;
}
#msg-div .msg h3 {
    margin: 0 0 8px;
    font-weight: bold;
    font-size: 15px;
}
#msg-div .msg p {
    margin: 0;
}
.x-grid3-row-body p {
    margin:5px 5px 10px 5px !important;
}

.feature-list {
    margin-bottom: 15px;
}
.feature-list li {
    list-style: disc;
    margin-left: 17px;
    margin-bottom: 4px;
}

.logIn {
	background-image: url('AdminImages/door_in.png');
	background-repeat: no-repeat;
}
	</style>

	
	<script language="javaScript" src="<%=basePath%>MeFTPLoginJs/MeFTPLogin.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPLoginJs/Ext.ux.MeFTP.Login.js"></script>
	<script type="text/javascript">
	Ext.onReady(function(){
		var detailEl;
		Ext.QuickTips.init();
		var bd = Ext.getBody();
	
		Ext.example = function() {
			var msgCt;

				function createBox(t, s) {

				return '<div class="msg"><h3>' + t + '</h3><p>' + s + '</p></div>';
			}
			return {
				msg : function(title, format) {
					if (!msgCt) {
						msgCt = Ext.core.DomHelper.insertFirst(document.body, {
							id : 'msg-div'
					}, true);
				}
				var s = Ext.String.format.apply(String, Array.prototype.slice.call(arguments, 1));
				var m = Ext.core.DomHelper.append(msgCt, createBox(title, s), true);
				m.hide();
				m.slideIn('t').ghost("t", {
					delay : 6000,
					remove : true
				});
			},
		init : function() {
		}
	};
}();
});
	
	</script>
	
  </head>
  
  <body>
  </body>
</html>
