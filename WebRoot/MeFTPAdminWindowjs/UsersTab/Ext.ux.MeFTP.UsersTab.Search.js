Ext.define('Ext.ux.MeFTP.UsersTab.Search',{
	extend		:	'Ext.form.FieldSet',
	alias		:	'widget.meftpuserssearch',
	id			:	'search_fieldset_id',
	width		:	1030,
	height		:	60,
	title		:	'Search',
	layout		:	'absolute',
	x			:	10,
	autoScroll	:	true,
	initComponent	:	function(){
		Ext.apply(this,{
			items		:	[
			     		 	 
			     		 	Ext.apply({
			     		 		 xtype		:	'combo',
			     		 		 width		:	'20%',
			     		 		 id			:	'criteria_search_id',
			     		 		 itemId		:	'criteria_search_combo_id',
			     		 		 fieldLabel	:	'Criteria',
			     		 		 store		:	userCriteriaOptions,
			     		 		 valueField	: 'id_Options',//Propiedades
						    	 displayField	: 'Options',
			     		 		 labelPad	:	-40,
			     		 		 x			:	10,
			     		 		listeners:{
			            			scope:this,
			            			select: this._onClickDate
			    	   			}
			     		 	 },this.comboCriteriaSearch),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 width		:	'10%',
			     		 		 id			:	'search_text_id',
			     		 		 itemId		:	'search_text_textfield_id',
			     		 		 fieldLabel	:	'Text',
			     		 		 labelPad	:	-70,
			     		 		 x			:	250  
			     		 	 },this.textfieldTextSearch),
			     		 	 			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'datefield',
			     		 		 width		:	'10%',
			     		 		 id			:	'date_from_id',
			     		 		 itemId		:	'date_from_datefield_id',
			     		 		 fieldLabel	:	'Date From',
			     		 		 labelPad	:	-30,
			     		 		 x			:	460,
			     		 		 disabled	:	true,
			     		 		 vtype		:	'daterange',
						    	 endDateField	:	'date_to_datefield_id'
			     		 	 },this.datefieldFromSearch),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'datefield',
			     		 		 width		:	'10%',
			     		 		 id			:	'date_to_id',
			     		 		 itemId		:	'date_to_datefield_id',
			     		 		 fieldLabel	:	'Date To',
			     		 		 labelPad	:	-50,
			     		 		 x			:	700,
			     		 		 disabled	:	true,
			     		 		 vtype		:	'daterange',
						    	 startDateField		:	'date_from_datefield_id'
			     		 	 },this.datefieldToSearch),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'button',
			     		 		 width		:	35,
			     		 		 height		:	24,
			     		 		 tooltip	:	'Search',
			     		 		 id			:	'user_option_id',
			     		 		 itemId		:	'user_search_button_id',
			     		 		 iconCls	:	'search',
			     		 		 scale		:	'medium',
			     		 		 x			:	930,
			     		 		 listeners	:	{
			     		 			 scope		:	this,
			     		 			 click		:	this._onClickAdvancedSearch
			     		 		 }
			     		 	 },this.buttonOptionSearch)
			     	]
		}),
		Ext.apply(Ext.form.field.VTypes, {
			daterange : function(val, field) {
				var date = field.parseDate(val);

				if (!date) {
					return false;
				}
				if (field.startDateField
						&& (!this.dateRangeMax || (date.getTime() != this.dateRangeMax
								.getTime()))) {
					var start = field.up('form').down('#' + field.startDateField);
					start.setMaxValue(date);
					start.validate();
					this.dateRangeMax = date;
				} else if (field.endDateField
						&& (!this.dateRangeMin || (date.getTime() != this.dateRangeMin
								.getTime()))) {
					var end = field.up('form').down('#' + field.endDateField);
					end.setMinValue(date);
					end.validate();
					this.dateRangeMin = date;
				}
				return true;
			},
			daterangeText : 'Start date must be less than end date'
		}),
		Ext.ux.MeFTP.UsersTab.Search.superclass.initComponent.call(this);
	},
	
	_onClickDate:function(){
		var combo = Ext.getCmp('criteria_search_id');
		var val = combo.getValue();
		if (val == 8 || val == 9) {
			Ext.getCmp('date_from_id').enable();
			Ext.getCmp('date_to_id').enable();
			Ext.getCmp('search_text_id').disable();
		} else {
			Ext.getCmp('date_from_id').disable();
			Ext.getCmp('date_to_id').disable();
			Ext.getCmp('search_text_id').enable();
			//Ext.getCmp('button_asearch_id').show();
		}
	},
	
	_onClickAdvancedSearch	:	function(){
		var r = Ext.getCmp('search_text_id').getValue();
		var cmb = Ext.getCmp('criteria_search_id').getValue();
		if(cmb == 8 || cmb == 9){
			userStore.load({params:{
				total		:	50000,
				comboValue	:	cmb,
				date1		:	Ext.Date.format(Ext.getCmp('date_from_id').getValue(),'Y-m-d'),
				date2		:	Ext.Date.format(Ext.getCmp('date_to_id').getValue(),'Y-m-d')
				}
			});
		}else if(r != null){
			userStore.load({params:{
				total		:	50000,
				comboValue	:	cmb,
				textValues	:	r
				}
			});
		}
		 else{
			alert('Wrogn Answer');
		}
	}
	
});           