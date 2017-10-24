// Information Panel
var genParams = new Ext.ux.MeFTP.InfoTab.GeneralParams();
var genInfo = new Ext.ux.MeFTP.InfoTab.GeneralInfo();
var tabInformation = Ext.create('Ext.panel.Panel',{
	id			:	'tab_Information_panel',
	autoScroll	: 	true,
	items		:	[
	        genInfo,genParams
	 ]
});
//
/*
var tabExplorer		= Ext.create('Ext.panel.Panel',{
	id			:	'tab_Explorer_panel',
	//layout		:	'absolute',
	autoScroll	:	true,
	items		:	[{
		xtype		:	'explorertab'
	},
	{
	xtype		:'explorergrid'
	}	     		 	 ]
});
*/

//Users Tab
/**
 * 
 **/
var userTab_search = new Ext.ux.MeFTP.UsersTab.Search();
var userTab_fields = new Ext.ux.MeFTP.UsersTab.UsersFields();
var userTab_list = new Ext.ux.MeFTP.UsersTab.UsersList();
var userTab_buttons	= new Ext.ux.MeFTP.UsersTab.UserButtons(); 

var tabUsers		= Ext.create('Ext.form.Panel',{
	id:'tab_Users_panel',
	autoScroll:true,
	layout:'absolute',
	width:1054,
	height:547,
	border:'0 0 0 0',
	items:[userTab_search,userTab_fields,userTab_list,userTab_buttons]
});