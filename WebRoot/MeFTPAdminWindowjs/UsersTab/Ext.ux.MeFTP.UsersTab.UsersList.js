Ext.define('Ext.ux.MeFTP.UsersTab.UsersList',{
	extend		:	'Ext.form.FieldSet',
	alias		:	'widget.userslist',
	id			:	'user_list_id',
	itemId		:	'user_list_fieldset_id',
	height		: 	477,
	width		:	560,
	x			:	10,
	y			:	60,
	layout		:	'absolute',
	title		:	'Users List',
	autoScroll	:	true,
	initComponent	:	function(){
		Ext.apply(this,{
			items		:	[
			     		 	 Ext.apply({
			     		 		 xtype		:	'gridpanel',
			     		 		 autoscroll	:	true,
			     		 		 itemId		:	'users_list_grid_id',
			     		 		 x			:	0,
			     		 		 y			:	0,
			     		 		 height		:	210,
			     		 		 width		:	535,
			     		 		 verticalScroller:{
			     		 			 xtype		:	'paginggridscroller'
			     		 		 },
			     		 		 invalidateScrollerOnRefresh	:	false,
			     		 		 viewConfig		:	{
			     		 			 trackOver		:	false
			     		 		 },
			     		 		 loadMask	:	true,
			     		 		 columns	:	[{
			     			    	xtype 		: 	'gridcolumn',
			     			    	dataIndex 	: 	'meftpUsersUserid',
			     			    	text 		:	'User Id',
			     			    	css:'background-color: #EEFFAA;border-style:solid;border-color:#0000ff;'
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
			     		 		 store		:	userStore,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			selectionchange : this._onClickSelectData
			     		 		 }
			     		 	 },this.userListGrid),
			     		 	 
			     		 	 Ext.apply({			     		 		 
			     		 		 xtype		:	'userscontactslist'
			     		 	 },this.setfieldContacts)
			     		 ]
		});
		
		Ext.ux.MeFTP.UsersTab.UsersList.superclass.initComponent.call(this);
	},
	_onClickSelectData	:	function(model, records,store){		
		if (records[0]) {
			this.up('form').getForm().loadRecord(records[0]);
			Ext.getCmp('user_fields_id').enable();
			userTab_search.getComponent('user_search_button_id').disable();
			userTab_search.getComponent('date_from_datefield_id').disable();
			userTab_search.getComponent('date_to_datefield_id').disable();
			userTab_search.getComponent('criteria_search_combo_id').disable();
			userTab_search.getComponent('search_text_textfield_id').disable();
			
			userTab_buttons.getComponent('add_user_button_id').disable();
			userTab_buttons.getComponent('add_contacts_button_id').show();
			userTab_buttons.getComponent('delete_user_button_id').show();
			userTab_buttons.getComponent('save_change_button_id').show();
			userTab_buttons.getComponent('cancel_action_button_id').show();
			userTab_buttons.getComponent('cancel_addaction_button_id').hide();
		}
		
	}
});           