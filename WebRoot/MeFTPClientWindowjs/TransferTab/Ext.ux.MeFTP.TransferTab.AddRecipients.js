Ext.define('Ext.ux.MeFTP.TransferTab.AddRecipients',{
	extend		:	'Ext.form.FieldSet',
	alias		:	'widget.addrecipients',
	width		:	470,
	height		:	220,
	layout		:	'absolute',
	title		:	'Add Recipients',
	x			:	320,
	y			:	220,
	initComponent	:	function(){
		
		Ext.apply(this,{
			items		:	[
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'combo',
			     		 		 width		:	150,
			     		 		 id			:	'user_recipients_id',
			     		 		 itemId		:	'user_recipients_combo_id',
			     		 		 fieldLabel	:	'Recipients',
			     		 		 store		:	userCriteriaOptions,
			     		 		 valueField	: 'id_Options',//Propiedades
						    	 displayField	: 'Options',
			     		 		 labelPad	:	-40,
			     		 		 x			:	10
			     		 	 },this.comboRecipient),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'button'
			     		 	 },this.buttonRemove)
			     		 	 			     		 	 
			     		 	 ]
		});
		
		Ext.ux.MeFTP.TransferTab.AddRecipients.superclass.initComponent.call(this);
	}
});           