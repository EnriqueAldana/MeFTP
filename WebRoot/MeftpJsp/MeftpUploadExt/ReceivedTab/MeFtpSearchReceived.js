var labelComboCriteriaReceived = new Ext.form.Label({
	id:'label_criteriareceived_id',
	text:'Criteria:',
	y:5,
	x:10
})



var comboCriteriaSearchReceived = new Ext.form.ComboBox({
	width		:	150,
	id			:	'criteria_searchreceived_id',
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
			var combo = Ext.getCmp('criteria_searchreceived_id');
			var val = combo.getValue();
			if (val == 8 || val == 9) {
				Ext.getCmp('date_fromReceived_id').enable();
				Ext.getCmp('date_toReceived_id').enable();
				Ext.getCmp('search_textreceived_id').disable();
			} else {
				Ext.getCmp('date_fromReceived_id').disable();
				Ext.getCmp('date_toReceived_id').disable();
				Ext.getCmp('search_textreceived_id').enable();
			}
		}
	}
});

var labelTextSearchReceived = new Ext.form.Label({
	id:'label_textsearchreceived_id',
	text:'Text:',
	y:5,
	x:240
})

var textfieldSearchReceived = new Ext.form.TextField({
		 width		:	'13%',
		 id			:	'search_textreceived_id',
		 emptyText	:	'Write parameters',
		 x			:	270  
});

var labelTextDateFromReceived = new Ext.form.Label({
	id:'label_dateFromReceived_id',
	text:'Date From:',
	y:5,
	x:440
})

var dateFromDateFieldReceived = new Ext.form.DateField({
		 width		:	150,
		 id			:	'date_fromReceived_id',
		 x			:	500,
		 disabled	:	true,
		 vtype		:	'daterange',
	     endDateField	:	'date_toReceived_id'
});

var labelTextDateToReceived = new Ext.form.Label({
	id:'label_dateToReceived_id',
	text:'Date To:',
	y:5,
	x:680
})

var dateToDateFieldReceived = new Ext.form.DateField({
		 width		:	150,
		 id			:	'date_toReceived_id',
		 x			:	730,
		 disabled	:	true,
		 vtype		:	'daterange',
		 startDateField		:	'date_fromReceived_id'
});

var buttonSearchReceived = new Ext.Button({
	 	 width		:	35,
		 height		:	24,
		 tooltip	:	'Search',
		 id			:	'send_searchReceived_id',
		 //iconCls	:	'Search',
		 //scale		:	'medium',
		 x			:	930/*,
		 listeners	:	{
			 click		:	function(){alert('Hola');}
		 }*/
});

var barReceivedSearch = new Ext.form.FieldSet({
	id			:	'search_received_id',
	width		:	1030,
	height		:	60,
	title		:	'Search',
	layout		:	'absolute',
	x			:	15,
	autoScroll	:	true,
	
			items		:	[
			     		 	 labelComboCriteriaReceived,
			     		 	 comboCriteriaSearchReceived,
			     		 	 labelTextSearchReceived,
			     		 	 textfieldSearchReceived,
			     		 	 labelTextDateFromReceived,
			     		 	 dateFromDateFieldReceived,
			     		 	 labelTextDateToReceived,
			     		 	 dateToDateFieldReceived ,
			     		 	 buttonSearchReceived
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