

Ext.define('Timesheet.store.ProjectReportStore', {
    extend: 'Ext.data.Store',

    alias: 'store.projectReportStore',

    model: 'Ext.data.Model',

    autoLoad: true,
    proxy: {
        type: 'ajax',
        async: true,
        actionMethods: {
            read: 'POST'
        },
        url: "/api/timesheet/getCommonReport",
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
