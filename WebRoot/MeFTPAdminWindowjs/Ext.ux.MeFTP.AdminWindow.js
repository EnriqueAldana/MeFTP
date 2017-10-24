var north = {
		
            xtype: 'box',
            id: 'header_admin_id',
            region: 'north',
            html: 'Metalsa electronic FTP Server',
            height: 30,
            margins: '10 10 10 10'
        
};

var south = {	
        xtype		:	'box',
        id			: 	'footer_admin_id',
        region		: 	'south',
        html		: 	' <H1 align="left"> Copyright (c) Metalsa  2011 - 2020</H1><H1 align="right">Powered by MEDS Platform Development Team</H1>',
        height		: 	5,
        margins		: 	'0 0 0 0',
        layout		:	'border',
        items		:	[
             		 	 {
             		 		 xtype		:	'label',
             		 		 text		:	'Copyright @ ',
             		 		 region		:	'west'
             		 	 },
             		 	 {
             		 		 xtype		:	'label',
             		 		 region		:	'',
             		 		 region		:	'east'
             		 	 }
             		 	 ]
    
};

this.panelContenido = Ext.create('Ext.tab.Panel',{
	id: 'content-panel',
    layout: 'card',
    activeItem: 0,
    border: false,
	region:'center',
	deferredRender:false,
	autoScroll: true, 
	margins:'0 10 10 0',
	items	:	[
	     	 	 {
	     	 		 xtype 	: 	'panel',
	     	 		 title	:	'Home',
	     	 		 html	:	'<p>Welcome to MeFTP Administration Window</p>'
	     	 	 }
	     	 	 ]
});

Ext.define('Ext.ux.MeFTP.AdminWindow',{
	extend		:	'Ext.container.Viewport',
	alias		:	'widget.AdminWindow',
	title		:	'MeFTP -Administration Window',
	layout		:	'border',
	items		:	[north,panelContenido,
	     		 	 {
		layout: 'border',
		title		:	'Administration Options',
        id: 'layout-browser',
        region:'west',
        collapsible: true,
        animCollapse: true,
        border: false,
        split		:	true,
    	margins		:	'0 10 10 10',
    	width		:	275,
    	minSize		:	300,
    	maxSize		:	500,
        items: [treePanel, detailsPanel]
	},south
	    ]
});        