var groupTab_buttons = Ext.create('Ext.ux.MeFTP.SubgroupsTab.SubgroupsButtons',{
	id			:	'group_buttons_id',
	itemId		:	'group_buttons_fieldset_id',
	
	addSubgroupButton	:	{
		 id			:	'add_group_id',
 		 itemId		:	'add_group_button_id',
 		 text		:	'Add',
 		 tooltip	:	'Add Group',
 		 listeners	:	{
 			 scope		:	this,
 			 click		:	function(){
 				Ext.getCmp('groups_fields_id').enable();
 				Ext.getCmp('add_group_id').disable();
 				Ext.getCmp('group_search_id').disable();
 				Ext.getCmp('cancel_addgroupaction_id').show();
 				Ext.getCmp('save_group_id').show();
 			 }
 		 }
	},
	
	cancelAddSubgroupButton	:	{
		 id			:	'cancel_addgroupaction_id',
 		 itemId		:	'cancel_addgroupaction_button_id',
 		 text		:	'Cancel',
 		 tooltip	:	'Cancel Add Action',
 		 listeners	:	{
 			 scope		:	this,
 			 click		:	function(){
 				var rg = Ext.getCmp('groups_fields_id');
 				rg.up('form').getForm().reset();
 				rg.disable();
 				Ext.getCmp('cancel_addgroupaction_id').hide();
 				Ext.getCmp('save_group_id').hide();
 				Ext.getCmp('groups_fields_id').disable();
 				Ext.getCmp('group_search_id').enable();
 				Ext.getCmp('add_group_id').enable();
 				
 				groupTab_search.getComponent('groups_search_button_id').enable();
 			 }
 		 }
	},
	
	cancelSubgroupButton	:	{
		 id			:	'cancel_groupaction_id',
 		 itemId		:	'cancel_groupaction_button_id',
 		 text		:	'Cancel',
 		 tooltip	:	'Cancel Action',
 		 listeners	:	{
 			 scope		:	this,
 			 click		:	function(){
 				var rg = Ext.getCmp('groups_fields_id');
 				rg.up('form').getForm().reset();
 				rg.disable(); 				
 				Ext.getCmp('cancel_groupaction_id').hide();
 				Ext.getCmp('save_changesgroup_id').hide();
 				Ext.getCmp('delete_group_id').hide();
 				Ext.getCmp('add_group_id').enable();
 				
 				groupTab_search.getComponent('groupsdate_from_datefield_id').disable();
 				groupTab_search.getComponent('groupsdate_to_datefield_id').disable();
 				groupTab_search.getComponent('groupscriteria_combo_search_id').enable();
 				groupTab_search.getComponent('groupssearch_text_textfield_id').enable();
 				groupTab_search.getComponent('groups_search_button_id').enable();
 			 }
 		 }
	},
	
	saveSubgroupButton		:	{
		 id			:	'save_group_id',
 		 itemId		:	'save_group_button_id',
 		 text		:	'Save',
 		 tooltip	:	'Save New Group',
 		 listeners	:	{
 			 scope		:	this,
 			 click		:	function(){
 				Ext.Msg.show({
 					title: 'Save',
 					msg : 'Wanna Save New Group.',
 					buttons : Ext.Msg.YESNO,
 					icon : 'ext-mb-saveuser',
 					fn : function(btn) {
 						if (btn == 'yes') {
 							var rsg = Ext.getCmp('groups_fields_id');
 							var nameGroup = groupTab_fields.getComponent('group_name_textfield_id').value;
 							if (rsg.up('form').getForm().isValid() == true) {
 								Ext.Ajax.request({
 									url : 'meftpGroupsActions/add.action',
 									method : 'POST',
 									params:{
 										meftpGroupName	:	groupTab_fields.getComponent('group_name_textfield_id').value,
 										meftpGroupDesc 	:	groupTab_fields.getComponent('group_desc_textfield_id').value,
 										meftpGroupenabled:	groupTab_fields.getComponent('group_enabled_checkbox_id').value,
 										meftpGroupEmail	:	groupTab_fields.getComponent('group_email_textfield_id').value,
 										meftpGroupExpirationDate	:	Ext.Date.format(groupTab_fields.getComponent('groupexpired_date_datefield_id').getValue(),'Y-m-d'),
 										meftpGroupEmailNotification	:	groupTab_fields.getComponent('group_emailnoti_checkboxfield_id').value,
 										meftpGroupComments		:	groupTab_fields.getComponent('group_comments_textfield_id').value
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
 										var name = groupTab_fields.getComponent('group_name_textfield_id').value;
 										rsg.up('form').getForm().reset();
 										subgroupStore.load({params:{
 											total		:	50000,
 											comboValueg	:	2,
 											textValuesg	:	name
 											}
 										});
 										Ext.getCmp('cancel_addgroupaction_id').hide();
 										Ext.getCmp('save_group_id').hide();
 										Ext.getCmp('add_group_id').enable();
 										Ext.getCmp('groups_fields_id').disable();
 										Ext.getCmp('group_search_id').enable();
 										
 										groupTab_search.getComponent('groupsdate_from_datefield_id').disable();
 										groupTab_search.getComponent('groupsdate_to_datefield_id').disable();
 										groupTab_search.getComponent('groupscriteria_combo_search_id').enable();
 										groupTab_search.getComponent('groupssearch_text_textfield_id').enable();
 										groupTab_search.getComponent('groups_search_button_id').enable();
 										Ext.MessageBox.close();
 										Ext.example.msg('Done', nameGroup +' '+'Group has been Saved');
 									}
 								});
 							}
 						}else{
 							Ext.example.msg('Cancel', 'Save New Group Action Canceled!!!');
 						}
 					}
 				});
 			 }
 		 }		
	},
	
	saveSubgroupChangesButton	:	{
		 id			:	'save_changesgroup_id',
 		 itemId		:	'save_changesgroup_button_id',
 		 text		:	'Save',
 		 tooltip	:	'Save Changes',
 		 listeners	:	{
 			 scope		:	this,
 			 click		:	function(){
 				Ext.Msg.show({
 					title: 'Save',
 					msg : 'Want to Save changes in Group?',
 					buttons : Ext.Msg.YESNO,
 					icon : 'ext-mb-saveuser',
 					fn : function(btn) {
 						if (btn == 'yes') {
 							var rsg = Ext.getCmp('groups_fields_id');
 							var nameChangeGroup = groupTab_fields.getComponent('group_name_textfield_id').value;
 							if (rsg.up('form').getForm().isValid() == true) {
 								Ext.Ajax.request({
 									url : 'meftpGroupsActions/edit.action',
 									method : 'POST',
 									params:{
 										meftpGroupId		:	groupTab_fields.getComponent('group_id_displayfield_id').value,
 										meftpGroupName		:	groupTab_fields.getComponent('group_name_textfield_id').value,
 										meftpGroupDesc 		:	groupTab_fields.getComponent('group_desc_textfield_id').value,
 										meftpGroupenabled	:	groupTab_fields.getComponent('group_enabled_checkbox_id').value,
 										meftpGroupEmail		:	groupTab_fields.getComponent('group_email_textfield_id').value,
 										meftpGroupExpirationDate	:	Ext.Date.format(groupTab_fields.getComponent('groupexpired_date_datefield_id').getValue(),'Y-m-d'),
 										meftpGroupEmailNotification	:	groupTab_fields.getComponent('group_emailnoti_checkboxfield_id').value,
 										meftpGroupComments		:	groupTab_fields.getComponent('group_comments_textfield_id').value
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
 										var name = groupTab_fields.getComponent('group_name_textfield_id').value;
 										rsg.up('form').getForm().reset();
 										groupStore.load({params:{
 											total		:	50000,
 											comboValueg	:	2,
 											textValuesg	:	name
 											}
 										});
 										Ext.getCmp('cancel_addgroupaction_id').hide();
 										Ext.getCmp('save_group_id').hide();
 										Ext.getCmp('add_group_id').enable();
 										Ext.getCmp('groups_fields_id').disable();
 										
 										groupTab_search.getComponent('groupsdate_from_datefield_id').disable();
 										groupTab_search.getComponent('groupsdate_to_datefield_id').disable();
 										groupTab_search.getComponent('groupscriteria_combo_search_id').enable();
 										groupTab_search.getComponent('groupssearch_text_textfield_id').enable();
 										groupTab_search.getComponent('groups_search_button_id').enable();
 										Ext.MessageBox.close();
 										Ext.example.msg('Done', nameChangeGroup+'\'s '+'data has been changed');
 									}
 								});
 							}
 						}else{
 							Ext.example.msg('Cancel', 'Save Group Changes Canceled!!!');
 						}
 					}
 				});
 			 }
 		 }
	},
	
	deleteSubgroupButton	:	{
		 id			:	'delete_group_id',
 		 itemId		:	'delete_group_button_id',
 		 text		:	'Delete',
 		 tooltip	:	'Delete Group',
 		 listeners	:	{
 			 scope		:	this,
 			 click		:	function(){
 				Ext.Msg.show({
 					title : 'Confirm',
 					msg : 'are you sure want to DELETE?',
 					buttons : Ext.Msg.YESNO,
 					icon : 'ext-mb-delete',
 					fn : function(btn) {
 						if (btn == 'yes') {
 								var groupDelete = groupTab_fields.getComponent('group_name_textfield_id').value;
 								Ext.Ajax.request({
 									url : 'meftpGroupsActions/delete.action',
 									method : 'POST',
 									params:{
 										meftpGroupId		:	groupTab_fields.getComponent('group_id_displayfield_id').value,
 										meftpGroupName		:	groupTab_fields.getComponent('group_name_textfield_id').value
 									},
 									success : function() {
 										groupStore.load();
 										var rg = Ext.getCmp('groups_fields_id');
 										rg.up('form').getForm().reset();
 										rg.disable();
 										
 										Ext.getCmp('cancel_groupaction_id').hide();
 										Ext.getCmp('save_changesgroup_id').hide();
 										Ext.getCmp('delete_group_id').hide();
 										Ext.getCmp('add_group_id').enable();
 										
 										groupTab_search.getComponent('groupsdate_from_datefield_id').disable();
 										groupTab_search.getComponent('groupsdate_to_datefield_id').disable();
 										groupTab_search.getComponent('groupscriteria_combo_search_id').enable();
 										groupTab_search.getComponent('groupssearch_text_textfield_id').enable();
 										groupTab_search.getComponent('groups_search_button_id').enable();
 										
 										Ext.example.msg('Done', 'You Delete\t' + groupDelete + '\t' + 'Group');
 									}
 								});
 						} else {
 							Ext.example.msg('Cancel', 'Delete Action Canceled!!!');
 						}
 					}
 				});
 			 }
 		 }
	}
});           