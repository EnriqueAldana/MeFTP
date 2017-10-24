var groupTab_fields 	= new Ext.ux.MeFTP.GroupsTab.GroupsFields();
var groupTab_list 		= new Ext.ux.MeFTP.GroupsTab.GroupsList();

var groupTabUSer		= Ext.create('Ext.form.Panel',{
	id			:	'tab_Groups_panel',
	autoScroll	:	true,
	layout		:	'absolute',
	width		:	1054,
	height		:	547,
	border		:	'0 0 0 0',
	items		:	[
	     		 	 groupTab_search ,
	     		 	 groupTab_fields,
	     		 	 groupTab_list,
	     		 	 groupTab_buttons 		 	
	     		 	 ]
});            