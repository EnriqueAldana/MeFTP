Ext.define('Ext.ux.MeFTP.UsersTab.UsersFields',{
	extend		:	'Ext.form.FieldSet',
	id			:	'user_fields_id',
	itemId		:	'user_fields_setfield_id',
	disabled	:	true,
	alias		:	'widget.usersfields',
	x			:	580,
	y			:	60,
	height		: 	387,
	width		: 	460,
	layout		:	'absolute',
	title		:	'User Information',
	initComponent	:	function(){
		Ext.apply(this,{
			items		:	[
			     		 	 Ext.apply({
			     		 		 xtype		:	'displayfield',
			     		 		 fieldLabel	:	'User Id',
			     		 		 name		:	'meftpUsersUserid',//test
			     		 		 id			:	'user_id_id',
			     		 		 itemId		:	'user_id_displayfield_id',
			     		 		 width		:	350,
			     		 		 x			:	10
			     		 	 },this.userIdDisplayField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'User Log In',
			     		 		 name		:	'meftpUsersUsernamelogin',
			     		 		 id			:	'user_login_id',
			     		 		 itemId		:	'user_login_textfield_id',
			     		 		 emptyText	:	'User Login',
			     		 		 msgTarget	: 	'side',
			     		 		 allowBlank	:	false,
			     		 		 width		:	350,
			     		 		 x			:	10,
			     		 		 y			:	30
			     		 	 },this.userLoginTextField),
			     		 	 
			     		 	Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'User Name',
			     		 		 name		:	'meftpUsersUsername',
			     		 		 id			:	'user_name_id',
			     		 		 itemId		:	'user_name_textfield_id',
			     		 		 emptyText	:	'User Name',
			     		 		 msgTarget	: 	'side',
			     		 		 allowBlank	:	false,
			     		 		 width		:	350,
			     		 		 x			:	10,
			     		 		 y			:	60
			     		 	 },this.nameUserTextField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'checkboxfield',
			     		 		 fieldLabel	:	'Enabled',
			     		 		 id			:	'user_enabled_id',
			     		 		 itemId		:	'user_enabled_checkbox_id',
			     		 		 checked	:	true,
			     		 		 labelPad	:	100,
			     		 		 x			:	10,
			     		 		 y			:	90
			     		 	 },this.enabledCheckBox),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'datefield',
			     		 		 fieldLabel	:	'Expired Date',
			     		 		 id			:	'expired_date_id',
			     		 		 itemId		:	'expired_date_datefield_id',
			     		 		 emptyText	:	'Select Date',
			     		 		 msgTarget	: 	'side',
			     		 		 allowBlank	:	false,
			     		 		 width		:	350,
			     		 		 x			:	10,
			     		 		 y			:	120
			     		 	 },this.dateExpiredDateField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'combo',
			     		 		 fieldLabel	:	'Groups',
			     		 		 id			:	'user_groups_id',
			     		 		 itemId		:	'user_groups_combo_id',
			     		 		 emptyText	:	'Select a Group',
			     		 		 msgTarget	:	'side',
			     		 		 allowBlank	:	false,
			     		 		 editable	:	false,
			     		 		 store		:	groupUserOptions,
			     		 		 valueField	: 	'meftpGroupsGroupid',//Propiedades
						    	 displayField	: 'meftpGroupsGroupname',
			     		 		 width		:	350,
			     		 		 x			:	10,
			     		 		 y			:	150,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 select		:	this._onClickGroups
			     		 		 }
			     		 	 },this.groupsCombo),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'combo',
			     		 		 fieldLabel	:	'Subgroups',
			     		 		 id			:	'user_subgroups_id',
			     		 		 itemId		:	'user_subgroups_combo_id',
			     		 		 emptyText	:	'Select a Subgroup',
			     		 		 msgTarget	:	'side',
			     		 		 disabled	:	true,
			     		 		 allowBlank	:	true,
			     		 		 editable	:	false,
			     		 		 valueField	: 	'meftpSubgroupsSubgroupid',//Propiedades
						    	 displayField	: 'meftpSubgroupsSubgroupname',
			     		 		 store		:	subgroupUserOptions,
			     		 		 width		:	350,
			     		 		 x			:	10,
			     		 		 y			:	180
			     		 	 },this.subgroupsCombo),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'Password',
			     		 		 id			:	'user_password_id',
			     		 		 itemId		:	'user_password_textfield_id',
			     		 		 name		:	'meftpUsersUserpassword',
			     		 		 emptyText	:	'User Password',
			     		 		 msgTarget	:	'side',
			     		 		 //allowBlank	:	false,
			     		 		 disabled	:	true,
			     		 		 width		:	250,
			     		 		 x			:	10,
			     		 		 y			:	210
			     		 	 },this.passwordTextField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'checkboxfield',
			     		 		 boxLabel	:	'Auto',
			     		 		 id			:	'user_autopass_id',
			     		 		 itemId		:	'user_autopass_checkbox_id',
			     		 		 checked	:	true,
			     		 		 x			:	320,
			     		 		 y			:	210,
			     		 		 handler	:	function(){
			     		 			var passTrue = userTab_fields.getComponent('user_autopass_checkbox_id').value;
			     					if (passTrue == true){
			     						userTab_fields.getComponent('user_password_textfield_id').disable();
			     					}else{
			     						userTab_fields.getComponent('user_password_textfield_id').enable();
			     					}
			     		 		 }
			     		 	 },this.autoCheckBox),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'Email Address',
			     		 		 id			:	'user_email_id',
			     		 		 itemId		:	'user_email_textfield_id',
			     		 		 name		:	'meftpUsersUseremailaddress',
			     		 		 emptyText	:	'User Email Address',
			     		 		 msgTarget	:	'side',
			     		 		 allowBlank	:	false,
			     		 		 width		:	350,
			     		 		 x			:	10,
			     		 		 y			:	240
			     		 	 },this.emailAddressTextField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'checkboxfield',
			     		 		 fieldLabel	:	'Write Permission',
			     		 		 id			:	'user_writeperm_id',
			     		 		 itemId		:	'user_writeperm_checkboxfield_id',
			     		 		 checked	:	true,
			     		 		 labelPad	:	50,
			     		 		 labelWidth	:	150,
			     		 		 x			:	10,
			     		 		 y			:	270
			     		 	 },this.writePermissionCheckBox),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'checkboxfield',
			     		 		 fieldLabel	:	'Email Notification',
			     		 		 id			:	'user_emailnoti_id',
			     		 		 itemId		:	'user_emailnoti_checkboxfield_id',
			     		 		 checked	:	true,
			     		 		 labelPad	:	50,
			     		 		 labelWidth	:	150,
			     		 		 x			:	10,
			     		 		 y			:	300
			     		 	 },this.emailNotificationCheckBox),
			     		 	 
			     		 	 Ext.apply({
			     		 	     xtype		:	'textfield',
			     		 		 fieldLabel	:	'Comments',
			     		 		 id			:	'user_comments_id',
			     		 		 itemId		:	'user_comments_textfield_id',
			     		 		 name		:	'meftpUsersUsercomments',
			     		 		 emptyText	:	'User Comments',
			     		 		 x			:	10,
			     		 		 y			:	330
			     		 	 },this.commentsTextArea)
			     		 	 ]
		});
		Ext.ux.MeFTP.UsersTab.UsersFields.superclass.initComponent.call(this);
	},
	_onClickGroups	:	function(){	
		Ext.getCmp('user_subgroups_id').enable();
		//groupUserOptions.load();
		var val = Ext.getCmp('user_groups_id').getValue();
		subgroupUserOptions.load({
			params:{
					comboValuesg	:	1,
					textValuessg	:	"*"
			}
		});
		
	}
});           