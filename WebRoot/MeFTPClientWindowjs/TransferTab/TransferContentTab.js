var recipients_transferTab = new Ext.ux.MeFTP.TransferTab.AddRecipients();
var optionalSettings_transferTab = new Ext.ux.MeFTP.TransferTab.OptionalSettings();


var clientPanel_transferTab = Ext.create('Ext.form.Panel',{
	title		:	'Transfer',
	id			:	'transfertab_client_id',
	layout		:	'absolute',
	bodyPadding	:	10,
	items		:	[
recipients_transferTab,optionalSettings_transferTab
	     		 	 ]
});