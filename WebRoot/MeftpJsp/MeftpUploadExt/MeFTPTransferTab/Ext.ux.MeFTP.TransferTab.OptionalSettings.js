var chekcboxmail = new Ext.form.Checkbox({
	id:'sendemail_tome_id',
	boxLabel:'Send email to me',
	x:	10,
	y:	0
});

var checkboxdownload = new Ext.form.Checkbox({
	id:'notify_download_id',
	boxLabel:'Notify Upon Download',
	x:160,
	y:0
});

var labelTrasnferName = new Ext.form.Label({
	id:'label_texttransfer_id',
	text:'Transfer Name:',
	y:35,
	x:10
});

var transferNametxtf = new Ext.form.TextField({
	id:'transfer_name_id',
	width:170,
	fieldLabel:'Transfer Name',
	emptyText:'Transfer Name',
	x:130,
	y:30
});

var checkboxprotectD = new Ext.form.Checkbox({
	id:'protect_download_id',
	boxLabel:'Protect Download',
	x:10,
	y:60,
	handler:function(){
		var passTrue = Ext.getCmp('protect_download_id').getValue();
			if (passTrue == true){
				Ext.getCmp('password_file_id').enable();
				Ext.getCmp('confirm_password_id').enable();
			}else{
				Ext.getCmp('password_file_id').disable();
				Ext.getCmp('confirm_password_id').disable();
			}
	}
});

var passTextfield = new Ext.form.TextField({
	width:80,
	disabled:true,
	id:'password_file_id',
	emptyText:'Password',
	x:130,
	y:60
});

var passComfirmTextfield = new Ext.form.TextField({
	width:80,
	disabled:true,
	id			:	'confirm_password_id',
	emptyText	:	'Confirm Password',
	msgTarget :'side',
	x			:	220,
	y			:	60,
	vtype: 'password',
    initialPassField: 'password_file_id' // id of the initial password field
});

var expDateCheckbox = new Ext.form.Checkbox({
	xtype		:	'checkbox',
	id			:	'expire_checkboxid',
	boxLabel	:	'Expire Date',
	x			:	10,
	y			:	100,
	handler:function(){
		var passTrue = Ext.getCmp('expire_checkboxid').getValue();
			if (passTrue == true){
				Ext.getCmp('expiredfile_date_id').enable();
			}else{
				Ext.getCmp('expiredfile_date_id').disable();
			}
	}
});

var datefieldExp = new Ext.form.DateField({
	id:'expiredfile_date_id',
	disabled:true,
	width		:	170,
	x			:	130,
	y			:	100
});

var labelMessage = new Ext.form.Label({
	text		:	'Message to recipient(s)',
	x			:	10,
	y			:	130,
});

var textareaMessage = new Ext.form.TextArea({
	emptyText	:	'Write a Message',
 	id			:	'messageto_recipients_id',
 	width		:	290,
 	height		:	40,
 	x			:	10,
 	y			:	150
})

var OptionalSettings = new Ext.form.FieldSet({
	width		:	330,
	height		:	230,
	layout		:	'absolute',
	title		:	'Optional Settings',
	x			:	720,
	y			:	10,
	items		:	[
chekcboxmail,
checkboxdownload,
labelTrasnferName,
transferNametxtf,
checkboxprotectD,
passTextfield,
passComfirmTextfield,
expDateCheckbox,
datefieldExp,
labelMessage,
textareaMessage
	    		 	 ]
});           