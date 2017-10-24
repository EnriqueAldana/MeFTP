var serverActivity = Ext.create('Ext.form.Panel',{
	id			:	'tab_Server Activity_panel',
	anchor		:	'100%',
	layout		:	'anchor',
	margins		:	'5 5 5 5',
	autoScroll	:	true,
	items		:	[
	     		 	 {
	     		 		 xtype		:	'gridpanel',
	     		 		 id			:	'server_panel_id',
	     		 		 margins	:	'10 10 10 10',
	     		 		 anchor		:	'100%',
	     		 		 autoScroll	:	true,
	     		 		 store		:	serverActivity,
	     		 		 columns	:	[
	     		 		        	 	 {
	     		 		        	 		 xtype 		: 	'gridcolumn',
	     		 		        	 		 dataIndex 	: 	'meftpJournalJournaleventid',
	     		 		        	 		 text 		:	'Journal Event Id',
	     		 		        	 		 width		:	100
	     		 		        	 	 },
	     		 		        	 	 {
	     		 		        	 		 xtype		:	'gridcolumn',
	     		 		        	 		 dataIndex	:	'meftpJournalJournaleventname',
	     		 		        	 		 text		:	'Journal Event Name',
	     		 		        	 		 width		:	200
	     		 		        	 	 },
	     		 		        	 	 {
	     		 		        	 		 xtype		:	'gridcolumn',
	     		 		        	 		 dataIndex	:	'meftpJournalJournaldescription',
	     		 		        	 		 text		:	'Journal Description Event',
	     		 		        	 		 width		:	350
	     		 		        	 	 },
	     		 		        	 	 {
	     		 		        	 		 xtype		:	'gridcolumn',
	     		 		        	 		 dataIndex	:	'meftpJournalJournaluserlogin',
	     		 		        	 		 text		:	'Journal User Log In',
	     		 		        	 		 width		:	200
	     		 		        	 	 },
	     		 		        	 	 {
	     		 		        	 		 xtype		:	'gridcolumn',
	     		 		        	 		 dataIndex	:	'meftpJournalJournaldateevent',
	     		 		        	 		 text		:	'Date Journal Event',
	     		 		        	 		 width		:	200
	     		 		        	 	 }
	     		 		       		 	 ],
	     		 		  listeners	:	{
	     		 			  activate	:	function(panel){
	     		 				  serverActivity.load();
	     		 		   	 	}
	     		 		  }
	     		 	 }
	       ]   
});         