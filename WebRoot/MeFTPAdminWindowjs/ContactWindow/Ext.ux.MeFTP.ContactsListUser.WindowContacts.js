Ext.define('Ext.ux.MeFTP.ContactList.WindowContacts',{
	extend		:	'Ext.form.FieldSet',
	alias		:	'widget.contactslistuser',
	id			:	'contactwindow_list_id',
	itemId		:	'contactwindow_list_fieldset_id',
	height: 260,
    width: 360,
	x: 620,
	y: 260,
	bodyPadding	:	10,
	layout		:	'anchor',
	title		:	'Selected User List',
	autoScroll	:	true,
	initComponent	:	function(){
		Ext.apply(this,{
			items		:	[
			     		 	 Ext.apply({
			     		 		 xtype		:	'gridpanel',
			     		 		 autoscroll	:	true,
			     		 		 itemId		:	'contact_list_grid_id',
			     		 		 anchor		:	'100% 95%',
			     		 		 //x			:	0,
			     		 		 //y			:	0,
			     		 		 //height		:	210,
			     		 		 //width		:	535,
			     		 		 viewConfig: {
			     		 			 plugins	:	{
			     		 				 ptype		:	'gridviewdragdrop',
			     		 				 dragGroup	: 	'Ext.ux.MeFTP.ContactList.WindowContactsDDGroup',
			     		 				 dropGroup	: 	'Ext.ux.MeFTP.UserList.WindowContactsDDGroup'
			     		 			 },
			     		 			 listeners	:	{
			     		 				 drop		:	function(node, data, dropRec, dropPosition) {
			     		 					 var dropOn = dropRec ? ' ' + dropPosition + ' ' + dropRec.get('meftpUsersUserid') : ' on empty view';
			     		 					 //Ext.example.msg("Drag from left to right", 'Dropped ' + data.records[0].get('name') + dropOn);
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
			     		 		 store		:	contactsUserStore2/*,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			selectionchange : this._onClickSelectData
			     		 		 }*/
			     		 	 },this.userContactsListGrid)			     		 	
			     		 ]
		});
		
		Ext.ux.MeFTP.ContactList.WindowContacts.superclass.initComponent.call(this);
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