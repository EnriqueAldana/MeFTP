Ext.define('Ext.ux.MeFTP.SubgroupsTab.SubgroupsList',{
	extend		:	'Ext.form.FieldSet',
	alias		:	'widget.subgroupsList',
	id			:	'subgroups_list_id',
	itemId		:	'subgroups_list_fieldset_id',
	title		:	'Subgroups List',
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
			     		 		 itemId		:	'subgroups_list_grid_id',
			     		 		 x			:	0,
			     		 		 y			:	0,
			     		 		 height		:	437,
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
			     			    	dataIndex 	: 	'meftpSubgroupsSubgroupid',
			     			    	text 		:	'Subgroup Id'
			     				}, {
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpSubgroupsSubgroupname',
			     					text 		: 	'Subgroup Name'
			     				}, {
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpSubgroupsMeftpsubgroupdescription',
			     					text 		: 	'Subgroup Description'
			     				}, {
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpSubgroupsSubgroupenable',
			     					text 		: 	'Subgroup Enable'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpSubgroupsSubgroupexpiredate',
			     					text 		: 	'Subgroup Expired Date'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpSubgroupsSubgroupemail',
			     					text 		: 	'Subgroup E-Mail'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpSubgroupsSubgroupemailnotification',
			     					text 		: 	'Subgroup E-Mail Notification'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpSubgroupsSubgroupcomments',
			     					text 		: 	'Subgroup Comments'
			     				},{
			     					xtype 		: 	'gridcolumn',
			     					dataIndex 	: 	'meftpSubgroupsSubgroupcreateddate',
			     					text 		: 	'Subgroup Create Date'
			     				}
			     				],
			     		 		store		:	subgroupStore,
			     		 		listeners	:	{
			     		 			scope		:	this,
			     		 			selectionchange : this._onClickSelectDataSubgroups
			     		 		}
			     		 },this.subgroupListGrid)
			   ]
		});
		
		Ext.ux.MeFTP.SubgroupsTab.SubgroupsList.superclass.initComponent.call(this);
		
	},
	
	_onClickSelectDataSubgroups	:	function(model, records){
		if (records[0]) {
			this.up('form').getForm().loadRecord(records[0]);
			Ext.getCmp('subgroups_fields_id').enable();
			
			subgroupTab_search.getComponent('subgroups_search_button_id').disable();
			subgroupTab_search.getComponent('subgroupsdate_from_datefield_id').disable();
			subgroupTab_search.getComponent('subgroupsdate_to_datefield_id').disable();
			subgroupTab_search.getComponent('subgroupscriteria_combo_search_id').disable();
			subgroupTab_search.getComponent('subgroupssearch_text_textfield_id').disable();
			
			subgroupTab_buttons.getComponent('delete_subgroup_button_id').show();
			subgroupTab_buttons.getComponent('save_changessubgroup_button_id').show();
			subgroupTab_buttons.getComponent('add_subgroup_button_id').show();
			subgroupTab_buttons.getComponent('cancel_subgroupaction_button_id').show();
			subgroupTab_buttons.getComponent('cancel_addsubgroupaction_button_id').hide();
		}
		
	}
});           