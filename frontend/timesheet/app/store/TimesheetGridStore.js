

Ext.define('Timesheet.store.TimesheetGridStore', {
    extend: 'Ext.data.Store',

    alias: 'store.timesheetGridStore',

    model: 'Timesheet.model.TimesheetModel',

    proxy: {
        type: 'ajax',
        async: true,
        actionMethods: {
            read: 'POST'
        },
        url: "/api/timesheet/getAll",
        reader: {
            type: 'json',
            // rootProperty: 'data',
            totalProperty: 'total'
        },
        headers: {
            Accept: "application/json"
        },
        paramsAsJson: true
    }
});
