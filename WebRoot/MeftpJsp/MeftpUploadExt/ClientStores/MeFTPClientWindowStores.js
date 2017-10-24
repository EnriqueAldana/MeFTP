var userDataCmb = [ [ "1", "User Id" ], [ "2", "User Name" ], [ "3", "User Log In" ], 
                    [ "4", "User Enabled" ], [ "5", "User Write Permission" ], 
                    ["6", "User E-Mail"], [ "7", "E-Mail Notification" ],
                    [ "8", "User Date Created" ], ["9", "User Expiration Date"]
    			  ];

var userCriteriaOptions = new Ext.data.ArrayStore({
	fields	:	['id_Options','Options'],
    data 	:	userDataCmb
});