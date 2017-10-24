Ext.define('Ext.ux.MeFTP.InfoTab.GeneralParams',{
	extend		:	'Ext.form.FieldSet',
	alias		:	'widget.generalParamsInfoTab',
	height		: 	355,
	anchor		:	'100%',
	margin		:	'20 10 10 10',
	autoScroll	:	true,
	layout		:	'absolute',
	title		: 	'Configuration Parameters',
	y			: 	150,
	initComponent	:	function(){
		
		Ext.apply(this,{
			items		:	[
			     		 	 Ext.apply({
			     		 		xtype		:	'displayfield',
			     		 		itemId		:	'passive_address_displayfield_id',
			     		 		fieldLabel	: 	'Passive Address Ip',
			     		 		value		: 	'',
			     		 		anchor		:	'100%',
			     		 		labelPad	: 	200,
			     		 		labelWidth	:	180
			     		 	},this.passiveAddresDisplayField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'displayfield',
			     		 		 itemId		:	'passive_ext_address_displayfield_id',
			     		 		 fieldLabel	:	'Passive External Address Ip',
			     		 		 value		:	'',
			     		 		 labelPad	: 	200,
			     		 		 labelWidth	:	180,
			     		 		 anchor		:	'100%',
			     		 		 y			:	40
			     		 	 },this.passiveExtAddresDisplayField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'displayfield',
			     		 		 itemId		:	'passive_port_displayfield_id',
			     		 		 fieldLabel	:	'Passive Ports Range',
			     		 		 value		:	'',
			     		 		 labelPad	:	200,
			     		 		 labelWidth	:	180,
			     		 		 anchor		:	'100%',
			     		 		 y			:	70
			     		 	 },this.passivePortsDisplayField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'displayfield',
			     		 		 itemId		:	'idle_time_displayfield_id',
			     		 		 fieldLabel	:	'Idle Time',
			     		 		 value		:	'',
			     		 		 labelPad	:	200,
			     		 		 labelWidth	:	180,
			     		 		 anchor		:	'100%',
			     		 		 y			:	100
			     		 	 },this.idleTimeDisplayField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'displayfield',
			     		 		 itemId		:	'file_nameusers_displayfield_id',
			     		 		 fieldLabel	:	'File Name Users',
			     		 		 value		:	'',
			     		 		 labelPad	:	200,
			     		 		 labelWidth	:	180,
			     		 		 anchor		:	'100%',
			     		 		 y			:	130
			     		 	 },this.fileNameUsersDisplayField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'displayfield',
			     		 		 itemId		:	'file_nameusersloc_displayfield_id',
			     		 		 fieldLabel	:	'File Name Users Location',
			     		 		 labelPad	:	200,
			     		 		 labelWidth	:	180,
			     		 		 value		:	'',
			     		 		 anchor		:	'100%',
			     		 		 y			:	160
			     		 	 },this.fileNameULocDisplayField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'displayfield',
			     		 		 itemId		:	'file_loggerloc_displayfield_id',
			     		 		 fieldLabel	:	'File Logger Location',
			     		 		 labelPad	:	200,
			     		 		 labelWidth	:	180,
			     		 		 value		:	'',
			     		 		 anchor		:	'100%',
			     		 		 y			:	190
			     		 	 },this.fileLoggerLocDisplayField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'displayfield',
			     		 		 itemId		:	'database_name_displayfield_id',
			     		 		 fieldLabel	:	'Data Base Name',
			     		 		 labelPad	:	200,
			     		 		 labelWidth	:	180,
			     		 		 value		:	'',
			     		 		 anchor		:	'100%',
			     		 		 y			:	220
			     		 	 },this.dataBaseNameDisplayField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'displayfield',
			     		 		 itemId		:	'database_ip_displayfield_id',
			     		 		 fieldLabel	:	'Data Base Ip',
			     		 		 labelPad	:	200,
			     		 		 labelWidth	:	180,
			     		 		 value		:	'',
			     		 		 anchor		:	'100%',
			     		 		 y			:	250
			     		 	 },this.dataBaseIpDisplayField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'displayfield',
			     		 		 itemId		:	'database_location_displayfield_id',
			     		 		 fieldLabel	:	'Data Base Location',
			     		 		 labelPad	:	200,
			     		 		 labelWidth	:	180,
			     		 		 value		:	'',
			     		 		 anchor		:	'100%',
			     		 		 y			:	280
			     		 	 },this.dataBaseLocDisplayField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'displayfield',
			     		 		 itemId		:	'log_level_displayfield_id',
			     		 		 fieldLabel	:	'Log Level',
			     		 		 labelPad	:	200,
			     		 		 labelWidth	:	180,
			     		 		 value		:	'',
			     		 		 anchor		:	'100%',
			     		 		 y			:	310
			     		 	 },this.logLevelDisplayField)
			       
			]
		})
		Ext.ux.MeFTP.InfoTab.GeneralParams.superclass.initComponent.call(this);
	}
	
});