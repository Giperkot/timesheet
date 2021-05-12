

Ext.define('Timesheet.store.ProjectStore', {
    extend: 'Ext.data.Store',

    alias: 'store.projectStore',
    storeId: 'projectStore',
    model: 'Ext.data.Model',

    autoLoad: true,
    proxy: {
        type: 'ajax',
        async: true,
        actionMethods: {
            read: 'POST'
        },
        url: "/api/project/getAll",
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
