Ext.define('Ext.ux.MeFTP.UsersTab.UserButtons',{
	extend		:	'Ext.form.FieldSet',
	alias		:	'widget.userbuttons',
	height		:	80,
	width		:	460,
	layout		:	'absolute',
	x			:	580,
	y			:	457,
	initComponent	:	function(){
		Ext.apply(this,{
			items		:	[
			     		 	 Ext.apply({
			     		 		 xtype		:	'button',
			     		 		 id			:	'add_user_id',
			     		 		 itemId		:	'add_user_button_id',
			     		 		 text		:	'Add',
			     		 		 tooltip	:	'Add New User',
			     		 		 width		:	80,
			     		 		 height		:	20,
			     		 		 x			:	10,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickAddButton
			     		 		 }
			     		 	 },this.addButton),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'button',
			     		 		 id			:	'cancel_addaction_id',
			     		 		 itemId		:	'cancel_addaction_button_id',
			     		 		 text		:	'Cancel',
			     		 		 tooltip	:	'Cancel Add Action',
			     		 		 hidden		:	true,
			     		 		 width		:	80,
			     		 		 height		:	20,
			     		 		 x			:	120,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickCancelAddButton
			     		 		 }
			     		 	 },this.cancelAddButton),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'button',
			     		 		 id			:	'cancel_action_id',
			     		 		 itemId		:	'cancel_action_button_id',
			     		 		 text		:	'Cancel',
			     		 		 tooltip	:	'Cancel Action',
			     		 		 hidden		:	true,
			     		 		 width		:	80,
			     		 		 height		:	20,
			     		 		 x			:	120,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickcancelActionButton
			     		 		 }
			     		 	 },this.cancelButton),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'button',
			     		 		 id			:	'save_user_id',
			     		 		 itemId		:	'save_user_button_id',
			     		 		 text		:	'Save',
			     		 		 tooltip	:	'Save New User',
			     		 		 hidden		:	true,
			     		 		 width		:	80,
			     		 		 height		:	20,
			     		 		 x			:	230,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickSaveUserButton
			     		 		 }
			     		 	 },this.saveUserButton),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'button',
			     		 		 id			:	'save_changes_id',
			     		 		 itemId		:	'save_change_button_id',
			     		 		 text		:	'Save',
			     		 		 tooltip	:	'Save Changes',
			     		 		 hidden		:	true,
			     		 		 width		:	80,
			     		 		 height		:	20,
			     		 		 x			:	230,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickSaveChangesButton
			     		 		 }
			     		 	 },this.saveChangesButton),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'button',
			     		 		 id			:	'delete_user_id',
			     		 		 itemId		:	'delete_user_button_id',
			     		 		 text		:	'Delete',
			     		 		 tooltip	:	'Delete User',
			     		 		 hidden		:	true,
			     		 		 width		:	80,
			     		 		 height		:	20,
			     		 		 x			:	340,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickDeleteButton
			     		 		 }
			     		 	 },this.deleteButton),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'button',
			     		 		 id			:	'add_contacts_id',
			     		 		 itemId		:	'add_contacts_button_id',
			     		 		 text		:	'Add Contact',
			     		 		 tooltip	:	'Admin Contacts',
			     		 		 hidden		:	true,	
			     		 		 width		:	190,
			     		 		 height		:	20,
			     		 		 x			:	10,
			     		 		 y			:	30,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickAddContactButton
			     		 		 }
			     		 	 },this.addContactButton),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'button',
			     		 		 id			:	'remove_contact_id',
			     		 		 itemId		:	'remove_contact_button_id',
			     		 		 text		:	'Remove Contact',
			     		 		 tooltip	:	'Remove a Contact',
			     		 		 hidden		:	true,
			     		 		 width		:	190,
			     		 		 height		:	20,
			     		 		 x			:	230,
			     		 		 y			:	30,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickRemoveContacts
			     		 		 }	
			     		 	 },this.removeContactButton)
			     		 	 
			     		 	 ]
		});
		Ext.ux.MeFTP.UsersTab.UserButtons.superclass.initComponent.call(this);
	},
	
	_onClickRemoveContacts	:	function(){
		var sm = Ext.getCmp('userscontact_list_id').getSelectionModel();
		contactsUserStore2.remove(sm.getSelection());
        if (contactsUserStore2.getCount() > 0) {
            sm.select(0);
        }
	},	
	
	_onClickAddButton	:	function(){
		Ext.getCmp('user_fields_id').enable();
		Ext.getCmp('add_user_id').disable();
		Ext.getCmp('search_fieldset_id').disable();
		Ext.getCmp('cancel_addaction_id').show();
		Ext.getCmp('save_user_id').show();
		
	},
	
	_onClickCancelAddButton	:	function(){
		this.up('form').getForm().reset();
		Ext.getCmp('cancel_addaction_id').hide();
		Ext.getCmp('save_user_id').hide();
		Ext.getCmp('user_fields_id').disable();
		Ext.getCmp('search_fieldset_id').enable();
		Ext.getCmp('add_user_id').enable();
		
		
		userTab_search.getComponent('user_search_button_id').enable();
	},
	
	_onClickcancelActionButton:function(){
		var r = Ext.getCmp('user_fields_id');
		r.up('form').getForm().reset();
		r.disable();
		Ext.getCmp('cancel_action_id').hide();
		Ext.getCmp('save_changes_id').hide();
		Ext.getCmp('delete_user_id').hide();
		Ext.getCmp('add_user_id').enable();
		Ext.getCmp('search_fieldset_id').enable();
		
		userTab_search.getComponent('date_from_datefield_id').disable();
		userTab_search.getComponent('date_to_datefield_id').disable();
		userTab_search.getComponent('criteria_search_combo_id').enable();
		userTab_search.getComponent('search_text_textfield_id').enable();
		userTab_search.getComponent('user_search_button_id').enable();
	},
	
	_onClickSaveUserButton	:	function(){
		Ext.Msg.show({
			title: 'Save',
			msg : 'Wanna Save New User.',
			buttons : Ext.Msg.YESNO,
			icon : 'ext-mb-saveuser',
			fn : function(btn) {
				if (btn == 'yes') {
					var r = Ext.getCmp('user_fields_id');
					var name = userTab_fields.getComponent('user_name_textfield_id').value;
					if (r.up('form').getForm().isValid() == true) {
						Ext.Ajax.request({
							url : 'meftpUsersActions/add.action',
							method : 'POST',
							params:{
								meftpUserLogin	:  	userTab_fields.getComponent('user_login_textfield_id').value,
								meftpUserName	:	userTab_fields.getComponent('user_name_textfield_id').value,
								meftpUserenabled:	userTab_fields.getComponent('user_enabled_checkbox_id').value,
								meftpUserPassword	:	userTab_fields.getComponent('user_password_textfield_id').value,
								meftpUserAutoPass	:	userTab_fields.getComponent('user_autopass_checkbox_id').value,
								meftpUserEmail	:	userTab_fields.getComponent('user_email_textfield_id').value,
								meftpUserWritePermission: userTab_fields.getComponent('user_writeperm_checkboxfield_id').value,
								meftpUserExpirationDate	:	Ext.Date.format(userTab_fields.getComponent('expired_date_datefield_id').getValue(),'Y-m-d'),
								meftpUserSubgroupid		:	1,//userTab_fields.getComponent('user_subgroups_combo_id').value,
								meftpUserComents:	userTab_fields.getComponent('user_comments_textfield_id').value,
								meftpEmailNotification	:	userTab_fields.getComponent('user_emailnoti_checkboxfield_id').value
							},
							waitMsg : Ext.MessageBox.show({
								id : 'wait_message_win',
								msg : 'Saving your data, please wait...',
								progressText : 'Saving...',
								width : 300,
								wait : true,
								interval : 1,
								icon : 'ext-mb-download'
							}),
							success : function() {
								var name = userTab_fields.getComponent('user_login_textfield_id').value;
								var r = Ext.getCmp('user_fields_id');
								r.up('form').getForm().reset();
								userStore.load({params:{
									total		:	50000,
									comboValue	:	3,
									textValues	:	name
									}
								});
								Ext.getCmp('cancel_addaction_id').hide();
								Ext.getCmp('save_user_id').hide();
								Ext.getCmp('add_user_id').enable();
								Ext.getCmp('search_fieldset_id').enable();
								Ext.getCmp('user_fields_id').disable();
								
								userTab_search.getComponent('date_from_datefield_id').disable();
								userTab_search.getComponent('date_to_datefield_id').disable();
								userTab_search.getComponent('criteria_search_combo_id').enable();
								userTab_search.getComponent('search_text_textfield_id').enable();
								userTab_search.getComponent('user_search_button_id').enable();
								
								Ext.MessageBox.close();
								Ext.example.msg('Done', name +' '+'User has been Saved');
							}
						});
					}
				}else{
					Ext.example.msg('Cancel', 'Save New User Action Canceled!!!');
				}
			}
		});
	},
	
	_onClickSaveChangesButton:function(){
		Ext.Msg.show({
			title: 'Save',
			msg : 'Wanna Save Changes?.',
			buttons : Ext.Msg.YESNO,
			icon : 'ext-mb-saveuser',
			fn : function(btn) {
				if (btn == 'yes') {
					var r = Ext.getCmp('user_fields_id');
					var nameChange = userTab_fields.getComponent('user_name_textfield_id').value;
					if (r.up('form').getForm().isValid() == true) {
						Ext.Ajax.request({
							url : 'meftpUsersActions/edit.action',
							method : 'POST',
							params:{
								meftpUserId		:	userTab_fields.getComponent('user_id_displayfield_id').value,
								meftpUserLogin	:  	userTab_fields.getComponent('user_login_textfield_id').value,
								meftpUserName	:	userTab_fields.getComponent('user_name_textfield_id').value,
								meftpUserenabled:	userTab_fields.getComponent('user_enabled_checkbox_id').value,
								meftpUserPassword	:	userTab_fields.getComponent('user_password_textfield_id').value,
								meftpUserAutoPass	:	userTab_fields.getComponent('user_autopass_checkbox_id').value,
								meftpUserEmail	:	userTab_fields.getComponent('user_email_textfield_id').value,
								meftpUserWritePermission: userTab_fields.getComponent('user_writeperm_checkboxfield_id').value,
								meftpUserExpirationDate	:	Ext.Date.format(userTab_fields.getComponent('expired_date_datefield_id').getValue(),'Y-m-d'),
								meftpUserSubgroupid		:	1,//userTab_fields.getComponent('user_subgroups_combo_id').value,
								meftpUserComents:	userTab_fields.getComponent('user_comments_textfield_id').value,
								meftpEmailNotification	:	userTab_fields.getComponent('user_emailnoti_checkboxfield_id').value
							},
							waitMsg : Ext.MessageBox.show({
								id : 'wait_message_win',
								msg : 'Saving your data, please wait...',
								progressText : 'Saving...',
								width : 300,
								wait : true,
								interval : 1,
								icon : 'ext-mb-download'
							}),
							success : function() {
								var name = userTab_fields.getComponent('user_login_textfield_id').value;
								var r = Ext.getCmp('user_fields_id');
								r.up('form').getForm().reset();
								userStore.load({params:{
									total		:	50000,
									comboValue	:	3,
									textValues	:	name
									}
								});
								Ext.getCmp('cancel_addaction_id').hide();
								Ext.getCmp('save_user_id').hide();
								Ext.getCmp('add_user_id').enable();
								Ext.getCmp('user_fields_id').disable();
								Ext.getCmp('search_fieldset_id').enable();
								
								userTab_search.getComponent('date_from_datefield_id').disable();
								userTab_search.getComponent('date_to_datefield_id').disable();
								userTab_search.getComponent('criteria_search_combo_id').enable();
								userTab_search.getComponent('search_text_textfield_id').enable();
								userTab_search.getComponent('user_search_button_id').enable();
								Ext.MessageBox.close();
								Ext.example.msg('Done', nameChange+'\'s '+'data has been changed');
							}
						});
					}
				}else{
					Ext.example.msg('Cancel', 'Save User Changes Canceled!!!');
				}
			}
		});
	},
	
	_onClickDeleteButton:function(){
			Ext.Msg.show({
				title : 'Confirm',
				msg : 'are you sure want to DELETE?',
				buttons : Ext.Msg.YESNO,
				icon : 'ext-mb-delete',
				fn : function(btn) {
					if (btn == 'yes') {
							var nomDelete = userTab_fields.getComponent('user_name_textfield_id').value
							Ext.Ajax.request({
								url : 'meftpUsersActions/delete.action',
								method : 'POST',
								params:{
									meftpUserId		:	userTab_fields.getComponent('user_id_displayfield_id').value,
									meftpUserName	:	userTab_fields.getComponent('user_name_textfield_id').value
								},
								success : function() {
									userStore.load();
									var r = Ext.getCmp('user_fields_id');
									r.up('form').getForm().reset();
									r.disable();
									
									Ext.getCmp('cancel_action_id').hide();
									Ext.getCmp('save_changes_id').hide();
									Ext.getCmp('delete_user_id').hide();
									Ext.getCmp('add_user_id').enable();
									
									userTab_search.getComponent('date_from_datefield_id').disable();
									userTab_search.getComponent('date_to_datefield_id').disable();
									userTab_search.getComponent('criteria_search_combo_id').enable();
									userTab_search.getComponent('search_text_textfield_id').enable();
									userTab_search.getComponent('user_search_button_id').enable();
									Ext.example.msg('Done', 'You Delete\t' + nomDelete + '\t' + 'user');
								}
							});
					} else {
						Ext.example.msg('Cancel', 'Delete Action Canceled!!!');
					}
				}
			});
	},
	
	_onClickAddContactButton	:	function(){
		var winContact;
		if(!winContact){
			winContact = Ext.create('Ext.window.Window',{
				title		:	'Add Contact',
				id			:	'window_contact_id',
				itemId		:	'window_contact_windows_id',
				width		:	1010,
				height		:	570,
				modal		:	true,
				resizable	: 	false,
				constrain	: 	true,
				plain		: 	true,
				border		: 	false,
				//maximizable	:	true,
				items		:	[
				     		 	 {
				     		 		 xtype		:	'form',
				     		 		 layout		:	'absolute',
				     		 		 id			:	'panel_addcontacts_id',
				     		 		 width		:	'100%',
				     		 		 height		:	'100%',
				     		 		 autoScroll	:	true,
				     		 		 bodyPadding	:	10,
				     		 		 items		:	[{
				     		 			xtype		:	'meftpcontactssearch' 
				     		 		 },{
				     		 			xtype 		:	'usercontactslist'
				     		 		 },{
				     		 			 xtype		:	'contactslistuser'
				     		 		 },{
				     		 			 xtype		:	'contactsbuttons'
				     		 		 }
				     		 		      		 	 ]
				     		 	 }
				     		 	 ]
			}).show();
			
		}
	}
});           