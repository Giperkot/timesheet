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
            xtype: 'menu-main',
            reference: 'mainTabPanel',
            flex: 1
        }
    ]
});
