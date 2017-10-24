var panelExplorerTab = Ext.create('Ext.form.Panel',{
	id			:	'tab_Explorer_panel',
	layout		:	'absolute',
	width		:	1054,
	height		:	547,
	margins		:	'10 10 10 10',
	items	:	[
	     	 	 explorerGrid_Grid,
	     	 	 {
	     	 		xtype : 'explorertab'
	     	 	 }
	     	 	 ]
});    