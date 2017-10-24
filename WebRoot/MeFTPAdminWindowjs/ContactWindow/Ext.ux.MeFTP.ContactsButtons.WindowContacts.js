Ext.define('Ext.ux.MeFTP.ContactsButtons.WindowContacts', {
    extend		: 	'Ext.form.FieldSet',
    alias		:	'widget.contactsbuttons',
    height: 180,
    width: 360,
    layout: {
        type: 'absolute'
    },
    x: 620,
    y: 75,

    initComponent: function() {

        Ext.apply(this, {
            items: [
                 Ext.apply({
                	 xtype		:	'button',
                     height		: 	30,
                     width		: 	150,
                     text		: 	'Add Select Contact',
                     x			: 	80,
                     listeners	:	{
                    	 scope		:	this,
                    	 click		:	this._onClickSelectedContacts
                     }
                 },this.buttonAddSelectContact),
                 
                 Ext.apply({
                	 xtype		: 	'button',
                     height		: 	30,
                     width		: 	150,
                     text		: 	'Clean Selected Contacts',
                     x			: 	80,
                     y			: 	40,
                     listeners	:	{
                    	 scope		:	this,
                    	 click		:	this._onClickCleanSelectedContacts
                     }
                 },this.buttonCleanSelectedContacts),
                 
                 Ext.apply({
                	 xtype		: 	'button',
                     height		: 	30,
                     width		: 	150,
                     text		: 	'Save and Exit',
                     x			: 	80,
                     y			: 	80,
                     listeners	:	{
                    	 scope		:	this,
                    	 click		:	this._onClickButtonSaveExit
                     }
                 },this.buttonSaveAndExit),
                 
                 Ext.apply({
                	 xtype		: 	'button',
                     height		: 	30,
                     width		: 	150,
                     text		: 	'Cancel and Exit',
                     x			: 	80,
                     y			: 	120,
                     listeners	:	{
                    	 scope		:	this,
                    	 click		:	this._onClickButtonCancelExit
                     }
                 },this.buttonCancelAndExit)             
            ]
        });
        Ext.ux.MeFTP.ContactsButtons.WindowContacts.superclass.initComponent.call(this);
    },
    _onClickSelectedContacts	:	function(){
    	
    },
    _onClickCleanSelectedContacts	:	function(){
    	//Ext.getCmp('contacts_store2_id').removeAll();
       contactsUserStore2.removeAll();
    },
    _onClickButtonSaveExit	:	function(){
    	
    },
    _onClickButtonCancelExit	:	function(){
    	Ext.getCmp('window_contact_id').close();
    	contactsUserStore.load();
    	contactsUserStore2.removeAll();
    }
    
});           