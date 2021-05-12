Ext.define('Timesheet.model.EmployeModel', {
    extend: 'Timesheet.model.Base',

    fields: [
        {
            type: 'number',
            name: 'id'
        },
        'lastName',
        'firstName',
        'middleName',
        {
            name: "fullName",
            convert: function (value, record) {
                return (record.get("lastName") + " " + record.get("firstName") + " " + record.get("middleName")).trim();
            }
        },
        'position',
    ]
});
