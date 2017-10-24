/**
 * User List Store
 **/
var userStore =	Ext.create('Ext.data.Store',{
	id			:	'user_store_id',
	pageSize	:	50,
	proxy 		: 	{
		type		: 	'rest',
		url 		: 	'meftpUsersSearch/advancedSearch.action',
		reader 		: 	{
			type		:	'json',
			root		:	'userList'
		}	
	},
	fields		:	[{name	:	'meftpUsersUserid'},{name	: 	'meftpUsersUsername'},{name: 'meftpUsersUsernamelogin'},
	      		 	 {name	: 	'meftpUsersUserpassword'},{name: 'meftpUsersUserhomedirectory'},{name: 'meftpUsersUserenabledflag'},
	      		 	 {name	: 	'meftpUsersUserwritepermission'},{name: 'meftpUsersUseridletime'},{name: 'meftpUsersUsercreatedate'},
	      		 	 {name	: 	'meftpUsersUserexpires'},{name: 'meftpUsersUsercomments'},
	      		 	 {name	: 	'meftpUsersUseremailaddress'},{name: 'meftpUsersUseremailnotification'}
	]
});

/**
 * Subgroups List Store
**/
var subgroupStore = Ext.create('Ext.data.Store',{
	id			:	'subgroups_store_id',
	pageSize	:	50,
	proxy		:	{
		type		:	'rest',
		url			:	'meftpSubgroupsSearchActions/advancedSearch.action',
		reader		:	{
			type	:	'json',
			root	:	'subgroupsList'
		}
	},
	fields		:	[{name	:	'meftpSubgroupsSubgroupid'},{name	:	'meftpSubgroupsSubgroupname'},
	      		 	 {name	:	'meftpSubgroupsMeftpsubgroupdescription'},{name	:	'meftpSubgroupsSubgroupenable'},
	      		 	 {name	:	'meftpSubgroupsSubgroupexpiredate'},{name	:	'meftpSubgroupsSubgroupemail'},
	      		 	 {name	:	'meftpSubgroupsSubgroupemailnotification'},{name	:	'meftpSubgroupsSubgroupcomments'},
	      		 	 {name	:	'meftpSubgroupsSubgroupcreateddate'}
	      		 	 ]
});

/**
 * Groups List Store
**/
var groupStore = Ext.create('Ext.data.Store',{
	id			:	'groups_store_id',
	pageSize	:	50,
	proxy		:	{
		type		:	'rest',
		url			:	'meftpGroupsSearchActions/advancedSearch.action',
		reader		:	{
			type	:	'json',
			root	:	'groupsList'
		}
	},
	fields		:	[{name	:	'meftpGroupsGroupid'},{name	:	'meftpGroupsGroupname'},
	      		 	 {name	:	'meftpGroupsGroupdescription'},{name	:	'meftpGroupsGroupenable'},
	      		 	 {name	:	'meftpGroupsGroupexpireddate'},{name	:	'meftpGroupsGroupemail'},
	      		 	 {name	:	'meftpGroupsEmailnotification'},{name	:	'meftpGroupsCreatedate'},
	      		 	 {name	:	'meftpGroupsGroupcomments'}
	      		 	 ]
});

/**
 *UserTab Criteria Combo 
 **/
var userDataCmb = [ [ "1", "User Id" ], [ "2", "User Name" ], [ "3", "User Log In" ], 
                    [ "4", "User Enabled" ], [ "5", "User Write Permission" ], 
                    ["6", "User E-Mail"], [ "7", "E-Mail Notification" ],
                    [ "8", "User Date Created" ], ["9", "User Expiration Date"]
    			  ];

var userCriteriaOptions = Ext.create('Ext.data.ArrayStore', {
	fields	:	[{name	:	'id_Options'}, {name	:	'Options'} ],
    data 	:	userDataCmb
});

/**
 * SubgroupTab Criteria Combo
 **/
var subgroupDataCmb = [ [ "1", "Subgroup Id" ], [ "2", "Subgroup Name" ], [ "3", "Subgroup Description" ], 
                    [ "4", "Subgroup Enabled" ], [ "5", "Subgroup Email" ], 
                    ["6", "Subgroup Comments"], [ "7", "Subgroup Email Notification" ],
                    [ "8", "Subgroup Date Created" ], ["9", "Subgroup Expiration Date"]
    			  ];

var subgroupCriteriaOptions = Ext.create('Ext.data.ArrayStore', {
	fields	:	[{name	:	'id_Options'}, {name	:	'Options'} ],
    data 	:	subgroupDataCmb
});

/**
 *GroupTab Criteria Combo 
 **/
var groupDataCmb = [ [ "1", "Group Id" ], [ "2", "Group Name" ], [ "3", "Group Description" ], 
                    [ "4", "Group Enable" ],["5", "Group E-Mail"], [ "6", "E-Mail Notification" ],
                    [ "7", "Group Date Created" ], ["8", "Group Expiration Date"]
    			  ];

var groupCriteriaOptions = Ext.create('Ext.data.ArrayStore', {
	fields	:	[{name	:	'id_Options'}, {name	:	'Options'} ],
    data 	:	groupDataCmb
});


/**
 * Log Level Combo Selection
 **/

var logDataCmb = [	 [ "0", "0 --> LOGGER OFF" ], [ "1", "1 --> LOGGER ALL" ], [ "6", "6 --> LOGGER INFO" ], 
                     [ "10", "10 --> LOGGER FATAL" ],["11", "11 --> LOGGER ERROR"], [ "12", "12 --> LOGGER WARNING" ],
                     [ "13", "13 --> LOGGER DEBUG" ]
     			  ];

 var logLevelCriteriaOptions = Ext.create('Ext.data.ArrayStore', {
 	fields	:	[{name	:	'id_Options'}, {name	:	'Options'} ],
     data 	:	logDataCmb
 });


/**
 * UserGroups
 **/
var groupUserOptions = Ext.create('Ext.data.Store',{
	id			:	'groupUser_store_id',
	autoLoad	:	true,
	pageSize	:	50,
	proxy		:	{
		type		:	'rest',
		url			:	'meftpGroupsSearchActions/getList.action',
		reader		:	{
			type	:	'json',
			root	:	'groupsList'
		}
	},
	fields		:	[{name	:	'meftpGroupsGroupid'},{name	:	'meftpGroupsGroupname'}]
});

/**
 *UserSubgroups
 **/
var subgroupUserOptions = Ext.create('Ext.data.Store',{
	id			:	'subgroupUser_store_id',
	pageSize	:	50,
	proxy		:	{
		type		:	'rest',
		url			:	'meftpSubgroupsSearchActions/advancedSearch.action',
		reader		:	{
			type	:	'json',
			root	:	'subgroupsList'
		}
	},
	fields		:	[{name	:	'meftpSubgroupsSubgroupid'},{name	:	'meftpSubgroupsSubgroupname'}]
	
});

/**
 *Server Activity 
 **/
var serverActivity = Ext.create('Ext.data.Store',{
	autoLoad	:	true,
	id			:	'serverActivity_store_id',
	pageSize	:	50,
	proxy		:	{
		type		:	'rest',
		url			:	'meftpJournalRegister/getDataJournal.action',
		reader		:	{
			type		:	'json',
			root		:	'serverList'
		}
	},
	fields		:	[{name	:	'meftpJournalJournaleventid'},{name	:	'meftpJournalJournaleventname'},
	      		 	 {name	:	'meftpJournalJournaldescription'},{name	:	'meftpJournalJournaluserlogin'},
	      		 	 {name	:	'meftpJournalJournaldateevent'}]
});

/**
 * 
 **/

var userContactDataCmb = [ [ "1", "User Id" ], [ "2", "User Name" ], [ "3", "User Log In" ], 
                    [ "4", "User Enabled" ], [ "5", "User Write Permission" ], 
                    ["6", "User E-Mail"],
                    [ "8", "User Date Created" ], ["9", "User Expiration Date"]
    			  ];

var contactCriteriaOptions = Ext.create('Ext.data.ArrayStore', {
	queryMode: 'local',
	fields	:	[{name	:	'id_Options'}, {name	:	'Options'} ],
    data 	:	userContactDataCmb
});

/**
 * Contacts User Store 
 **/

var contactsUserStore =	Ext.create('Ext.data.Store',{
	id			:	'usercontact_store_id',
	pageSize	:	50,
	proxy 		: 	{
		type		: 	'rest',
		url 		: 	'meftpUsersSearch/advancedSearch.action',
		reader 		: 	{
			type		:	'json',
			root		:	'userList'
		}	
	},
	fields		:	[{name	:	'meftpUsersUserid'},{name	: 	'meftpUsersUsername'},{name: 'meftpUsersUsernamelogin'},
	      		 	 {name	: 	'meftpUsersUserpassword'},{name: 'meftpUsersUserhomedirectory'},{name: 'meftpUsersUserenabledflag'},
	      		 	 {name	: 	'meftpUsersUserwritepermission'},{name: 'meftpUsersUseridletime'},{name: 'meftpUsersUsercreatedate'},
	      		 	 {name	: 	'meftpUsersUserexpires'},{name: 'meftpUsersUsercomments'},
	      		 	 {name	: 	'meftpUsersUseremailaddress'},{name: 'meftpUsersUseremailnotification'}
	]
});

Ext.define('DataObject', {
    extend: 'Ext.data.Model',
    fields: ['meftpUsersUserid', 'meftpUsersUsername', 'meftpUsersUsernamelogin',
             'meftpUsersUserpassword','meftpUsersUserhomedirectory','meftpUsersUserenabledflag',
             'meftpUsersUserwritepermission','meftpUsersUseridletime','meftpUsersUsercreatedate',
             'meftpUsersUserexpires','meftpUsersUsercomments','meftpUsersUseremailaddress','meftpUsersUseremailnotification'
             ]
});

var contactsUserStore2 = Ext.create('Ext.data.Store', {
	id			:	'contacts_store2_id',
	pageSize	:	50,
	proxy 		: 	{
		type		: 	'rest',
		url 		: 	'meftpUsersSearch/contactsSearch.action',
		reader 		: 	{
			type		:	'json',
			root		:	'usersContact'
		}	
	},
    model: 'DataObject'
});


Ext.define('BackUpContact', {
    extend: 'Ext.data.Model',
    fields: ['meftpUsersUserid', 'meftpUsersUsername', 'meftpUsersUsernamelogin',
             'meftpUsersUserpassword','meftpUsersUserhomedirectory','meftpUsersUserenabledflag',
             'meftpUsersUserwritepermission','meftpUsersUseridletime','meftpUsersUsercreatedate',
             'meftpUsersUserexpires','meftpUsersUsercomments','meftpUsersUseremailaddress','meftpUsersUseremailnotification'
             ]
});

var backUpStore = Ext.create('Ext.data.Store', {
	id			:	'backup_storecontact_id',
    model: 'BackUpContact',
    recordType: contactsUserStore.recordType
});


