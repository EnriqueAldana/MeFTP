<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"MeFTPServer";
String emailTecWeb = Constantes.EMAIL_ADMINISTRADOR_TECWEB
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>MeFTP Server error page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    Could you call to Metalsa TecWeb support<br>
    Or send email to <%=emailTecWeb%>
    <br>
    <br>
    
    <html:link action="<%=basePath>">MeFTP home page</html:link>
    <A href="<%=basePath%>MeFTPLogin.jsp">Administration</A>
  
  </body>
</html>
