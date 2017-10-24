var generalConfigs_fieldSet 	= new Ext.ux.MeFTP.ConfigurationTab.GeneralConfig();
var configParameters_fieldSet	= new Ext.ux.MeFTP.ConfigurationTab.ConfigurationParameters();

var configPanel		= Ext.create('Ext.form.Panel',{
	id			:	'tab_Configurations_panel',
	layout		:	'absolute',
	width		:	1054,
	height		:	547,
	border		:	'0 0 0 0',
	items		:	[
	     		 	 generalConfigs_fieldSet,
	     		 	 configParameters_fieldSet
	     		 	 ]
});             