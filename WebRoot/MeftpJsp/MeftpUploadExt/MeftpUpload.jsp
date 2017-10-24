<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>MeFTP - Client</title>
<link rel="stylesheet" type="text/css" href="ext-3.2.1/resources/css/ext-all.css" />
<link rel="stylesheet" type="text/css" href="Ext.ux.form.FileUploadField.css" /> 
<link rel="stylesheet" type="text/css" href="AwesomeUploader.css" />
<link rel="stylesheet" type="text/css" href="AwesomeUploader Progress Bar.css" />
</head><!--
Copyright (c) 2010, Andrew Rymarczyk<BR>
All rights reserved.
--><style>
body {
	margin: 40px;
	font-family: arial;
}
pre {
	background: none;
	font-family: Courier New, Lucida Console;
	font-style: normal;
}
</style>
<body>


<script type="text/javascript" src="ext-3.2.1/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="ext-3.2.1/ext-all.js"></script>
<script type="text/javascript" src="ClientStores/MeFTPClientWindowStores.js"></script>
<script type="text/javascript" src="Ext.ux.form.FileUploadField.js"></script>
<script type="text/javascript" src="Ext.ux.XHRUpload.js"></script>
<script type="text/javascript" src="swfupload.js"></script>
<!--  script type="text/javascript" src="swfupload.swfobject.js"></script> -->
<script type="text/javascript" src="Ext.ux.AwesomeUploaderLocalization.js"></script>
<script type="text/javascript" src="Ext.ux.AwesomeUploader.js"></script>
<script type="text/javascript" src="MeFTPTransferTab/Ext.ux.MeFTP.TransferTab.AddRecipients.js"></script>
<script type="text/javascript" src="MeFTPTransferTab/Ext.ux.MeFTP.TransferTab.OptionalSettings.js"></script>
<script type="text/javascript" src="SendTab/Ext.ux.MeFTP.SendTab.Search.js"></script>
<script type="text/javascript" src="ReceivedTab/MeFtpSearchReceived.js"></script>



<script type="text/javascript">

Ext.BLANK_IMAGE_URL = 'ext-3.2.1/resources/images/default/s.gif';


Ext.onReady(function(){

	Ext.QuickTips.init();
	
	/*
	uploadGridColumns = [
		{name:'id'}
		,{name:'name'}
		,{name:'size'}
		,{name:'status'}
		,{name:'progress'}
	];
	*/
		
	var statusIconRenderer = function(value){
		switch(value){
			default:
				return value;
			case 'Pending':
				return '<img src="hourglass.png" width=16 height=16>';
			case 'Sending':
				return '<img src="loading.gif" width=16 height=16>';
			case 'Error':
				return '<img src="cross.png" width=16 height=16>';
			case 'Cancelled':
			case 'Aborted':
				return '<img src="cancel.png" width=16 height=16>';
			case 'Uploaded':
				return '<img src="tick.png" width=16 height=16>';
		}
	},
	
	progressBarColumnTemplate = new Ext.XTemplate(
		'<div class="ux-progress-cell-inner ux-progress-cell-inner-center ux-progress-cell-foreground">',
			'<div>{value} %</div>',
		'</div>',
		'<div class="ux-progress-cell-inner ux-progress-cell-inner-center ux-progress-cell-background" style="left:{value}%">',
			'<div style="left:-{value}%">{value} %</div>',
		'</div>'
    ),
    
	progressBarColumnRenderer = function(value, meta, record, rowIndex, colIndex, store){
        meta.css += ' x-grid3-td-progress-cell';
		return progressBarColumnTemplate.apply({
			value: value
		});
	},
	
	updateFileUploadRecord = function(id, column, value){
		var rec = fileUploadPanel.awesomeUploaderGrid.store.getById(id);
		rec.set(column, value);
		rec.commit();
	};
	
	var fileUploadPanel = new Ext.Panel({
		//title:'MEDS super uploader '
		//renderTo:'MeFTPcontainer'
		//,frame:true
		width: 550,
		height: 480,
		x:10,
		y:10
		//anchor:'60% 100%'
		,layout:'anchor'
		//,width:600
		//,height:
		,items:[
		{
			xtype:'awesomeuploader'
			,ref:'awesomeUploader'
			,extraPostData:{
				'key':'value'
				,'test':'testvalue'
			}
			,height:40
			,awesomeUploaderRoot:'<%=basePath%>'
			/*,awesomeUploaderRoot:'http://localhost:8080/MeFTPServer/MeftpUpload/'*/
			,allowDragAndDropAnywhere:true
			,autoStartUpload:false
			,maxFileSizeBytes: 200 * 1024 * 1024 // 15 MiB
			,listeners:{
				scope:this
				,fileselected:function(awesomeUploader, file){
				/*
					file will at minimum be:
					file = {
						name: fileName
						,method: "swfupload" //(can be "swfupload", "standard", "dnd"
						,id: 1 // a unique identifier to abort or remove an individual file, incrementing int
						,status: "queued" // file status. will always be queued at this point
						// if swfupload or dnd or standard upload on a modern browser (supports the FILE API) is used, size property will be set:
						,size: 12345 // file size in bytes
					}
				*/
				
					//Example of cancelling a file to be selection
					if( file.name == 'image.jpg' ){	
						Ext.Msg.alert('Error','You cannot upload a file named "image.jpg"');
						return false;
					}
					
					fileUploadPanel.awesomeUploaderGrid.store.loadData({
						id:file.id
						,name:file.name
						,size:file.size
						,status:'Pending'
						,progress:0
					}, true);
				}
				,uploadstart:function(awesomeUploader, file){
				
					updateFileUploadRecord(file.id, 'status', 'Sending');
				}
				,uploadprogress:function(awesomeUploader, fileId, bytesComplete, bytesTotal){
				
					updateFileUploadRecord(fileId, 'progress', Math.round((bytesComplete / bytesTotal)*100) );
				}
				,uploadcomplete:function(awesomeUploader, file, serverData, resultObject){
					//Ext.Msg.alert('Data returned from server'+ serverData);
					
					try{
						var result = Ext.util.JSON.decode(serverData);//throws a SyntaxError.
					}catch(e){
						resultObject.error = 'Invalid JSON data returned';
						//Invalid json data. Return false here and "uploaderror" event will be called for this file. Show error message there.
						return false;
					}
					resultObject = result;
					
					if(result.success){
						updateFileUploadRecord(file.id, 'progress', 100 );
						updateFileUploadRecord(file.id, 'status', 'Uploaded' );
					}else{
						return false;
					}
					
				}
				,uploadaborted:function(awesomeUploader, file ){
					updateFileUploadRecord(file.id, 'status', 'Aborted' );
				}
				,uploadremoved:function(awesomeUploader, file ){
					
					fileUploadPanel.awesomeUploaderGrid.store.remove(fileUploadPanel.awesomeUploaderGrid.store.getById(file.id) );
				}
				,uploaderror:function(awesomeUploader, file, serverData, resultObject){
					resultObject = resultObject || {};
					
					var error = 'Error! ';
					if(resultObject.error){
						error += resultObject.error;
					}
					
					updateFileUploadRecord(file.id, 'progress', 0 );
					updateFileUploadRecord(file.id, 'status', 'Error' );
					
				}
			}
		},{
			xtype:'grid'
			,ref:'awesomeUploaderGrid'
			//,width:420
			//,height:200
			,anchor :'100% 100%'
			,enableHdMenu:false
			,tbar:[
			{
				text:'Start Upload'
				,icon:'tick.png'
				,scope:this
				,handler:function(){
					fileUploadPanel.awesomeUploader.startUpload();
				}
			},{
				text:'Abort'
				,icon:'cancel.png'
				,scope:this
				,handler:function(){
					var selModel = fileUploadPanel.awesomeUploaderGrid.getSelectionModel();
					if(!selModel.hasSelection()){
						Ext.Msg.alert('','Please select an upload to cancel');
						return true;
					}
					var rec = selModel.getSelected();
					fileUploadPanel.awesomeUploader.abortUpload(rec.data.id);
				}
			},{
				text:'Abort All'
				,icon:'cancel.png'
				,scope:this
				,handler:function(){
					fileUploadPanel.awesomeUploader.abortAllUploads();
				}
			},{
				text:'Remove'
				,icon:'cross.png'
				,scope:this
				,handler:function(){
					var selModel = fileUploadPanel.awesomeUploaderGrid.getSelectionModel();
					if(!selModel.hasSelection()){
						Ext.Msg.alert('','Please select an upload to cancel');
						return true;
					}
					var rec = selModel.getSelected();
					fileUploadPanel.awesomeUploader.removeUpload(rec.data.id);
				}
			},{
				text:'Remove All'
				,icon:'cross.png'
				,scope:this
				,handler:function(){
					fileUploadPanel.awesomeUploader.removeAllUploads();
				}
			}]
			,store:new Ext.data.JsonStore({
				fields: ['id','name','size','status','progress']
    			,idProperty: 'id'
			})
			,columns:[
				{header:'File Name',dataIndex:'name', width:150}
				,{header:'Size',dataIndex:'size', width:60, renderer:Ext.util.Format.fileSize}
				,{header:'&nbsp;',dataIndex:'status', width:30, renderer:statusIconRenderer}
				,{header:'Status',dataIndex:'status', width:60}
				,{header:'Progress',dataIndex:'progress', renderer:progressBarColumnRenderer}
			]
		}]
	});
	

	Ext.apply(Ext.form.VTypes, {
	    daterange : function(val, field) {
	        var date = field.parseDate(val);

	        if(!date){
	            return false;
	        }
	        if (field.startDateField) {
	            var start = Ext.getCmp(field.startDateField);
	            if (!start.maxValue || (date.getTime() != start.maxValue.getTime())) {
	                start.setMaxValue(date);
	                start.validate();
	            }
	        }
	        else if (field.endDateField) {
	            var end = Ext.getCmp(field.endDateField);
	            if (!end.minValue || (date.getTime() != end.minValue.getTime())) {
	                end.setMinValue(date);
	                end.validate();
	            }
	        }
	        return true;
	    },

    password : function(val, field) {
        if (field.initialPassField) {
            var pwd = Ext.getCmp(field.initialPassField);
            return (val == pwd.getValue());
        }
        return true;
    },

    passwordText : 'Passwords do not match'
	
	});
			
			
	var transferPanel = new Ext.Panel({
		title : 'TransferPanel',
		width:'100%',
		layout	:	'absolute',
		items	:	[
					fileUploadPanel,
					addRecipients
		     	 	 ]
	});
	
	 win = new Ext.Window({
         width:500,
         height:300,
         plain: true,
         title		:	'MeFTP Transfer Files',
		margins		:	'20 20 20 20',
		height: 600,
 		width: 1100,
 		bodyPadding	:	'10 10 10 10',
 		layout	:	'absolute',
 		resizable	:	false,
 		plain		:	true,
 		closable	: 	false,
		constrain	: 	true,
		border		: 	false,
		modal		:	true,
		maximizable	:	false,
		bodyPadding:10,
		items:[
		       {
		    	   xtype:'fieldset',
				   plain: true,
				   anchor:'100% 100%',
				   activeTab: 0,
				   layout:'anchor',
				   title:'Users Information',
				   items:[
				          {
				          xtype:'tabpanel',
				          title:'User Information',
				          anchor:'100% 100%',
				          activeTab:0,
				          items:[
								{
	  								xtype:'panel',
	  								title:'Trasnfer Files',
	  								layout:'absolute',
	  								autoScroll:true,
	  								items:[
											fileUploadPanel,
											addRecipients,
											OptionalSettings
	  								       ]
								},
								{	
	  								xtype:'panel',
	  								title:'Sent Files',
	  								layout:'absolute',
	  								items:[
											barSendSearch
	  								      ]
								},
								{
	  								xtype:'panel',
	  								title:'Received Files',
	  								layout:'absolute',
	  								items:[
											barReceivedSearch
	  								       ]
								}
				                 ]
				          
				          }
				          
			
					       ]
				}
                ]
     }).show();			
	
});
</script>
</body>
</html>
