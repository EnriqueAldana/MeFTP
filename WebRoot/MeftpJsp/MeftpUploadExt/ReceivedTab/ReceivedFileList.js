var myData2 = [
        ['3m Co'                               ],
        ['Alcoa Inc'                           ],
        ['Altria Group Inc'                    ],
        ['American Express Company'            ],
        ['American International Group, Inc.'  ],
        ['AT&T Inc.'                           ],
        ['Boeing Co.'                          ],
        ['Caterpillar Inc.'                    ],
        ['Citigroup, Inc.'                     ],
        ['E.I. du Pont de Nemours and Company' ],
        ['Exxon Mobil Corp'                    ],
        ['General Electric Company'            ],
        ['General Motors Corporation'		   ],
        ['Hewlett-Packard Co.'				   ],
        ['Honeywell Intl Inc'],
        ['Intel Corporation' ],
        ['International Business Machines'],
        ['Johnson & Johnson'],
        ['JP Morgan & Chase & Co'],
        ['McDonald\'s Corporation'],
        ['Merck & Co., Inc.' ],
        ['Microsoft Corporation'],
        ['Pfizer Inc'],
        ['The Coca-Cola Company'],
        ['The Home Depot, Inc.' ],
        ['The Procter & Gamble Company'],
        ['United Technologies Corporation'],
        ['Verizon Communications' ],
        ['Wal-Mart Stores, Inc.' ]
    ];


    // create the data store
    var store2 = Ext.create('Ext.data.ArrayStore', {
        fields: [
           {name: 'Received'}
        ],
        data: myData2
    });

    // create the Grid
    var gridreceived = Ext.create('Ext.grid.Panel', {
    	
        store: store2,
        stateful: true,
        stateId: 'stateReceivedGrid',
        columns: [
            {
                text     : 'Received',
                width		:	200,
                sortable : false,
                dataIndex: 'Received'
            },
            {
                xtype: 'actioncolumn',
                width: 100,
                items: [{
                    icon   : 'MeFTPClientImages/application_go.png',  // Use a URL in
																// the icon
																// config
                    tooltip: 'Download File',
                    handler: function(grid, rowIndex, colIndex) {
                        var rec = store.getAt(rowIndex);
                        alert("Sell " + rec.get('company'));
                    }
                }
                ]
            }
        ],
        margins	:	'10 10 10 10',
        anchor		:	'100% 75%',
        viewConfig: {
            stripeRows: true
        }
    });           