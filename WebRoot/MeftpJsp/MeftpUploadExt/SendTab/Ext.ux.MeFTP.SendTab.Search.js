var labelComboCriteria = new Ext.form.Label({
	id:'label_criteria_id',
	text:'Criteria:',
	y:5,
	x:10
})


var comboCriteriaSearch = new Ext.form.ComboBox({
	width		:	150,
	id			:	'criteria_search_id',
	store		:	userCriteriaOptions,
	valueField	: 'id_Options',//Propiedades
	displayField	: 'Options',
	x			:	55,
	typeAhead: true,
     mode: 'local',
     forceSelection: true,
     triggerAction: 'all',
     emptyText:'Select a Criteria',
     selectOnFocus:true,
	listeners:{
		scope:this,
		select: function(){
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
			}
		}
	}
});

var labelTextSearch = new Ext.form.Label({
	id:'label_textsearch_id',
	text:'Text:',
	y:5,
	x:240
})

var textfieldSearch = new Ext.form.TextField({
		 width		:	'13%',
		 id			:	'search_text_id',
		 emptyText	:	'Write parameters',
		 itemId		:	'search_text_textfield_id',
		 x			:	270  
});

var labelTextDateFrom = new Ext.form.Label({
	id:'label_dateFrom_id',
	text:'Date From:',
	y:5,
	x:440
})

var dateFromDateField = new Ext.form.DateField({
		 width		:	150,
		 id			:	'date_from_id',
		 x			:	500,
		 disabled	:	true,
		 vtype		:	'daterange',
	     endDateField	:	'date_to_id'
});

var labelTextDateTo = new Ext.form.Label({
	id:'label_dateTo_id',
	text:'Date To:',
	y:5,
	x:680
})

var dateToDateField = new Ext.form.DateField({
		 width		:	150,
		 id			:	'date_to_id',
		 x			:	730,
		 disabled	:	true,
		 vtype		:	'daterange',
		 startDateField		:	'date_from_id'
});

var buttonSearch = new Ext.Button({
	 	 width		:	35,
		 height		:	24,
		 tooltip	:	'Search',
		 id			:	'send_search_id',
		 //iconCls	:	'Search',
		 //scale		:	'medium',
		 x			:	930/*,
		 listeners	:	{
			 click		:	function(){alert('Hola');}
		 }*/
});

var barSendSearch = new Ext.form.FieldSet({
	id			:	'searchclient_id',
	width		:	1030,
	height		:	60,
	title		:	'Search',
	layout		:	'absolute',
	x			:	15,
	autoScroll	:	true,
	
			items		:	[
			     		 	 labelComboCriteria,
			     		 	 comboCriteriaSearch,
			     		 	 labelTextSearch,
			     		 	 textfieldSearch,
			     		 	 labelTextDateFrom,
			     		 	 dateFromDateField,
			     		 	 labelTextDateTo,
			     		 	 dateToDateField,
			     		 	 buttonSearch
			     		 	 ]
});           

/*
 
 
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
			 Ext.MessageBox.alert('ERROR', 'Selected it Option Wrong');
		}
	}
 
 */