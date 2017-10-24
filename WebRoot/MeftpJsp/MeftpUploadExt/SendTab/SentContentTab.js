var searchFieldSet_ClientTab = new Ext.ux.MeFTP.SendTab.Search({});

var fieldSet_SendTab = Ext.create('Ext.form.FieldSet',{
	anchor		:	'100% 100%',
    title		: 	'Sent files list',
    layout		:	'anchor',
    bodyPadding	:	10,
    items		:	[
         		 	 searchFieldSet_ClientTab,
         		 	 	grid
         		 	 ]
}); 

var clientPanel_SendTab = Ext.create('Ext.form.Panel',{
	title		:	'Sent',
	id			:	'sendtab_client_id',
	layout		:	'anchor',
	bodyPadding	:	10,
	items		:	[
	     		 	 fieldSet_SendTab
	     		 	 ]
});