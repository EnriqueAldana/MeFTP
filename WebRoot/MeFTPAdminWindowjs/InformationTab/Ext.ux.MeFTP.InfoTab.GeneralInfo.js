Ext.define('Ext.ux.MeFTP.InfoTab.GeneralInfo',{
	extend		:	'Ext.form.FieldSet',
	alias		:	'widget.generalInfoTab',
	height		:	140,
	margin		:	'20 10 10 10',
	anchor		:	'100%',
	autoScroll	:	true,
	title		:	'General Information',
    layout: {
        type: 'absolute'
    },
    title: 'General Information',	
	initComponent	:	function(){
		Ext.apply(this,{
			items		:	[
			     		 Ext.apply({
		     		 		 xtype		:	'displayfield',
		     		 		 fieldLabel	: 	'Name',
		     		 		 id			:	'name_server_id',
		     		 		 itemId		:	'name_server_displayfield_id',
		     		 		 labelPad	: 	-30,
		     		 		 labelWidth	:	120,
		     		 		 x			: 	10,
		     		 		 y			: 	10
		     		 	 },this.serverNameDisplayField),
		     		 	 
		     		 	 Ext.apply({
		     		 		 xtype		:	'displayfield',
		     		 		 fieldLabel	:	'Status',
		     		 		 value		:	'Running',
		     		 		 id			:	'status_server_id',
		     		 		 itemId		:	'status_server_displayfield_id',
		     		 		 labelPad	:	-30,
		     		 		 labelWidth	:	120,
		     		 		 x			: 	10,
		     		 		 y			: 	50
		     		 	 },this.serverStatusDisplayField),
		     		 	 
		     		 	 Ext.apply({
		     		 		 xtype		:	'displayfield',
		     		 		 fieldLabel	:	'Directories Number',
		     		 		 id			:	'directories_number_id',
		     		 		 itemId		:	'directories_number_displayfield_id',
		     		 		 labelPad	:	10,
		     		 		 labelWidth	:	120,
		     		 		 x			:	410,
		     		 		 y			:	10
		     		 	 },this.serverDirNumDisplayField),
		     		 	 
		     		 	 Ext.apply({
		     		 		 xtype		:	'displayfield',
		     		 		 fieldLabel	:	'Files Number',
		     		 		 id			:	'files_number_id',
		     		 		 itemId		:	'files_number_displayfield_id',
		     		 		 labelPad	:	10,
		     		 		 labelWidth	:	120,
		     		 		 x			:	410,
		     		 		 y			:	50
		     		 	 },this.serverFilesNumDisplayField),
		     		 	 
		     		 	 Ext.apply({
		     		 		 xtype		:	'displayfield',
		     		 		 fieldLabel	:	'Enabled Users',
		     		 		 id			:	'enabledserver_users_id',
		     		 		 itemId		:	'enabled_users_displayfield_id',
		     		 		 labelPad	:	-30,
		     		 		 labelWidth	:	120,
		     		 		 x			:	810,
		     		 		 y			:	10
		     		 	 },this.serverEnabUsersDisplayField),
		     		 	 
		     		 	 Ext.apply({
		     		 		 xtype		:	'displayfield',
		     		 		 fieldLabel	:	'Disabled Users',
		     		 		 id			:	'disabledserver_users_id',
		     		 		 itemId			:	'disabled_users_displayfield_id',
		     		 		 labelPad	:	-30,
		     		 		 labelWidth	:	120,
		     		 		 x			:	810,
		     		 		 y			:	50
		     		 	 },this.serverDisUsersDisplayField),
		     		 	 
		     		 	 Ext.apply({
		     		 		 xtype		:	'button',
		     		 		 id			:	'refresh_id',
		     		 		 itemId		:	'refres_button_id',
		     		 		 height		: 	20,
		     		 		 width		: 	100,
		     		 		 text		: 	'Refresh',
		     		 		 x			: 	810,
		     		 		 y			: 	80,
		     		 		 listeners	:	{
		     		 			 scope		:	this,
		     		 			 click		:	this._onRefresh
		     		 		 }
		     		 	 },this.refreshButton)
		     ]
		});
		
		Ext.ux.MeFTP.InfoTab.GeneralInfo.superclass.initComponent.call(this);
	},
	_onRefresh:function(){
		Ext.Ajax.request({
			url			:	'',
			method		:	'POST',
			success		:	function(response){
				
			}
		});
		
		Ext.Ajax.request({
			url			:	'getInfoTab/infoTab.action',
			method 		: 	'POST',
			success		:	function(response){
				var datas;
				data = Ext.decode(response.responseText);
				Ext.each(data, function(datas) {
					 sN		=	datas.sN
					 paIp	= 	datas.pAIP;
					 peaip	=	datas.pEAIP;
					 ppr	=	datas.pPR;
					 it		=	datas.iT;
					 fnu	=	datas.fNU;
					 fnul	=	datas.fNUL;
					 fll	=	datas.fLL;
					 dbn	=	datas.dBN;
					 dbip	=	datas.dBIP;
					 dbl	=	datas.dBL;
					 ll		=	datas.lL;
					 nue	=	datas.nUE;
					 nud  	=	datas.nDU;
				});
				
				Ext.getCmp('name_server_id').setRawValue(sN);
				Ext.getCmp('enabledserver_users_id').setRawValue(nue);
				Ext.getCmp('disabledserver_users_id').setRawValue(nud);
				genParams.getComponent('passive_address_displayfield_id').setRawValue(paIp);
				genParams.getComponent('passive_ext_address_displayfield_id').setRawValue(peaip);
				genParams.getComponent('passive_port_displayfield_id').setRawValue(ppr);
				genParams.getComponent('idle_time_displayfield_id').setRawValue(it);
				genParams.getComponent('file_nameusers_displayfield_id').setRawValue(fnu);
				genParams.getComponent('file_nameusersloc_displayfield_id').setRawValue(fnul);
				genParams.getComponent('file_loggerloc_displayfield_id').setRawValue(fll);
				genParams.getComponent('database_name_displayfield_id').setRawValue(dbn);
				genParams.getComponent('database_ip_displayfield_id').setRawValue(dbip);
				genParams.getComponent('database_location_displayfield_id').setRawValue(dbl);
				genParams.getComponent('log_level_displayfield_id').setRawValue(ll);
				
			}
		});
	}
});           