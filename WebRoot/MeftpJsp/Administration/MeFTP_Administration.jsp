<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>MeFTP Administration module</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="MeFTPCSS/adminwindow.css">
	
	<style type="text/css">	
	
	.addGroup{
		background: url('AdminImages/newgroup.png');
		no-repeat !important;
	}
	
	.deleteGroup{
		background:	url('AdminImages/deletegroup.png');
		no-repeat !important;
	}
	
	.search {
	background-image: url('AdminImages/search_24x16.png');
	background-repeat: no-repeat;
}

.delete {
	background-image: url('AdminImages/delete.png');
	background-repeat: no-repeat;
}

.cancel {
	background-image: url('AdminImages/cancel.png');
	background-repeat: no-repeat;
}

.save {
	background-image: url('AdminImages/save.png');
	background-repeat: no-repeat;
}

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
	</style>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  	<!-- <link rel="stylesheet" type="text/css" href="<%=basePath%>MEDSextJS4/css/ext-all.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>MEDSextJS4/css/extjs.css" /> -->
	
	<script type="text/javascript" src="<%=basePath%>MEDSextJS4/ext-all-debug.js"></script>
  
  	
    <link rel="stylesheet" type="text/css" href="http://extjs.cachefly.net/ext-4.0.2a/resources/css/ext-all.css" />
		<!--<script type="text/javascript" src="http://extjs.cachefly.net/ext-4.0.2a/ext-all-debug.js"></script> --> 
	 
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/AdminWindowStores/MeftpAdminStores.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/Ext.ux.MeFTP.MenuAdminWindow.Tree.js" ></script>
	
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/UsersTab/Ext.ux.MeFTP.UsersTab.Search.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/UsersTab/Ext.ux.MeFTP.UsersTab.UsersList.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/UsersTab/Ext.ux.MeFTP.UsersTab.UsersContactsList.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/UsersTab/Ext.ux.MeFTP.UsersTab.UsersFields.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/UsersTab/Ext.ux.MeFTP.UsersTab.UserButtons.js" ></script>
	
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/ContactWindow/Ext.ux.MeFTP.UserList.WindowContacts.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/ContactWindow/Ext.ux.MeFTP.ContactsButtons.WindowContacts.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/ContactWindow/Ext.ux.MeFTP.ContactsListUser.WindowContacts.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/ContactWindow/MeFTPContactSearch.js" ></script>
	
	
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/InformationTab/Ext.ux.MeFTP.InfoTab.GeneralInfo.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/InformationTab/Ext.ux.MeFTP.InfoTab.GeneralParams.js" ></script>
	
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/ExplorerTab/Ext.ux.MeFTP.ExplorerTab.Tree.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/ExplorerTab/Ext.ux.MeFTP.ExplorerTab.Grid.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/ExplorerTab/ExplorerTabContent.js" ></script>
	
	
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/Ext.ux.MeFTP.AdminWindow.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/SubgroupsTab/Ext.ux.MeFTP.SubgroupsTab.Search.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/SubgroupsTab/Ext.ux.MeFTP.SubgroupsTab.SubgroupsList.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/SubgroupsTab/Ext.ux.MeFTP.SubgroupsTab.SubgroupsFields.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/SubgroupsTab/Ext.ux.MeFTP.SubgroupsTab.SubgroupsButtons.js" ></script>
	
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/ServerActivityTab/ServerActivityContent.js" ></script>
	
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/MultiselectLayout/Ext.lyout.component.field.Field.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/MultiselectLayout/MultiSelect.js" ></script>
	
	<script language="javascript" src="<%=basePath%>MeFTPAdminWindowjs/ConfirgurationTab/Ext.ux.MeFTP.ConfigurationTab.ConfigurationParameters.js"></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/ConfirgurationTab/Ext.ux.MeFTP.ConfigurationTab.GeneralConfig.js"></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/ConfirgurationTab/ConfigurationTabContent.js" ></script>
	
	<!-- <script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/GroupsTab/MultiSelect.js" ></script> -->
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/GroupsTab/Ext.ux.MeFTP.GroupsTab.GroupsFields.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/GroupsTab/Ext.ux.MeFTP.GroupsTab.GroupsList.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/GroupsTab/GroupsButtons.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/GroupsTab/GroupsSearch.js" ></script>
	
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/ContactWindow/MeFTPContactWindowContent.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/Ext.ux.MeFTP.Content.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/GroupsTab/GroupsTabContent.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/SubgroupsTab/SubgroupsTabContent.js" ></script>
	<script language="javaScript" src="<%=basePath%>MeFTPAdminWindowjs/ContentPanel/contentPanelsAdminWindow.js" ></script>
	
	<style type="text/css">
		
	</style>
	
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
			var s = Ext.String.format.apply(String, Array.prototype.slice.call(
					arguments, 1));
			var m = Ext.core.DomHelper.append(msgCt, createBox(title, s), true);
			m.hide();
			m.slideIn('t').ghost("t", {
				delay : 2000,
				remove : true
			});
		},

		init : function() {
		}
	};
}();
		
		
		treePanel.getSelectionModel().on('select', function(selModel, record) {
			this.addTab(selModel,record);
		},this);
		addTab	=	function(selModel,record){ 
			if(record.get('leaf')){
				var tab = this.Ext.getCmp("id-"+record.id);
				if(!tab){ 
					tab = new Ext.Panel({  
						id			: 	"id-"+record.id,
						closable	: 	true, 
						title		: 	record.get('text'),
						items		: 	Ext.getCmp('tab_'+record.get('text')+'_panel'),
						autoScroll	:	true
					});
					this.panelContenido.add(tab);
					this.panelContenido.doLayout();
				}
				this.panelContenido.setActiveTab(Ext.getCmp(tab.id));
				 if (!detailEl) {
                var bd = Ext.getCmp('details_panel_id').body;
                bd.update('').setStyle('background','#fff');
                detailEl = bd.createChild(); //create default empty div
            }
            detailEl.hide().update(Ext.getDom(record.get('text')+ '-details').innerHTML).slideIn('l', {stopAnimation:true,duration: 200});
			}	
		};
				
		viewport = new Ext.ux.MeFTP.AdminWindow();
	});
	</script>
    
 <body>
 <div style="display:none;">
  <div id="Users-details">
            <p>This is an example of change detail 1</p>
             <h2>Users Tab</h2>
           <p><b>Look the example</b></p>           
        </div>
 <div id="Groups-details">
            <p>This is an example of change detail 2</p>
             <h2>Groups Tab</h2>
           <p><b>Look the example</b></p>           
        </div>
        <div id="Information-details">
            <p>This is an example of change detail 3</p>
             <h2>Information Tab</h2>
           <p><b>Look the example</b></p>           
        </div>
        <div id="Explorer-details">
            <p>This is an example of change detail 4</p>
             <h2>Explorer Tab</h2>
           <p><b>Look the example</b></p>           
        </div>
        <div id="Server Messages-details">
            <p>This is an example of change detail 5</p>
             <h2>Server Messages Tab</h2>
           <p><b>Look the example</b></p>           
        </div>
        <div id="Server Activity-details">
            <p>This is an example of change detail 6</p>
             <h2>Server Activity Tab</h2>
           <p><b>Look the example</b></p>           
        </div>
        <div id="Subgroups-details">
            <p>This is an example of change detail 7</p>
             <h2>Subgroups Tab</h2>
           <p><b>Look the example</b></p>           
        </div>
        <div id="Configurations-details">
            <p>This is an example of change detail 8</p>
             <h2>Configurations Tab</h2>
           <p><b>Look the example</b></p>           
        </div>
 </div>
      <!--   MeFTP Administration module <br>
       
    <br><br>
 
    <A href="<%=basePath%>meftpServerAdmin/MeftpServer_start.action">Start server</A>
    <br><br>
    <A href="<%=basePath%>meftpServerAdmin/MeftpServer_stop.action">Stop server</A>
    <br><br>
    <br><br>
    <br><br>
    <A href="<%=basePath%>index.jsp">MeFTP home</A>
    <br>
     -->
  </body>
</html>
