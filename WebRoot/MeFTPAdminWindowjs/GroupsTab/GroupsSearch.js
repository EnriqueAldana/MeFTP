var groupTab_search 	= Ext.create('Ext.ux.MeFTP.UsersTab.Search',{
	id		:	'group_search_id',
	itemId	:	'group_search_fieldset_id',
	title	:	'Group Search',
	
	comboCriteriaSearch		:	{
		id		:	'groupscriteria_search_id',
		itemId	:	'groupscriteria_combo_search_id',
		store	:	groupCriteriaOptions,
		listeners	:	{
			scope		:	this,
			select		:	function(){
				var combo = Ext.getCmp('groupscriteria_search_id');
				var val = combo.getValue();
				if (val == 7 || val == 8) {
					Ext.getCmp('groupsdate_from_id').enable();
					Ext.getCmp('groupsdate_to_id').enable();
					Ext.getCmp('groupssearch_text_id').disable();
				} else {
					Ext.getCmp('groupsdate_from_id').disable();
					Ext.getCmp('groupsdate_to_id').disable();
					Ext.getCmp('groupssearch_text_id').enable();
				}
			}
		}
		
	},
	
	textfieldTextSearch		:	{
		 id			:	'groupssearch_text_id',
 		 itemId		:	'groupssearch_text_textfield_id'	
	},
	
	datefieldFromSearch		:	{
		id			:	'groupsdate_from_id',
	 	itemId		:	'groupsdate_from_datefield_id',
	 	vtype		:	'daterange',
	 	endDateField	:	'groupsdate_to_datefield_id'
	},
	
	datefieldToSearch		:	{
		id			:	'groupsdate_to_id',
		itemId		:	'groupsdate_to_datefield_id',
		vtype		:	'daterange',
		startDateField	:	'groupsdate_from_datefield_id'
	},
	
	buttonOptionSearch		:	{
		id			:	'groups_option_id',
 		itemId		:	'groups_search_button_id',
 		tooltip		:	'Execute Search',
 		listeners	:	{
 			scope		:	this,
 			click		:	function(){
	
 				var valuetextg = Ext.getCmp('groupssearch_text_id').getValue();
 				var cmbg = Ext.getCmp('groupscriteria_search_id').getValue();
 				if(cmbg == 7 || cmbg == 8){
 					groupStore.load({params:{
 						total		:	50000,
 						comboValueg	:	cmbg,
 						date1g		:	Ext.Date.format(Ext.getCmp('groupsdate_from_id').getValue(),'Y-m-d'),
 						date2g		:	Ext.Date.format(Ext.getCmp('groupsdate_to_id').getValue(),'Y-m-d')
 						}
 					});
 				}else if(valuetextg != null){
 					groupStore.load({params:{
 						total		:	50000,
 						comboValueg	:	cmbg,
 						textValuesg	:	valuetextg
 						}
 					});
 				}
 				 else{
 					alert('Wrong Option');
 				}
 			}
	
 		}
	}
	
});            