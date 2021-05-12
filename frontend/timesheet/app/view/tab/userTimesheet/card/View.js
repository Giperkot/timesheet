Ext.define('Timesheet.view.tab.userTimesheet.card.View', {
    extend: 'Ext.form.Panel',
    requires: [
        /*'Timesheet.view.tab.userTimesheet.card.Controller',
        'Timesheet.view.tab.userTimesheet.card.ViewModel',
        'Timesheet.view.common.DateTimeField',
        'Timesheet.view.tab.experts.Grid',
        'Ext.layout.VBox',
        'Ext.Container'*/
    ],

    alias: 'widget.timesheet-card-view',
    controller: 'timesheet-card-controller',
    viewModel: 'timesheet-card-view-model',
    autoScroll: true,

    maxHeight: window.innerHeight - 80,

    items: [
        {
            xtype: "container",
            padding: '20 0 0 20',
            scrollable: true,
            autoScroll: true,

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
                        value: "{item.employeId}",
                        store: '{employeStore}'
                    },
                    listeners: {
                        // change: 'onChangeEmploye'
                    }
                },
                {
                    xtype: "textfield",
                    width: 550,
                    fieldLabel: "Должность",
                    bind: {
                        value: "{item.position}"
                    }
                },
                {
                    xtype: "combobox",
                    width: 550,
                    fieldLabel: "Проект",
                    displayField: 'name',
                    valueField: 'id',
                    triggerCls: "fa fa-caret-down",
                    fieldCls: "min_width_411",
                    bind: {
                        value: "{item.projectId}",
                        store: '{projectStore}'
                    }
                },
                {
                    xtype: "datefield",
                    width: 550,
                    format: 'd.m.Y',
                    usePicker: true,
                    minValue: new Date("2018-01-01"),
                    maxValue: new Date(),
                    fieldLabel: "Дата",
                    bind: {
                        value: "{item.workDate}"
                    }
                },
                {
                    xtype: "textfield",
                    width: 550,
                    fieldLabel: "Часов потрачено",
                    bind: {
                        value: "{item.timeWasted}"
                    }
                },
                {
                    xtype: "textfield",
                    width: 550,
                    fieldLabel: "Номер задачи",
                    bind: {
                        value: "{item.taskNum}"
                    }
                },
                {
                    xtype: "textarea",
                    width: 550,
                    fieldLabel: "Описание",
                    bind: {
                        value: "{item.taskDescription}"
                    }
                },
                {
                    xtype: "panel",
                    layout: "hbox",
                    items: [
                        {
                            xtype: "button",
                            text: 'Сохранить',
                            handler: 'saveCard'
                        },
                        {
                            xtype: "button",
                            text: 'Отмена',
                            hidden: true,
                            listeners: {
                                click: function(el) {

                                }
                            }
                        }
                    ]
                }
            ]
        }
    ],
    listeners: {
        // activate: 'onActivate'
    }
});
