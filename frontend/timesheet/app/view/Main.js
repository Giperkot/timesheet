/**
 * Главная страница
 */
Ext.define('Timesheet.view.Main', {
    extend: 'Ext.panel.Panel',
    xtype: 'app-main',

    requires: [
        'Timesheet.view.MainController',
        'Timesheet.view.MainViewModel',
        'Timesheet.view.menu.Menu'
    ],

    controller: 'main-controller',
    viewModel: 'main-view-model',

    defaults: {
        tab: {
            iconAlign: 'left'
        },
        styleHtmlContent: true
    },

    tabBarPosition: 'left',

    layout: 'vbox',

    items: [
        {
            xtype: "panel",
            height: 80,
            width: '100%',
            layout: {
                type: "hbox",
                pack: "start",
                align: "middle"
            },
            items: [
                {
                    xtype: "panel",
                    layout: {
                        type: "hbox",
                        pack: "center",
                    },
                    html: '<div class="header">Табель учета времени сотрудника</div>',
                    width: 210
                },
                {
                    xtype: "panel",
                    padding: "20 30",
                    layout: {
                        type: "vbox",
                        pack: "start",
                        align: "middle"
                    },
                    bind: {
                        html: "{userInfo}"
                    }
                },
                {
                    xtype: "button",
                    height: 30,
                    width: 100,
                    text: "Выход",
                    handler: 'onExitUser'
                }
            ]
        }, {
            xtype: 'menu-main',
            reference: 'mainTabPanel',
            flex: 1
        }
    ]
});
