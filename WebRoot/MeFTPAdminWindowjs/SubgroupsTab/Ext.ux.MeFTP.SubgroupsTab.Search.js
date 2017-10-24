var subgroupTab_search 		= Ext.create('Ext.ux.MeFTP.UsersTab.Search',{
	id		:	'subgroup_search_id',
	itemId	:	'subgroup_search_fieldset_id',
	title	:	'Subgroup Search',
	
	comboCriteriaSearch		:	{
		id		:	'subgroupscriteria_search_id',
		itemId	:	'subgroupscriteria_combo_search_id',
		store	:	subgroupCriteriaOptions,
		listeners	:	{
			scope		:	this,
			select		:	function(){
				var combo = Ext.getCmp('subgroupscriteria_search_id');
				var val = combo.getValue();
				if (val == 8 || val == 9) {
					Ext.getCmp('subgroupsdate_from_id').enable();
					Ext.getCmp('subgroupsdate_to_id').enable();
					Ext.getCmp('subgroupssearch_text_id').disable();
				} else {
					Ext.getCmp('subgroupsdate_from_id').disable();
					Ext.getCmp('subgroupsdate_to_id').disable();
					Ext.getCmp('subgroupssearch_text_id').enable();
				}
			}
		}
		
	},
	
	textfieldTextSearch		:	{
		 id			:	'subgroupssearch_text_id',
 		 itemId		:	'subgroupssearch_text_textfield_id'	
	},
	
	datefieldFromSearch		:	{
		id			:	'subgroupsdate_from_id',
	 	itemId		:	'subgroupsdate_from_datefield_id',
	 	vtype		:	'daterange',
	 	endDateField	:	'subgroupsdate_to_datefield_id'
	},
	
	datefieldToSearch		:	{
		id			:	'subgroupsdate_to_id',
		itemId		:	'subgroupsdate_to_datefield_id',
		vtype		:	'daterange',
		startDateField	:	'subgroupsdate_from_datefield_id'
	},
	
	buttonOptionSearch		:	{
		id			:	'subgroups_option_id',
 		itemId		:	'subgroups_search_button_id',
 		tooltip		:	'Execute Search',
 		listeners	:	{
 			scope		:	this,
 			click		:	function(){
	
 				var valuetextssg = Ext.getCmp('subgroupssearch_text_id').getValue();
 				var cmbssg = Ext.getCmp('subgroupscriteria_search_id').getValue();
 				if(cmbssg == 8 || cmbssg == 9){
 					subgroupStore.load({params:{
 						total		:	50000,
 						comboValuesg	:	cmbssg,
 						date1sg		:	Ext.Date.format(Ext.getCmp('subgroupsdate_from_id').getValue(),'Y-m-d'),
 						date2sg		:	Ext.Date.format(Ext.getCmp('subgroupsdate_to_id').getValue(),'Y-m-d')
 						}
 					});
 				}else if(valuetextssg != null){
 					subgroupStore.load({params:{
 						total		:	50000,
 						comboValuesg	:	cmbssg,
 						textValuessg	:	valuetextssg
 						}
 					});
 				}
 				 else{
 					Ext.Message();
 				}
 			}
	
 		}
	}
	
}); 