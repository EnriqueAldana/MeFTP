var store = Ext.create('Ext.data.TreeStore', {
    root: {
        "children": [
                     {
                         "text": "YAIR",
                         "children": [
                             {
                                 "text": "Outbox",
                                 "leaf": true
                             },
                             {
                            	 "text"	:	"Inbox",
                        	 "leaf"	:true
                             }
                         ],
                         "expanded": "false"
                     },
                     {
                         "text": "YAIR",
                         "children": [
                             {
                                 "text": "Outbox",
                                 "leaf": true
                             }
                         ],
                         "expanded": "false"
                     },
                     {
                         "text": "YAIR",
                         "children": [
                             {
                                 "text": "Outbox",
                                 "leaf": true
                             }
                         ],
                         "expanded": "false"
                     },
                     {
                         "text": "YAIR",
                         "children": [
                             {
                                 "text": "Outbox",
                                 "leaf": true
                             }
                         ],
                         "expanded": "false"
                     },
                     {
                         "text": "YAIR",
                         "children": [
                             {
                                 "text": "Outbox",
                                 "leaf": true
                             }
                         ],
                         "expanded": "false"
                     },
                     {
                         "text": "YAIR",
                         "children": [
                             {
                                 "text": "Outbox",
                                 "leaf": true
                             }
                         ],
                         "expanded": "false"
                     },
                     {
                         "text": "YAIR",
                         "children": [
                             {
                                 "ext": "Outbox1",
                                 "leaf": true
                             }
                         ],
                         "expanded": "false"
                     }
                 ],
                 "expanded": true
             }
});


Ext.define('Ext.ux.MeFTP.ExplorerTab.Tree',{
	extend		:	'Ext.tree.Panel',
	alias		:	'widget.explorertab',
	title		:	'User Files Explorer',
	height		:	500,
	width		:	150,
	x			:	10,
	rootVisible	:	true,
	//renderTo	:	Ext.getBody(),
	store		:	store,
	initComponent	:	function(){
		Ext.ux.MeFTP.ExplorerTab.Tree.superclass.initComponent.call(this);
	}
});    