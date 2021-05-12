
Ext.define('Timesheet.view.tab.userTimesheet.Grid', {
    extend: 'Ext.grid.Panel',
    // xtype: 'timesheet-grid',
    alias: 'widget.timesheet-grid',

    requires: [
        'Timesheet.view.tab.userTimesheet.Controller'
    ],

    // title: 'Timesheet',
    // width: 1000,
    controller: 'timesheet-controller',

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
                                text: "Создать",
                                handler: "onCreate",
                                bind: {
                                    hidden: '{!isAdmin}'
                                }
                            },
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
                                xtype: "combobox",
                                width: 550,
                                fieldLabel: "ФИО",
                                displayField: 'fullName',
                                valueField: 'id',
                                triggerCls: "fa fa-caret-down",
                                fieldCls: "min_width_411",
                                bind: {
                                    value: "{filterByUser}",
                                    store: '{employeStore}'
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
            text: 'ФИО',
            dataIndex: 'lastName',
            minWidth: 230,
            flex: 1,
            renderer: function (value, smth, record) {
                return record.get("lastName") + " " + record.get("firstName") + " " + record.get("middleName");
            }
        },
        {
            text: 'Должность',
            dataIndex: 'position',
            minWidth: 130,
        },
        {
            text: 'Проект',
            dataIndex: 'projectName',
            width: 150
        },
        {
            text: 'Дата',
            dataIndex: 'workDate',
            xtype: 'datecolumn',
            format: 'd.m.Y'
        },
        {
            text: 'Номер задачи',
            dataIndex: 'taskNum'
        },
        {
            text: 'Описание',
            dataIndex: 'taskDescription',
            flex: 1,
            renderer: function (value) {
                return (value.length > 200) ? value.substring(0, 200) : value;
            }
        }
    ],
    listeners: {
        activate: function () {
            console.log("activate");
            // this.getController().onViewReady();
        },
        rowdblclick: 'gridRowDoubleClick'
    }
});
