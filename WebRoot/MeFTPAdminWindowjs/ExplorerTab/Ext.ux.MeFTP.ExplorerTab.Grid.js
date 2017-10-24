var myData = [
				[ "1", "Gus", "Gustavo", "algo@metalsa.com"],
				[ "2", "Pepe", "Jose", "algo@metalsa.com"],
				[ "3", "Quique", "Enrique", "algo@metalsa.com"],
				[ "4", "Beto", "Alberto", "algo@metalsa.com"],
				[ "5", "Nacho", "Ignacio", "algo@metalsa.com"],
				[ "6", "Luis", "Luisillo", "algo@metalsa.com"],
				[ "7", "Juanito", "Juan", "algo@metalsa.com"],
				[ "8", "Rafa", "Rafael", "algo@metalsa.com"],
				[ "9", "Robert", "Roberto", "algo@metalsa.com"],
				[ "10", "Berna", "Bernardo", "algo@metalsa.com"],
				[ "11", "Hermel", "Jose", "algo@metalsa.com"],
				[ "12", "Gus", "Gustavo", "algo@metalsa.com"],
				[ "13", "Gus", "Gustavo", "algo@metalsa.com"],
				[ "4", "Beto", "Alberto", "algo@metalsa.com"],
				[ "5", "Nacho", "Ignacio", "algo@metalsa.com"],
				[ "6", "Luis", "Luisillo", "algo@metalsa.com"],
				[ "7", "Juanito", "Juan", "algo@metalsa.com"],
				[ "8", "Rafa", "Rafael", "algo@metalsa.com"],
				[ "9", "Robert", "Roberto", "algo@metalsa.com"],
				[ "10", "Berna", "Bernardo", "algo@metalsa.com"],
				[ "11", "Hermel", "Jose", "algo@metalsa.com"],
				[ "12", "Gus", "Gustavo", "algo@metalsa.com"],
				[ "13", "Gus", "Gustavo", "algo@metalsa.com"],
				[ "4", "Beto", "Alberto", "algo@metalsa.com"],
				[ "5", "Nacho", "Ignacio", "algo@metalsa.com"],
				[ "6", "Luis", "Luisillo", "algo@metalsa.com"],
				[ "7", "Juanito", "Juan", "algo@metalsa.com"],
				[ "8", "Rafa", "Rafael", "algo@metalsa.com"],
				[ "9", "Robert", "Roberto", "algo@metalsa.com"],
				[ "10", "Berna", "Bernardo", "algo@metalsa.com"],
				[ "11", "Hermel", "Jose", "algo@metalsa.com"],
				[ "12", "Gus", "Gustavo", "algo@metalsa.com"],
				[ "13", "Gus", "Gustavo", "algo@metalsa.com"]];

var ds = Ext.create('Ext.data.ArrayStore', {
	fields : [ {
		name : 'fileId'
	}, {
		name : 'fileName'
	}, {
		name : 'fileOwner'
	}, {
		name : 'filedesc'
	}],
	data : myData
});


var explorerGrid_Grid = Ext.create('Ext.grid.Panel',{
	height		: 	500,
	width		: 	570,
	x			: 	170,
	store		:	ds,
	columns		:	[ 
	    {
	    	xtype 		: 	'gridcolumn',
	    	dataIndex 	: 	'fileId',
	    	text 		:	'File Id'
		}, {
			xtype 		: 	'gridcolumn',
			dataIndex 	: 	'fileName',
			text 		: 	'File Name'
		}, {
			xtype 		: 	'gridcolumn',
			dataIndex 	: 	'fileOwner',
			text 		: 	'File Owner'
		}, {
			xtype 		: 	'gridcolumn',
			dataIndex 	: 	'filedesc',
			text 		: 	'E-Mail'
		}/*, {
			xtype 		: 	'gridcolumn',
			dataIndex 	: 	'employeeId',
			text 		: 	'Employee Id'
		}, {
			xtype 		: 	'gridcolumn',
			dataIndex 	: 	'medsrol',
			text 		: 	'Meds Rol'
		}, {
			xtype 		: 	'gridcolumn',
			dataIndex 	: 	'medsroldescription',
			text 		: 	'Meds Rol Des'
		}, {
			xtype		:	'gridcolumn',
			dataIndex	:	'entryDate',
			text		:	'Entry Date'
	}*/]
});           