Ext.define('Ext.ux.MeFTP.SubgroupsTab.SubgroupsButtons',{
	extend		:	'Ext.form.FieldSet',
	id			:	'subgroups_options_id',
	itemId		:	'subgroups_options_fieldset_id',
	alias		:	'widget.subgroupsbuttons',
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
			     		 		 id			:	'add_subgroup_id',
			     		 		 itemId		:	'add_subgroup_button_id',
			     		 		 text		:	'Add',
			     		 		 tooltip	:	'Add Subgroup',
			     		 		 iconCls	:	'addGroup',
			     		 		 scale		:	'medium',
			     		 		 iconAlign	:	'left',
			     		 		 width		:	80,
			     		 		 height		:	35,
			     		 		 x			:	10,
			     		 		 y			:	10,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickAddSubgroupButton
			     		 		 }
			     		 	 },this.addSubgroupButton),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'button',
			     		 		 id			:	'cancel_addsubgroupaction_id',
			     		 		 itemId		:	'cancel_addsubgroupaction_button_id',
			     		 		 text		:	'Cancel',
			     		 		 tooltip	:	'Cancel Add Action',
			     		 		 iconCls	:	'cancel',
			     		 		 scale		:	'medium',
			     		 		 iconAlign	:	'left',
			     		 		 hidden		:	true,
			     		 		 width		:	80,
			     		 		 height		:	35,
			     		 		 x			:	120,
			     		 		 y			:	10,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickCancelAddSubgroupButton
			     		 		 }
			     		 	 },this.cancelAddSubgroupButton),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'button',
			     		 		 id			:	'cancel_subgroupaction_id',
			     		 		 itemId		:	'cancel_subgroupaction_button_id',
			     		 		 text		:	'Cancel',
			     		 		 tooltip	:	'Cancel Action',
			     		 		 iconCls	:	'cancel',
			     		 		 scale		:	'medium',
			     		 		 iconAlign	:	'left',
			     		 		 hidden		:	true,
			     		 		 width		:	80,
			     		 		 height		:	35,
			     		 		 x			:	120,
			     		 		 y			:	10,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickcancelsubgroupActionButton
			     		 		 }
			     		 	 },this.cancelSubgroupButton),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'button',
			     		 		 id			:	'save_subgroup_id',
			     		 		 itemId		:	'save_subgroup_button_id',
			     		 		 text		:	'Save',
			     		 		 tooltip	:	'Save New Subgroup',
			     		 		 iconCls	:	'save',
			     		 		 scale		:	'medium',
			     		 		 iconAlign	:	'left',
			     		 		 hidden		:	true,
			     		 		 width		:	80,
			     		 		 height		:	35,
			     		 		 x			:	230,
			     		 		 y			:	10,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickSaveSubgroupButton
			     		 		 }
			     		 	 },this.saveSubgroupButton),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'button',
			     		 		 id			:	'save_changessubgroup_id',
			     		 		 itemId		:	'save_changessubgroup_button_id',
			     		 		 text		:	'Save',
			     		 		 tooltip	:	'Save Changes',
			     		 		 iconCls	:	'save',
			     		 		 scale		:	'medium',
			     		 		 iconAlign	:	'left',
			     		 		 hidden		:	true,
			     		 		 width		:	80,
			     		 		 height		:	35,
			     		 		 x			:	230,
			     		 		 y			:	10,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickSaveSubgroupChangesButton
			     		 		 }
			     		 	 },this.saveSubgroupChangesButton),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'button',
			     		 		 id			:	'delete_subgroup_id',
			     		 		 itemId		:	'delete_subgroup_button_id',
			     		 		 text		:	'Delete',
			     		 		 tooltip	:	'Delete Subgroup',
			     		 		 iconCls	:	'deleteGroup',
			     		 		 scale		:	'medium',
			     		 		 iconAlign	:	'left',
			     		 		 hidden		:	true,
			     		 		 width		:	80,
			     		 		 height		:	35,
			     		 		 x			:	340,
			     		 		 y			:	10,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickDeleteSubgroupButton
			     		 		 }
			     		 	 },this.deleteSubgroupButton),
			     		 	 
			     		 	 ]
		});
		Ext.ux.MeFTP.SubgroupsTab.SubgroupsButtons.superclass.initComponent.call(this);
	},
	
	_onClickAddSubgroupButton	:	function(){
		Ext.getCmp('subgroups_fields_id').enable();
		Ext.getCmp('add_subgroup_id').disable();
		Ext.getCmp('subgroup_search_id').disable();
		Ext.getCmp('cancel_addsubgroupaction_id').show();
		Ext.getCmp('save_subgroup_id').show();
		
	},
	
	_onClickCancelAddSubgroupButton	:	function(){
		this.up('form').getForm().reset();
		Ext.getCmp('cancel_addsubgroupaction_id').hide();
		Ext.getCmp('save_subgroup_id').hide();
		Ext.getCmp('subgroups_fields_id').disable();
		Ext.getCmp('subgroup_search_id').enable();
		Ext.getCmp('add_subgroup_id').enable();
		
		subgroupTab_search.getComponent('subgroups_search_button_id').enable();
	},
	
	_onClickcancelsubgroupActionButton	:	function(){
		var rsg = Ext.getCmp('subgroups_fields_id');
		rsg.up('form').getForm().reset();
		rsg.disable();
		
		Ext.getCmp('cancel_subgroupaction_id').hide();
		Ext.getCmp('save_changessubgroup_id').hide();
		Ext.getCmp('delete_subgroup_id').hide();
		Ext.getCmp('add_subgroup_id').enable();
		
		subgroupTab_search.getComponent('subgroupsdate_from_datefield_id').disable();
		subgroupTab_search.getComponent('subgroupsdate_to_datefield_id').disable();
		subgroupTab_search.getComponent('subgroupscriteria_combo_search_id').enable();
		subgroupTab_search.getComponent('subgroupssearch_text_textfield_id').enable();
		subgroupTab_search.getComponent('subgroups_search_button_id').enable();
	},
	
	_onClickSaveSubgroupButton	:	function(){
		Ext.Msg.show({
			title: 'Save',
			msg : 'Wanna Save New Subgroup.',
			buttons : Ext.Msg.YESNO,
			icon : 'ext-mb-saveuser',
			fn : function(btn) {
				if (btn == 'yes') {
					var rsg = Ext.getCmp('subgroups_fields_id');
					var nameSubgroup = subgroupTab_fields.getComponent('subgroup_name_textfield_id').value;
					if (rsg.up('form').getForm().isValid() == true) {
						Ext.Ajax.request({
							url : 'meftpSubgroupsActions/add.action',
							method : 'POST',
							params:{
								meftpSubgroupName	:	subgroupTab_fields.getComponent('subgroup_name_textfield_id').value,
								meftpSubgroupDesc 	:	subgroupTab_fields.getComponent('subgroup_desc_textfield_id').value,
								meftpSubgroupenabled:	subgroupTab_fields.getComponent('subgroup_enabled_checkbox_id').value,
								meftpSubgroupEmail	:	subgroupTab_fields.getComponent('subgroup_email_textfield_id').value,
								meftpSubgroupGroupId:	subgroupTab_fields.getComponent('subgroups_groups_combo_id').value,
								meftpSubgroupExpirationDate	:	Ext.Date.format(subgroupTab_fields.getComponent('subgroupexpired_date_datefield_id').getValue(),'Y-m-d'),
								meftpSubgroupEmailNotification	:	subgroupTab_fields.getComponent('subgroup_emailnoti_checkboxfield_id').value,
								meftpSubgroupComents	:	subgroupTab_fields.getComponent('subgroup_comments_textfield_id').value
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
								var name = subgroupTab_fields.getComponent('subgroup_name_textfield_id').value;
								rsg.up('form').getForm().reset();
								subgroupStore.load({params:{
									total		:	50000,
									comboValuesg	:	2,
									textValuessg	:	name
									}
								});
								Ext.getCmp('cancel_addsubgroupaction_id').hide();
								Ext.getCmp('save_subgroup_id').hide();
								Ext.getCmp('add_subgroup_id').enable();
								Ext.getCmp('subgroups_fields_id').disable();
								Ext.getCmp('subgroup_search_id').enable();
								
								subgroupTab_search.getComponent('subgroupsdate_from_datefield_id').disable();
								subgroupTab_search.getComponent('subgroupsdate_to_datefield_id').disable();
								subgroupTab_search.getComponent('subgroupscriteria_combo_search_id').enable();
								subgroupTab_search.getComponent('subgroupssearch_text_textfield_id').enable();
								subgroupTab_search.getComponent('subgroups_search_button_id').enable();
								Ext.MessageBox.close();
								Ext.example.msg('Done', nameSubgroup +' '+'Subgroup has been Saved');
							}
						});
					}
				}else{
					Ext.example.msg('Cancel', 'Save New Subgroup Action Canceled!!!');
				}
			}
		});
	},
	
	_onClickSaveSubgroupChangesButton	:	function(){
		Ext.Msg.show({
			title: 'Save',
			msg : 'Want to Save changes in Subgroup?',
			buttons : Ext.Msg.YESNO,
			icon : 'ext-mb-saveuser',
			fn : function(btn) {
				if (btn == 'yes') {
					var rsg = Ext.getCmp('subgroups_fields_id');
					var nomSubgroupChange = subgroupTab_fields.getComponent('subgroup_name_textfield_id').value;
					if (rsg.up('form').getForm().isValid() == true) {
						Ext.Ajax.request({
							url : 'meftpSubgroupsActions/edit.action',
							method : 'POST',
							params:{
								meftpSubgroupId		:	subgroupTab_fields.getComponent('subgroup_id_displayfield_id').value,
								meftpSubgroupName	:	subgroupTab_fields.getComponent('subgroup_name_textfield_id').value,
								meftpSubgroupDesc 	:	subgroupTab_fields.getComponent('subgroup_desc_textfield_id').value,
								meftpSubgroupenabled:	subgroupTab_fields.getComponent('subgroup_enabled_checkbox_id').value,
								meftpSubgroupEmail	:	subgroupTab_fields.getComponent('subgroup_email_textfield_id').value,
								meftpSubgroupGroupId:	subgroupTab_fields.getComponent('subgroups_groups_combo_id').value,
								meftpSubgroupExpirationDate	:	Ext.Date.format(subgroupTab_fields.getComponent('subgroupexpired_date_datefield_id').getValue(),'Y-m-d'),
								meftpSubgroupEmailNotification	:	subgroupTab_fields.getComponent('subgroup_emailnoti_checkboxfield_id').value,
								meftpSubgroupComents	:	subgroupTab_fields.getComponent('subgroup_comments_textfield_id').value
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
								var name = subgroupTab_fields.getComponent('subgroup_name_textfield_id').value;
								rsg.up('form').getForm().reset();
								subgroupStore.load({params:{
									total		:	50000,
									comboValue	:	2,
									textValues	:	name
									}
								});
								Ext.getCmp('cancel_addsubgroupaction_id').hide();
								Ext.getCmp('save_subgroup_id').hide();
								Ext.getCmp('add_subgroup_id').enable();
								Ext.getCmp('subgroups_fields_id').disable();
								
								subgroupTab_search.getComponent('subgroupsdate_from_datefield_id').disable();
								subgroupTab_search.getComponent('subgroupsdate_to_datefield_id').disable();
								subgroupTab_search.getComponent('subgroupscriteria_combo_search_id').enable();
								subgroupTab_search.getComponent('subgroupssearch_text_textfield_id').enable();
								subgroupTab_search.getComponent('subgroups_search_button_id').enable();
								Ext.MessageBox.close();
								Ext.example.msg('Done', nomSubgroupChange+'\'s '+'data has been changed');
							}
						});
					}
				}else{
					Ext.example.msg('Cancel', 'Save Subgroup Changes Canceled!!!');
				}
			}
		});
	},
	
	_onClickDeleteSubgroupButton	:	function(){
			Ext.Msg.show({
				title : 'Confirm',
				msg : 'are you sure want to DELETE?',
				buttons : Ext.Msg.YESNO,
				icon : 'ext-mb-delete',
				fn : function(btn) {
					if (btn == 'yes') {
							var subgroupDelete = userTab_fields.getComponent('subgroup_name_textfield_id').value;
							Ext.Ajax.request({
								url : 'meftpSubgroupsActions/delete.action',
								method : 'POST',
								params:{
									meftpSubgroupId		:	subgroupTab_fields.getComponent('subgroup_id_displayfield_id').value,
									meftpSubgroupName	:	subgroupTab_fields.getComponent('subgroup_name_textfield_id').value
								},
								success : function() {
									subgroupStore.load();
									var rsg = Ext.getCmp('subgroups_fields_id');
									rsg.up('form').getForm().reset();
									rsg.disable();
									
									Ext.getCmp('cancel_subgroupaction_id').hide();
									Ext.getCmp('save_changessubgroup_id').hide();
									Ext.getCmp('delete_subgroup_id').hide();
									Ext.getCmp('add_subgroup_id').enable();
									
									subgroupTab_search.getComponent('subgroupsdate_from_datefield_id').disable();
									subgroupTab_search.getComponent('subgroupsdate_to_datefield_id').disable();
									subgroupTab_search.getComponent('subgroupscriteria_combo_search_id').enable();
									subgroupTab_search.getComponent('subgroupssearch_text_textfield_id').enable();
									subgroupTab_search.getComponent('subgroups_search_button_id').enable();
									
									Ext.example.msg('Done', 'You Delete\t' + subgroupDelete + '\t' + 'user');
								}
							});
					} else {
						Ext.example.msg('Cancel', 'Delete Action Canceled!!!');
					}
				}
			});
	}
	
});