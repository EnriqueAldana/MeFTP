Ext.onReady(function(){
	Ext.QuickTips.init();
	requires: ['Ext.ux.MeFTP.Login'],
	Ext.create('Ext.ux.MeFTP.Login',{
		id			:	'Window_login',
		resizable	: 	false,
		plain		: 	true,
		border		: 	false
	}).show();
});           