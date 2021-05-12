Ext.define('Timesheet.view.tab.userTimesheet.Controller', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.timesheet-controller',

    requires: [
        'Timesheet.view.tab.userTimesheet.card.View'
    ],

    onViewReady: function () {

    },
    gridRowDoubleClick: function  (_this, record, target, index, e, eOpts ) {
        var mainTabPanel = this.getView().up("app-main").lookupReference("mainTabPanel");

        var addIndex = mainTabPanel.items.length;
        mainTabPanel.insert(addIndex,{
            title: "Табеля учета: " + record.get("id"),
            closable: true,
            items: [
                {
                    xtype: 'timesheet-card-view',
                    // itemId: record.get("id"),
                    // gridController: this
                }
            ]
        });

        mainTabPanel.items.items[addIndex].down('timesheet-card-view').getViewModel().set("item", record);

        mainTabPanel.setActiveItem(addIndex);
    },
    onCreate: function () {
        var mainTabPanel = this.getView().up("app-main").lookupReference("mainTabPanel");

        var addIndex = mainTabPanel.items.length;
        mainTabPanel.insert(addIndex,{
            title: "Табеля учета: Новый",
            closable: true,
            items: [
                {
                    xtype: 'timesheet-card-view',
                    itemId: null,
                    gridController: this
                }
            ]
        });

        var emptyRecord = Ext.create("Timesheet.model.TimesheetModel", {
            workDate: new Date(),
            id: -1
        });
        mainTabPanel.items.items[addIndex].down('timesheet-card-view').getViewModel().set("item", emptyRecord);

        mainTabPanel.setActiveItem(addIndex);
    },
    updateGrid: function () {
        let vm = this.getViewModel();
        let filterByUser = vm.get("filterByUser");

        let store = vm.getStore("timesheetGridStore");
        store.proxy.extraParams = {
            userId: filterByUser
        };

        store.reload();
    },
    resetFilter: function () {
        let vm = this.getViewModel();
        vm.set("filterByUser", null);

        let store = vm.getStore("timesheetGridStore");
        store.proxy.extraParams = {};
        store.reload();
    }
});
