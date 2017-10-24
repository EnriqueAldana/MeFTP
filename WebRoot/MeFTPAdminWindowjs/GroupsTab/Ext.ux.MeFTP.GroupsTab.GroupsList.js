Ext.define('Ext.ux.MeFTP.GroupsTab.GroupsList',{
	extend		:	'Ext.form.FieldSet',
	alias		:	'widget.groupsList',
	id			:	'groups_list_id',
	itemId		:	'groups_list_fieldset_id',
	title		:	'Groups List',
	height		: 	477,
	width		:	560,
	x			:	10,
	y			:	60,
	initComponent	:	function(){
		
		Ext.apply(this,{
			items		:	[
			     		 	 Ext.apply({
			     		 		 xtype		:	'gridpanel',
			     		 		 autoscroll	:	true,
			     		 		 itemId		:	'groups_list_grid_id',
			     		 		 x			:	0,
			     		 		 y			:	0,
			     		 		 height		:	437,
			     		 		 width		:	535,
			     		 		/* verticalScroller:{
			     		 			 xtype		:	'paginggridscroller'
			     		 		 },
			     		 		 invalidateScrollerOnRefresh	:	false,
			     		 		 viewConfig		:	{
			     		 			 trackOver		:	false
			     		 		 },*/
			     		 		 loadMask	:	true,
			     		 		 columns	:	[{
			     			    	xtype 		: 	'gridcolumn',
			     			    	dataIndex 	: 	'meftpGroupsGroupid',
			     			    	text 		:	'Group Id'
			     				}, {
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpGroupsGroupname',
			     					text 		: 	'Group Name'
			     				}, {
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpGroupsGroupdescription',
			     					text 		: 	'Group Description'
			     				}, {
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpGroupsGroupenable',
			     					text 		: 	'Group Enable'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpGroupsGroupexpireddate',
			     					text 		: 	'Group Expired Date'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpGroupsGroupemail',
			     					text 		: 	'Group E-Mail'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpGroupsEmailnotification',
			     					text 		: 	'Group E-Mail Notification'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpGroupsCreatedate',
			     					text 		: 	'Group Created Date'
			     				},{
			     					xtype		:	'gridcolumn',
			     					dataIndex	:	'meftpGroupsGroupcomments',
			     					text		:	'GroupComments'
			     				}
			     				],
			     		 		store		:	groupStore,
			     		 		listeners	:	{
			     		 			scope		:	this,
			     		 			selectionchange : this._onClickSelectDataGroups
			     		 		}
			     		 },this.subgroupListGrid)
			   ]
		});
		
		Ext.ux.MeFTP.GroupsTab.GroupsList.superclass.initComponent.call(this);
		
	},
	
	_onClickSelectDataGroups	:	function(model, records){
		if (records[0]) {
			this.up('form').getForm().loadRecord(records[0]);
			Ext.getCmp('groups_fields_id').enable();
			
			groupTab_search.getComponent('groups_search_button_id').disable();
			groupTab_search.getComponent('groupsdate_from_datefield_id').disable();
			groupTab_search.getComponent('groupsdate_to_datefield_id').disable();
			groupTab_search.getComponent('groupscriteria_combo_search_id').disable();
			groupTab_search.getComponent('groupssearch_text_textfield_id').disable();
			
			groupTab_buttons.getComponent('delete_group_button_id').show();
			groupTab_buttons.getComponent('save_changesgroup_button_id').show();
			groupTab_buttons.getComponent('add_group_button_id').show();
			groupTab_buttons.getComponent('cancel_groupaction_button_id').show();
			groupTab_buttons.getComponent('cancel_addgroupaction_button_id').hide();
		}
		
	}
});           