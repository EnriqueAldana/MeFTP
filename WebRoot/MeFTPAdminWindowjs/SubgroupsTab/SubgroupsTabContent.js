var subgroupTab_fields 	= new Ext.ux.MeFTP.SubgroupsTab.SubgroupsFields();
var subgroupTab_list 		= new Ext.ux.MeFTP.SubgroupsTab.SubgroupsList();
var subgroupTab_buttons 	= new Ext.ux.MeFTP.SubgroupsTab.SubgroupsButtons(); 

var subgroupTabUSer		= Ext.create('Ext.form.Panel',{
	id			:	'tab_Subgroups_panel',
	autoScroll	:	true,
	layout		:	'absolute',
	width		:	1054,
	height		:	547,
	border		:	'0 0 0 0',
	items		:	[
	     		 	 subgroupTab_search ,
	     		 	subgroupTab_fields,
	     		 	 subgroupTab_list,
	     		 	 subgroupTab_buttons 		 	
	     		 	 ]
});           