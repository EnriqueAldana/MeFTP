var myData = [
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
    var store = Ext.create('Ext.data.ArrayStore', {
        fields: [
           {name: 'company'}
        ],
        data: myData
    });

    // create the Grid
    var grid = Ext.create('Ext.grid.Panel', {
        store: store,
        stateful: true,
        stateId: 'stateGrid',
        columns: [
            {
                text     : 'Company',
                width		:	200,
                sortable : false,
                dataIndex: 'company'
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
                }, /*{
                    getClass: function(v, meta, rec) {          // Or return a
																// class from a
																// function
                        if (rec.get('change') < 0) {
                            this.items[1].tooltip = 'Hold stock';
                            return 'alert-col';
                        } else {
                            this.items[1].tooltip = 'Buy stock';
                            return 'buy-col';
                        }
                    },
                    handler: function(grid, rowIndex, colIndex) {
                        var rec = store.getAt(rowIndex);
                        alert((rec.get('change') < 0 ? "Hold " : "Buy ") + rec.get('company'));
                    }*/
                ]
            }
        ],
        margins	:	'10 10 10 10',
        anchor		:	'100% 75%',
        //height: 350,
        //width: 600,
       // title: 'Array Grid',
        viewConfig: {
            stripeRows: true
        }
    });
