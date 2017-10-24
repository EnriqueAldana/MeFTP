Ext.define('Ext.ux.MeFTP.ConfigurationTab.ConfigurationParameters',{
	extend		:	'Ext.form.FieldSet',
	alias		:	'widget.configurationparameters',
	id			:	'configuration_parameters_id',
	itemId		:	'configuration_parameters_fieldset_id',
	height		:	400,
	margin		:	'5 10 10 10',
	anchor		:	'100%',
	title		:	'Configuration Parameters',
	y			:	135,
	layout		:	'absolute',
	initComponent	:	function(){
		Ext.apply(this,{
			items		:	[
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			                     fieldLabel	: 	'Passive Address Ip',
			                     id			:	'passive_address_id',
			                     itemId		:	'passive_address_textfield_id',
			                     emptyText	:	'Write server passive address Ip',
			                     width		:	400,
			                     msgTarget	: 	'side',
			                     allowBlank	:	false,
			                     labelPad	:	0,
			                     labelWidth	: 	200,
			                     x			: 	20
			                 },this.passiveAddressIpTextfield),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		: 	'textfield',
			                     fieldLabel	: 	'Passive External Address Ip',
			                     id			:	'passive_external_id',
			                     itemId		:	'passive_external_textfield_id',
			                     emptyText	:	'Write Server External Address Ip',
			                     width		:	400,
			                     msgTarget	: 	'side',
			                     allowBlank	:	false,
			                     labelPad	: 	0,
			                     labelWidth	: 	200,
			                     x			: 	20,
			                     y			: 	30
			                 },this.passiveExternalIpTextfield),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		: 	'textfield',
			     		 		 fieldLabel	: 	'Passive Ports Range',
			     		 		 id			:	'passive_ports_id',
			     		 		 itemId		:	'passive_ports_textfield_id',
			     		 		 emptyText	:	'Write Server Passive Ports Range',
			     		 		 width		:	400,
			     		 		 msgTarget	: 	'side',
			                     allowBlank	:	false,
			     		 		 labelPad	: 	0,
			     		 		 labelWidth	: 	200,
			     		 		 x			:	20,
			     		 		 y			:	60
			     		 	 },this.passivePortsRangeTextfield),
			     		 	
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'Idle Time',
			     		 		 id			:	'idle_time_id',
			     		 		 itemId		:	'idle_time_textfield_id',
			     		 		 emptyText	:	'Write Idle Time',
			     		 		 width		:	400,
			     		 		 msgTarget	: 	'side',
			                     allowBlank	:	false,
			     		 		 labelPad	:	0,
			     		 		 labelWidth	:	200,
			     		 		 x			:	20,
			     		 		 y			:	90
			     		 	 },this.idleTImeTextfield),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'File Name Users',
			     		 		 id			:	'file_name_id',
			     		 		 itemId		:	'file_name_textfield_id',
			     		 		 emptyText	:	'Write File Users Properties Name',
			     		 		 width		:	400,
			     		 		 msgTarget	: 	'side',
			                     allowBlank	:	false,
			     		 		 labelPad	:	0,
			     		 		 labelWidth	:	200,
			     		 		 x			:	20,
			     		 		 y			:	120
			     		 	 },this.fileNameUsersTextfield),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'File Logger Location',
			     		 		 id			:	'file_logger_id',
			     		 		 itemId		:	'file_logger_textfield_id',
			     		 		 emptyText	:	'Write File Logger Location',
			     		 		 width		:	400,
			     		 		 msgTarget	: 	'side',
			                     allowBlank	:	false,
			     		 		 labelPad	:	0,
			     		 		 labelWidth	:	200,
			     		 		 x			:	20,
			     		 		 y			:	150
			     		 	 },this.fileLoggerLocationTextfield),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'Data Base Name',
			     		 		 id			:	'database_name_id',
			     		 		 itemId		:	'database_name_textfield_id',
			     		 		 emptyText	:	'Write Data Base Name',
			     		 		 width		:	400,
			     		 		 msgTarget	: 	'side',
			                     allowBlank	:	false,
			     		 		 labelPad	:	0,
			     		 		 labelWidth	:	200,
			     		 		 x			:	20,
			     		 		 y			:	180
			     		 	 },this.dataBaseNameTextfield),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'Data Base Ip',
			     		 		 id			:	'database_ip_id',
			     		 		 itemId		:	'database_ip_textfield_id',
			     		 		 emptyText	:	'Write Data Base Ip',
			     		 		 width		:	400,
			     		 		 msgTarget	: 	'side',
			                     allowBlank	:	false,
			     		 		 labelPad	:	0,
			     		 		 labelWidth	:	200,
			     		 		 x			:	20,
			     		 		 y			:	210
			     		 	 },this.dataBaseIpTextfield),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'Data Base Location',
			     		 		 id			:	'database_location_id',
			     		 		 itemId		:	'database_location_textfield_id',
			     		 		 emptyText	:	'Write Data Base Location',
			     		 		 width		:	400,
			     		 		 msgTarget	: 	'side',
			                     allowBlank	:	false,
			     		 		 labelPad	:	0,
			     		 		 labelWidth	:	200,
			     		 		 x			:	20,
			     		 		 y			:	240
			     		 	 },this.dataBaseLocationTextfield),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'combobox',
			     		 		 fieldLabel	:	'Log Level',
			     		 		 id			:	'log_level_id',
			     		 		 itemId		:	'log_level_combobox_id',
			     		 		 emptyText	:	'Select an Option',
			     		 		 width		:	400,
			     		 		 msgTarget	:	'side',
			     		 		 allowBlank	:	false,
			     		 		 editable	:	false,
			     		 		 valueField	: 	'id_Options',//Propiedades
						    	 displayField	: 'Options',
			     		 		 store		:	logLevelCriteriaOptions,
			     		 		 labelPad	:	0,
			     		 		 labelWidth	:	200,
			     		 		 x			:	20,
			     		 		 y			:	270
			     		 	 },this.logLevelCombobox),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'Days for Password Life',
			     		 		 value		:	'30',
			     		 		 id			:	'password_life_id',
			     		 		 itemId		:	'password_life_textfield_id',
			     		 		 width		:	400,
			     		 		 msgTarget	:	'side',
			     		 		 allowBlank	:	false,
			     		 		 labelPad	:	0,
			     		 		 labelWidth	:	200,
			     		 		 x			:	20,
			     		 		 y			:	300
			     		 	 },this.daysPasswordLifeTextfield),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'Days of Sending Email por Password Life',
			     		 		 id			:	'email_sending_id',
			     		 		 itemId		:	'email_sending_textfield_id',
			     		 		 value		:	'5',
			     		 		 width		:	400,
			     		 		 msgTarget	:	'side',
			     		 		 allowBlank	:	false,
			     		 		 labelPad	:	0,
			     		 		 labelWidth	:	200,
			     		 		 x			:	20,
			     		 		 y			:	330
			     		 	 },this.dayssendingmailTextfield),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'Maximums day for expiration days',
			     		 		 id			:	'maximums_days_id',
			     		 		 itemId		:	'maximums_days_textfield_id',
			     		 		 emptyText	:	'Write a number for Maximums Days',
			     		 		 width		:	400,
			     		 		 msgTarget	:	'side',
			     		 		 allowBlank	:	false,
			     		 		 labelPad	:	0,
			     		 		 labelWidth	:	200,
			     		 		 x			:	450,
			     		 		 y			:	300
			     		 	 },this.maximumsDaysForExpirationTextfield),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'Minimums day for expiration days',
			     		 		 id			:	'minimums_days_id',
			     		 		 itemId		:	'minimums_days_textfield_id',
			     		 		 emptyText	:	'Write a number for Minimums Days',
			     		 		 width		:	400,
			     		 		 msgTarget	:	'side',
			     		 		 allowBlank	:	false,
			     		 		 labelPad	:	0,
			     		 		 labelWidth	:	200,
			     		 		 x			:	450,
			     		 		 y			:	340
			     		 	 },this.minimumsDaysForExpirationTextfield),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'button',
			     		 		 id			:	'save_changes_id',
			     		 		 itemId		:	'save_changes_button_id',
			     		 		 height		:	40,
			     		 		 width		:	100,
			     		 		 text		:	'Save Changes',
			     		 		 x			:	650,
			     		 		 y			:	20,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickUpdateDataServer
			     		 		 }
			     		 	 },this.saveChangesButton)
			     		 	 
			      ]
		});
		Ext.ux.MeFTP.ConfigurationTab.ConfigurationParameters.superclass.initComponent.call(this);
	},
	_onClickUpdateDataServer	:	function(){
		Ext.Msg.show({
			title: 'Update Server Data',
			msg : 'Wanna Update the Server Data?',
			buttons : Ext.Msg.YESNOCANCEL,
			icon : 'ext-mb-saveuser',
			fn : function(btn) {
				if (btn == 'yes') {
					var r = Ext.getCmp('configuration_parameters_id');
					var rr = Ext.getCmp('general_config_id');
					if (r.up('form').getForm().isValid() == true && rr.up('form').getForm().isValid()) {
						Ext.Ajax.request({
							url : 'meftpChangeConfig/saveProperties.action',
							method : 'POST',
							params:{
								meftpServerPassiveAddress	:	Ext.getCmp('passive_address_id').value,
								meftpServerPassiveExtAdddress	:	Ext.getCmp('passive_external_id').value,
								meftpSercerPassivePorts	:	Ext.getCmp('passive_ports_id').value,
								meftpServerIdleTime		:	Ext.getCmp('idle_time_id').value,
								meftpServerFileName		:	Ext.getCmp('file_name_id').value,
								meftpServerFileLoggerLocation	:	Ext.getCmp('file_logger_id').value,
								meftpServerDatabaseName	:	Ext.getCmp('database_name_id').value,
								meftpServerDatabaseIp	:	Ext.getCmp('database_ip_id').value,
								meftpServerDatabaseLocation	:	Ext.getCmp('database_location_id').value,
								meftpServerLogLevel		:	Ext.getCmp('log_level_id').value,
								meftpServerPasswordLife	:	Ext.getCmp('password_life_id').value,
								meftpServerEmailSending	:	Ext.getCmp('email_sending_id').value,
								meftpServerMaximumsDays	:	Ext.getCmp('maximums_days_id').value,
								meftpServerMinimumsDays	:	Ext.getCmp('minimums_days_id').value,
								
								meftpServerName			:	generalConfigs_fieldSet.getComponent('name_server_textfield_id').value,
								meftpServerSite			:	generalConfigs_fieldSet.getComponent('server_site_textfield_id').value,
								meftpServerEnabled		:	generalConfigs_fieldSet.getComponent('server_enabled_checkbox_id').value,
								meftpServerSSLConnections	:	generalConfigs_fieldSet.getComponent('ssl_server_checkbox_id').value
							},
							
							waitMsg : Ext.MessageBox.show({
								id : 'wait_message_win',
								msg : 'Saving data, please wait...',
								progressText : 'Saving...',
								width : 300,
								wait : true,
								interval : 1,
								icon : 'ext-mb-download'
							}),
							success : function() {
								r.up('form').getForm().reset();
								rr.up('form').getForm().reset();
								Ext.MessageBox.close();
								Ext.MessageBox.alert('Status', 'THe Changes will be applied, the next time you Restart the Server');
								//Ext.example.msg('Done', 'New User save');
							}
						});
					}
				}
			}
		});		
	}
});