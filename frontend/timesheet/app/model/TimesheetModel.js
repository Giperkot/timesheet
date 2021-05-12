Ext.define('Timesheet.model.TimesheetModel', {
    extend: 'Timesheet.model.Base',

    fields: [
        {
            type: 'number',
            name: 'id'
        },
        {
            type: 'number',
            name: 'employeId'
        },
        {
            type: 'number',
            name: 'projectId'
        },
        'lastName',
        'firstName',
        'middleName',
        'position',
        'projectName',
        {
            name: 'workDate',
            type: 'date',
            dateFormat: 'c'
        },
        'taskNum',
        'taskDescription'
    ]
});
