Ext.define('Ext.ux.MeFTP.TransferTab.OptionalSettings',{
	extend		:	'Ext.form.FieldSet',
	alias		:	'widget.generalParamsTransfer',
	width		:	340,
	height		:	210,
	layout		:	'absolute',
	title		:	'Optional Settings',
	x			:	450,
	y			:	0,
	initComponent	:	function(){
		
		Ext.apply(this,{
			items		:	[
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'checkbox',
			     		 		 id			:	'sendemail_tome_id',
			     		 		 itemId		:	'sendemail_tome_checbox_id',
			     		 		 boxLabel	:	'Send email to me',
			     		 		 x			:	0,
			     		 		 y			:	0
			     		 	 },this.sendEmailToMeCheckbox),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'checkbox',
			     		 		 id			:	'notify_download_id',
			     		 		 itemId		:	'notify_downola_checkbox_id',
			     		 		 boxLabel	:	'Protect Download',
			     		 		 x			:	0,
			     		 		 y			:	60
			     		 	 },this.notifyDownloadCheckbox),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 id			:	'transfer_name_id',
			     		 		 itemId		:	'transfer_name_textfield_id',
			     		 		 fieldLabel	:	'Transfer Name',
			     		 		 x			:	0,
			     		 		 y			:	30
			     		 	 },this.transferNameTextfield),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'checkbox',
			     		 		 id			:	'protect_download_id',
			     		 		 itemId		:	'protect_download_checkbox_id',
			     		 		 boxLabel	:	'Protect Download',
			     		 		 x			:	0,
			     		 		 y			:	60
			     		 	 },this.protectDownloadCheckbox),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textfield',
			     		 		 id			:	'password_file_id',
			     		 		 itemId		:	'password_file_textfield',
			     		 		 emptyText	:	'Password',
			     		 		 x			:	240,
			     		 		 y			:	60
			     		 	 },this.passwordFileTextfield),
			     		 	 
			     		 	 Ext.apply({
			     		 		xtype		:	'textfield',
			     		 		id			:	'confirm_password_id',
			     		 		itemId		:	'confirm_password_textfield_id',
			     		 		emptyText	:	'Confirm Password',
			     		 		x			:	240,
			     		 		y			:	60
			     		 	 },this.confirmPasswordTextfield),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'checkbox',
			     		 		 id			:	'expire_datefile_id',
			     		 		 itemId		:	'expire_datefile_checbox_id',
			     		 		 boxLabel	:	'Expire Date',
			     		 		 x			:	0,
			     		 		 y			:	100
			     		 	 },this.expireDateCheckbox),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'datefield',
			     		 		 x			:	170,
			     		 		 y			:	100
			     		 	 },this.expireDateDateField),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'label',
			     		 		 text		:	'Message to recipient(s)',
			     		 		 x			:	0,
			     		 		 y			:	130,
			     		 		 emptyText	:	'Write a Message'
			     		 	 },this.messageToRecipientslabel),
			     		 	 
			     		 	 Ext.apply({
			     		 		 xtype		:	'textareafield',
			     		 		 id			:	'messageto_recipients_id',
			     		 		 itemId		:	'messageto_recipients_textarea_id',
			     		 		 width		:	320,
			     		 		 height		:	40,
			     		 		 x			:	0,
			     		 		 y			:	150
			     		 	 },this.messageToRecipientsTextfield)
			     		 	 
			     		 	 ]
		});
		
		Ext.ux.MeFTP.TransferTab.OptionalSettings.superclass.initComponent.call(this);
	}
});           