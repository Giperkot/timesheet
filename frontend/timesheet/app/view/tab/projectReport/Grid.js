
Ext.define('Timesheet.view.tab.projectReport.Grid', {
    extend: 'Ext.grid.Panel',
    // xtype: 'timesheet-grid',
    alias: 'widget.report-grid',

    requires: [
        'Timesheet.view.tab.userTimesheet.Controller'
    ],

    controller: 'report-controller',

    tbar: {
        items: [
            {
                xtype: 'container',
                items: [
                    {
                        xtype: 'container',
                        layout: 'hbox',
                        margin: '2 0',
                        items: [
                            {
                                xtype: "button",
                                margin: '0 10 0 10',
                                text: "Обновить",
                                handler: "updateGrid"
                            },
                            {
                                xtype: "button",
                                margin: '0 10 0 10',
                                text: "Сбросить",
                                handler: "resetFilter"
                            }
                        ]
                    },
                    {
                        xtype: 'container',
                        layout: 'hbox',
                        items: [
                            {
                                xtype: "datefield",
                                format: 'd.m.Y',
                                usePicker: true,
                                minValue: new Date("2018-01-01"),
                                maxValue: new Date(),
                                fieldLabel: "Дата от",
                                bind: {
                                    value: "{filterDateFrom}"
                                }
                            },
                            {
                                margin: '0 0 0 10',
                                xtype: "datefield",
                                format: 'd.m.Y',
                                usePicker: true,
                                minValue: new Date("2018-01-01"),
                                maxValue: new Date(),
                                fieldLabel: "Дата по",
                                bind: {
                                    value: "{filterDateTo}"
                                }
                            },
                            {
                                xtype: "button",
                                margin: '0 0 0 10',
                                text: "Поиск",
                                handler: "updateGrid"
                            }
                        ]
                    }
                ]
            }
        ]

    },

    columns: [
        {
            text: 'Название проекта',
            dataIndex: 'projectName',
            minWidth: 230,
            flex: 1
        },
        {
            text: 'Общее время, часы',
            dataIndex: 'sumTimeWasted',
            minWidth: 230,
        },
        {
            text: 'Количество работников',
            dataIndex: 'employeCount',
            width: 230
        }
    ],
    listeners: {

    }
});
