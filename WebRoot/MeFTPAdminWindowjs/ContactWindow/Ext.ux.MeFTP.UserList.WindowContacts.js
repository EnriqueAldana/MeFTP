Ext.define('Ext.ux.MeFTP.UserList.WindowContacts',{
	extend		:	'Ext.form.FieldSet',
	alias		:	'widget.usercontactslist',
	id			:	'usercontact_list_id',
	itemId		:	'usercontact_list_fieldset_id',
	height		: 	450,
	width		:	600,
	y			:	70,
	bodyPadding	:	10,
	layout		:	'anchor',
	title		:	'Available Users List',
	autoScroll	:	true,
	initComponent	:	function(){
		Ext.apply(this,{
			items		:	[
			     		 	 Ext.apply({
			     		 		 xtype		:	'gridpanel',
			     		 		 autoscroll	:	true,
			     		 		 itemId		:	'userscontact_list_grid_id',
			     		 		 anchor		:	'100% 95%',
			     		 		 multiSelect: 	true,
			     		 		 viewConfig	: 	{
			     		 			 plugins		:	{
			     		 				 ptype		:	'gridviewdragdrop',
			     		 				 dragGroup	: 	'Ext.ux.MeFTP.UserList.WindowContactsDDGroup',
			     		 				 dropGroup: 	'Ext.ux.MeFTP.ContactList.WindowContactsDDGroup'
			     		            },
			     		            listeners: {
			     		                drop: function(node, data, dropRec, dropPosition) {
			     		                    var dropOn = dropRec ? ' ' + dropPosition + ' ' + dropRec.get('meftpUsersUserid') : ' on empty view';
			     		                    //Ext.example.msg("Drag from right to left", 'Dropped ' + data.records[0].get('name') + dropOn);
			     		                }
			     		            }
			     		        },
			     		 		 verticalScroller:{
			     		 			 xtype		:	'paginggridscroller'
			     		 		 },
			     		 		 invalidateScrollerOnRefresh	:	false,
			     		 		 /*viewConfig		:	{
			     		 			 trackOver		:	false
			     		 		 },*/
			     		 		 loadMask	:	true,
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
			     		 		 store		:	contactsUserStore/*,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			selectionchange : this._onClickSelectData
			     		 		 }*/
			     		 	 },this.userContactsListGrid)			     		 	
			     		 ]
		});
		
		Ext.ux.MeFTP.UserList.WindowContacts.superclass.initComponent.call(this);
	}/*,
	_onClickSelectData	:	function(model, records,store){		
		if (records[0]) {
			this.up('form').getForm().loadRecord(records[0]);
			Ext.getCmp('user_fields_id').enable();
			userTab_search.getComponent('user_search_button_id').disable();
			userTab_search.getComponent('date_from_datefield_id').disable();
			userTab_search.getComponent('date_to_datefield_id').disable();
			userTab_search.getComponent('criteria_search_combo_id').disable();
			userTab_search.getComponent('search_text_textfield_id').disable();
			userTab_buttons.getComponent('delete_user_button_id').show();
			userTab_buttons.getComponent('save_change_button_id').show();
			userTab_buttons.getComponent('add_user_button_id').show();
			userTab_buttons.getComponent('cancel_action_button_id').show();
			userTab_buttons.getComponent('cancel_addaction_button_id').hide();
		}
		
	}*/
});             