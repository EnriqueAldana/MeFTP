var fieldSet_ReceivedTab = Ext.create('Ext.form.FieldSet',{
	anchor		:	'100% 100%',
    title		: 	'Received files list',
   // margins		:	'10 5 5 5',
   // x			: 	10,
    //y			:	0,
    layout		:	'anchor',
    bodyPadding	:	10,
    items		:	[
         		 	 receivedTab_search,
         		 	gridreceived
         		 	 ]
}); 



var clientPanel_ReceivedTab = Ext.create('Ext.form.Panel',{
	title		:	'Received',
	id			:	'receivedtab_client_id',
	layout		:	'anchor',
	bodyPadding	:	10,
	items		:	[
	     		 	 fieldSet_ReceivedTab
	     		 	 ]
});           