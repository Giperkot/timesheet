Ext.define('Timesheet.view.MainViewModel', {
    extend: 'Ext.app.ViewModel',

    alias: 'viewmodel.main-view-model',

    requires: [
        /*'Timesheet.store.MedGridStore',
        'Timesheet.store.ServiceGridStore',
        'Timesheet.store.UsersGridStore',
        'Timesheet.store.RequestGridStore',
        'Timesheet.store.ExpertGridStore'*/
    ],

    data: {
        name: 'Timesheet',

        gridSelection: null,
        filterByUser: null
    },
    stores: {
        timesheetGridStore: {
            type: 'timesheetGridStore',
            autoLoad: true
        }
        /*serviceGridStore: {
            type: 'serviceGridStore',
            autoLoad: true
        },
        requestsGridStore: {
            type: 'requestsGridStore',
            autoLoad: true
        },
        expertsGridStore: {
            type: 'expertsGridStore',
            autoLoad: true
        },
        usersGridStore: {
            type: 'usersGridStore',
            autoLoad: true
        }*/
    },
    formulas: {
        loremIpsum: function () {
            return ";alskdjflasdjfklajsdfjasdf";
        },
        employeStore: function () {
            return Ext.getStore("employeStore");
        }
    }



});
