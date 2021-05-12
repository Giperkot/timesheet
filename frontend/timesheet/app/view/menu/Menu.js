
Ext.define('Timesheet.view.menu.Menu', {
    extend: 'Ext.tab.Panel',
    xtype: 'menu-main',

    requires: [
        'Ext.layout.Fit',

    ],

    controller: 'main-controller',
    viewModel: 'main-view-model',

    ui: 'navigation',

    tabBarHeaderPosition: 1,
    titleRotation: 0,
    tabRotation: 0,

    width: '100%',

    header: {
        layout: {
            align: 'stretchmax'
        },
        title: {
            text: "Timesheet",
            flex: 0
        },
        iconCls: 'fa fa-th-list'
    },

    tabBar: {
        flex: 1,
        layout: {
            align: 'stretch',
            overflowHandler: 'none'
        }
    },

    responsiveConfig: {
        tall: {
            headerPosition: 'top'
        },
        wide: {
            headerPosition: 'left'
        }
    },

    defaults: {
        bodyPadding: 20,
        tabConfig: {
            responsiveConfig: {
                wide: {
                    iconAlign: 'left',
                    textAlign: 'left'
                },
                tall: {
                    iconAlign: 'top',
                    textAlign: 'center',
                    width: 120
                }
            }
        }
    },

    /*defaults: {
        tab: {
            iconAlign: 'left'
        },
        tabBar: {
            orientation: 'horizontal',
        },
    },

    tabBarPosition: 'left',*/

    items: [{
        title: 'Табеля',
        iconCls: 'fa fa-home',
        layout: 'fit',
        items: [{
            xtype: 'timesheet-grid',
            minHeight: 500,
            width: '100%',
            reference: 'timesheetGrid',
            bind: {
                store: "{timesheetGridStore}"
            }
        }]
    }, {
        title: 'Отчет по списанному времени',
        iconCls: 'fa fa-user',
        bind: {
            html: '{loremIpsum}'
        }
    }]
});
