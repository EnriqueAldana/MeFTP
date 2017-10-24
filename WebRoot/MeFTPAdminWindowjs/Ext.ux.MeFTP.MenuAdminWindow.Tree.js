var store2 = Ext.create('Ext.data.TreeStore', {
    root: {
        expanded: true,
        children: [
            { text: "Information", leaf: true },
            { text: "Explorer", leaf: true},
            { text: "Logging", expanded: false, children: [
                { text: "Server Messages", leaf: true },
                { text: "Server Activity", leaf: true}
            ] },
            { text: "Users", leaf: true },
            { text: "Groups", leaf: true },
            { text: "Subgroups", leaf: true },
            { text: "Configurations", leaf: true },
                                                                                      
        ]
    }
});

var treePanel = Ext.create('Ext.tree.Panel', {
	store		:	store2,
	region		:	'north',
	height		:	250,
    id			: 	'tree-panel',
    title		: 	'Explorer',
    split		: 	true,
    minSize		: 	150,
    rootVisible	: 	false,
    autoScroll	: 	true
});

var detailsPanel = Ext.create('Ext.form.Panel',{
	id			:	'details_panel_id',
		title		:	'Details',
		region		:	'center',
		bodyStyle	:	'padding-bottom:15px;background:#ccc;',
		margins		:	'10 0 0 0',
		autoScroll	:	true,
		html		:	'<p class="details-info">Hi</p>'
});