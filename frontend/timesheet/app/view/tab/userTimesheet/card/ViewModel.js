Ext.define('Timesheet.view.tab.userTimesheet.card.ViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.timesheet-card-view-model',

    requires: [

    ],
    mixins: [

    ],

    data: {

    },

    stores: {
        /*employeStore: {
            type: 'employeStore',
            autoLoad: true
        },
        projectStore: {
            type: 'projectStore',
            autoLoad: true
        }*/
    },

    formulas: {
        employeStore: function () {
            return Ext.getStore("employeStore");
        },
        projectStore: function () {
            return Ext.getStore("projectStore");
        }
    }
});
