Ext.define('Ext.ux.MeFTP.Login',{
	extend		:	'Ext.window.Window',
	alias		:	'widget.meftpLogin',
	layout 		: 	'absolute',
	height		: 	530,
	width		:	350,
	bodyPadding	:	10,
	closable	: 	false,
	constrain	: 	true,
	labelWidth	: 	65,
	minHeight	: 	140,
	minWidth	: 	220,
	modal		: 	true,
	title		:	'MeFTP - Metalsa electronic FTP Log In Service',
	
	initComponent	:	function(){
		
		Ext.apply(this,{
			items:[		    
			    Ext.apply({
			    	xtype		:	'image',
			    	height		: 	100,
			    	width		: 	230,
			    	src			: 	'http://www.alvolante.info/wp-content/joblogo.gif',
			    	x			: 	20,
			    	y			: 	20
			    },this.metalsaImage),
			    
			    Ext.apply({
			    	xtype		:	'label',
			    	text		:	'User Name:',
			    	x			:	20,
			    	y			: 	140,
			    },this.labelUserName),
				   					
			    Ext.apply({
			    	xtype		:	'textfield',
			    	itemId		:	'user_name_textfield',
			    	emptyText	: 	'User Name',
			    	msgTarget	: 	'side',
			    	allowBlank	: 	false,
			    	selectOnFocus	:	true,
			    	enableKeyEvents	: 	true,
			    	width		: 	300,
			    	x			: 	20,
			    	y			: 	160,
			    	listeners	: {
			    		scope		: 	this
			    	}
			    },this.userNameTextfield),
			    
			    Ext.apply({
			    	xtype		:	'label',
			    	text		:	'User Password',
			    	x			: 	20,
			        y			: 	220
			    },this.userPasswordLabel),
			      	
			    Ext.apply({
			    	xtype		: 	'textfield',
			    	itemId		:	'user_password_textfield',
			    	inputType	: 	'password',
			    	emptyText	: 	'User Password',
			    	msgTarget	: 	'side',
			    	allowBlank	: 	false,
			    	width		: 	300,
			    	x			: 	20,
			    	y			: 	240,
			    	selectOnFocus	:	true,
			    	enableKeyEvents	: 	true,
			    	listeners		: {
			    		scope		: 	this
					}
						
				},this.userPasswordField),
				
				/*Ext.apply({
					xtype		:	'image',
					height		: 	60,
				    width		: 	170,
				    src			: 	'http://www.sencha.com/img/sencha-large.png',
				    x			: 	20,
				    y			: 	300
						
				},this.captchaImage),
				
				Ext.apply({
					xtype		:	'label',
					text		: 	'Captcha:',
				    x			: 	20,
				    y			: 	380
				},this.captchaLabel),
				
				Ext.apply({
					xtype		:	'textfield',
					itemId		:	'captcha_textfield',
					emptyText	:	'Write your Captcha',
					allowBlank	:	true,
					x: 20,
				    y: 400,
				},this.captchaField),*/
				
				Ext.apply({
					xtype		: 	'box',
					autoEl		: 	{tag: 'a', href: 'http://www.google.com', html: 'RecoveryPassword'},
				    x			: 	10,
				    y			: 	470,
				},this.recoveryPasswordLink),
				
				Ext.apply({
					xtype		:	'label',
					height		:	20,
				    text		: 	'Powered by Meds Platform Development Team',
				    x			: 	180,
				    y			: 	470,
				},this.poweredLabel),
				
				Ext.apply({
					xtype		:	'button',
					height		: 	50,
					width		: 	110,
					text		: 	'Login',
					x			: 	210,
					y			: 	380,
					listeners	:	{
						scope		:	this,
						click		:	this._loginMeFTP
					}
					
				},this.userLoginButton)
			]
		});
		Ext.ux.MeFTP.Login.superclass.initComponent.call(this);
		
	},
	_loginMeFTP:function(){
		var user = this.getComponent('user_name_textfield');
		var password= this.getComponent('user_password_textfield');

		if(!this.getComponent('user_name_textfield').isValid())
			return false;
		if(!this.getComponent('user_password_textfield').isValid())
			return false;
		
		//location	=	"meftpLogInService/login.action?userLogin="+user.value+"&userPassword="+password.value;
		var redirectAdmin='/MeFTPServer/MeftpJsp/Administration/MeFTP_Administration.jsp';
		var redirectClient='/MeFTPServer/MeftpJsp/MeftpUploadExt/MeftpUpload.jsp';
		Ext.Ajax.request({
			url:'meftpLogInService/login.action',
			method:'POST',
			params:{
				userLogin:user.value,
				userPassword:password.value
			},
			success:function(response){
				data = Ext.decode(response.responseText);
				var datas;
				response = Ext.decode(response.responseText);
				Ext.each(data, function(datas) {
					 admin		=	datas.admin
					 succ	= 	datas.success;
				});
				if(admin==true && succ==true){
					window.location.href=redirectAdmin;
				}else if(admin==false && succ==true){
					window.location.href=redirectClient
				}else{
					Ext.example.msg('LOGIN FAILED','Username or Password is not correct, try again or consult MeFTP administrator for assistance');
				}
			}
		});
	}
	
});