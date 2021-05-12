

Ext.define('Timesheet.store.EmployeStore', {
    extend: 'Ext.data.Store',

    alias: 'store.employeStore',
    storeId: 'employeStore',
    model: 'Timesheet.model.EmployeModel',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        async: true,
        actionMethods: {
            read: 'POST'
        },
        url: "/api/employe/getAll",
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
