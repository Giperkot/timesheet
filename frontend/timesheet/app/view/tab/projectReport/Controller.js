Ext.define('Timesheet.view.tab.projectReport.Controller', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.report-controller',

    requires: [
        'Timesheet.view.tab.userTimesheet.card.View'
    ],

    onViewReady: function () {

    },
    updateGrid: function () {
        let vm = this.getViewModel();
        let filterDateFrom = vm.get("filterDateFrom");
        let filterDateTo = vm.get("filterDateTo");

        let store = vm.getStore("projectReportStore");
        store.proxy.extraParams = {
            start: filterDateFrom,
            end: filterDateTo
        };

        store.reload();
    },
    resetFilter: function () {
        let vm = this.getViewModel();
        vm.set("filterDateFrom", null);
        vm.set("filterDateTo", null);

        let store = vm.getStore("projectReportStore");
        store.proxy.extraParams = {};
        store.reload();
    }
});
