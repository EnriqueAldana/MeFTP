Ext.define('Ext.ux.MeFTP.SubgroupsTab.SubgroupsFields',{
	extend		:	'Ext.form.FieldSet',
	id			:	'subgroups_fields_id',
	itemId		:	'subgroups_fields_setfield_id',
	disabled	:	true,
	alias		:	'widget.subgroupsfields',
	x			:	580,
	y			:	60,
	height		: 	387,
	width		: 	460,
	layout		:	'absolute',
	title		:	'Subgroup Information',
	initComponent	:	function(){
		Ext.apply(this,{
			items		:	[
			     		 	 Ext.apply({
			     		 		 xtype		:	'displayfield',
			     		 		 fieldLabel	:	'Subgroup Id',
			     		 		 name		:	'meftpSubgroupsSubgroupid',//test
			     		 		 id			:	'subgroup_id_id',
			     		 		 itemId		:	'subgroup_id_displayfield_id',
			     		 		 labelWidth	:	150,
			     		 		 width		:	350,
			     		 		 x			:	10
			     		 	 },this.subgroupIdDisplayField),
			     		 	 
			     		 	Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'Subgroup Name',
			     		 		 name		:	'meftpSubgroupsSubgroupname',
			     		 		 id			:	'subgroup_name_id',
			     		 		 itemId		:	'subgroup_name_textfield_id',
			     		 		 emptyText	:	'Subgroup Name',
			     		 		 msgTarget	: 	'side',
			     		 		 allowBlank	:	false,
			     		 		 labelWidth	:	150,
			     		 		 width		:	350,
			     		 		 x			:	10,
			     		 		 y			:	50
			     		 	 },this.nameSubgroupTextField),

				     		 Ext.apply({
				     		 	 xtype		:	'textfield',
				     		 	 fieldLabel	:	'Subgroup Description',
				     		 	 name		:	'meftpSubgroupsMeftpsubgroupdescription',
				     		 	 id			:	'subgroup_desc_id',
				     		 	 itemId		:	'subgroup_desc_textfield_id',
				     		 	 emptyText	:	'Subgroup Description',
				     		 	 msgTarget	: 	'side',
				     		 	 allowBlank	:	false,
				     		 	 labelWidth	:	150,
				     		 	 width		:	350,
				     		 	 x			:	10,
				     		 	 y			:	90
				     		 },this.subgroupDescriptionTextField),
				     		 			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'checkboxfield',
			     		 		 fieldLabel	:	'Enabled',
			     		 		 id			:	'subgroup_enabled_id',
			     		 		 itemId		:	'subgroup_enabled_checkbox_id',
			     		 		 checked	:	true,
			     		 		 labelPad	:	100,
			     		 		 x			:	10,
			     		 		 y			:	140
			     		 	 },this.subgroupEnabledCheckBox),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'datefield',
			     		 		 fieldLabel	:	'Expired Date',
			     		 		 id			:	'subgroupexpired_date_id',
			     		 		 itemId		:	'subgroupexpired_date_datefield_id',
			     		 		 emptyText	:	'Select Date',
			     		 		 msgTarget	: 	'side',
			     		 		 name		:	'meftpSubgroupsSubgroupexpiredate',
			     		 		 editable	:	false,
			     		 		 allowBlank	:	false,
			     		 		 width		:	350,
			     		 		 labelWidth	:	150,
			     		 		 x			:	10,
			     		 		 y			:	170
			     		 	 },this.subgroupDateExpiredDateField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'combo',
			     		 		 fieldLabel	:	'Groups',
			     		 		 id			:	'subgroups_groups_id',
			     		 		 itemId		:	'subgroups_groups_combo_id',
			     		 		 emptyText	:	'Select a Group',
			     		 		 msgTarget	:	'side',
			     		 		 allowBlank	:	false,
			     		 		 editable	:	false,
			     		 		 store		:	groupUserOptions,
			     		 		 valueField	: 	'meftpGroupsGroupid',//Propiedades
						    	 displayField	: 'meftpGroupsGroupname',
			     		 		 width		:	350,
			     		 		 labelWidth	:	150,
			     		 		 x			:	10,
			     		 		 y			:	200
			     		 	 },this.comboGroups),
			     		 	 		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 fieldLabel	:	'Email Address',
			     		 		 id			:	'subgroup_email_id',
			     		 		 itemId		:	'subgroup_email_textfield_id',
			     		 		 name		:	'meftpSubgroupsSubgroupemail',
			     		 		 emptyText	:	'Subgroup Email Address',
			     		 		 msgTarget	:	'side',
			     		 		 allowBlank	:	false,
			     		 		 labelWidth	:	150,
			     		 		 width		:	350,
			     		 		 x			:	10,
			     		 		 y			:	240
			     		 	 },this.subgroupEmailAddressTextField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'checkboxfield',
			     		 		 fieldLabel	:	'Email Notification',
			     		 		 id			:	'subgroup_emailnoti_id',
			     		 		 itemId		:	'subgroup_emailnoti_checkboxfield_id',
			     		 		 checked	:	true,
			     		 		 labelPad	:	50,
			     		 		 labelWidth	:	150,
			     		 		 x			:	10,
			     		 		 y			:	280
			     		 	 },this.subgroupEmailNotificationCheckBox),
			     		 	 
			     		 	 Ext.apply({
			     		 	     xtype		:	'textfield',
			     		 		 fieldLabel	:	'Comments',
			     		 		 id			:	'subgroup_comments_id',
			     		 		 itemId		:	'subgroup_comments_textfield_id',
			     		 		 name		:	'meftpSubgroupsSubgroupcomments',
			     		 		 emptyText	:	'Subgroup Comments',
			     		 		 labelWidth	:	150,
			     		 		 x			:	10,
			     		 		 y			:	320
			     		 	 },this.subgroupCommentsTextArea)
			     		 	 ]
		});
		Ext.ux.MeFTP.SubgroupsTab.SubgroupsFields.superclass.initComponent.call(this);
	}	
});                    