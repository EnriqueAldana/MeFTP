Ext.define('Ext.ux.MeFTP.GroupsTab.GroupsFields',{
	extend		:	'Ext.form.FieldSet',
	id			:	'groups_fields_id',
	itemId		:	'groups_fields_setfield_id',
	disabled	:	true,
	alias		:	'widget.groupsfields',
	x			:	580,
	y			:	60,
	height		: 	387,
	width		: 	460,
	layout		:	'absolute',
	title		:	'Group Information',
	initComponent	:	function(){
		Ext.apply(this,{
			items		:	[
			     		 	 Ext.apply({
			     		 		 xtype		:	'displayfield',
			     		 		 fieldLabel	:	'Group Id',
			     		 		 name		:	'meftpGroupsGroupid',//test
			     		 		 id			:	'group_id_id',
			     		 		 itemId		:	'group_id_displayfield_id',
			     		 		 labelWidth	:	150,
			     		 		 width		:	350,
			     		 		 x			:	10
			     		 	 },this.groupIdDisplayField),
			     		 	 
			     		 	Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'Group Name',
			     		 		 name		:	'meftpGroupsGroupname',
			     		 		 id			:	'group_name_id',
			     		 		 itemId		:	'group_name_textfield_id',
			     		 		 emptyText	:	'Group Name',
			     		 		 msgTarget	: 	'side',
			     		 		 allowBlank	:	false,
			     		 		 labelWidth	:	150,
			     		 		 width		:	350,
			     		 		 x			:	10,
			     		 		 y			:	40
			     		 	 },this.nameGroupTextField),

				     		 Ext.apply({
				     		 	 xtype		:	'textfield',
				     		 	 fieldLabel	:	'Group Description',
				     		 	 name		:	'meftpGroupsGroupdescription',
				     		 	 id			:	'group_desc_id',
				     		 	 itemId		:	'group_desc_textfield_id',
				     		 	 emptyText	:	'Group Description',
				     		 	 msgTarget	: 	'side',
				     		 	 allowBlank	:	false,
				     		 	 labelWidth	:	150,
				     		 	 width		:	350,
				     		 	 x			:	10,
				     		 	 y			:	70
				     		 },this.groupDescriptionTextField),
				     		 			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'checkboxfield',
			     		 		 fieldLabel	:	'Enabled',
			     		 		 id			:	'group_enabled_id',
			     		 		 itemId		:	'group_enabled_checkbox_id',
			     		 		 checked	:	true,
			     		 		 labelPad	:	100,
			     		 		 x			:	10,
			     		 		 y			:	100
			     		 	 },this.groupEnabledCheckBox),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'datefield',
			     		 		 fieldLabel	:	'Expired Date',
			     		 		 id			:	'groupexpired_date_id',
			     		 		 itemId		:	'groupexpired_date_datefield_id',
			     		 		 emptyText	:	'Select Date',
			     		 		 msgTarget	: 	'side',
			     		 		 editable	:	false,
			     		 		 allowBlank	:	false,
			     		 		 width		:	350,
			     		 		 labelWidth	:	150,
			     		 		 x			:	10,
			     		 		 y			:	130
			     		 	 },this.groupDateExpiredDateField),
			     		 	 		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'Email Address',
			     		 		 id			:	'group_email_id',
			     		 		 itemId		:	'group_email_textfield_id',
			     		 		 name		:	'meftpGroupsGroupemail',
			     		 		 emptyText	:	'Group Email Address',
			     		 		 msgTarget	:	'side',
			     		 		 allowBlank	:	false,
			     		 		 labelWidth	:	150,
			     		 		 width		:	350,
			     		 		 x			:	10,
			     		 		 y			:	180
			     		 	 },this.groupEmailAddressTextField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'checkboxfield',
			     		 		 fieldLabel	:	'Email Notification',
			     		 		 id			:	'group_emailnoti_id',
			     		 		 itemId		:	'group_emailnoti_checkboxfield_id',
			     		 		 checked	:	true,
			     		 		 labelPad	:	50,
			     		 		 labelWidth	:	150,
			     		 		 x			:	10,
			     		 		 y			:	210
			     		 	 },this.groupEmailNotificationCheckBox),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'Comments',
			     		 		 id			:	'group_comments_id',
			     		 		 itemId		:	'group_comments_textfield_id',
			     		 		 name		:	'meftpGroupsGroupemail',
			     		 		 emptyText	:	'Group Comments',
			     		 		 msgTarget	:	'side',
			     		 		 allowBlank	:	false,
			     		 		 labelWidth	:	150,
			     		 		 width		:	350,
			     		 		 x			:	10,
			     		 		 y			:	240
			     		 	 },this.groupCommentsTextField)/*,
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'multiselect',
			     		 		 fieldLabel	:	'Subgroups',
			     		 		 id			:	'groups_subgroups_id',
			     		 		 itemId		:	'groups_subgroups_multiselect_id',
			     		 		 name		:	'multiselect',
			     		 		 msgTarget	:	'side',
			     		 		 allowBlank	:	false,
			     		 		 labelWidth	:	150,
			     		 		 store		:	groupCriteriaOptions,
			     		 		 width		:	350,
			     		 		 height		:	200,
			     		 		 x			:	10,
			     		 		 y			:	270
			     		 	 },this.multiselectText)*/
			     		 	 
			     		 	 ]
		});
		Ext.ux.MeFTP.GroupsTab.GroupsFields.superclass.initComponent.call(this);
	}
	
});                               