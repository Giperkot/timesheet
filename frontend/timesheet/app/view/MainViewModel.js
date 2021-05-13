Ext.define('Timesheet.view.MainViewModel', {
    extend: 'Ext.app.ViewModel',

    alias: 'viewmodel.main-view-model',

    requires: [
    ],

    data: {
        name: 'Timesheet',

        gridSelection: null,
        filterByUser: null,
        filterDateFrom: null,
        filterDateTo: null
    },
    stores: {
        timesheetGridStore: {
            type: 'timesheetGridStore',
            autoLoad: true
        },
        projectReportStore: {
            type: 'projectReportStore',
            autoLoad: true
        }
    },
    formulas: {
        employeStore: function () {
            return Ext.getStore("employeStore");
        }
    }



});
