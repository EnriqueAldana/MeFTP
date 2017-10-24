Ext.define('Ext.ux.MeFTP.ConfigurationTab.GeneralConfig',{
	extend		:	'Ext.form.FieldSet',
	id			:	'general_config_id',
	itemId		:	'general_config_fieldset_id',
	alias		:	'widget.generalConfig',
	height		:	140,
	margin		:	'0 10 10 10',
	anchor		:	'100%',
	autoScroll	:	true,
	title		:	'General Configuration',
    layout: {
        type: 'absolute'
    },
    title: 'General Information',	
	initComponent	:	function(){
		Ext.apply(this,{
			items		:	[
			     		 Ext.apply({
		     		 		 xtype		:	'textfield',
		     		 		 fieldLabel	: 	'Server Name',
		     		 		 id			:	'name_server_id',
		     		 		 itemId		:	'name_server_textfield_id',
		     		 		 emptyText	:	'Write Server Name',
		     		 		 allowBlank	:	false,
		     		 		 msgTarget	:	'side',
		     		 		 labelPad	: 	-30,
		     		 		 labelWidth	:	120,
		     		 		 x			: 	10,
		     		 		 y			: 	10
		     		 	 },this.serverNameTextfield),
		     		 	 
		     		 	 Ext.apply({
		     		 		 xtype		:	'textfield',
		     		 		 fieldLabel	:	'Site',
		     		 		 id			:	'server_site_id',
		     		 		 allowBlank	:	false,
		     		 		 msgTarget	:	'side',
		     		 		 itemId		:	'server_site_textfield_id',
		     		 		 emptyText	:	'Write Server Site',
		     		 		 id			:	'site_server_textfield_id',
		     		 		 labelPad	:	-30,
		     		 		 labelWidth	:	120,
		     		 		 x			: 	10,
		     		 		 y			: 	50
		     		 	 },this.serverSiteTextfield),
		     		 	 
		     		 	 Ext.apply({
		     		 		 xtype		:	'checkbox',
		     		 		 boxLabel	:	'Enabled',
		     		 		 id			:	'server_enabled_id',
		     		 		 itemId		:	'server_enabled_checkbox_id',
		     		 		 x			:	390,
		     		 		 y			:	10
		     		 	 },this.serverEnabledCheckBox),
		     		 	 
		     		 	 Ext.apply({
		     		 		 xtype		:	'checkbox',
		     		 		 boxLabel	:	'SSL for FTP Connections',
		     		 		 id			:	'ssl_server_id',
		     		 		 itemId		:	'ssl_server_checkbox_id',
		     		 		 x			:	390,
		     		 		 y			:	50
		     		 	 },this.SSLServerFTP),
		     		 	     		 	 
		     		 	 Ext.apply({
		     		 		 xtype		:	'button',
		     		 		 text		:	'START',
		     		 		 id			:	'start_server_id',
		     		 		 itemId		:	'start_server_button_id',
		     		 		 disabled	:	true,
		     		 		 width		:	80,
		     		 		 height		:	30,
		     		 		 x			:	810,
		     		 		 y			:	10,
		     		 		 listeners	:	{
		     		 			 scope		:	this,
		     		 			 click		:	this._onClickStartServer
		     		 		 }
		     		 	 },this.startServerButton),
		     		 	 
		     		 	 Ext.apply({
		     		 		 xtype		:	'button',
		     		 		 text		:	'STOP',
		     		 		 value		:	'49',
		     		 		 id			:	'stop_server_id',
		     		 		 itemId		:	'stop_server_button_id',
		     		 		 width		:	80,
		     		 		 height		:	30,
		     		 		 x			:	810,
		     		 		 y			:	50,
		     		 		 listeners	:	{
		     		 			 scope		:	this,
		     		 			 click		:	this._onClickStopServer
		     		 		 }
		     		 	 },this.stopServerButton),
		     ]
		});
		
		Ext.ux.MeFTP.ConfigurationTab.GeneralConfig.superclass.initComponent.call(this);
	},
	
	_onClickStartServer	:	function(){
		Ext.Ajax.request({
			url : 'meftpServerAdmin/MeftpServer_start.action',
			method : 'POST',
			success:function(response){
				Ext.getCmp('start_server_id').disable();
				Ext.getCmp('stop_server_id').enable();
				Ext.example.msg('Done', 'Server has been started');
			}
		});
		//location	=	"meftpServerAdmin/MeftpServer_start.action";
	},
	
	_onClickStopServer	:	function(){
		Ext.Ajax.request({
			url : 'meftpServerAdmin/MeftpServer_stop.action',
			method : 'POST',
			success:function(response){
				Ext.getCmp('start_server_id').enable();
				Ext.getCmp('stop_server_id').disable();
				Ext.example.msg('Done','Server has been stoped');
			}
		});
		//location	=	"meftpServerAdmin/MeftpServer_stop.action";
	}
}); 