/*
 * This file launches the application by asking Ext JS to create
 * and launch() the Application class.
 */
/*Ext.application({
    extend: 'Timesheet.Application',

    name: 'Timesheet',

    requires: [
        // This will automatically load all classes in the Timesheet namespace
        // so that application classes do not need to require each other.
        'Timesheet.*'
    ],

    // The name of the initial view to create.
    mainView: 'Timesheet.view.main.Main'
});*/
Ext.application({
    extend: 'Timesheet.Application',
    name: 'Timesheet',

    requires: [
        // 'Ext.MessageBox'
        'Timesheet.*'
    ],

    mainView: 'Timesheet.view.Main',

    launch: function () {

    }
});
