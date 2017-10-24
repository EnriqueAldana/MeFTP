Ext.define('Ext.ux.MeFTP.UsersTab.UsersContactsList',{
	extend		:	'Ext.form.FieldSet',
	alias		:	'widget.userscontactslist',
	height		:	200,
	width		:	535,
	layout		:	'absolute',
	title		:	'Users Contacts List',
	autoScroll	:	true,
	y			:	220,
	initComponent	:	function(){
		Ext.apply(this,{
			items		:	[
			     		 	 Ext.apply({
			     		 		 xtype		:	'gridpanel',
			     		 		 id			:	'userscontact_list_id',
			     		 		 itemId		:	'userscontact_list_grid_id',
			     		 		 height		:	160,
			     		 		 width		:	510,
			     		 		columns	:	[{
			     			    	xtype 		: 	'gridcolumn',
			     			    	dataIndex 	: 	'meftpUsersUserid',
			     			    	text 		:	'User Id'
			     				}, {
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpUsersUsername',
			     					text 		: 	'User Name'
			     				}, {
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpUsersUsernamelogin',
			     					text 		: 	'User Log In'
			     				}, {
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpUsersUserpassword',
			     					text 		: 	'User Password'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpUsersUserhomedirectory',
			     					text 		: 	'User Home'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpUsersUserenabledflag',
			     					text 		: 	'User Enabled'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpUsersUserwritepermission',
			     					text 		: 	'User Write Permission'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpUsersUseridletime',
			     					text 		: 	'User Idle Time'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpUsersUsercreatedate',
			     					text 		: 	'User Create Date'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpUsersUserexpires',
			     					text 		: 	'User Expired Date'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpUsersUsercomments',
			     					text 		: 	'User Comments'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpUsersUseremailaddress',
			     					text 		: 	'User E-Mail'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpUsersUseremailnotification',
			     					text 		: 	'User E-Mail Notification'
			     				}
			     				],
			     		 		 store			:	contactsUserStore2,
			     		 		listeners	:	{
			     		 			 scope		:	this,
			     		 			 selectionchange : this._onClickSelectDataContact
			     		 		 }
			     		 	 },this.userContactsListGrid)    		 	
			     		 ]
		});
		
		Ext.ux.MeFTP.UsersTab.UsersContactsList.superclass.initComponent.call(this);
	},
	
	_onClickSelectDataContact	:	function(model, records,store){
		//if (records[0]) {
			userTab_buttons.getComponent('remove_contact_button_id').show();
		//}
	}
});  

/*
 var rows=Ext.getCmp(lic_aut.id+'_gridAut').getSelectionModel().getSelections();
                                                  Ext.getCmp(autNueva_sol.id+'c_idcont').setValue(rows[0].get('c_idcont'));
                           Ext.getCmp(autNueva_sol.id+'descvia').setValue(rows[0].get('direc_fisc')); --------> Combo
                           Ext.getCmp(autNueva_sol.id+'obs').setValue(rows[0].get('obs'));   
                           Ext.getCmp(autNueva_sol.id+'v_nomaco').setValue(rows[0].get('c_repres'));
                           Ext.getCmp(autNueva_sol.id+'v_nrodoc').setValue(rows[0].get('c_dnirep'));
                           Ext.getCmp(autNueva_sol.id+'nvaltra').setValue(rows[0].get('n_totalsolic')); 
 */